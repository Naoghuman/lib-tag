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

import java.beans.Transient;
import java.io.Externalizable;
import java.util.Optional;

/**
 * From the basic idea a {@code Tag} is a simple {@link java.lang.String} which 
 * can be used to displayed in a {@link javafx.scene.control.Button},  
 * {@link javafx.scene.control.Label} or another {@code JavaFX} component.<br>
 * Tagged topics can be easily searched or analysed for a Tag.
 * <p>
 * An instance from this {@code Interface} can be easily generated with the fluent builder 
 * {@link com.github.naoghuman.lib.tag.core.TagBuilder} which is the preferred way 
 * to generate an implementation from this {@code Interface}.
 *
 * @author Naoghuman
 * @since   0.1.0
 * @version 0.4.0
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    java.lang.String
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 */
public interface Tag extends Comparable<Tag>, Externalizable {

    /**
     * Constant which defines the attribute {@code default-id} (= 
     * {@link java.lang.Long#MIN_VALUE}) from a {@code Tag}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final Long DEFAULT_ID = Long.MIN_VALUE;
    
    /**
     * Constant which defines an empty {@link java.lang.String}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     * @see     java.lang.String
     */
    public static final String SIGN__EMPTY = ""; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code description}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final String TAG_PARA__DESCRIPTION = "description"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code id}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final String TAG_PARA__ID = "id"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code generationTime}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code style}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final String TAG_PARA__STYLE = "style"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code title}.
     * 
     * @since   0.1.0
     * @version 0.4.0
     */
    public static final String TAG_PARA__TITLE = "title"; // NOI18N

    /**
     * Gets the value from the attribute {@code id} from this {@code Tag}.
     * 
     * @return  the value from the attribute {@code id}.
     * @since   0.1.0
     * @version 0.4.0
     */
    public long getId();
    
    /**
     * Sets the new value from the attribute {@code id}.
     * <p>
     * This is an mandory value. Setting the value will validate the value against 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
     * 
     * @param   id the new value for the attribute {@code id}.
     * @throws  NullPointerException if {@code id} is NULL.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public void setId(final Long id);

    /**
     * Gets the value from the attribute {@code title} from this {@code Tag}.
     * 
     * @return  the value from the attribute {@code title}.
     * @since   0.1.0
     * @version 0.4.0
     */
    public String getTitle();
    
    /**
     * Sets the new value from the attribute {@code title}.
     * <p>
     * This is an mandory value. Setting the value will validate the value against 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
     * 
     * @param   title the new value for the attribute {@code title}.
     * @throws  IllegalArgumentException if {@code id} is EMPTY.
     * @throws  NullPointerException     if {@code id} is NULL.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public void setTitle(final String title);

    /**
     * Gets the value from the attribute {@code generationTime} from this {@code Tag}.
     * 
     * @return  the value from the attribute {@code generationTime}.
     * @since   0.1.0
     * @version 0.4.0
     */
    public Long getGenerationTime();
    
    /**
     * Sets the new optional value from the attribute {@code generationTime}.
     * <p>
     * If the value is set then it will be valid against 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
     * 
     * @param   generationTime the new value for the attribute {@code generationTime}.
     * @throws  NullPointerException if {@code generationTime} is NULL.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public void setGenerationTime(final Long generationTime);

    /**
     * Gets the value from the attribute {@code description} from this {@code Tag}.
     * <p>
     * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
     * will returned.
     * 
     * @return  the value from the attribute {@code description}.
     * @since   0.1.0
     * @version 0.4.0
     * @see     java.util.Optional#empty()
     */
    public Optional<String> getDescription();
    
    /**
     * Sets the new optional value from the attribute {@code description}.
     * <p>
     * If the value is set then it will be valid against 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
     * 
     * @param   description the new value for the attribute {@code description}.
     * @throws  IllegalArgumentException if {@code description} is EMPTY.
     * @throws  NullPointerException     if {@code description} is NULL.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public void setDescription(final String description);
    
    /**
     * Gets the value from the attribute {@code style} from this {@code Tag}.
     * <p>
     * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
     * will returned.
     * 
     * @return  the value from the attribute {@code style}.
     * @since   0.1.0
     * @version 0.4.0
     * @see     java.util.Optional#empty()
     */
    public Optional<String> getStyle();
    
    /**
     * Sets the new optional value from the attribute {@code style}.
     * <p>
     * If the value is set then it will be valid against 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
     * 
     * @param   style the new value for the attribute {@code style}.
     * @throws  IllegalArgumentException if {@code style} is EMPTY.
     * @throws  NullPointerException     if {@code style} is NULL.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public void setStyle(final String style);

    /**
     * Gets the value from the attribute {@code markAsChanged} from this {@code Tag}.
     * 
     * @return  the value from the attribute {@code markAsChanged}.
     * @since   0.1.0
     * @version 0.4.0
     */
    @Transient
    public boolean isMarkAsChanged();
    
    /**
     * Sets the new value from the attribute {@code markAsChanged}.
     * 
     * @param   markAsChanged the new value for the attribute {@code markAsChanged}.
     * @since   0.1.0
     * @version 0.4.0
     */
    public void setMarkAsChanged(final boolean markAsChanged);

}
