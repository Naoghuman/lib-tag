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
package com.github.naoghuman.lib.tag.core;

import java.io.Externalizable;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

/**
 * A {@code TagRelation} is a simple mapping between a container like 
 * {@link javafx.scene.layout.FlowPane} and all {@code Tag}s which should be shown
 * in this container.
 * <p>
 * An instance from this {@code Interface} can be easily generated with the fluent 
 * builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} which is 
 * the preferred way to generate an implementation from this {@code Interface}.
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see     javafx.scene.layout.FlowPane
 */
public interface TagRelation extends Comparable<TagRelation>, Externalizable {

    /**
     * Constant which defines the attribute {@code default-id}(= 
     * {@link java.lang.Long#MIN_VALUE}) from a {@code TagRelation}.
     */
    public static final Long DEFAULT_ID = Long.MIN_VALUE;

    /**
     * Constant which defines the name from the attribute {@code id}.
     */
    public static final String TAG_RELATION__PARA__ID = "id"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code containerId}.
     */
    public static final String TAG_RELATION__PARA__CONTAINER_ID = "containerId"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code tagId}.
     */
    public static final String TAG_RELATION__PARA__TAG_ID = "tagId"; // NOI18N

    /**
     * Gets the value from the attribute {@code id} from this {@code TagRelation}.
     * 
     * @return the value from the attribute {@code id}.
     */
    public long getId();
    
    /**
     * Sets the new value from the attribute {@code id}.
     * <p>
     * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
     * 
     * @param  id the new value for the attribute {@code id}.
     * @throws NullPointerException if {@code id} is NULL.
     * @see    com.github.naoghuman.lib.tag.core.TagValidator
     */
    public void setId(final Long id);
    
    /**
     * Returnes the attribute {@code id} as a {@link javafx.beans.property.LongProperty}.
     * 
     * @return the attribute {@code id} as a {@code LongProperty}.
     * @see    javafx.beans.property.LongProperty
     */
    public LongProperty idProperty();

    /**
     * Gets the value from the attribute {@code tagId} from the {@code Tag}.
     * 
     * @return the value from the attribute {@code tagId}.
     */
    public long getTagId();
    
    /**
     * Sets the new value from the attribute {@code tagId}.
     * <p>
     * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
     * 
     * @param  tagId the new value for the attribute {@code tagId}.
     * @throws NullPointerException if {@code tagId} is NULL.
     * @see    com.github.naoghuman.lib.tag.core.TagValidator
     */
    public void setTagId(final Long tagId);
    
    /**
     * Returnes the attribute {@code tagId} as a {@link javafx.beans.property.LongProperty}.
     * 
     * @return the attribute {@code tagId} as a {@code LongProperty}.
     * @see    javafx.beans.property.LongProperty
     */
    public LongProperty tagIdProperty();

    /**
     * Gets the value from the attribute {@code containerId} which defines the 
     * {@code id} from the container where the {@code Tag} is added.
     * 
     * @return the value from the attribute {@code containerId}.
     */
    public String getContainerId();
    
    /**
     * Sets the new value from the attribute {@code containerId}.
     * <p>
     * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
     * 
     * @param  containerId the new value for the attribute {@code containerId}.
     * @throws IllegalArgumentException if {@code containerId} is EMPTY.
     * @throws NullPointerException     if {@code containerId} is NULL.
     * @see    com.github.naoghuman.lib.tag.core.TagValidator
     */
    public void setContainerId(final String containerId);
    
    /**
     * Returnes the attribute {@code containerId} as a {@link javafx.beans.property.StringProperty}.
     * 
     * @return the attribute {@code containerId} as a {@code StringProperty}.
     * @see    javafx.beans.property.StringProperty
     */
    public StringProperty containerIdProperty();

}
