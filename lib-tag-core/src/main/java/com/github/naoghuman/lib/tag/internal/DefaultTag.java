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
package com.github.naoghuman.lib.tag.internal;

import com.github.naoghuman.lib.tag.core.Tag;

import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Naoghuman
 */
public final class DefaultTag implements Tag {

    private static final String SIGN__EMPTY = ""; // NOI18N

    public DefaultTag() {
        this(TAG__DEFAULT_ID);
    }

    public DefaultTag(final long id) {
        this(id, TAG__DEFAULT_ID);
    }

    public DefaultTag(final long id, final long generationTime) {
        this(id, TAG__DEFAULT_ID, SIGN__EMPTY);
    }

    public DefaultTag(final long id, final long generationTime, final String title) {
        this(id, TAG__DEFAULT_ID, title, SIGN__EMPTY);
    }

    public DefaultTag(final long id, final long generationTime, final String title, final String description) {
        this.setId(id);
        this.setGenerationTime(generationTime);

        DefaultTagValidator.getDefault().validate(title);
        this.setTitle(title);

        DefaultTagValidator.getDefault().requireNonNull(description);
        this.setDescription(description);

        markAsChangedProperty = new SimpleBooleanProperty(Boolean.FALSE);
    }

    // START ID ---------------------------------------------------------------
    private LongProperty idProperty;
    private long _id = TAG__DEFAULT_ID;

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
            idProperty = new SimpleLongProperty(this, TAG_PARA__ID, _id);
        }

        return idProperty;
    }
    // END ID -----------------------------------------------------------------

    // START GENERATIONTIME ---------------------------------------------------
    private LongProperty generationTimeProperty;
    private long _generationTime = System.currentTimeMillis();

    @Override
    public long getGenerationTime() {
        if (generationTimeProperty == null) {
            return _generationTime;
        } else {
            return generationTimeProperty.get();
        }
    }

    @Override
    public void setGenerationTime(final long generationTime) {
        if (generationTimeProperty == null) {
            _generationTime = generationTime;
        } else {
            generationTimeProperty.set(generationTime);
        }
    }

    @Override
    public LongProperty generationTimeProperty() {
        if (generationTimeProperty == null) {
            generationTimeProperty = new SimpleLongProperty(this, TAG_PARA__GENERATION_TIME, _generationTime);
        }
        return generationTimeProperty;
    }
    // END GENERATIONTIME -----------------------------------------------------

    // START DESCRIPTION ------------------------------------------------------
    private StringProperty descriptionProperty = null;
    private String _description = SIGN__EMPTY;

    @Override
    public String getDescription() {
        if (descriptionProperty == null) {
            return _description;
        } else {
            return descriptionProperty.get();
        }
    }

    @Override
    public void setDescription(final String description) {
        if (descriptionProperty == null) {
            _description = description;
        } else {
            descriptionProperty.set(description);
        }
    }

    @Override
    public StringProperty descriptionProperty() {
        if (descriptionProperty == null) {
            descriptionProperty = new SimpleStringProperty(this, TAG_PARA__DESCRIPTION, _description);
        }

        return descriptionProperty;
    }
    // END DESCRIPTION --------------------------------------------------------

    // START TITLE ------------------------------------------------------------
    private StringProperty titleProperty = null;
    private String _title = SIGN__EMPTY;

    @Override
    public String getTitle() {
        if (titleProperty == null) {
            return _title;
        } else {
            return titleProperty.get();
        }
    }

    @Override
    public void setTitle(final String title) {
        if (titleProperty == null) {
            _title = title;
        } else {
            titleProperty.set(title);
        }
    }

    @Override
    public StringProperty titleProperty() {
        if (titleProperty == null) {
            titleProperty = new SimpleStringProperty(this, TAG_PARA__TITLE, _title);
        }

        return titleProperty;
    }
    // END TITLE --------------------------------------------------------------

    // START MARK-AS-CHANGED --------------------------------------------------
    private transient BooleanProperty markAsChangedProperty = null;

    @Transient
    @Override
    public boolean isMarkAsChanged() {
        return markAsChangedProperty.getValue();
    }

    @Override
    public BooleanProperty markAsChangedProperty() {
        return markAsChangedProperty;
    }

    @Override
    public void setMarkAsChanged(boolean isMarkAsChanged) {
        markAsChangedProperty.setValue(isMarkAsChanged);
    }
    // END MARK-AS-CHANGED ----------------------------------------------------

    @Override
    public int compareTo(final Tag other) {
        int compareTo = this.getTitle().compareTo(other.getTitle());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = Long.compare(this.getId(), other.getId());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = Long.compare(this.getGenerationTime(), other.getGenerationTime());
        if (compareTo != 0) {
            return compareTo;
        }

        return compareTo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getId()             ^ (this.getId()             >>> 32));
        result = prime * result + (int) (this.getGenerationTime() ^ (this.getGenerationTime() >>> 32));
        result = prime * result + this.getTitle().hashCode();

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

        final DefaultTag other = (DefaultTag) obj;
        if (this.getId() != other.getId()) {
            return false;
        }

        if (this.getGenerationTime() != other.getGenerationTime()) {
            return false;
        }

        if (!this.getTitle().equals(other.getTitle())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tag ["); // NOI18N

        sb.append("id=")              .append(this.getId()); // NOI18N
        sb.append(", generationTime=").append(this.getGenerationTime()); // NOI18N
        sb.append(", title=")         .append(this.getTitle()); // NOI18N
        sb.append(", description=")   .append(this.getDescription()); // NOI18N

        sb.append("]"); // NOI18N

        return sb.toString();
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeLong(this.getId());
        out.writeLong(this.getGenerationTime());
        out.writeObject(this.getTitle());
        out.writeObject(this.getDescription());
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setId(in.readLong());
        this.setGenerationTime(in.readLong());
        this.setTitle(String.valueOf(in.readObject()));
        this.setDescription(String.valueOf(in.readObject()));
    }

}
