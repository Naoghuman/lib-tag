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

/**
 * Example usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * for the documentation.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 */
public class TagBuilderAllowedSteps {
    
    TagBuilderAllowedSteps() {
        
        /**
         * With the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
         * its possible to create easly a {@code Tag} which is the preferred way.
         * 
         * <ul>
         * <li>The first three attributes {@code id}, {@code title} and {@code generationTime} are mandory.</li>
         * <li>All other attributes are {@code optional}.</li>
         * <li>All defined values will be validate against the {@code Interface} {@code TagValidator}.</li>
         * </ul>
         * 
         * @see com.github.naoghuman.lib.tag.core.Tag
         * @see com.github.naoghuman.lib.tag.core.TagBuilder
         * @see com.github.naoghuman.lib.tag.core.TagValidator
         */
        final Tag tag = TagBuilder.create()
                .id(Tag.DEFAULT_ID)               // mandory (NOT NULL)
                .title("title")                   // mandory (NOT NULL && NOT EMPTY)
                .generationTime(Long.MIN_VALUE)   // mandory (NOT NULL)
                .description("description")       // optional
                .style("style")                   // optional
                .build();
    }
    
}






























