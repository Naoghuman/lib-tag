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
import static com.github.naoghuman.lib.tag.core.Tag.DESCRIPTION;
import static com.github.naoghuman.lib.tag.core.Tag.GENERATION_TIME;
import static com.github.naoghuman.lib.tag.core.Tag.ID;
import static com.github.naoghuman.lib.tag.core.Tag.STYLE;
import static com.github.naoghuman.lib.tag.core.Tag.TITLE;
import com.github.naoghuman.lib.tag.internal.DefaultTag;
import com.github.naoghuman.lib.tag.internal.DefaultTagValidator;
import java.util.Optional;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * the developer can easily create an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
 * <li>All other attributes are optional, that means skipping them returns {@link java.util.Optional#empty()}.</li>
 * <li>Any attribute (mandory or optional if set) will be validate against {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
 * </ul>
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
 * @see     com.github.naoghuman.lib.tag.core.TagBuilder
 * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 * @see     java.util.Optional#empty()
 */
public final class TagBuilder {
    
    /**
     * Starting point from this fluent builder to generate and configured an 
     * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
     * 
     * @return  the first step to generate and configured an instance from the {@code Interface} {@code Tag}.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.core.Tag
     */
    public static final IdStep create() {
        return new TagBuilderImpl();
    }
    
    /**
     * First mandory step to generate and configured an instance from the {@code Interface} {@code Tag}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code id}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface IdStep {
        
        /**
         * Setter for the mandory attribute {@code id} in the upcoming instance 
         * from the {@code Interface} {@code Tag}. 
         * 
         * @param   id value for the attribute {@code id}.
         * @return  the next step {@code TitleStep} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public TitleStep id(final Long id);
        
    }

    /**
     * Second mandory step to generate and configured an instance from the {@code Interface} {@code Tag}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code title}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface TitleStep {
        
        /**
         * Setter for the mandory attribute {@code title} in the upcoming instance 
         * from the {@code Interface} {@code Tag}. 
         * 
         * @param   title value for the attribute {@code title}.
         * @return  the next step {@code GenerationTimeStep} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public GenerationTimeStep title(final String title);
        
    }
    
    /**
     * Third mandory step to generate and configured an instance from the {@code Interface} {@code Tag}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code generationTime}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public interface GenerationTimeStep {
        
        /**
         * Setter for the mandory attribute {@code generationTime} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param   generationTime value for the attribute {@code generationTime}.
         * @return  the next optional steps {@code Step} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public Step generationTime(final Long generationTime);
        
    }
    
    /**
     * Optional steps for the configuration from the new instance from the 
     * {@code Interface} {@code Tag}.<br>
     * <ul>
     * <li>All attributes in this {@code Interface} are optional. If not set, then {@link java.util.Optional#empty()} will be returned.</li>
     * <li>All setted values will be validate against the {@code Interface} {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
     * <li>For any optinal attribute if setted more then ones then the last {@code value} will be used for the configuration.</li>
     * </ul>
     * 
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     * @see     java.util.Optional#empty()
     */
    public interface Step {
        
        /**
         * Setter for the optional attribute {@code description} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param   description value for the attribute {@code description}.
         * @return  the next optional steps {@code Step} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public Step description(final String description);
        
        /**
         * Setter for the optional attribute {@code style} in the upcoming 
         * instance from the {@code Interface} {@code Tag}. 
         * 
         * @param   style value for the attribute {@code style}.
         * @return  the next optional steps {@code Step} in this fluent builder.
         * @since   0.1.0
         * @version 0.4.0
         */
        public Step style(final String style);
        
        /**
         * Generated and configured an instance from the {@code Interface} {@code Tag} 
         * with the used values from the previous steps.
         * 
         * @return the generated and configured instance.
         * @since   0.1.0
         * @version 0.4.0
         * @see    com.github.naoghuman.lib.tag.core.Tag
         */
        public Tag build();
        
    }

    private static final class TagBuilderImpl implements GenerationTimeStep, IdStep, Step, TitleStep {
        
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagBuilderImpl() {
            this.init();
        }

        private void init() {
            // Mandory attributes
            properties.put(ID,    new SimpleLongProperty(DEFAULT_ID));
            properties.put(TITLE, new SimpleStringProperty());
            
            // Optional attributes
            properties.put(DESCRIPTION,     new SimpleStringProperty());
            properties.put(GENERATION_TIME, new SimpleLongProperty());
            properties.put(STYLE,           new SimpleStringProperty());
        }

        @Override
        public TitleStep id(final Long id) {
            DefaultTagValidator.requireNonNull(id);
            
            properties.put(ID, new SimpleLongProperty(id));
        
            return this;
        }

        @Override
        public GenerationTimeStep title(final String title) {
            DefaultTagValidator.requireNonNullAndNotEmpty(title);
            
            properties.put(TITLE, new SimpleStringProperty(title));
            
            return this;
        }

        @Override
        public Step generationTime(final Long generationTime) {
            DefaultTagValidator.requireNonNull(generationTime);
            
            properties.put(GENERATION_TIME, new SimpleLongProperty(generationTime));
            
            return this;
        }

        @Override
        public Step description(final String description) {
            DefaultTagValidator.requireNonNullAndNotEmpty(description);
            
            properties.put(DESCRIPTION, new SimpleStringProperty(description));
            
            return this;
        }

        @Override
        public Step style(final String style) {
            DefaultTagValidator.requireNonNullAndNotEmpty(style);
            
            properties.put(STYLE, new SimpleStringProperty(style));
            
            return this;
        }

        @Override
        public Tag build() {
            // Catch data
            final LongProperty   id             = (LongProperty)   properties.get(ID);
            final StringProperty title          = (StringProperty) properties.get(TITLE);
            final LongProperty   generationTime = (LongProperty)   properties.get(GENERATION_TIME);
            final StringProperty description    = (StringProperty) properties.get(DESCRIPTION);
            final StringProperty style          = (StringProperty) properties.get(STYLE);

            // Create a new Tag
            return DefaultTag.create(
                    id.getValue(),
                    title.getValue(),
                    generationTime.getValue(),
                    Optional.ofNullable(description.getValue()),
                    Optional.ofNullable(style.getValue()));
        }

    }

}
