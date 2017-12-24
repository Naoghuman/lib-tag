/*
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

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * The class {@code TagComponentEventHandler} allowed to configure different 
 * {@link javafx.event.EventHandler}s in context from the library {@code Lib-Action}.
 * <br>
 * That means the events transferred a {@link com.github.naoghuman.lib.action.core.TransferData} 
 * when they triggered.
 * <p>
 * With the enum {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick} 
 * the developer can configure under which conditions the {@code EventHandler} will trigger. 
 * For example with the value {@code MouseClick#ONE_RIGHT_CLICK} the mouse event will 
 * trigger when the user clicks {@code one right click} on the given component.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
 * @see    javafx.event.EventHandler
 */
public final class TagComponentEventHandler {
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
     * the {@link javafx.event.EventHandler} returned by 
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#actionHandler(java.lang.Long)}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#actionHandler(java.lang.Long)
     * @see    javafx.event.EventHandler
     */
    public static final String ON_ACTION__TRIGGER_ACTION_EVENT = "ON_ACTION__TRIGGER_ACTION_EVENT"; // NOI18N
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
     * the {@link javafx.event.EventHandler} returned by 
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)}.
     * <br>
     * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick#DOUBLE_LEFT_CLICK}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
     * @see    javafx.event.EventHandler
     */
    public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK"; // NOI18N
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
     * the {@link javafx.event.EventHandler} returned by 
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)}.
     * <br>
     * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick#ONE_RIGHT_CLICK}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
     * @see    javafx.event.EventHandler
     */
    public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK"; // NOI18N
    
    /**
     * Creates an {@link javafx.event.EventHandler} where the transferred
     * {@link com.github.naoghuman.lib.action.core.TransferData} will configured with 
     * the following values:
     * <ul>
     * <li>The given {@code tagId} (can then received with transferData.getLong()).</li>
     * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_ACTION_EVENT} (can then received with transferData.getActionId()).</li>
     * </ul>
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
     * @return 
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_ACTION_EVENT
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.event.EventHandler
     */
    public static final EventHandler<ActionEvent> actionHandler(Long tagId) {
        DefaultTagComponentValidator.getDefault().requireNonNull(tagId);
        
        final EventHandler<ActionEvent> actionHandler = (ActionEvent event) -> {
            final TransferData transferData = TransferDataBuilder.create()
                    .actionId(ON_ACTION__TRIGGER_ACTION_EVENT)
                    .longValue(tagId)
                    .build();
                    
            ActionHandlerFacade.getDefault().handle(transferData);
        };
        
        return actionHandler;
    }
    
    /**
     * Creates an {@link javafx.event.EventHandler} where the transferred
     * {@link com.github.naoghuman.lib.action.core.TransferData} will configured with 
     * the following values:
     * <ul>
     * <li>The given {@code tagId} (can then received with transferData.getLong()).</li>
     * <li>The given {@code mouseTrigger} which allowed to configure the {@code EventHandler}.</li>
     * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK} 
     * or {@code ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK} (can then received with transferData.getActionId()).</li>
     * </ul>
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
     * @param  mouseTrigger allowed the developer to configure the {@code EventHandler}.
     * @return 
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.event.EventHandler
     */
    public static final EventHandler<MouseEvent> mouseHandler(final Long tagId, final MouseClick mouseTrigger) {
        DefaultTagComponentValidator.getDefault().requireNonNull(tagId);
        DefaultTagComponentValidator.getDefault().requireNonNull(mouseTrigger);
        
        EventHandler<MouseEvent> mouseHandler = null;
        switch(mouseTrigger) {
            case DOUBLE_LEFT_CLICK: {
                mouseHandler = mouseHandlerDoubleLeftClick(tagId);
                break;
            }
            case DOUBLE_LEFT_OR_ONE_RIGHT_CLICK: {
                mouseHandler = mouseHandlerDoubleLeftOrOneRightClick(tagId);
                break;
            }
            case ONE_RIGHT_CLICK: {
                mouseHandler = mouseHandlerOneRightClick(tagId);
                break;
            }
        }
        
        DefaultTagComponentValidator.getDefault().requireNonNull(mouseHandler);
        
        return mouseHandler;
    }
    
    private static EventHandler<MouseEvent> mouseHandlerDoubleLeftClick(final Long tagId) {
        final EventHandler<MouseEvent> mouseHandler = (MouseEvent event) -> {
            if (
                    event.isPrimaryButtonDown()
                    && event.getClickCount() >= 2
            ) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK)
                        .longValue(tagId)
                        .build();

                ActionHandlerFacade.getDefault().handle(transferData);
            }
        };
        
        return mouseHandler;
    }
    
    private static EventHandler<MouseEvent> mouseHandlerDoubleLeftOrOneRightClick(final Long tagId) {
        final EventHandler<MouseEvent> mouseHandler = (MouseEvent event) -> {
            if (
                    event.isPrimaryButtonDown()
                    && event.getClickCount() >= 2
            ) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK)
                        .longValue(tagId)
                        .build();

                ActionHandlerFacade.getDefault().handle(transferData);
            }
            
            if (
                    event.isSecondaryButtonDown()
                    && event.getClickCount() == 1
            ) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK)
                        .longValue(tagId)
                        .build();

                ActionHandlerFacade.getDefault().handle(transferData);
            }
        };
        
        return mouseHandler;
    }
    
    private static EventHandler<MouseEvent> mouseHandlerOneRightClick(final Long tagId) {
        final EventHandler<MouseEvent> mouseHandler = (MouseEvent event) -> {
            if (
                    event.isSecondaryButtonDown()
                    && event.getClickCount() == 1
            ) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK)
                        .longValue(tagId)
                        .build();

                ActionHandlerFacade.getDefault().handle(transferData);
            }
        };
        
        return mouseHandler;
    }
    
    /**
     * Enum which help to distinguish different {@link javafx.scene.input.MouseEvent}.
     * <p>
     * The single constants from this enum described the under which conditions 
     * the mouse event will trigger with the given {@code actionId} (which allowed 
     * then to receive the {@link com.github.naoghuman.lib.action.core.TransferData}.
     * <br>
     * For example:
     * <ul>
     * <li>{@code DOUBLE_LEFT_CLICK} will be triggered if the user double left clicks on the given component.</li>
     * </ul>
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    javafx.scene.input.MouseEvent
     */
    public enum MouseClick {
        
        /**
         * Constant which defines a {@code double left click}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         */
        DOUBLE_LEFT_CLICK,
        
        /**
         * Constant which defines a {@code double left or one right click}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         */
        DOUBLE_LEFT_OR_ONE_RIGHT_CLICK,
        
        /**
         * Constant which defines a {@code one right click}.
         * 
         * @author Naoghuman
         * @since  0.3.0
         */
        ONE_RIGHT_CLICK;
    }
    
}
