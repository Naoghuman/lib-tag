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

import com.github.naoghuman.lib.tag.components.core.TagLabel;
import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.tag.core.Tag;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public final class DefaultTagLabel implements TagLabel {

    private String defaultActionId = "ON_ACTION_SHOW_TAG_POPUP";    // NOI18N
    private String defaultStyle    = "default-style-for-tag-label"; // NOI18N
    
    public DefaultTagLabel() {
        this.initialize();
    }
    
    private void initialize() {
        
    }
    
    private Label configureButton(final Tag tag, final String style, final EventHandler<MouseEvent> eventHandler) {
        final Label label = new Label();
        label.setText(tag.getTitle());
        label.setStyle(style);
        label.setOnMouseClicked(eventHandler);
        label.setUserData(tag);
        
        return label;
    }

    @Override
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final long tagId) {
        return this.getMouseHandlerForLabel(defaultActionId, tagId);
    }

    @Override
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final String actionId, final long tagId) {
        final EventHandler<MouseEvent> eventHandler = (MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(actionId)
                        .longValue(tagId)
                        .build();
                
                ActionHandlerFacade.getDefault().handle(transferData);
            }
        };
        
        return eventHandler;
    }

    @Override
    public Label getTagAsLabel(Tag tag) {
        final EventHandler<MouseEvent> eventHandler = this.getMouseHandlerForLabel(tag.getId());
        return this.configureButton(tag, defaultStyle, eventHandler);
    }

    @Override
    public Label getTagAsLabel(Tag tag, EventHandler<MouseEvent> eventHandler) {
        return this.configureButton(tag, defaultStyle, eventHandler);
    }

    @Override
    public Label getTagAsLabel(Tag tag, String style, EventHandler<MouseEvent> eventHandler) {
        return this.configureButton(tag, style, eventHandler);
    }

    @Override
    public void setLabelDefaultActionId(String defaultActionId) {
        this.defaultActionId = defaultActionId;
    }

    @Override
    public void setLabelDefaultStyle(String defaultStyle) {
        this.defaultStyle = defaultStyle;
    }

}
