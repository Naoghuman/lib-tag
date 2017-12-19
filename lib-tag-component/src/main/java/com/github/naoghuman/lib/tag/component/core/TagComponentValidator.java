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
package com.github.naoghuman.lib.tag.component.core;

import java.util.Objects;

/**
 * This {@code Interface} contains different default methods to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is NULL or not.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    java.lang.Object
 */
public interface TagComponentValidator {
    
    /**
     * Validates if the parameter {@code value} isn't NULL.
     *
     * @author      Naoghuman
     * @param value the attribute which should be validated.
     * @param <T>   the type of the reference.
     * @throws      NullPointerException if (value == NULL).
     * @since       0.3.0
     */
    public default <T> void requireNonNull(T value) throws NullPointerException {
        Objects.requireNonNull(value, "The parameter [value] can't be NULL"); // NOI18N
    }
    
    /**
     * Validates if the {@link java.lang.String} {@code value} isn't NULL and not EMPTY.
     *
     * @author      Naoghuman
     * @param value the attribute which should be validated.
     * @see         java.lang.String
     * @throws      NullPointerException if (value == NULL).
     * @throws      IllegalArgumentException if (value.trim() == EMPTY).
     * @since       0.3.0
     */
    public default void requireNonNullAndNotEmpty(String value) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(value, "The parameter [value] can't be NULL"); // NOI18N
        
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The String [value] can't be EMPTY"); // NOI18N
        }
    }

}
