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
 *
 * @author Naoghuman
 */
public interface Tag extends Comparable<Tag>, Externalizable {

    public static final long TAG__DEFAULT_ID = -1l;

    public static final String TAG_PARA__DESCRIPTION     = "description"; // NOI18N
    public static final String TAG_PARA__ID              = "id";
    public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N
    public static final String TAG_PARA__TITLE           = "title"; // NOI18N

    public long getId();
    public void setId(final long id);
    public LongProperty idProperty();

    public long getGenerationTime();
    public void setGenerationTime(final long generationTime);
    public LongProperty generationTimeProperty();

    public String getDescription();
    public void setDescription(final String description);
    public StringProperty descriptionProperty();

    public String getTitle();
    public void setTitle(final String title);
    public StringProperty titleProperty();

    @Transient
    public boolean isMarkAsChanged();
    public void setMarkAsChanged(final boolean isMarkAsChanged);
    public BooleanProperty markAsChangedProperty();

}
