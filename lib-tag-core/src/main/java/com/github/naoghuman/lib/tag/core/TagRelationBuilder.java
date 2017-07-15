/**
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
import com.github.naoghuman.lib.tag.internal.DefaultValidator;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} 
 * the developer can create easily an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * <ul>
 * <li>All attributes are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@code Validator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see    com.github.naoghuman.lib.tag.core.Validator
 */
public final class TagRelationBuilder {

    public static final IdStep create() {
        return new TagRelationBuilderImpl();
    }

    public static interface IdStep {
        public TagIdStep id(final Long id);
    }

    public static interface TagIdStep {
        public ContainerIdStep tagId(final Long tagId);
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
            // Mandory attributes
            properties.put(TAG_RELATION__PARA__CONTAINER_ID,   new SimpleStringProperty());
            properties.put(TAG_RELATION__PARA__CONTAINER_TYPE, new SimpleStringProperty());
            properties.put(TAG_RELATION__PARA__ID,             new SimpleLongProperty());
            properties.put(TAG_RELATION__PARA__TAG_ID,         new SimpleLongProperty());
        }

        @Override
        public TagIdStep id(final Long id) {
            DefaultValidator.getDefault().requireNonNull(id);
            properties.put(TAG_RELATION__PARA__ID, new SimpleLongProperty(id));
            
            return this;
        }

        @Override
        public ContainerIdStep tagId(final Long tagId) {
            DefaultValidator.getDefault().requireNonNull(tagId);
            properties.put(TAG_RELATION__PARA__TAG_ID, new SimpleLongProperty(tagId));
            
            return this;
        }

        @Override
        public ContainerTypeStep containerId(final String containerId) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(containerId);
            properties.put(TAG_RELATION__PARA__CONTAINER_ID, new SimpleStringProperty(containerId));
            
            return this;
        }

        @Override
        public Builder containerType(final String containerType) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(containerType);
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

            // Create a the TagRelation
            return DefaultTagRelation.create(id, tagId, containerId, containerType);
        }

    }

}
