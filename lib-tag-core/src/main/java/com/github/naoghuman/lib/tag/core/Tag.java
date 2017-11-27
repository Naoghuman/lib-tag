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
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    java.lang.String
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 */
public interface Tag extends Comparable<Tag>, Externalizable {

    /**
     * Constant which defines the attribute {@code default-id} (= 
     * {@link java.lang.Long#MIN_VALUE}) from a {@code Tag}.
     */
    public static final Long DEFAULT_ID = Long.MIN_VALUE;
    
    /**
     * Constant which defines an empty {@link java.lang.String}.
     * 
     * @see java.lang.String
     */
    public static final String SIGN__EMPTY = ""; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code description}.
     */
    public static final String TAG_PARA__DESCRIPTION = "description"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code id}.
     */
    public static final String TAG_PARA__ID = "id";

    /**
     * Constant which defines the name from the attribute {@code generationTime}.
     */
    public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code style}.
     */
    public static final String TAG_PARA__STYLE = "style"; // NOI18N

    /**
     * Constant which defines the name from the attribute {@code title}.
     */
    public static final String TAG_PARA__TITLE = "title"; // NOI18N

    /**
     * Gets the value from the attribute {@code id} from this {@code Tag}.
     * 
     * @return the value from the attribute {@code id}.
     */
    public Long getId();
    
    /**
     * Sets the new value from the attribute {@code id}.<br>
     * This is an mandory value. Setting the value will validate the value against 
     * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
     * 
     * @param id the new value for the attribute {@code id}.
     * @see   com.github.naoghuman.lib.tag.core.TagValidator
     */
    public void setId(final Long id);

    /**
     * Gets the value from the attribute {@code title} from this {@code Tag}.
     * 
     * @return the value from the attribute {@code title}.
     */
    public String getTitle();
    
    /**
     * Sets the new value from the attribute {@code title}.<br>
     * This is an mandory value. Setting the value will validate the value against 
     * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
     * 
     * @param title the new value for the attribute {@code title}.
     * @see   com.github.naoghuman.lib.tag.core.TagValidator
     */
    public void setTitle(final String title);

    /**
     * Gets the value from the attribute {@code generationTime} from this {@code Tag}.<br>
     * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
     * will returned.
     * 
     * @return the value from the attribute {@code generationTime}.
     * @see    java.util.Optional#empty()
     */
    public Optional<Long> getGenerationTime();
    
    /**
     * Sets the new value from the attribute {@code generationTime}.
     * 
     * @param generationTime the new value for the attribute {@code generationTime}.
     */
    public void setGenerationTime(final Long generationTime);

    /**
     * Gets the value from the attribute {@code description} from this {@code Tag}.<br>
     * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
     * will returned.
     * 
     * @return the value from the attribute {@code description}.
     * @see    java.util.Optional#empty()
     */
    public Optional<String> getDescription();
    
    /**
     * Sets the new value from the attribute {@code description}.
     * 
     * @param description the new value for the attribute {@code description}.
     */
    public void setDescription(final String description);
    
    /**
     * Gets the value from the attribute {@code style} from this {@code Tag}.<br>
     * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
     * will returned.
     * 
     * @return the value from the attribute {@code style}.
     * @see    java.util.Optional#empty()
     */
    public Optional<String> getStyle();
    
    /**
     * Sets the new value from the attribute {@code style}.
     * 
     * @param style the new value for the attribute {@code style}.
     */
    public void setStyle(final String style);

    /**
     * Gets the value from the attribute {@code markAsChanged} from this {@code Tag}.
     * 
     * @return the value from the attribute {@code markAsChanged}.
     */
    @Transient
    public boolean isMarkAsChanged();
    
    /**
     * Sets the new value from the attribute {@code markAsChanged}.
     * 
     * @param markAsChanged the new value for the attribute {@code markAsChanged}.
     */
    public void setMarkAsChanged(final boolean markAsChanged);

}
