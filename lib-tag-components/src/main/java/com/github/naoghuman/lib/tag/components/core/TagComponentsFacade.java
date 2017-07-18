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

import java.util.Optional;

import com.github.naoghuman.lib.tag.components.internal.DefaultTagButton;
import com.github.naoghuman.lib.tag.components.internal.DefaultTagFlowPane;
import com.github.naoghuman.lib.tag.components.internal.DefaultTagLabel;
import com.github.naoghuman.lib.tag.components.internal.TagButton;
import com.github.naoghuman.lib.tag.components.internal.TagFlowPane;
import com.github.naoghuman.lib.tag.components.internal.TagLabel;
import com.github.naoghuman.lib.tag.core.Tag;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

/**
 * Over the {@code Class} {@link com.github.naoghuman.lib.tag.components.core.TagComponentsFacade} 
 * the developer have access to different possibilities to show a {@link  com.github.naoghuman.lib.tag.core.Tag} 
 * in different {@code JavaFX} gui components.
 * <p>
 * Momentary following possibilities exists:<br>
 * Show a {@code Tag} as a
 * <ul>
 * <li>JavaFX {@link javafx.scene.control.Buttton}.</li>
 * <li>JavaFX {@link javafx.scene.control.Label}.</li>
 * </ul>
 * Show a {@link java.util.List} of {@code Tag}s in a
 * <ul>
 * <li>JavaFX {@link javafx.scene.layout.FlowPane}.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.1.0
 */
public class TagComponentsFacade implements TagButton, TagFlowPane, TagLabel {

    private static final Optional<TagComponentsFacade> INSTANCE = Optional.of(new TagComponentsFacade());

    /**
     * Returns a singleton instance from the class {@code TagComponentsFacade}.
     * 
     * @return a singleton instance from the class {@code TagComponentsFacade}.
     */
    public static final TagComponentsFacade getDefault() {
        return INSTANCE.get();
    }
    
    private TagButton tagButton;
    private TagFlowPane tagFlowPane;
    private TagLabel tagLabel;

    private TagComponentsFacade() {
        this.initialize();
    }
    
    private void initialize() {
        tagButton   = new DefaultTagButton();
        tagFlowPane = new DefaultTagFlowPane();
        tagLabel    = new DefaultTagLabel();
    }

    @Override
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons) {
        tagFlowPane.configureFlowPaneWithTagsAsButtons(flowPane, tagsAsButtons);
    }

    @Override
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels) {
        tagFlowPane.configureFlowPaneWithTagsAsLabels(flowPane, tagsAsLabels);
    }

    @Override
    public void configureFlowPaneWithTagsAsButtons(final FlowPane flowPane, final ObservableList<Button> tagsAsButtons, final String style) {
        tagFlowPane.configureFlowPaneWithTagsAsButtons(flowPane, tagsAsButtons, style);
    }

    @Override
    public void configureFlowPaneWithTagsAsLabels(final FlowPane flowPane, final ObservableList<Label> tagsAsLabels, final String style) {
        tagFlowPane.configureFlowPaneWithTagsAsLabels(flowPane, tagsAsLabels, style);
    }

    @Override
    public EventHandler<ActionEvent> getActionHandlerForButton(final long tagId) {
        return tagButton.getActionHandlerForButton(tagId);
    }

    @Override
    public EventHandler<ActionEvent> getActionHandlerForButton(final String actionId, final long tagId) {
        return tagButton.getActionHandlerForButton(actionId, tagId);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons) {
        return tagFlowPane.getFlowPaneWithTagsAsButtons(tagsAsButtons);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels) {
        return tagFlowPane.getFlowPaneWithTagsAsLabels(tagsAsLabels);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsButtons(final ObservableList<Button> tagsAsButtons, final String style) {
        return tagFlowPane.getFlowPaneWithTagsAsButtons(tagsAsButtons, style);
    }

    @Override
    public FlowPane getFlowPaneWithTagsAsLabels(final ObservableList<Label> tagsAsLabels, final String style) {
        return tagFlowPane.getFlowPaneWithTagsAsLabels(tagsAsLabels, style);
    }

    @Override
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final long tagId) {
        return tagLabel.getMouseHandlerForLabel(tagId);
    }

    @Override
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final String actionId, final long tagId) {
        return tagLabel.getMouseHandlerForLabel(actionId, tagId);
    }

    @Override
    public Button getTagAsButton(final Tag tag) {
        return tagButton.getTagAsButton(tag);
    }

    @Override
    public Button getTagAsButton(final Tag tag, final EventHandler<ActionEvent> eventHandler) {
        return tagButton.getTagAsButton(tag, eventHandler);
    }

    @Override
    public Button getTagAsButton(final Tag tag, String style, final EventHandler<ActionEvent> eventHandler) {
        return tagButton.getTagAsButton(tag, style, eventHandler);
    }

    @Override
    public Label getTagAsLabel(final Tag tag) {
        return tagLabel.getTagAsLabel(tag);
    }

    @Override
    public Label getTagAsLabel(final Tag tag, final EventHandler<MouseEvent> eventHandler) {
        return tagLabel.getTagAsLabel(tag, eventHandler);
    }

    @Override
    public Label getTagAsLabel(final Tag tag, final String style, final EventHandler<MouseEvent> eventHandler) {
        return tagLabel.getTagAsLabel(tag, style, eventHandler);
    }

    @Override
    public void setButtonDefaultActionId(final String defaultActionId) {
        tagButton.setButtonDefaultActionId(defaultActionId);
    }

    @Override
    public void setButtonDefaultStyle(final String defaultStyle) {
        tagButton.setButtonDefaultStyle(defaultStyle);
    }
    
    @Override
    public void setFlowPaneDefaultStyleForTagButtons(final String defaultStyleForTagButtons) {
        tagFlowPane.setFlowPaneDefaultStyleForTagButtons(defaultStyleForTagButtons);
    }

    @Override
    public void setFlowPaneDefaultStyleForTagLabels(final String defaultStyleForTagLabels) {
        tagFlowPane.setFlowPaneDefaultStyleForTagLabels(defaultStyleForTagLabels);
    }

    @Override
    public void setLabelDefaultActionId(final String defaultActionId) {
        tagLabel.setLabelDefaultActionId(defaultActionId);
    }

    @Override
    public void setLabelDefaultStyle(final String defaultStyle) {
        tagLabel.setLabelDefaultStyle(defaultStyle);
    }
    
}
