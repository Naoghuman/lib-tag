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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Examples for the documentation how to use the fluent builder 
 * {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 */
public class TagButtonBuilderAllowedSteps {
    
    TagButtonBuilderAllowedSteps() {
        
        /**
         * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} 
         * allowed to create easly a configured {@link javafx.scene.control.Button} with the 
         * given {@link com.github.naoghuman.lib.tag.core.Tag}.
         * 
         * <ul>
         * <li>All attributes are mandory.</li>
         * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
         * </ul>
         * 
         * @see com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
         * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
         * @see com.github.naoghuman.lib.tag.core.Tag
         * @see javafx.scene.control.Button
         */
        final Button btn = TagButtonBuilder.create()
                .tag(null)           // mandory (NOT NULL)
                .actionHandler(null) // mandory (NOT NULL)
                .mouseHandler(null)  // mandory (NOT NULL)
                .build();
        
        // Example from the usage from TagComponentEventHandler
        final EventHandler<ActionEvent> actionHandler = TagComponentEventHandler.actionHandler(Long.MIN_VALUE);
        final EventHandler<MouseEvent>  mouseHandler  = TagComponentEventHandler.mouseHandler(Long.MIN_VALUE, 
                TagComponentEventHandler.MouseClick.ONE_RIGHT_CLICK);
        final Button btn2 = TagButtonBuilder.create()
                .tag(null)                    // mandory (NOT NULL)
                .actionHandler(actionHandler) // mandory (NOT NULL)
                .mouseHandler(mouseHandler)   // mandory (NOT NULL)
                .build();
    }
    
}
