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

import com.github.naoghuman.lib.tag.components.core.TagButton;
import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.tag.core.Tag;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public class DefaultTagButton implements TagButton {

    private String defaultActionId = "ON_ACTION_SHOW_TAG_POPUP";     // NOI18N
    private String defaultStyle    = "default-style-for-tag-button"; // NOI18N

    public DefaultTagButton() {
        this.initialize();
    }
    
    private void initialize() {
        
    }
    
    private Button configureButton(final Tag tag, final String style, final EventHandler<ActionEvent> eventHandler) {
        final Button button = new Button();
        button.setText(tag.getTitle());
        button.setStyle(style);
        button.setOnAction(eventHandler);
        button.setUserData(tag);
        
        return button;
    }
    
    @Override
    public EventHandler<ActionEvent> getActionHandlerForButton(final long tagId) {
        return this.getActionHandlerForButton(defaultActionId, tagId);
    }
    
    @Override
    public EventHandler<ActionEvent> getActionHandlerForButton(final String actionId, final long tagId) {
        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            final TransferData transferData = TransferDataBuilder.create()
                    .actionId(actionId)
                    .longValue(tagId)
                    .build();
            
            ActionHandlerFacade.getDefault().handle(transferData);
        };
        
        return eventHandler;
    }
    
    @Override
    public Button getTagAsButton(final Tag tag) {
        final EventHandler<ActionEvent> eventHandler = this.getActionHandlerForButton(tag.getId());
        return this.configureButton(tag, defaultStyle, eventHandler);
    }
    
    @Override
    public Button getTagAsButton(final Tag tag, final EventHandler<ActionEvent> eventHandler) {
        return this.configureButton(tag, defaultStyle, eventHandler);
    }
    
    @Override
    public Button getTagAsButton(final Tag tag, final String style, final EventHandler<ActionEvent> eventHandler) {
        return this.configureButton(tag, style, eventHandler);
    }
    
    @Override
    public void setButtonDefaultActionId(final String defaultActionId) {
        this.defaultActionId = defaultActionId;
    }
    
    @Override
    public void setButtonDefaultStyle(final String defaultStyle) {
        this.defaultStyle = defaultStyle;
    }

}
