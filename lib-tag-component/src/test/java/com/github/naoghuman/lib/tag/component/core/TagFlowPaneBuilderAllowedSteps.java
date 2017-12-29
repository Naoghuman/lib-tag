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

import javafx.scene.layout.FlowPane;

/**
 * Examples for the documentation how to use the fluent builder 
 * {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
 */
public class TagFlowPaneBuilderAllowedSteps {
    
    TagFlowPaneBuilderAllowedSteps() {
        
        /**
         * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder} 
         * allowed to configured a {@link javafx.scene.layout.FlowPane} with a list from 
         * {@link com.github.naoghuman.lib.tag.core.Tag} which are wrapped in 
         * {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s.
         * 
         * <ul>
         * <li>All attributes are mandory.</li>
         * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
         * </ul>
         * 
         * @see com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
         * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
         * @see com.github.naoghuman.lib.tag.core.Tag
         * @see javafx.scene.control.Button
         * @see javafx.scene.control.Label
         * @see javafx.scene.layout.FlowPane
         */
        final FlowPane fpWithButtons = TagFlowPaneBuilder.create()
                .style("style") // mandory (NOT NULL)
                .buttons(null)  // mandory (NOT NULL)
                .build();
        
        final FlowPane fpWithLabels = TagFlowPaneBuilder.create()
                .style("style") // mandory (NOT NULL)
                .labels(null)   // mandory (NOT NULL)
                .build();
    }
    
}
