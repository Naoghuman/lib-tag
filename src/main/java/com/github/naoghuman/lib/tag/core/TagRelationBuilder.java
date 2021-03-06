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

import com.github.naoghuman.lib.tag.internal.DefaultTagRelation;
import com.github.naoghuman.lib.tag.internal.DefaultTagValidator;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import static com.github.naoghuman.lib.tag.core.TagRelation.CONTAINER_ID;
import static com.github.naoghuman.lib.tag.core.TagRelation.ID;
import static com.github.naoghuman.lib.tag.core.TagRelation.TAG_ID;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} 
 * the developer can create easily an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * <ul>
 * <li>All attributes are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
 * </ul>
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelation
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 */
public final class TagRelationBuilder {

    /**
     * Starting point from this fluent builder to configured and generate an 
     * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagRelation}.
     * 
     * @return  the first step to configure and generate an instance from the {@code Interface} {@code TagRelation}.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.core.TagRelation 
     */
    public static final IdStep create() {
        
        return new TagRelationBuilderImpl();
        
    }

    /**
     * First mandory step to configure and generate an instance from the {@code Interface} {@code TagRelation}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code id}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface IdStep {
        
        /**
         * Setter for the mandory attribute {@code id} in the upcoming instance 
         * from the {@code Interface} {@code TagRelation}. 
         * 
         * @param   id value for the attribute {@code id}.
         * @return  the next step {@code TagIdStep} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public TagIdStep id(final Long id);
        
    }

    /**
     * Second mandory step to generate and configured an instance from the {@code Interface} {@code TagRelation}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code tagId}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface TagIdStep {
        
        /**
         * Setter for the mandory attribute {@code tagId} in the upcoming instance 
         * from the {@code Interface} {@code TagRelation}. 
         * 
         * @param   tagId value for the attribute {@code tagId}.
         * @return  the next step {@code ContainerIdStep} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public ContainerIdStep tagId(final Long tagId);
        
    }

    /**
     * Third mandory step to generate and configured an instance from the {@code Interface} {@code TagRelation}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code containerId}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface ContainerIdStep {
        
        /**
         * Setter for the mandory attribute {@code containerId} in the upcoming 
         * instance from the {@code Interface} {@code TagRelation}. 
         * 
         * @param   containerId value for the attribute {@code containerId}.
         * @return  the last step {@code Builder} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public Builder containerId(final String containerId);
        
    }

    /**
     * Last step to generate and configured an instance from the {@code Interface} {@code TagRelation}.<br>
     * This {@code Interface} returned the generated and configured instance.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface Builder {
        
        /**
         * Configure and generate an instance from the {@code Interface} {@code TagRelation} 
         * with the defined values from the previous steps.
         * 
         * @return  the generated and configured instance.
         * @since   0.1.0
         * @version 0.4.0
         * @see     com.github.naoghuman.lib.tag.core.TagRelation
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
            properties.put(CONTAINER_ID, new SimpleStringProperty());
            properties.put(ID,           new SimpleLongProperty());
            properties.put(TAG_ID,       new SimpleLongProperty());
        }

        @Override
        public TagIdStep id(final Long id) {
            DefaultTagValidator.requireNonNull(id);
            
            properties.put(ID, new SimpleLongProperty(id));
            
            return this;
        }

        @Override
        public ContainerIdStep tagId(final Long tagId) {
            DefaultTagValidator.requireNonNull(tagId);
            
            properties.put(TAG_ID, new SimpleLongProperty(tagId));
            
            return this;
        }

        @Override
        public Builder containerId(final String containerId) {
            DefaultTagValidator.requireNonNullAndNotEmpty(containerId);
            
            properties.put(CONTAINER_ID, new SimpleStringProperty(containerId));
            
            return this;
        }

        @Override
        public TagRelation build() {
            // Catch data
            final LongProperty idLongProperty = (LongProperty) properties.get(ID);
            final Long id = idLongProperty.get();

            final LongProperty tagIdLongProperty = (LongProperty) properties.get(TAG_ID);
            final Long tagId = tagIdLongProperty.get();

            final StringProperty containerIdStringProperty = (StringProperty) properties.get(CONTAINER_ID);
            final String containerId = containerIdStringProperty.get();

            // Create the TagRelation
            return DefaultTagRelation.create(
                    id,
                    tagId,
                    containerId);
        }

    }

}
