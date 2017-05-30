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
package com.github.naoghuman.lib.tag.core;

import java.beans.Transient;
import java.io.Externalizable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

/**
 * From the basic idea is a <code>Tag</code> a simple {@link java.lang.String} which 
 * be used to displayed in a {@link javafx.control.Button} or {@link javafx.control.Label}.<br>
 * With this tag it's easily to search for or analyse a topic if it's tagged.
 *
 * @author Naoghuman
 * @see java.lang.String
 * @see javafx.control.Button
 * @see javafx.control.Label
 */
public interface Tag extends Comparable<Tag>, Externalizable {

    /**
     * Constant which defines the <code>default-id</code> (= -1L) from a <code>Tag</code>.
     */
    public static final long TAG__DEFAULT_ID = -1L;
    
    /**
     * Constant which defines an empty {@link java.lang.String}.
     * 
     * @see java.lang.String
     */
    public static final String SIGN__EMPTY = ""; // NOI18N

    /**
     * Constant which defines the attribute <code>description</code>.
     */
    public static final String TAG_PARA__DESCRIPTION = "description"; // NOI18N

    /**
     * Constant which defines the attribute <code>id</code>.
     */
    public static final String TAG_PARA__ID = "id";

    /**
     * Constant which defines the attribute <code>generationTime</code>.
     */
    public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N

    /**
     * Constant which defines the attribute <code>style</code>.
     */
    public static final String TAG_PARA__STYLE = "style"; // NOI18N

    /**
     * Constant which defines the attribute <code>title</code>.
     */
    public static final String TAG_PARA__TITLE = "title"; // NOI18N

    /**
     * Gets the value from the attribute <code>id</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>id</code>.
     */
    public long getId();
    
    /**
     * Sets the new value from the attribute <code>id</code>.
     * 
     * @param id the new value for the attribute <code>id</code>.
     */
    public void setId(final long id);
    
    /**
     * Returnes the attribute <code>id</code> as a {@link javafx.beans.property.LongProperty}.
     * 
     * @return the attribute <code>id</code> as a <code>LongProperty</code>.
     * @see javafx.beans.property.LongProperty
     */
    public LongProperty idProperty();

    /**
     * Gets the value from the attribute <code>generationTime</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>generationTime</code>.
     */
    public long getGenerationTime();
    
    /**
     * Sets the new value from the attribute <code>generationTime</code>.
     * 
     * @param generationTime the new value for the attribute <code>generationTime</code>.
     */
    public void setGenerationTime(final long generationTime);
    
    /**
     * Returnes the attribute <code>generationTime</code> as a {@link javafx.beans.property.LongProperty}.
     * 
     * @return the attribute <code>generationTime</code> as a <code>LongProperty</code>.
     * @see javafx.beans.property.LongProperty
     */
    public LongProperty generationTimeProperty();

    /**
     * Gets the value from the attribute <code>description</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>description</code>.
     */
    public String getDescription();
    
    /**
     * Sets the new value from the attribute <code>description</code>.
     * 
     * @param description the new value for the attribute <code>description</code>.
     */
    public void setDescription(final String description);
    
    /**
     * Returnes the attribute <code>description</code> as a {@link javafx.beans.property.StringProperty}.
     * 
     * @return the attribute <code>description</code> as a <code>StringProperty</code>.
     * @see javafx.beans.property.StringProperty
     */
    public StringProperty descriptionProperty();
    
    /**
     * Gets the value from the attribute <code>style</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>style</code>.
     */
    public String getStyle();
    
    /**
     * Sets the new value from the attribute <code>style</code>.
     * 
     * @param style the new value for the attribute <code>style</code>.
     */
    public void setStyle(final String style);
    
    /**
     * Returnes the attribute <code>style</code> as a {@link javafx.beans.property.StringProperty}.
     * 
     * @return the attribute <code>style</code> as a <code>StringProperty</code>.
     * @see javafx.beans.property.StringProperty
     */
    public StringProperty styleProperty();

    /**
     * Gets the value from the attribute <code>title</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>title</code>.
     */
    public String getTitle();
    
    /**
     * Sets the new value from the attribute <code>title</code>.
     * 
     * @param title the new value for the attribute <code>title</code>.
     */
    public void setTitle(final String title);
    
    /**
     * Returnes the attribute <code>title</code> as a {@link javafx.beans.property.StringProperty}.
     * 
     * @return the attribute <code>title</code> as a <code>StringProperty</code>.
     * @see javafx.beans.property.StringProperty
     */
    public StringProperty titleProperty();

    /**
     * Gets the value from the attribute <code>isMarkAsChanged</code> from the <code>Tag</code>.
     * 
     * @return the value from the attribute <code>isMarkAsChanged</code>.
     */
    @Transient
    public boolean isMarkAsChanged();
    
    /**
     * Sets the new value from the attribute <code>isMarkAsChanged</code>.
     * 
     * @param isMarkAsChanged the new value for the attribute <code>isMarkAsChanged</code>.
     */
    public void setMarkAsChanged(final boolean isMarkAsChanged);
    
    /**
     * Returnes the attribute <code>isMarkAsChanged</code> as a {@link javafx.beans.property.BooleanProperty}.
     * 
     * @return the attribute <code>isMarkAsChanged</code> as a <code>BooleanProperty</code>.
     * @see javafx.beans.property.BooleanProperty
     */
    public BooleanProperty markAsChangedProperty();

}
