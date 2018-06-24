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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The class {@code TagComponentActionHandler} allowed to configure different  
 * {@link javafx.event.EventHandler}&lt;{@link javafx.event.ActionEvent}&gt; 
 * in context from the library {@code Lib-Action} (https://github.com/Naoghuman/lib-action).
 * <br>
 * That means the events from the {@code EventHandler}&lt;{@link ActionEvent}&gt;}
 * (when triggered) transferred a {@link com.github.naoghuman.lib.action.core.TransferData}.
 * <p>
 * To retrieved the {@code TransferData} the <code>actionId</code> and its associated 
 * {@link javafx.event.EventHandler} must before registered during the method 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
 * <p>
 * // Example how to configure an {@code actionId}<br>
 * public interface IActionConfiguration {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;public static final String ON_ACTION__MY_OWN_ACTION = "ON_ACTION__MY_OWN_ACTION"; // NOI18N<br>
 * }
 * <p>
 * // Example how to register an action<br>
 * private void registerOnActionMyOwnAction() {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;ActionHandlerFacade.getDefault().register(<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ON_ACTION__MY_OWN_ACTION,<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(ActionEvent event) -> {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = (TransferData) event.getSource();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;final Optional<java.langLong> entityId = transferData.getLong();<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (entityId.isPresent() {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.onActionShowDoSomethingWithId(entityId.get());<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;});<br>
 * }
 * <p>
 * // Example implementation from an EventHandler&lt;ActionEvent&gt;<br>
 * public static final EventHandler&lt;ActionEvent&gt; actionHandler(final Long tagId, final String actionId) {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DefaultTagComponentValidator.getDefault().requireNonNull(tagId);<br>
 * <br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;final EventHandler&lt;ActionEvent&gt; actionHandler = (ActionEvent event) -> {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = TransferDataBuilder.create()<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.actionId(actionId)<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.longValue(tagId)<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.build();<br>
 * <br>  
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ActionHandlerFacade.getDefault().handle(transferData);<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;};<br> 
 * <br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;return actionHandler;<br>
 * }
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.ActionHandlerFacade
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.action.core.TransferDataBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentActionHandler#actionHandler(java.lang.Long, java.lang.String) 
 * @see    javafx.event.ActionEvent
 * @see    javafx.event.EventHandler
 */
public final class TagComponentActionHandler {
    
    /**
     * Constant which defines an {@code actionId} which allowed to receive the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by the 
     * {@link javafx.event.EventHandler}&lt;{@link javafx.event.ActionEvent}&gt; returned by 
     * {@link com.github.naoghuman.lib.tag.component.core.TagComponentActionHandler#actionHandler(java.lang.Long)}.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentActionHandler#actionHandler(java.lang.Long)
     * @see    javafx.event.ActionEvent
     * @see    javafx.event.EventHandler
     */
    public static final String ON_ACTION__TRIGGER_ACTION_EVENT = "ON_ACTION__TRIGGER_ACTION_EVENT"; // NOI18N

    /**
     * Creates an {@link javafx.event.EventHandler}&lt;{@link javafx.event.ActionEvent}&gt; 
     * where the transferred {@link com.github.naoghuman.lib.action.core.TransferData} is 
     * configured with the following parameters:
     * <ul>
     * <li>The given {@code tagId} which can't be NULL.</li>
     * <li>The {@code actionId} is {@code ON_ACTION__TRIGGER_ACTION_EVENT}).</li>
     * </ul>
     * 
     * Hint:
     * <br>
     * To see how to extract the data from the {@code TransferData} see the {@code JavaDoc} 
     * from this class.
     * 
     * @author Naoghuman
     * @since  0.3.0
     * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
     * @return the generated and configured {@code EventHandler<ActionEvent>}.
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentActionHandler#ON_ACTION__TRIGGER_ACTION_EVENT
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.event.ActionEvent
     * @see    javafx.event.EventHandler
     */
    public static final EventHandler<ActionEvent> actionHandler(final Long tagId) {
        DefaultTagComponentValidator.getDefault().requireNonNull(tagId);

        return actionHandler(tagId, ON_ACTION__TRIGGER_ACTION_EVENT);
    }

    /**
     * Creates an {@link javafx.event.EventHandler}&lt;{@link javafx.event.ActionEvent}&gt; 
     * where the transferred {@link com.github.naoghuman.lib.action.core.TransferData} is 
     * configured with the following parameters:
     * <ul>
     * <li>The given {@code tagId} which can't be NULL.</li>
     * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_ACTION_EVENT} or an own 
     * {@code actionId}.</li>
     * </ul>
     * 
     * Hint:
     * <br>
     * To see how to extract the data from the {@code TransferData} see the {@code JavaDoc} 
     * from this class.
     * 
     * @author Naoghuman
     * @since  0.4.0
     * @param  tagId    the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
     * @param  actionId The actionId which allowed access to the assoziated action.
     * @return the generated and configured {@code EventHandler<ActionEvent>}.
     * @see    com.github.naoghuman.lib.action.core.TransferData
     * @see    com.github.naoghuman.lib.tag.component.core.TagComponentActionHandler#ON_ACTION__TRIGGER_ACTION_EVENT
     * @see    com.github.naoghuman.lib.tag.core.Tag
     * @see    javafx.event.ActionEvent
     * @see    javafx.event.EventHandler
     */
    public static final EventHandler<ActionEvent> actionHandler(final Long tagId, final String actionId) {
        DefaultTagComponentValidator.getDefault().requireNonNull(tagId);
        
        final EventHandler<ActionEvent> actionHandler = (ActionEvent event) -> {
            final TransferData transferData = TransferDataBuilder.create()
                    .actionId(actionId)
                    .longValue(tagId)
                    .build();
            
            ActionHandlerFacade.getDefault().handle(transferData);
        };
        
        return actionHandler;
    }
    
}
