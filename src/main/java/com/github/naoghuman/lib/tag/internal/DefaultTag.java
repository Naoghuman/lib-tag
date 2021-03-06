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

import com.github.naoghuman.lib.tag.core.Tag;
import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation class from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <p>
 * An instance from this {@code Class} can be easily generated with the fluent 
 * builder {@link com.github.naoghuman.lib.tag.core.TagBuilder} which is the 
 * preferred way to generate an implementation from this {@code Interface}.
 *
 * @author Naoghuman
 * @since   0.1.0
 * @version 0.4.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 */
public final class DefaultTag implements Tag {
    
    private static final String NOT_DEFINED = "[not defined]"; // NOI18N
    
    /**
     * Factory method to create an instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
     * <p>
     * The usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder}
     * is preferred against the directly usage from this method.
     * 
     * <ul>
     * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
     * <li>Setting an value will be validate the value against 
     *     {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
     * </ul>
     * 
     * This method delegates to 
     * {@link com.github.naoghuman.lib.tag.internal.DefaultTag#create(java.lang.Long, java.lang.String, java.lang.Long, java.util.Optional, java.util.Optional)  }
     * where all optional values are {@link java.util.Optional#empty()}.
     * 
     * @param   id             The id (mandory attribute) from this DefaultTag.
     * @param   title          The title (mandory attribute) from this DefaultTag.
     * @param   generationTime The generationTime (mandory attribute) from this DefaultTag.
     * @return                 A new instance from the {@code Interface} Tag.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.core.Tag
     * @see     com.github.naoghuman.lib.tag.core.TagBuilder
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     * @see     java.util.Optional#empty()
     */
    public static final Tag create(
            final Long id, final String title, final Long generationTime
    ) {
        return DefaultTag.create(id, title, generationTime, Optional.empty(), Optional.empty());
    }
    
    /**
     * Factory method to create an instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
     * <p>
     * The usage from the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder}
     * is preferred against the directly usage from this method.
     * <ul>
     * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
     * <li>All other attributes are optional, that means if not set then {@link java.util.Optional#empty()}
     *     will returned.</li>
     * <li>Setting an value in a mandory or an optional attribute will be validate the value 
     *     against {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.</li>
     * </ul>
     * 
     * @param   id             The id (mandory attribute) from this DefaultTag.
     * @param   title          The title (mandory attribute) from this DefaultTag.
     * @param   generationTime The generationTime (mandory attribute) from this DefaultTag.
     * @param   description    Optional attribute. If not set then Optional#empty() will returned.
     * @param   style          Optional attribute. If not set then Optional#empty() will returned.
     * @return                 A new instance from the {@code Interface} Tag.
     * @since   0.1.0
     * @version 0.4.0
     * @see     com.github.naoghuman.lib.tag.core.Tag
     * @see     com.github.naoghuman.lib.tag.core.TagBuilder
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     * @see     java.util.Optional#empty()
     */
    public static final Tag create(
            final Long id, final String title, final Long generationTime, 
            final Optional<String> description, final Optional<String> style
    ) {
        return new DefaultTag(id, title, generationTime, description, style);
    }
    
    private transient Boolean markAsChanged;
    
    private Long   id;
    private String title;
    private Long generationTime;
    
    private Optional<String> description = Optional.empty();
    private Optional<String> style       = Optional.empty();
    
    private DefaultTag(
            final Long id, final String title, final Long generationTime, 
            final Optional<String> description, final Optional<String> style
    ) {
        this.setId(id);
        this.setTitle(title);
        this.setGenerationTime(generationTime);
        
        if (description.isPresent()) {
            this.setDescription(description.get());
        }
        
        if (style.isPresent()) {
            this.setStyle(style.get());
        }
        
        markAsChanged = Boolean.FALSE;
    }
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public final void setId(final Long id) {
        DefaultTagValidator.requireNonNull(id);
        
        this.id = id;
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(final String title) {
        DefaultTagValidator.requireNonNullAndNotEmpty(title);
        
        this.title = title;
    }
    
    @Override
    public Long getGenerationTime() {
        return generationTime;
    }

    @Override
    public void setGenerationTime(final Long generationTime) {
        DefaultTagValidator.requireNonNull(generationTime);
        
        this.generationTime = generationTime;
    }
    
    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public void setDescription(final String description) {
        DefaultTagValidator.requireNonNullAndNotEmpty(description);
        
        this.description = Optional.of(description);
    }
    
    @Override
    public Optional<String> getStyle() {
        return style;
    }

    @Override
    public void setStyle(final String style) {
        DefaultTagValidator.requireNonNullAndNotEmpty(style);
        
        this.style = Optional.of(style);
    }

    @Transient
    @Override
    public boolean isMarkAsChanged() {
        return markAsChanged;
    }

    @Override
    public void setMarkAsChanged(final boolean markAsChanged) {
        this.markAsChanged = markAsChanged;
    }

    @Override
    public int compareTo(final Tag other) {
        int compareTo = this.getTitle().compareTo(other.getTitle());
        if (compareTo != 0) {
            return compareTo;
        }

        compareTo = Long.compare(this.getId(), other.getId());

        return compareTo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(this.id);
        result = prime * result + Objects.hashCode(this.title);
        result = prime * result + Objects.hashCode(this.generationTime);

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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        
        return Objects.equals(this.generationTime, other.generationTime);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tag ["); // NOI18N

        sb.append("id=")              .append(this.getId());             // NOI18N
        sb.append(", title=")         .append(this.getTitle());          // NOI18N
        sb.append(", generationTime=").append(this.getGenerationTime()); // NOI18N
        
        sb.append(", description=")   .append(this.getDescription().isPresent() ? this.getDescription().get() : NOT_DEFINED); // NOI18N
        sb.append(", style=")         .append(this.getStyle().isPresent()       ? this.getStyle().get()       : NOT_DEFINED); // NOI18N

        sb.append("]"); // NOI18N

        return sb.toString();
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeLong(this.getId());
        out.writeObject(this.getTitle());
        out.writeLong(this.getGenerationTime());
        
        out.writeObject(this.getDescription().isPresent() ? this.getDescription().get() : NOT_DEFINED);
        out.writeObject(this.getStyle().isPresent()       ? this.getStyle().get()       : NOT_DEFINED);
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setId(in.readLong());
        this.setTitle(String.valueOf(in.readObject()));
        this.setGenerationTime(in.readLong());

        final String readedDescription = String.valueOf(in.readObject());
        this.description = (readedDescription.equals(NOT_DEFINED)) ? Optional.ofNullable(readedDescription) : Optional.empty();
        
        final String readedStyle = String.valueOf(in.readObject());
        this.style = (readedStyle.equals(NOT_DEFINED)) ? Optional.ofNullable(readedStyle) : Optional.empty();
    }

}
