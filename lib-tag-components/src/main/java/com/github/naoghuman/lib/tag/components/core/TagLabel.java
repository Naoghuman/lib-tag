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
public interface TagLabel {

    /**
     * TODO
     * 
     * @param tagId
     * @return
     */
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final long tagId);

    /**
     * TODO
     * 
     * @param actionId
     * @param tagId
     * @return
     */
    public EventHandler<MouseEvent> getMouseHandlerForLabel(final String actionId, final long tagId);

    /**
     * TODO
     * 
     * @param tag
     * @return
     */
    public Label getTagAsLabel(Tag tag);

    /**
     * TODO
     * 
     * @param tag
     * @param eventHandler
     * @return
     */
    public Label getTagAsLabel(final Tag tag, final EventHandler<MouseEvent> eventHandler);

    /**
     * TODO
     * 
     * @param tag
     * @param style
     * @param eventHandler
     * @return
     */
    public Label getTagAsLabel(final Tag tag, String style, final EventHandler<MouseEvent> eventHandler);

    /**
     * TODO
     * 
     * @param defaultActionId
     */
    public void setLabelDefaultActionId(final String defaultActionId);

    /**
     * TODO
     * 
     * @param defaultStyle
     */
    public void setLabelDefaultStyle(final String defaultStyle);

}