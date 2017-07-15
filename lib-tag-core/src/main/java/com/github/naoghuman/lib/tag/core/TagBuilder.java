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

import static com.github.naoghuman.lib.tag.core.Tag.DEFAULT_ID;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__DESCRIPTION;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__GENERATION_TIME;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__ID;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__STYLE;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__TITLE;

import com.github.naoghuman.lib.tag.internal.DefaultTag;
import com.github.naoghuman.lib.tag.internal.DefaultValidator;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * the developer can create easily an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
 * <li>All other attributes are optional, that means skipping them returns 
 *     {@link java.util.Optional#empty()}.</li>
 * <li>Any optinal attribute if set will be validate against 
 *     {@link com.github.naoghuman.lib.tag.core.Validator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    com.github.naoghuman.lib.tag.core.Validator
 * @see    java.util.Optional#empty()
 */
public final class TagBuilder {
    
    /**
     * Starting point from this fluent builder to generate and configured an 
     * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
     * 
     * @return the first step to generate and configured an instance from the 
     *         {@code Interface} {@code Tag}.
     * @see    com.github.naoghuman.lib.tag.core.Tag
     */
    public static final IdStep create() {
        return new TagBuilderImpl();
    }
    
    /**
     * First mandory step to generate and configured an instance from the 
     * {@code Interface} {@code Tag}.<br>
     * This {@code Interface} allowed to set the attribute {@code id}.
     */
    public interface IdStep {
        
        /**
         * Setter for the mandory attribute {@code id} in the upcoming instance 
         * from the {@code Interface} {@code Tag}. 
         * 
         * @param id value for the attribute {@code id}.
         * @return the next step {@code TitleStep} in this fluent builder.
         */
        public TitleStep id(final Long id);
        
    }

    /**
     * Second mandory step to generate and configured an instance from the 
     * {@code Interface} {@code Tag}.<br>
     * This {@code Interface} allowed to set the attribute {@code title}.
     */
    public interface TitleStep {
        
        /**
         * Setter for the mandory attribute {@code title} in the upcoming instance 
         * from the {@code Interface} {@code Tag}. 
         * 
         * @param title value for the attribute {@code title}.
         * @return the next optional steps {@code Step} in this fluent builder.
         */
        public Step title(final String title);
        
    }
    
    /**
     * Optional steps for the configuration from the new instance from the 
     * {@code Interface} {@code Tag}.<br>
     * <ul>
     * <li>All attributes in this {@code Interface} are optional. If not set, then
     *     {@link java.util.Optional#empty()} for every unset attribute will returned.</li>
     * <li>All setted values will be validate against the {@code Interface} 
     *     {@link com.github.naoghuman.lib.tag.core.Validator}.</li>
     * <li>Any optinal attribute is set more then ones then the last {@code value}
     *     will be used for the configuration.</li>
     * </ul>
     * 
     * @see com.github.naoghuman.lib.tag.core.Validator
     * @see java.util.Optional#empty()
     */
    public interface Step {
        
        /**
         * Setter for the optional attribute {@code generationTime} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param generationTime value for the attribute {@code generationTime}.
         * @return the next optional steps {@code Step} in this fluent builder.
         */
        public Step generationTime(final Long generationTime);
        
        /**
         * Setter for the optional attribute {@code description} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param description value for the attribute {@code description}.
         * @return the next optional steps {@code Step} in this fluent builder.
         */
        public Step description(final String description);
        
        /**
         * Setter for the optional attribute {@code style} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param style value for the attribute {@code style}.
         * @return the next optional steps {@code Step} in this fluent builder.
         */
        public Step style(final String style);
        
        /**
         * Generated and configured an instance from the {@code Interface} {@code Tag} 
         * with the used values from the previous steps.
         * 
         * @return the generated and configured instance.
         * @see    com.github.naoghuman.lib.tag.core.Tag
         */
        public Tag build();
        
    }

    private static final class TagBuilderImpl implements IdStep, Step, TitleStep {
        
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagBuilderImpl() {
            this.init();
        }

        private void init() {
            // Mandory attributes
            properties.put(TAG_PARA__ID,    new SimpleLongProperty(DEFAULT_ID));
            properties.put(TAG_PARA__TITLE, new SimpleStringProperty());
            
            // Optional attributes
            properties.put(TAG_PARA__DESCRIPTION,     new SimpleStringProperty());
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty());
            properties.put(TAG_PARA__STYLE,           new SimpleStringProperty());
        }

        @Override
        public TitleStep id(final Long id) {
            DefaultValidator.getDefault().requireNonNull(id);
            properties.put(TAG_PARA__ID, new SimpleLongProperty(id));
        
            return this;
        }

        @Override
        public Step title(final String title) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(title);
            properties.put(TAG_PARA__TITLE, new SimpleStringProperty(title));
            
            return this;
        }

        @Override
        public Step generationTime(final Long generationTime) {
            DefaultValidator.getDefault().requireNonNull(generationTime);
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty(generationTime));
            
            return this;
        }

        @Override
        public Step description(final String description) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(description);
            properties.put(TAG_PARA__DESCRIPTION, new SimpleStringProperty(description));
            
            return this;
        }

        @Override
        public Step style(final String style) {
            DefaultValidator.getDefault().requireNonNullAndNotEmpty(style);
            properties.put(TAG_PARA__STYLE, new SimpleStringProperty(style));
            
            return this;
        }

        @Override
        public Tag build() {
            // Catch data
            final LongProperty idLongProperty              = (LongProperty)   properties.get(TAG_PARA__ID);
            final StringProperty titleStringProperty       = (StringProperty) properties.get(TAG_PARA__TITLE);
            final LongProperty generationTimeLongProperty  = (LongProperty)   properties.get(TAG_PARA__GENERATION_TIME);
            final StringProperty descriptionStringProperty = (StringProperty) properties.get(TAG_PARA__DESCRIPTION);
            final StringProperty styleStringProperty       = (StringProperty) properties.get(TAG_PARA__STYLE);

            // Create a new Tag
            return DefaultTag.create(
                    idLongProperty.getValue(),
                    titleStringProperty.getValue(),
                    generationTimeLongProperty.getValue(),
                    descriptionStringProperty.getValue(),
                    styleStringProperty.getValue());
        }

    }

}
