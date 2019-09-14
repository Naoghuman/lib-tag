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

import com.github.naoghuman.lib.tag.internal.DefaultTagContainerId;
import com.github.naoghuman.lib.tag.internal.DefaultTagValidator;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagContainerIdBuilder} 
 * the developer can create easily an unique {@code Id} and returned it as a {@link java.lang.String}.
 * <p>
 * The main point from this {@code builder} is the possibility to generate an unique {@code Id} for a relation 
 * between a {@link com.github.naoghuman.lib.tag.core.Tag} and the container where the {@code Tag} will be embbeded.
 * 
 * <ul>
 * <li>All attributes are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
 * </ul>
 *
 * @author  Naoghuman
 * @since   0.4.0
 * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
 * @see     com.github.naoghuman.lib.tag.core.TagRelation
 * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 */
public class TagContainerIdBuilder {
    
    /**
     * Starting point from this fluent builder to configure and create an unique {@code Id},
     * returned as a {@link java.lang.String}.
     * 
     * @return  the first step to generate and configured an unique {@code Id}.
     * @since   0.4.0
     * @version 0.4.0
     */
    public static final PathStep create() {
        
        return new TagContainerIdBuilderImpl();
        
    }
    
    /**
     * First mandory step to configure and create an unique {@code Id}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code path}.
     * 
     * @since   0.4.0
     * @version 0.4.0
     */
    public interface PathStep {
        
        /**
         * Setter for the mandory attribute {@code path}.
         * <p>
         * Internal {@link java.lang.Class#getCanonicalName()} will be used to 
         * defined the first part from the unique {@code Id}.
         * 
         * @param  path value for the attribute {@code path}.
         * @return the next step {@code ContainerStep} in this fluent builder.
         * @throws NullPointerException if {@code path} is NULL.
         * @since   0.4.0
         * @version 0.4.0
         */
        public ContainerStep path(final Class path);
        
    }
    
    /**
     * Second mandory step to configure and create an unique {@code Id}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code container}.
     * 
     * @since   0.4.0
     * @version 0.4.0
     */
    public interface ContainerStep {
        
        /**
         * Setter for the mandory attribute {@code container}.
         * <p>
         * Internal {@link java.lang.Class#getSimpleName()} will be used to 
         * defined the second part from the unique {@code Id}.
         * 
         * @param   container value for the attribute {@code container}.
         * @return  the next step {@code FxIdStep} in this fluent builder.
         * @throws  NullPointerException if {@code container} is NULL.
         * @since   0.4.0
         * @version 0.4.0
         */
        public FxIdStep container(final Class container);
        
    }
    
    /**
     * Third mandory step to configure and create an unique {@code Id}.
     * <p>
     * This {@code Interface} allowed to set the attribute {@code fxId}.
     * 
     * @since   0.4.0
     * @version 0.4.0
     */
    public interface FxIdStep {
        
        /**
         * Setter for the mandory attribute {@code fxId}.
         * 
         * @param   fxId value for the attribute {@code fxId}.
         * @return  the next step {@code Builder} in this fluent builder.
         * @throws  NullPointerException     if {@code fxId} is NULL.
         * @throws  IllegalArgumentException if {@code fxId} is EMPTY.
         * @since   0.4.0
         * @version 0.4.0
         */
        public Builder fxId(final String fxId);
        
    }
    
    /**
     * In the last step the unique {@code Id} will created and returned.
     * <p>
     * This {@code Interface} allowed to generate the {@code Id}.
     * 
     * @since   0.4.0
     * @version 0.4.0
     */
    public interface Builder {
        
        /**
         * Configure and generate the unique {@code Id} with the defined values 
         * from the previous steps.
         * 
         * @return  the generated and configured instance.
         * @since   0.4.0
         * @version 0.4.0
         * @see     com.github.naoghuman.lib.tag.core.TagRelation
         */
        public String build();
        
    }
    
    private static final class TagContainerIdBuilderImpl implements PathStep, ContainerStep, FxIdStep, Builder {

        private static final String PARA__PATH      = "path";      // NOI18N
        private static final String PARA__CONTAINER = "container"; // NOI18N
        private static final String PARA__FX_ID     = "fxId";      // NOI18N
        
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();
        
        TagContainerIdBuilderImpl() {
            this.init();
        }

        private void init() {
            // Mandory attributes
            properties.put(PARA__PATH,      new SimpleObjectProperty());
            properties.put(PARA__CONTAINER, new SimpleObjectProperty());
            properties.put(PARA__FX_ID,     new SimpleStringProperty());
        }

        @Override
        public ContainerStep path(final Class path) {
            DefaultTagValidator.requireNonNull(path);
            
            properties.put(PARA__PATH, new SimpleObjectProperty(path));
            
            return this;
        }

        @Override
        public FxIdStep container(final Class container) {
            DefaultTagValidator.requireNonNull(container);
            
            properties.put(PARA__CONTAINER, new SimpleObjectProperty(container));
            
            return this;
        }

        @Override
        public Builder fxId(final String containerId) {
            DefaultTagValidator.requireNonNullAndNotEmpty(containerId);
            
            properties.put(PARA__FX_ID, new SimpleStringProperty(containerId));
            
            return this;
        }

        @Override
        public String build() {
            // Catch data
            final ObjectProperty pathObjectProperty = (ObjectProperty) properties.get(PARA__PATH);
            final Class path = (Class) pathObjectProperty.get();
            
            final ObjectProperty containerObjectProperty = (ObjectProperty) properties.get(PARA__CONTAINER);
            final Class container = (Class) containerObjectProperty.get();
            
            final StringProperty fxIdStringProperty = (StringProperty) properties.get(PARA__FX_ID);
            final String fxId = fxIdStringProperty.get();
            
            // and returned the unique id
            return DefaultTagContainerId.getDefault().generateId(path, container, fxId);
        }
        
    }
    
}
