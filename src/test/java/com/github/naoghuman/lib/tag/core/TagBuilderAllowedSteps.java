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
        final Tag tag = TagBuilder.create()
                .id(Tag.DEFAULT_ID)               // mandory (NOT NULL)
                .title("title")                   // mandory (NOT NULL && NOT EMPTY)
                .generationTime(Long.MIN_VALUE)   // mandory (NOT NULL)
                .description("description")       // optional
                .style("style")                   // optional
                .build();
    }
    
}






























