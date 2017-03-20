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

import java.io.Externalizable;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Naoghuman
 */
public interface TagRelation extends Comparable<TagRelation>, Externalizable {

    public static final long TAG_RELATION__DEFAULT_ID = -1l;

    public static final String TAG_RELATION__PARA__ID = "id";
    public static final String TAG_RELATION__PARA__CONTAINER_ID = "containerId";
    public static final String TAG_RELATION__PARA__CONTAINER_TYPE = "containerType";
    public static final String TAG_RELATION__PARA__TAG_ID = "tagId";

    public long getId();
    public void setId(final long id);
    public LongProperty idProperty();

    public long getTagId();
    public void setTagId(final long tagId);
    public LongProperty tagIdProperty();

    public String getContainerId();
    public void setContainerId(final String containerId);
    public StringProperty containerIdProperty();

    public String getContainerType();
    public void setContainerType(final String containerType);
    public StringProperty containerTypeProperty();

}
