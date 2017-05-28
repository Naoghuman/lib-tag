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

/**
 *
 * @author Naoghuman
 */
public class TagRelationBuilderAllowedSteps {
    
    TagRelationBuilderAllowedSteps() {
        
        /*
        The TagRelationBuilder creates an TagRelation which can be used to map
        a Tag to a gui component. All attributes in the builder are mandory.
        */
        final TagRelation tagRelation = TagRelationBuilder.create()
                .id(0L)                         // mandory
                .tagId(0L)                      // mandory
                .containerId("containerId")     // mandory (NOT NULL && NOT EMPTY)
                .containerType("containerType") // mandory (NOT NULL && NOT EMPTY)
                .build();
        
    }
    
}
