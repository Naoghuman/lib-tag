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

import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__DESCRIPTION;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__GENERATION_TIME;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__ID;
import static com.github.naoghuman.lib.tag.core.Tag.TAG_PARA__TITLE;

import com.github.naoghuman.lib.tag.core.internal.DefaultTag;
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

    public static final IdTagBuilder create() {
        return new TagBuilderImpl();
    }

    public static interface IdTagBuilder {
        public GenerationTimeTagBuilder id(final long id);
    }

    public static interface GenerationTimeTagBuilder {
        public TitleTagBuilder generationTime(final long generationTime);
    }

    public static interface TitleTagBuilder {
        public DescriptionTagBuilder title(final String title);
    }

    public static interface DescriptionTagBuilder {
        public BuildTagBuilder description(final String description);
        public Tag build();
    }

    public static interface BuildTagBuilder {
        public Tag build();
    }

    private static final class TagBuilderImpl implements BuildTagBuilder, DescriptionTagBuilder, GenerationTimeTagBuilder, IdTagBuilder, TitleTagBuilder {

        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        TagBuilderImpl() {
            this.init();
        }

        private void init() {
            properties.put(TAG_PARA__DESCRIPTION,     new SimpleStringProperty());
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty());
            properties.put(TAG_PARA__ID,              new SimpleLongProperty());
            properties.put(TAG_PARA__TITLE,           new SimpleStringProperty());
        }

        @Override
        public GenerationTimeTagBuilder id(long id) {
            properties.put(TAG_PARA__ID, new SimpleLongProperty(id));
            return this;
        }

        @Override
        public BuildTagBuilder description(String description) {
            properties.put(TAG_PARA__DESCRIPTION, new SimpleStringProperty(description));
            return this;
        }

        @Override
        public TitleTagBuilder generationTime(final long generationTime) {
            properties.put(TAG_PARA__GENERATION_TIME, new SimpleLongProperty(generationTime));
            return this;
        }

        @Override
        public DescriptionTagBuilder title(String title) {
            properties.put(TAG_PARA__TITLE, new SimpleStringProperty(title));
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

            final StringProperty descriptionStringProperty = (StringProperty) properties.get(TAG_PARA__DESCRIPTION);
            final String description = descriptionStringProperty.get();

            // Create the tag
            final Tag tag = new DefaultTag(id, generationTime, title, description);

            return tag;
        }

    }

}
