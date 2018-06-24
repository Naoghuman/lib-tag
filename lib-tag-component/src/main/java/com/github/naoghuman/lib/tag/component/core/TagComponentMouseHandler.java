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

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * The class {@code TagComponentMouseHandler} allowed to configure different  
 * {@link javafx.event.EventHandler}&lt;{@link javafx.scene.input.MouseEvent}&gt; 
 * in context from the library {@code Lib-Action}.
 * <br>
 * That means the events (when triggered) transferred a {@link com.github.naoghuman.lib.action.core.TransferData}.
 * <p>
 * With the enum {@link com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick} 
 * the developer can configure under which conditions the {@code EventHandler<MouseEvent>} will trigger.
 * <br>
 * For example with the value {@code MouseClick#ONE_RIGHT_CLICK} the mouse event will 
 * trigger when the user clicks {@code 'one right click'} on the given component.
 * 
 * TODO VALIDATOR, example how to register the action? write how data can received from TransferData
 * 
 * @author Naoghuman
 * @since  0.4.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick
 * @see    javafx.event.EventHandler
 * @see    javafx.scene.input.MouseEvent
 */
public final class TagComponentMouseHandler {
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
     * the {@link javafx.event.EventHandler}&lt;{@link javafx.scene.input.MouseEvent}&gt; returned by 
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick)}.
     * <p>
     * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick#DOUBLE_LEFT_CLICK}.
     * 
     * @author Naoghuman
     * @since  0.4.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick)
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick
     * @see    javafx.event.EventHandler
     * @see    javafx.scene.input.MouseEvent
     */
    public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK"; // NOI18N
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
     * the {@link javafx.event.EventHandler}&lt;{@link javafx.scene.input.MouseEvent}&gt; returned by  
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick)}.
     * <p>
     * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick#ONE_RIGHT_CLICK}.
     * 
     * @author Naoghuman
     * @since  0.4.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick)
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick
     * @see    javafx.event.EventHandler
     * @see    javafx.scene.input.MouseEvent
     */
    public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK"; // NOI18N
    
    /**
     * Creates an {@link javafx.event.EventHandler}&lt;{@link javafx.scene.input.MouseEvent}&gt; 
     * where the transferred {@link com.github.naoghuman.lib.action.core.TransferData} will 
     * configured with the following parameters:
     * <ul>
     * <li>The given {@code tagId} (can then received with transferData.getLong()).</li>
     * <li>The given {@code mouseTrigger} which allowed to configure the {@code EventHandler}.</li>
     * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK} 
     * or {@code ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK} (can then received with transferData.getActionId()).</li>
     * </ul>
     * 
     * TODO VALIDATOR, example how to register the action? write how data can received from TransferData
     * 
     * @author Naoghuman
     * @since  0.4.0
     * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
     * @param  mouseTrigger allowed the developer to configure the {@code EventHandler<MouseEvent>}.
     * @return the generated and configured {@code EventHandler<MouseEvent>}.
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentMouseHandler.MouseClick
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.event.EventHandler
     * @see    javafx.scene.input.MouseEvent
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
     * The single constants from this enum described the conditions when the mouse event 
     * will trigger with the given {@code actionId} (which allowed then to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData}.
     * <br>
     * For example:
     * <ul>
     * <li>{@code DOUBLE_LEFT_CLICK} will be triggered if the user 'double left clicks' on the given component.</li>
     * </ul>
     * 
     * @author Naoghuman
     * @since  0.4.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    javafx.scene.input.MouseEvent
     */
    public enum MouseClick {
        
        /**
         * Constant which defines a {@code 'double left click'} on the given component.
         * 
         * @author Naoghuman
         * @since  0.4.0
         */
        DOUBLE_LEFT_CLICK,
        
        /**
         * Constant which defines a {@code 'one right click'} on the given component.
         * 
         * @author Naoghuman
         * @since  0.4.0
         */
        ONE_RIGHT_CLICK;
        
    }
    
}
