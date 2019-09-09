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
package com.github.naoghuman.lib.tag.internal;

import com.github.naoghuman.lib.tag.core.TagRelation;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Implementation class from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * <p>
 * An instance from this {@code Class} can be easily generated with the fluent 
 * builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} which is 
 * the preferred way to generate an implementation from this {@code Interface}.
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelation
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 */
public final class DefaultTagRelation implements TagRelation {

    private static final String SIGN__EMPTY = ""; // NOI18N

    /**
     * Factory method to create an instance from the {@code Interface} 
     * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
     * <p>
     * The usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder}
     * is preferred against the directly usage from this method.
     * <ul>
     * <li>All attributes are mandory and validate against {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
     * <li>The attribute {@code id} defines the id from the entity.</li>
     * <li>The attribute {@code tagId} defines the id from the {@code Tag}.</li>
     * <li>The attribute {@code containerId} defines the id from the {@code container} where the Tag should be shown.</li>
     * </ul>
     * 
     * @param   id          The id (mandory attribute) from this DefaultTagRelation.
     * @param   tagId       The tagId (mandory attribute) from this DefaultTagRelation.
     * @param   containerId The containerId (mandory attribute) from this DefaultTagRelation.
     * @return              A new instance from the {@code Interface} TagRelation.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.core.TagRelation
     * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     */
    public static TagRelation create(
            final Long id, final Long tagId, final String containerId
    ) {
        return new DefaultTagRelation(id, tagId, containerId);
    }

    private DefaultTagRelation(
            final Long id, final Long tagId, final String containerId
    ) {
        this.setId(id);
        this.setTagId(tagId);
        this.setContainerId(containerId);
    }

    // START ID ----------------------------------------------------------------
    private LongProperty idProperty = null;
    private long         _id        = DEFAULT_ID;

    @Override
    public long getId() {
        if (idProperty == null) {
            return _id;
        } else {
            return idProperty.get();
        }
    }

    @Override
    public final void setId(final Long id) {
        DefaultTagValidator.requireNonNull(id);
        
        if (idProperty == null) {
            _id = id;
        } else {
            idProperty.set(id);
        }
    }

    @Override
    public LongProperty idProperty() {
        if (idProperty == null) {
            idProperty = new SimpleLongProperty(this, ID, _id);
        }

        return idProperty;
    }
    // END ID ------------------------------------------------------------------

    // START TAG-ID ------------------------------------------------------------
    private LongProperty tagIdProperty = null;
    private long         _tagId        = DEFAULT_ID;
 
    @Override
    public long getTagId() {
        if (tagIdProperty == null) {
            return _tagId;
        } else {
            return tagIdProperty.get();
        }
    }

    @Override
    public final void setTagId(final Long tagId) {
        DefaultTagValidator.requireNonNull(tagId);
        
        if (tagIdProperty == null) {
            _tagId = tagId;
        } else {
            tagIdProperty.set(tagId);
        }
    }

    @Override
    public LongProperty tagIdProperty() {
        if (tagIdProperty == null) {
            tagIdProperty = new SimpleLongProperty(this, TAG_ID, _tagId);
        }

        return tagIdProperty;
    }
    // END TAG-ID --------------------------------------------------------------

    // START CONTAINER-ID ------------------------------------------------------
    private StringProperty containerIdProperty = null;
    private String         _containerId        = SIGN__EMPTY;

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
        DefaultTagValidator.requireNonNullAndNotEmpty(containerId);
        
        if (containerIdProperty == null) {
            _containerId = containerId;
        } else {
            containerIdProperty.set(containerId);
        }
    }

    @Override
    public StringProperty containerIdProperty() {
        if (containerIdProperty == null) {
            containerIdProperty = new SimpleStringProperty(this, CONTAINER_ID, _containerId);
        }

        return containerIdProperty;
    }
    // END CONTAINER-ID --------------------------------------------------------

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

        return result;
    }

    @Override
    public boolean equals(final Object obj) {
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

        return this.getContainerId().equals(other.getContainerId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TagRelation ["); // NOI18N

        sb.append("id=")           .append(this.getId()); // NOI18N
        sb.append(", tagId=")      .append(this.getTagId()); // NOI18N
        sb.append(", containerId=").append(this.getContainerId()); // NOI18N

        sb.append("]"); // NOI18N

        return sb.toString();
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeLong(this.getId());
        out.writeLong(this.getTagId());
        out.writeObject(this.getContainerId());
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setId(in.readLong());
        this.setTagId(in.readLong());
        this.setContainerId(String.valueOf(in.readObject()));
    }

}
