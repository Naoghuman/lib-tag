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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.layout.FlowPane} 
 * configured with a list from {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s 
 * which elements presented a {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>Any attribute will be validate against {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.</li>
 * </ul>
 * 
 * The list ({@code buttons} or {@code labels}) can easily with the fluent builders 
 * {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} or 
 * {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 * @see    javafx.scene.layout.FlowPane
 */
public final class TagFlowPaneBuilder {

    /**
     * Starting point from this fluent builder to generate and configured an instance 
     * from a {@link javafx.scene.layout.FlowPane} configured with a list from 
     * {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s 
     * which elements presented a {@link com.github.naoghuman.lib.tag.core.Tag}.
     * <p>
     * Internal all attributes will be validate against 
     * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @return the first step {@code StyleStep} from this fluent builder.
     * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.scene.control.Button
     * @see    javafx.scene.control.Label
     * @see    javafx.scene.layout.FlowPane
     */
    public static final StyleStep create() {
        return new TagFlowPaneBuilderImpl();
    }
    
    /**
     * First mandory step to generate and configured an instance from a 
     * {@link javafx.scene.layout.FlowPane}.
     * <br>
     * This {@code Interface} allowed to set the attribute {@code style}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.layout.FlowPane
     */
    public interface StyleStep {
        
        /**
         * Setter for the mandory attribute {@code style} in the upcoming instance 
         * from the generated {@link javafx.scene.layout.FlowPane}.
         * <p>
         * Internal the attribute {@code style} will be checked if it isn't NULL and 
         * not EMPTY with {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  style value for the attribute {@code style}.
         * @return the second step {@code ChildrenStep} in this fluent builder.
         * @throws NullPointerException     if {@code style} is NULL.
         * @throws IllegalArgumentException if {@code style} is EMPTY.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    com.github.naoghuman.lib.tag.core.Tag
         * @see    javafx.scene.layout.FlowPane
         */
        public ChildrenStep style(final String style);
        
    }
    
    /**
     * Second mandory step to generate and configured an instance from a 
     * {@link javafx.scene.layout.FlowPane}.
     * <br>
     * This {@code Interface} allowed to set the childrens from the {@code FlowPane}. 
     * Either this can be a list from {@link javafx.scene.control.Button}s or a list 
     * {@link javafx.scene.control.Label}s which elements presented a 
     * {@link com.github.naoghuman.lib.tag.core.Tag}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.scene.control.Button
     * @see    javafx.scene.control.Label
     * @see    javafx.scene.layout.FlowPane
     */
    public interface ChildrenStep {
        
        /**
         * Setter for the mandory attribute {@code buttons} in the upcoming instance 
         * from the generated {@link javafx.scene.layout.FlowPane}.
         * <p>
         * Internal the attribute {@code buttons} will be checked if it isn't NULL 
         * with {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  buttons value for the attribute {@code buttons}.
         * @return the last step {@code BuilderStep} in this fluent builder.
         * @throws NullPointerException if {@code buttons} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    javafx.scene.control.Button
         */
        public BuilderStep buttons(final ObservableList<Button> buttons);
        
        /**
         * Setter for the mandory attribute {@code labels} in the upcoming instance 
         * from the generated {@link javafx.scene.layout.FlowPane}.
         * <p>
         * Internal the attribute {@code labels} will be checked if it isn't NULL 
         * with {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @param  labels value for the attribute {@code labels}.
         * @return the last step {@code BuilderStep} in this fluent builder.
         * @throws NullPointerException if {@code labels} is NULL.
         * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
         * @see    javafx.scene.control.Label
         */
        public BuilderStep labels(final ObservableList<Label> labels);
        
    }
    
    /**
     * Last step to generate and configured an instance from a 
     * {@link javafx.scene.layout.FlowPane} in context from the library {@code Lib-Tag}.
     * <br>
     * This {@code Interface} returned the generated and configured {@code FlowPane}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    javafx.scene.layout.FlowPane
     */
    public interface BuilderStep {
        
        /**
         * Generated and configured an instance from a {@link javafx.scene.layout.FlowPane}
         * with the used values from the previous steps.
         * 
         * @author Naoghuman
         * @since  0.3.0
         * @return the generated and configured {@code FlowPane}.
         * @see    javafx.scene.layout.FlowPane
         */
        public FlowPane build();
        
    }
    
    private static final class TagFlowPaneBuilderImpl implements BuilderStep, ChildrenStep, StyleStep {
        
        private static final String PARA__BUTTONS = "PARA__BUTTONS"; // NOI18N
        private static final String PARA__LABELS  = "PARA__LABELS";  // NOI18N
        private static final String PARA__STYLE   = "PARA__STYLE";   // NOI18N

        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();
        
        private boolean buttonsAsChildren = Boolean.FALSE;
        private boolean labelsAsChildren  = Boolean.FALSE;

        TagFlowPaneBuilderImpl() {
            this.init();
        }
        
        private void init() {
            // Mandory attributes
            properties.put(PARA__BUTTONS, new SimpleObjectProperty());
            properties.put(PARA__LABELS,  new SimpleObjectProperty());
            properties.put(PARA__STYLE,   new SimpleStringProperty());
        }

        @Override
        public ChildrenStep style(final String style) {
            DefaultTagComponentValidator.getDefault().requireNonNullAndNotEmpty(style);
            
            properties.put(PARA__STYLE, new SimpleStringProperty(style));
        
            return this;
        }

        @Override
        public BuilderStep buttons(final ObservableList<Button> buttons) {
            DefaultTagComponentValidator.getDefault().requireNonNull(buttons);
            
            properties.put(PARA__BUTTONS, new SimpleObjectProperty(buttons));
            buttonsAsChildren = Boolean.TRUE;
        
            return this;
        }

        @Override
        public BuilderStep labels(final ObservableList<Label> labels) {
            DefaultTagComponentValidator.getDefault().requireNonNull(labels);
            
            properties.put(PARA__LABELS, new SimpleObjectProperty(labels));
            labelsAsChildren = Boolean.TRUE;
        
            return this;
        }

        @Override
        public FlowPane build() {
            // Catch data
            final StringProperty styleObjectProperty   = (StringProperty) properties.get(PARA__STYLE);
            final ObjectProperty buttonsObjectProperty = (ObjectProperty) properties.get(PARA__BUTTONS);
            final ObjectProperty labelsObjectProperty  = (ObjectProperty) properties.get(PARA__LABELS);

            final String style = styleObjectProperty.getValue();
            final ObservableList<Button> buttons = (ObservableList<Button>) buttonsObjectProperty.getValue();
            final ObservableList<Label>  labels  = (ObservableList<Label>) labelsObjectProperty.getValue();
            
            // Create the flowpane
            final FlowPane fp = new FlowPane();
            fp.setStyle(style);
            
            if (buttonsAsChildren) {
                fp.getChildren().addAll(buttons);
            }
            
            if (labelsAsChildren) {
                fp.getChildren().addAll(labels);
            }
            
            return fp;
        }
        
    }
    
}
