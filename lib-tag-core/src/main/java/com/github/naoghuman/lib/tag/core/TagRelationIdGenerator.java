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

import java.util.Optional;

/**
 * This {@code Interface} contains different default methods to generate an 
 * unique {@code Id} and returned it as a {@link java.lang.String}.
 * <p>
 * The main point from this {@code Interface} is the possibility to generate an unique 
 * {@code Id} for a relation between a {@link com.github.naoghuman.lib.tag.core.Tag}
 * and the container where the {@code Tag} will be embbeded.
 * <p>
 * For additional information about the {@code relation} plz see
 * {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * 
 */
public interface TagRelationIdGenerator {
    
    /**
     * Use simple {@link java.lang.System#nanoTime()} to generate the {@code Id}.
     * 
     * @return the generated {@code Id}.
     * @since  0.3.0
     * @see    java.lang.System#nanoTime()
     */
    public String generateId();
    
    /**
     * Generate an (unique) {@code Id} as an {@link java.lang.String}.
     * 
     * This method delegates to 
     * {@link com.github.naoghuman.lib.tag.core.TagRelationIdGenerator#generateId(java.lang.Class, java.lang.Class, java.util.Optional)}
     * with {@link java.util.Optional#empty()}.
     * 
     * @param  path usually the path from the class where the {@code Tag} used.
     * @param  type usually the type of the container where the {@code Tag} should be embbeded.
     * @return the generated {@code Id}.
     * @throws NullPointerException if path or type is NULL.
     * @since  0.3.0
     * @see    java.util.Optional#empty()
     */
    public String generateId(final Class path, final Class type);
    
    /**
     * Generate an (unique) {@code Id} as an {@link java.lang.String}.
     * 
     * The format from the {@code Id} is:
     * <ul>
     * <li>path.getCanonicalName()</li>
     * <li>'_'</li>
     * <li>type.getSimpleName()</li>
     * <li>'_' (if additional.isPresent())</li>
     * <li>additional.get() (if additional.isPresent())</li>
     * <li>'_'</li>
     * <li>System.nanoTime()</li>
     * </ul>
     * 
     * Example with/out optional information:
     * <ul>
     * <li>com.github.naoghuman.lib.tag.internal.DefaultIdGeneratorTest_AnchorPane_Hello-World_832469951006256</li>
     * <li>com.github.naoghuman.lib.tag.internal.DefaultIdGeneratorTest_AnchorPane_832531206890821</li>
     * </ul>
     * 
     * Internal {@link com.github.naoghuman.lib.tag.internal.DefaultValidator#requireNonNull(java.lang.Object)}
     * will be used to validate if {@code path} and / or {@code type} isn't NULL.
     * 
     * @param path       usually the path from the class where the {@code Tag} used.
     * @param type       usually the type of the container where the {@code Tag} should be embbeded.
     * @param additional flag for additional {@code Id} information.
     * @return the generated {@code Id}.
     * @throws NullPointerException if path or type is NULL.
     * @since  0.3.0
     * @see    com.github.naoghuman.lib.tag.internal.DefaultValidator#requireNonNull(java.lang.Object)
     * @see    java.lang.System#nanoTime()
     */
    public String generateId(final Class path, final Class type, final Optional<String> additional);
    
}
