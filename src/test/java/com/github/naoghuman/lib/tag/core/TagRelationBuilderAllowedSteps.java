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

import javafx.scene.layout.AnchorPane;

/**
 * Example usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} 
 * for the documentation.
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see     com.github.naoghuman.lib.tag.core.TagContainerIdBuilder
 */
public class TagRelationBuilderAllowedSteps {
    
    TagRelationBuilderAllowedSteps() {
        
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
        final TagRelation tagRelation = TagRelationBuilder.create()
                .id(TagRelation.DEFAULT_ID)                  // mandory (NOT NULL)
                .tagId(0L)                                   // mandory (NOT NULL)
                .containerId(TagContainerIdBuilder.create()
                        .path(TagContainerId.class)          // mandory (NOT NULL)
                        .container(AnchorPane.class)         // mandory (NOT NULL)
                        .fxId("fx-id")                       // mandory (NOT NULL && NOT EMPTY)
                        .build())
                .build();
        
    }
    
}
