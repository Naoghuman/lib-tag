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
package com.github.naoghuman.lib.tag.component.core;

import com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator;
import com.github.naoghuman.lib.tag.core.Tag;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.control.Label} 
 * configured with a {@link com.github.naoghuman.lib.tag.core.Tag} and different 
 * {@link javafx.event.EventHandler}s.
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>Any attribute will be validate against {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.event.EventHandler
 * @see    javafx.scene.control.Label
 */
public final class TagLabelBuilder {

    /**
     * Starting point from this fluent builder to generate and configured an instance 
     * from a {@link javafx.scene.control.Label} configured with the given 
     * {@link com.github.naoghuman.lib.tag.core.Tag} and different {@link javafx.event.EventHandler}s.
     * <p>
     * Internal all attributes will be validate against 
     * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the first step {@code TagStep} from this fluent builder.
     * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.scene.control.Label
     * @see    javafx.scene.control.EventHandler
     */
    public static final TagStep create() {
        return new TagLabelBuilderImpl();
    }
    
    /**
     * First mandory step to generate and configured an instance from a 
     * {@link javafx.scene.control.Label}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code tag}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Label
     */
    public interface TagStep {
        
        /**
         * Setter for the mandory attribute {@code tag} in the upcoming instance 
         * from the {@link javafx.scene.control.Label}.
         * <p>
         * Internal the attribute {@code tag} will be checked if it isn't NULL with
         * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  tag value for the attribute {@code tag}.
         * @return the second step {@code MouseHandlerStep} in this fluent builder.
         * @throws NullPointerException if {@code tag} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    com.github.naoghuman.lib.tag.core.Tag
         * @see    javafx.scene.control.Label
         */
        public MouseHandlerStep tag(final Tag tag);
        
    }
    
    /**
     * Second mandory step to generate and configured an instance from a 
     * {@link javafx.scene.control.Label}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code mouseHandler}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Label
     */
    public interface MouseHandlerStep {
        
        /**
         * Setter for the mandory attribute {@code mouseHandler} in the upcoming 
         * instance from the {@link javafx.scene.control.Label}.
         * <p>
         * Internal the attribute {@code mouseHandler} will be checked if it isn't NULL with
         * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  mouseHandler value for the attribute {@code mouseHandler}.
         * @return the second step {@code MouseHandlerStep} in this fluent builder.
         * @throws NullPointerException if {@code mouseHandler} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    javafx.event.EventHandler
         * @see    javafx.scene.control.Label
         * @see    javafx.scene.input.MouseEvent
         */
        public BuilderStep mouseHandler(final EventHandler<MouseEvent> mouseHandler);
        
    }
    
    /**
     * Last step to generate and configured an instance from a 
     * {@link javafx.scene.control.Label}.
     * <br>
     * This {@code Interface} returned the generated and configured {@code Label} 
     * in context from the library {@code Lib-Tag}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Label
     */
    public interface BuilderStep {
        
        /**
         * Generated and configured an instance from a {@link javafx.scene.control.Label}
         * with the used values from the previous steps.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @return the generated and configured {@code Label}.
         * @see    javafx.scene.control.Label
         */
        public Label build();
        
    }
    
    private static final class TagLabelBuilderImpl implements BuilderStep, MouseHandlerStep, TagStep {
        
        private static final String PARA__TAG           = "PARA__TAG"; // NOI18N
        private static final String PARA__MOUSE_HANDLER = "PARA__MOUSE_HANDLER";  // NOI18N
        
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagLabelBuilderImpl() {
            this.init();
        }
        
        private void init() {
            // Mandory attributes
            properties.put(PARA__TAG,           new SimpleObjectProperty());
            properties.put(PARA__MOUSE_HANDLER, new SimpleObjectProperty());
        }

        @Override
        public MouseHandlerStep tag(final Tag tag) {
            DefaultTagComponentValidator.getDefault().requireNonNull(tag);
            
            return this;
        }

        @Override
        public BuilderStep mouseHandler(final EventHandler<MouseEvent> mouseHandler) {
            DefaultTagComponentValidator.getDefault().requireNonNull(mouseHandler);
            
            return this;
        }

        @Override
        public Label build() {
            // Catch data
            final ObjectProperty tagObjectProperty          = (ObjectProperty) properties.get(PARA__TAG);
            final ObjectProperty mouseHandlerObjectProperty = (ObjectProperty) properties.get(PARA__MOUSE_HANDLER);
            
            final Tag tag = (Tag) tagObjectProperty.getValue();
            final EventHandler<MouseEvent> mouseHandler  = (EventHandler<MouseEvent>) mouseHandlerObjectProperty.getValue();
            
            // Create the label
            final Label lbl = new Label();
            lbl.setText(tag.getTitle());
            lbl.setOnMouseClicked(mouseHandler);
            lbl.setUserData(tag);
            
            if (tag.getStyle().isPresent()) {
               lbl.setStyle(tag.getStyle().get()); 
            }
            
            return lbl;
        }
        
    }
    
}
