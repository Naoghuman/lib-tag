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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.control.Button} 
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
 */
public final class TagButtonBuilder {

    /**
     * Starting point from this fluent builder to generate and configured an instance 
     * from a {@link javafx.scene.control.Button} configured with the given 
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
     * @see    javafx.scene.control.Button
     * @see    javafx.scene.control.EventHandler
     */
    public static final TagStep create() {
        return new TagButtonBuilderImpl();
    }
    
    /**
     * First mandory step to generate and configured an instance from a 
     * {@link javafx.scene.control.Button}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code tag}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Button
     */
    public interface TagStep {
        
        /**
         * Setter for the mandory attribute {@code tag} in the upcoming instance 
         * from the {@link javafx.scene.control.Button}.
         * <p>
         * Internal the attribute {@code tag} will be checked if it isn't NULL with
         * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  tag value for the attribute {@code tag}.
         * @return the second step {@code ActionHandlerStep} in this fluent builder.
         * @throws NullPointerException if {@code tag} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    com.github.naoghuman.lib.tag.core.Tag
         * @see    javafx.scene.control.Button
         */
        public ActionHandlerStep tag(final Tag tag);
        
    }
    
    /**
     * Second mandory step to generate and configured an instance from a 
     * {@link javafx.scene.control.Button}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code actionHandler}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Button
     */
    public interface ActionHandlerStep {
        
        /**
         * Setter for the mandory attribute {@code actionHandler} in the upcoming 
         * instance from the {@link javafx.scene.control.Button}.
         * <p>
         * Internal the attribute {@code actionHandler} will be checked if it isn't NULL with
         * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  actionHandler value for the attribute {@code actionHandler}.
         * @return the third step {@code MouseHandlerStep} in this fluent builder.
         * @throws NullPointerException if {@code actionHandler} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    javafx.event.ActionEvent
         * @see    javafx.event.EventHandler
         * @see    javafx.scene.control.Button
         */
        public MouseHandlerStep actionHandler(final EventHandler<ActionEvent> actionHandler);
        
    }
    
    /**
     * Third mandory step to generate and configured an instance from a 
     * {@link javafx.scene.control.Button}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code mouseHandler}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Button
     */
    public interface MouseHandlerStep {
        
        /**
         * Setter for the mandory attribute {@code mouseHandler} in the upcoming 
         * instance from the {@link javafx.scene.control.Button}.
         * <p>
         * Internal the attribute {@code mouseHandler} will be checked if it isn't NULL with
         * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  mouseHandler value for the attribute {@code mouseHandler}.
         * @return the third step {@code MouseHandlerStep} in this fluent builder.
         * @throws NullPointerException if {@code mouseHandler} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    javafx.event.EventHandler
         * @see    javafx.scene.control.Button
         * @see    javafx.scene.input.MouseEvent
         */
        public BuilderStep mouseHandler(final EventHandler<MouseEvent> mouseHandler);
        
    }
    
    /**
     * Last step to generate and configured an instance from a 
     * {@link javafx.scene.control.Button}.
     * <br>
     * This {@code Interface} return the generated and configured {@code button}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.control.Button
     */
    public interface BuilderStep {
        
        /**
         * Generated and configured an instance from a {@link javafx.scene.control.Button}
         * with the used values from the previous steps.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @return the generated and configured {@code button}.
         * @see    javafx.scene.control.Button
         */
        public Button build();
        
    }
    
    private static final class TagButtonBuilderImpl implements ActionHandlerStep, BuilderStep, MouseHandlerStep, TagStep {
        
        private static final String PARA__ACTION_HANDLER = "PARA__ACTION_HANDLER"; // NOI18N
        private static final String PARA__MOUSE_HANDLER  = "PARA__MOUSE_HANDLER";  // NOI18N
        private static final String PARA__TAG            = "PARA__TAG";            // NOI18N

        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagButtonBuilderImpl() {
            this.init();
        }
        
        private void init() {
            // Mandory attributes
            properties.put(PARA__ACTION_HANDLER, new SimpleObjectProperty());
            properties.put(PARA__MOUSE_HANDLER,  new SimpleObjectProperty());
            properties.put(PARA__TAG,            new SimpleObjectProperty());
        }
        
        @Override
        public ActionHandlerStep tag(final Tag tag) {
            DefaultTagComponentValidator.getDefault().requireNonNull(tag);
            
            properties.put(PARA__TAG, new SimpleObjectProperty(tag));
        
            return this;
        }

        @Override
        public MouseHandlerStep actionHandler(final EventHandler<ActionEvent> actionHandler) {
            DefaultTagComponentValidator.getDefault().requireNonNull(actionHandler);
            
            properties.put(PARA__ACTION_HANDLER, new SimpleObjectProperty(actionHandler));
        
            return this;
        }

        @Override
        public BuilderStep mouseHandler(final EventHandler<MouseEvent> mouseHandler) {
            DefaultTagComponentValidator.getDefault().requireNonNull(mouseHandler);
            
            properties.put(PARA__MOUSE_HANDLER, new SimpleObjectProperty(mouseHandler));
        
            return this;
        }

        @Override
        public Button build() {
            // Catch data
            final ObjectProperty tagObjectProperty           = (ObjectProperty) properties.get(PARA__TAG);
            final ObjectProperty actionHandlerObjectProperty = (ObjectProperty) properties.get(PARA__ACTION_HANDLER);
            final ObjectProperty mouseHandlerObjectProperty  = (ObjectProperty) properties.get(PARA__MOUSE_HANDLER);

            final Tag tag = (Tag) tagObjectProperty.getValue();
            final EventHandler<ActionEvent> actionHandler = (EventHandler<ActionEvent>) actionHandlerObjectProperty.getValue();
            final EventHandler<MouseEvent>  mouseHandler  = (EventHandler<MouseEvent>)  mouseHandlerObjectProperty.getValue();
            
            // Create the button
            final Button btn = new Button();
            btn.setText(tag.getTitle());
            btn.setOnAction(actionHandler);
            btn.setOnMouseClicked(mouseHandler);
            btn.setUserData(tag);
            
            if (tag.getStyle().isPresent()) {
               btn.setStyle(tag.getStyle().get()); 
            }
            
            return btn;
        }
        
    }
    
}
