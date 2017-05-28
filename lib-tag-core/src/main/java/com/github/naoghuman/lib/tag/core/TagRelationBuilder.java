/*
 * Copyright (C) 2017 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.tag.core;

import static com.github.naoghuman.lib.tag.core.TagRelation.TAG_RELATION__PARA__CONTAINER_ID;
import static com.github.naoghuman.lib.tag.core.TagRelation.TAG_RELATION__PARA__CONTAINER_TYPE;
import static com.github.naoghuman.lib.tag.core.TagRelation.TAG_RELATION__PARA__ID;
import static com.github.naoghuman.lib.tag.core.TagRelation.TAG_RELATION__PARA__TAG_ID;

import com.github.naoghuman.lib.tag.internal.DefaultTagRelation;
import com.github.naoghuman.lib.tag.internal.TagValidator;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author Naoghuman
 */
public class TagRelationBuilder {

    public static final IdStep create() {
        return new TagRelationBuilderImpl();
    }

    public static interface IdStep {
        public TagIdStep id(final long id);
    }

    public static interface TagIdStep {
        public ContainerIdStep tagId(final long tagId);
    }

    public static interface ContainerIdStep {
        public ContainerTypeStep containerId(final String containerId);
    }

    public static interface ContainerTypeStep {
        public Builder containerType(final String containerType);
    }

    public static interface Builder {
        public TagRelation build();
    }

    private static final class TagRelationBuilderImpl implements
            IdStep, TagIdStep, ContainerIdStep, ContainerTypeStep,
            Builder
    {
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagRelationBuilderImpl() {
            this.init();
        }

        private void init() {
            properties.put(TAG_RELATION__PARA__CONTAINER_ID,   new SimpleStringProperty());
            properties.put(TAG_RELATION__PARA__CONTAINER_TYPE, new SimpleStringProperty());
            properties.put(TAG_RELATION__PARA__ID,             new SimpleLongProperty());
            properties.put(TAG_RELATION__PARA__TAG_ID,         new SimpleLongProperty());
        }

        @Override
        public TagIdStep id(final long id) {
            properties.put(TAG_RELATION__PARA__ID, new SimpleLongProperty(id));
            
            return this;
        }

        @Override
        public ContainerIdStep tagId(final long tagId) {
            properties.put(TAG_RELATION__PARA__TAG_ID, new SimpleLongProperty(tagId));
            
            return this;
        }

        @Override
        public ContainerTypeStep containerId(final String containerId) {
            properties.put(TAG_RELATION__PARA__CONTAINER_ID, new SimpleStringProperty(containerId));
            
            return this;
        }

        @Override
        public Builder containerType(final String containerType) {
            properties.put(TAG_RELATION__PARA__CONTAINER_TYPE, new SimpleStringProperty(containerType));
            
            return this;
        }

        @Override
        public TagRelation build() {
            // Catch data
            final LongProperty idLongProperty = (LongProperty) properties.get(TAG_RELATION__PARA__ID);
            final Long id = idLongProperty.get();

            final LongProperty tagIdLongProperty = (LongProperty) properties.get(TAG_RELATION__PARA__TAG_ID);
            final Long tagId = tagIdLongProperty.get();

            final StringProperty containerIdStringProperty = (StringProperty) properties.get(TAG_RELATION__PARA__CONTAINER_ID);
            final String containerId = containerIdStringProperty.get();
            TagValidator.getDefault().validate(containerId);

            final StringProperty containerTypeStringProperty = (StringProperty) properties.get(TAG_RELATION__PARA__CONTAINER_TYPE);
            final String containerType = containerTypeStringProperty.get();
            TagValidator.getDefault().validate(containerType);

            // Create the tag
            final TagRelation tagRelation = new DefaultTagRelation(id, tagId, containerId, containerType);

            return tagRelation;
        }

    }

}
