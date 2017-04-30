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
package com.github.naoghuman.lib.tag.core.internal;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.github.naoghuman.lib.tag.core.TagRelation;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Naoghuman
 */
public class DefaultTagRelation implements TagRelation {

    private static final String SIGN__EMPTY = ""; // NOI18N

    public DefaultTagRelation(final long id, final long tagId, final String containerId, final String containerType) {
        this.init(id, tagId, containerId, containerType);
    }

    private void init(final long id, final long tagId, final String containerId, final String containerType) {
        this.setId(id);
        this.setTagId(tagId);

        DefaultTagValidator.getDefault().validate(containerId);
        this.setContainerId(containerId);

        DefaultTagValidator.getDefault().validate(containerType);
        this.setContainerType(containerId);
    }

    // START ID ----------------------------------------------------------------
    private LongProperty idProperty;
    private long _id = TAG_RELATION__DEFAULT_ID;

    @Override
    public long getId() {
        if (idProperty == null) {
            return _id;
        } else {
            return idProperty.get();
        }
    }

    @Override
    public final void setId(final long id) {
        if (idProperty == null) {
            _id = id;
        } else {
            idProperty.set(id);
        }
    }

    @Override
    public LongProperty idProperty() {
        if (idProperty == null) {
            idProperty = new SimpleLongProperty(this, TAG_RELATION__PARA__ID, _id);
        }

        return idProperty;
    }
    // END ID ------------------------------------------------------------------

    // START TAG-ID ------------------------------------------------------------
    private LongProperty tagIdProperty;
    private long _tagId = TAG_RELATION__DEFAULT_ID;

    @Override
    public long getTagId() {
        if (tagIdProperty == null) {
            return _tagId;
        } else {
            return tagIdProperty.get();
        }
    }

    @Override
    public final void setTagId(final long tagId) {
        if (tagIdProperty == null) {
            _tagId = tagId;
        } else {
            tagIdProperty.set(tagId);
        }
    }

    @Override
    public LongProperty tagIdProperty() {
        if (tagIdProperty == null) {
            tagIdProperty = new SimpleLongProperty(this, TAG_RELATION__PARA__TAG_ID, _tagId);
        }

        return tagIdProperty;
    }
    // END TAG-ID --------------------------------------------------------------

    // START CONTAINER-ID ------------------------------------------------------
    private StringProperty containerIdProperty = null;
    private String _containerId = SIGN__EMPTY;

    @Override
    public String getContainerId() {
        if (containerIdProperty == null) {
            return _containerId;
        } else {
            return containerIdProperty.get();
        }
    }

    @Override
    public void setContainerId(final String containerId) {
        if (containerIdProperty == null) {
            _containerId = containerId;
        } else {
            containerIdProperty.set(containerId);
        }
    }

    @Override
    public StringProperty containerIdProperty() {
        if (containerIdProperty == null) {
            containerIdProperty = new SimpleStringProperty(this, TAG_RELATION__PARA__CONTAINER_ID, _containerId);
        }

        return containerIdProperty;
    }
    // END CONTAINER-ID --------------------------------------------------------

    // START CONTAINER-TYPE ----------------------------------------------------
    private StringProperty containerTypeProperty = null;
    private String _containerType = SIGN__EMPTY;

    @Override
    public String getContainerType() {
        if (containerTypeProperty == null) {
            return _containerType;
        } else {
            return containerTypeProperty.get();
        }
    }

    @Override
    public void setContainerType(final String containerType) {
        if (containerTypeProperty == null) {
            _containerType = containerType;
        } else {
            containerTypeProperty.set(containerType);
        }
    }

    @Override
    public StringProperty containerTypeProperty() {
        if (containerTypeProperty == null) {
            containerTypeProperty = new SimpleStringProperty(this, TAG_RELATION__PARA__CONTAINER_TYPE, _containerType);
        }

        return containerTypeProperty;
    }
    // END CONTAINER-TYPE ------------------------------------------------------

    @Override
    public int compareTo(final TagRelation other) {
        int compareTo = Long.compare(this.getTagId(), other.getTagId());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = this.getContainerId().compareTo(other.getContainerId());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = this.getContainerType().compareTo(other.getContainerType());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = Long.compare(this.getId(), other.getId());
        if (compareTo != 0) {
            return compareTo;
        }

        return compareTo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getId()    ^ (this.getId()    >>> 32));
        result = prime * result + (int) (this.getTagId() ^ (this.getTagId() >>> 32));
        result = prime * result + this.getContainerId().hashCode();
        result = prime * result + this.getContainerType().hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DefaultTagRelation other = (DefaultTagRelation) obj;
        if (this.getId() != other.getId()) {
            return false;
        }

        if (this.getTagId() != other.getTagId()) {
            return false;
        }

        if (!this.getContainerId().equals(other.getContainerId())) {
            return false;
        }

        if (!this.getContainerType().equals(other.getContainerType())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tag ["); // NOI18N

        sb.append("id=")             .append(this.getId()); // NOI18N
        sb.append(", tagId=")        .append(this.getTagId()); // NOI18N
        sb.append(", containerId=")  .append(this.getContainerId()); // NOI18N
        sb.append(", containerType=").append(this.getContainerType()); // NOI18N

        sb.append("]"); // NOI18N

        return sb.toString();
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeLong(this.getId());
        out.writeLong(this.getTagId());
        out.writeObject(this.getContainerId());
        out.writeObject(this.getContainerType());
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setId(in.readLong());
        this.setTagId(in.readLong());
        this.setContainerId(String.valueOf(in.readObject()));
        this.setContainerType(String.valueOf(in.readObject()));
    }

}
