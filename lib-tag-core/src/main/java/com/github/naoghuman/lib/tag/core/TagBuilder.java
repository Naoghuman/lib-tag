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

import static com.github.naoghuman.lib.tag.core.Tag.SIGN__EMPTY;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__DESCRIPTION;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__GENERATION_TIME;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__ID;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__STYLE;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__TITLE;
import static com.github.naoghuman.lib.tag.core.Tag.TAG__DEFAULT_ID;

import com.github.naoghuman.lib.tag.internal.DefaultTag;
import com.github.naoghuman.lib.tag.internal.TagValidator;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author Naoghuman
 */
public class TagBuilder {

    public static final IdStep create() {
        return new TagBuilderImpl();
    }

    public interface IdStep {
        public GenerationTimeStep id(final long id);
        public TitleStep generationTime(final long generationTime);
        public DescriptionStep title(final String title);
    }

    public interface GenerationTimeStep {
        public TitleStep generationTime(final long generationTime);
        public DescriptionStep title(final String title);
    }

    public interface TitleStep {
        public DescriptionStep title(final String title);
    }

    public interface DescriptionStep {
        public StyleStep description(final String description);
        public Builder style(final String style);
        public Tag build();
    }
    
    public interface StyleStep {
        public Builder style(final String style);
        public Tag build();
    }

    public interface Builder {
        public Tag build();
    }

    private static final class TagBuilderImpl implements Builder, 
            DescriptionStep, GenerationTimeStep, IdStep, StyleStep, 
            TitleStep
    {
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagBuilderImpl() {
            this.init();
        }

        private void init() {
            properties.put(TAG_PARA__DESCRIPTION,     new SimpleStringProperty(SIGN__EMPTY));
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty(System.nanoTime()));
            properties.put(TAG_PARA__ID,              new SimpleLongProperty(TAG__DEFAULT_ID));
            properties.put(TAG_PARA__STYLE,           new SimpleStringProperty(SIGN__EMPTY));
            properties.put(TAG_PARA__TITLE,           new SimpleStringProperty());
        }

        @Override
        public GenerationTimeStep id(long id) {
            properties.put(TAG_PARA__ID, new SimpleLongProperty(id));
            
            return this;
        }

        @Override
        public StyleStep description(String description) {
            properties.put(TAG_PARA__DESCRIPTION, new SimpleStringProperty(description));
            
            return this;
        }

        @Override
        public TitleStep generationTime(final long generationTime) {
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty(generationTime));
            
            return this;
        }

        @Override
        public DescriptionStep title(String title) {
            properties.put(TAG_PARA__TITLE, new SimpleStringProperty(title));
            
            return this;
        }

        @Override
        public Builder style(String style) {
            properties.put(TAG_PARA__STYLE, new SimpleStringProperty(style));
            
            return this;
        }

        @Override
        public Tag build() {
            // Catch data
            final LongProperty idLongProperty = (LongProperty) properties.get(TAG_PARA__ID);
            final Long id = idLongProperty.get();

            final LongProperty generationTimeLongProperty = (LongProperty) properties.get(TAG_PARA__GENERATION_TIME);
            final Long generationTime = generationTimeLongProperty.get();

            final StringProperty titleStringProperty = (StringProperty) properties.get(TAG_PARA__TITLE);
            final String title = titleStringProperty.get();
            TagValidator.getDefault().validate(title);

            final StringProperty descriptionStringProperty = (StringProperty) properties.get(TAG_PARA__DESCRIPTION);
            final String description = descriptionStringProperty.get();
            TagValidator.getDefault().requireNonNull(description);

            final StringProperty styleStringProperty = (StringProperty) properties.get(TAG_PARA__STYLE);
            final String style = styleStringProperty.get();
            TagValidator.getDefault().requireNonNull(style);

            // Create the tag
            final Tag tag = new DefaultTag(id, generationTime, title, description, style);

            return tag;
        }

    }

}
