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

import javafx.scene.layout.AnchorPane;

/**
 * Example usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder} 
 * for the documentation.
 *
 * @author  Naoghuman
 * @since   0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder
 */
public class TagRelationContainerIdBuilderAllowedSteps {
    
    TagRelationContainerIdBuilderAllowedSteps() {
        
        /**
         * With the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder} 
         * its possible to create easly an unique {@code Id} which can be used to map a 
         * {@link com.github.naoghuman.lib.tag.core.Tag} against a gui component.
         * 
         * For more information about how to map a {@code Tag} with a container see 
         * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
         * 
         * <ul>
         * <li>All attributes in the builder are {@code mandory}.</li>
         * <li>All defined values will be validate against the {@code Interface} {@code TagValidator}.</li>
         * </ul>
         * 
         * @see com.github.naoghuman.lib.tag.core.Tag
         * @see com.github.naoghuman.lib.tag.core.TagRelation
         * @see com.github.naoghuman.lib.tag.core.TagRelationBuilder
         * @see com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder
         * @see com.github.naoghuman.lib.tag.core.TagValidator
         */
        final String tagRelationContainerId = TagRelationContainerIdBuilder.create()
                .path(TagRelationContainerId.class) // mandory (NOT NULL)
                .container(AnchorPane.class)        // mandory (NOT NULL)
                .containerId("container-id")        // mandory (NOT NULL && NOT EMPTY)
                .build();
        
    }
    
}
