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

import java.util.Objects;

/**
 *
 * @author Naoghuman
 */
public interface Validator {

    /**
     * Validates if the parameter <code>value</code> isn't NULL.
     *
     * @param value the parameter which should be validated.
     * @throws NullPointerException if (value == NULL).
     */
    public default void requireNonNull(Object value) throws NullPointerException {
        Objects.requireNonNull(value, "The parameter [value] can't be NULL"); // NOI18N
    }

    /**
     * This method validates if the parameter <code>value</code> isn't NULL or EMPTY.
     *
     * TODO hit default-validator rules
     *
     * @param value the parameter which should be validated.
     * @throws NullPointerException if (value == NULL).
     * @throws IllegalArgumentException if the validation fails.
     */
    public void validate(String value) throws NullPointerException, IllegalArgumentException;

}
