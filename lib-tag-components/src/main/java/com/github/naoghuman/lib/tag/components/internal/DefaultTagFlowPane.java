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
package com.github.naoghuman.lib.tag.components.internal;

import com.github.naoghuman.lib.tag.components.core.TagFlowPane;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.1.0
 */
public final class DefaultTagFlowPane implements TagFlowPane {

    private String defaultStyleForTagButtons = "default-style-for-tag-flowpane-with-buttons";

    private String defaultStyleForTagLabels = "default-style-for-tag-flowpane-with-labels";
    
    public DefaultTagFlowPane() {
        this.initialize();
    }
    
    private void initialize() {
        
    }

    @Override
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons) {
        this.configureFlowPaneWithTagsAsButtons(flowPane, tagsAsButtons, defaultStyleForTagButtons);
    }

    @Override
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels) {
        this.configureFlowPaneWithTagsAsLabels(flowPane, tagsAsLabels, defaultStyleForTagLabels);
    }

    @Override
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons, final String style) {
        flowPane.getChildren().clear();
        flowPane.getChildren().addAll(tagsAsButtons);
        flowPane.setStyle(style);
    }

    @Override
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels, final String style) {
        flowPane.getChildren().clear();
        flowPane.getChildren().addAll(tagsAsLabels);
        flowPane.setStyle(style);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons) {
        return this.getFlowPaneWithTagsAsButtons(tagsAsButtons, defaultStyleForTagButtons);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels) {
        return this.getFlowPaneWithTagsAsLabels(tagsAsLabels, defaultStyleForTagLabels);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons, final String style) {
        final FlowPane flowPane = new FlowPane(7.0d, 7.0d);
        flowPane.getChildren().addAll(tagsAsButtons);
        flowPane.setStyle(style);
        
        return flowPane;
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels, final String style) {
        final FlowPane flowPane = new FlowPane(7.0d, 7.0d);
        flowPane.getChildren().addAll(tagsAsLabels);
        flowPane.setStyle(style);
        
        return flowPane;
    }

    @Override
    public void setFlowPaneDefaultStyleForTagButtons(final String defaultStyleForTagButtons) {
        this.defaultStyleForTagButtons = defaultStyleForTagButtons;
    }

    @Override
    public void setFlowPaneDefaultStyleForTagLabels(final String defaultStyleForTagLabels) {
        this.defaultStyleForTagLabels = defaultStyleForTagLabels;
    }
    
}
