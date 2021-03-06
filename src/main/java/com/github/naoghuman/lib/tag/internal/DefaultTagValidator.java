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

import java.util.Objects;

/**
 * This class includes an implementation of various {@code validation} methods to 
 * test for minimal assumptions in the context of this library.
 * 
 * In general, all {@code parameters} are checked for minimal conditions by all 
 * functions in this library. For example, a {@code string} can not be {@code NULL} 
 * or {@code EMPTY}.
 * 
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
 * @see     com.github.naoghuman.lib.tag.core.TagBuilder
 * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 * @see     com.github.naoghuman.lib.tag.internal.DefaultTag
 */
public final class DefaultTagValidator {

    /**
     * Validates if the attribute {@code value} isn't {@code NULL}.
     * <p>
     * An additional error message will be added to the error stack:
     * <ul>
     * <li>The attribute [value] can't be NULL.</li>
     * </ul>
     *
     * @param   <T>   the type of the reference.
     * @param   value the attribute which should be validated.
     * @throws  NullPointerException if {@code (value == NULL)}.
     * @author  Naoghuman
     * @since   0.1.0
     * @version 0.4.0
     */
    public static <T> void requireNonNull(final T value) throws NullPointerException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL."); // NOI18N
    }
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL} or {@code EMPTY}.
     * <p>
     * Adds following additional error messages depending from the error to the error stack:
     * <ul>
     * <li>The attribute [value] can't be NULL.</li>
     * <li>The attribute [value] can't be EMPTY.</li>
     * </ul>
     *
     * @param   value the attribute which should be validated.
     * @throws  IllegalArgumentException if {@code (value.trim() == EMPTY)}.
     * @throws  NullPointerException     if {@code (value        == NULL)}.
     * @author  Naoghuman
     * @since   0.1.0
     * @version 0.4.0
     */
    public static void requireNonNullAndNotEmpty(final String value) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL."); // NOI18N
        
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The attribute [value] can't be EMPTY."); // NOI18N
        }
    }
}
