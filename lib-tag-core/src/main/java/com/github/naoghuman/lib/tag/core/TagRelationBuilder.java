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
 * <li>All defined values will be validate against the {@code Interface} 
 *     {@link com.github.naoghuman.lib.tag.core.Validator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see    com.github.naoghuman.lib.tag.core.Validator
 */
public final class TagRelationBuilder {

    /**
     * Starting point from this fluent builder to generate and configured an 
     * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagRelation}.
     * 
     * @return the first step to generate and configured an instance from the 
     *         {@code Interface} {@code TagRelation}.
     * @see    com.github.naoghuman.lib.tag.core.TagRelation 
     */
    public static final IdStep create() {
        return new TagRelationBuilderImpl();
    }

    /**
     * First mandory step to generate and configured an instance from the {@code Interface} 
     * {@code TagRelation}.<br>
     * This {@code Interface} allowed to set the attribute {@code id}.
     */
    public interface IdStep {
        
        /**
         * Setter for the mandory attribute {@code id} in the upcoming instance 
         * from the {@code Interface} {@code TagRelation}. 
         * 
         * @param id value for the attribute {@code id}.
         * @return the next step {@code TagIdStep} in this fluent builder.
         */
        public TagIdStep id(final Long id);
        
    }

    /**
     * Second mandory step to generate and configured an instance from the 
     * {@code Interface} {@code TagRelation}.<br>
     * This {@code Interface} allowed to set the attribute {@code tagId}.
     */
    public interface TagIdStep {
        
        /**
         * Setter for the mandory attribute {@code tagId} in the upcoming instance 
         * from the {@code Interface} {@code TagRelation}. 
         * 
         * @param tagId value for the attribute {@code tagId}.
         * @return the next step {@code ContainerIdStep} in this fluent builder.
         */
        public ContainerIdStep tagId(final Long tagId);
        
    }

    /**
     * Third mandory step to generate and configured an instance from the 
     * {@code Interface} {@code TagRelation}.<br>
     * This {@code Interface} allowed to set the attribute {@code containerId}.
     */
    public interface ContainerIdStep {
        
        /**
         * Setter for the mandory attribute {@code containerId} in the upcoming 
         * instance from the {@code Interface} {@code TagRelation}. 
         * 
         * @param containerId value for the attribute {@code containerId}.
         * @return the last step {@code Builder} in this fluent builder.
         */
        public Builder containerId(final String containerId);
        
    }

    /**
     * Last step to generate and configured an instance from the {@code Interface} 
     * {@code TagRelation}.<br>
     * This {@code Interface} returned the generated and configured instance.
     */
    public interface Builder {
        
        /**
         * Generated and configured an instance from the {@code Interface} {@code TagRelation} 
         * with the used values from the previous steps.
         * 
         * @return the generated and configured instance.
         * @see    com.github.naoghuman.lib.tag.core.TagRelation
         */
        public TagRelation build();
        
    }

    private static final class TagRelationBuilderImpl implements
            IdStep, TagIdStep, ContainerIdStep, Builder
    {
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagRelationBuilderImpl() {
            this.init();
        }

        private void init() {
            // Mandory attributes
            properties.put(TAG_RELATION__PARA__CONTAINER_ID,   new SimpleStringProperty());
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
        public Builder containerId(final String containerId) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(containerId);
            properties.put(TAG_RELATION__PARA__CONTAINER_ID, new SimpleStringProperty(containerId));
            
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

            // Create a the TagRelation
            return DefaultTagRelation.create(
                    id,
                    tagId,
                    containerId);
        }

    }

}
