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
package com.github.naoghuman.lib.tag.components.core;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public interface TagFlowPane {
    
    /**
     * TODO
     * 
     * @param flowPane
     * @param tagsAsButtons 
     */
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons);
    
    /**
     * TODO
     * 
     * @param flowPane
     * @param tagsAsLabels 
     */
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels);
    
    /**
     * TODO
     * 
     * @param flowPane
     * @param tagsAsButtons
     * @param style 
     */
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons, final String style);
    
    /**
     * TODO
     * 
     * @param flowPane
     * @param tagsAsLabels
     * @param style 
     */
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels, final String style);
    
    /**
     * TODO
     * 
     * @param tagsAsButtons
     * @return 
     */
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons);
    
    /**
     * TODO
     * 
     * @param tagsAsLabels
     * @return 
     */
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels);
    
    /**
     * TODO
     * 
     * @param tagsAsButtons
     * @param style
     * @return 
     */
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons, final String style);
    
    /**
     * TODO
     * 
     * @param tagsAsLabels
     * @param style
     * @return 
     */
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels, final String style);

    /**
     * TODO
     * 
     * @param defaultStyleForTagButtons 
     */
    public void setFlowPaneDefaultStyleForTagButtons(final String defaultStyleForTagButtons);

    /**
     * TODO
     * 
     * @param defaultStyleForTagLabels 
     */
    public void setFlowPaneDefaultStyleForTagLabels(final String defaultStyleForTagLabels);

}
