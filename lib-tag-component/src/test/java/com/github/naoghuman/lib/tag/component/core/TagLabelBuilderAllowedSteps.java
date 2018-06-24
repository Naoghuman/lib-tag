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

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Examples for the documentation how to use the fluent builder 
 * {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
 */
public class TagLabelBuilderAllowedSteps {
    
    TagLabelBuilderAllowedSteps() {
        
        /**
         * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder} 
         * allowed to create easly a configured {@link javafx.scene.control.Label} with the 
         * given {@link com.github.naoghuman.lib.tag.core.Tag}.
         * 
         * <ul>
         * <li>All attributes are mandory.</li>
         * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
         * </ul>
         * 
         * @see com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
         * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
         * @see com.github.naoghuman.lib.tag.core.Tag
         * @see javafx.scene.control.Label
         */
        final Label lbl = TagLabelBuilder.create()
                .tag(null)          // mandory (NOT NULL)
                .mouseHandler(null) // mandory (NOT NULL)
                .build();
        
        // Example from the usage from the enum TagComponentMouseHandler.MouseClick
        final EventHandler<MouseEvent>  mouseHandler = TagComponentMouseHandler.mouseHandler(Long.MIN_VALUE, 
                TagComponentMouseHandler.MouseClick.DOUBLE_LEFT_CLICK);
        final Label lbl2 = TagLabelBuilder.create()
                .tag(null)                  // mandory (NOT NULL)
                .mouseHandler(mouseHandler) // mandory (NOT NULL)
                .build();
        
    }
    
}
