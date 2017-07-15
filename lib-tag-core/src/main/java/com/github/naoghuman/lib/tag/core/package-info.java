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
/**
 * Contains the {@code API} from the library {@code Lib-Tag-Core}.
 * <p>
 * The main entry point from the API is the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag} 
 * which defines a Tag. A Tag is basically a simple {@link java.lang.String} which can be used for example 
 * in a {@link javafx.scene.control.Button}, {@link javafx.scene.control.Label} or another {@code JavaFX} 
 * gui component.<br>
 * Suchlike tagged topics can be easily searched or analysed for a Tag.
 * <p>
 * A Tag can be easily created and configured with the fluent builder {@code Class} 
 * {@link com.github.naoghuman.lib.tag.core.TagBuilder} which is the preferred way to create an instance 
 * from the {@code Interface} Tag. Another way would be to use directly the {@code Class} 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTag} which isn't the recommended way.
 * <p>
 * A Tag can be easily mapped with an {@code JavaFX} gui component with the {@code Interface}
 * {@link com.github.naoghuman.lib.tag.core.TagRelation}. Again a fluent builder {@code Class}
 * {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} exists, which allowed to create
 * and configured an instance from the {@code Interface} TagRelation.<br>
 * Like the {@code Class} DefaultTag the {@code Class} 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTagRelation} allowed to create and configured 
 * directly an implementation from the {@code Interface} TagRelation, but again the preferred way is the 
 * corresponding fluent builder.
 * 
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTag
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTagRelation
 */
package com.github.naoghuman.lib.tag.core;
