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

    public static final IdTagRelationBuilder create() {
        return new TagRelationBuilderImpl();
    }

    public static interface IdTagRelationBuilder {
        public TagIdTagRelationBuilder id(final long id);
    }

    public static interface TagIdTagRelationBuilder {
        public ContainerIdTagRelationBuilder tagId(final long tagId);
    }

    public static interface ContainerIdTagRelationBuilder {
        public ContainerTypeTagRelationBuilder containerId(final String containerId);
    }

    public static interface ContainerTypeTagRelationBuilder {
        public BuildTagRelationBuilder containerType(final String containerType);
    }

    public static interface BuildTagRelationBuilder {
        public TagRelation build();
    }
    
    private static final class TagRelationBuilderImpl implements 
            IdTagRelationBuilder, TagIdTagRelationBuilder, 
            ContainerIdTagRelationBuilder, ContainerTypeTagRelationBuilder,
            BuildTagRelationBuilder
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
        public TagIdTagRelationBuilder id(final long id) {
            properties.put(TAG_RELATION__PARA__ID, new SimpleLongProperty(id));
            return this;
        }

        @Override
        public ContainerIdTagRelationBuilder tagId(final long tagId) {
            properties.put(TAG_RELATION__PARA__TAG_ID, new SimpleLongProperty(tagId));
            return this;
        }

        @Override
        public ContainerTypeTagRelationBuilder containerId(final String containerId) {
            properties.put(TAG_RELATION__PARA__CONTAINER_ID, new SimpleStringProperty(containerId));
            return this;
        }

        @Override
        public BuildTagRelationBuilder containerType(final String containerType) {
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

            final StringProperty containerTypeStringProperty = (StringProperty) properties.get(TAG_RELATION__PARA__CONTAINER_TYPE);
            final String containerType = containerTypeStringProperty.get();

            // Create the tag
            final TagRelation tagRelation = new DefaultTagRelation(id, tagId, containerId, containerType);

            return tagRelation;
        }
        
    }
    
}
