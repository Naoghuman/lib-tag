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
package com.github.naoghuman.lib.tag.core.internal;

import java.util.Optional;

import com.github.naoghuman.lib.tag.core.Validator;

/**
 *
 * @author Naoghuman
 */
public class TagValidator implements Validator {

    private static final Optional<TagValidator> INSTANCE = Optional.of(new TagValidator());

    /**
     * Returns a singleton instance from the class <code>TagValidator</code>.
     *
     * @return a singleton instance from this class.
     */
    public static final TagValidator getDefault() {
        return INSTANCE.get();
    }

    private TagValidator() {

    }

    @Override
    public void validate(String value) throws NullPointerException, IllegalArgumentException {
        Validator.super.requireNonNull(value);

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The parameter [value] can't be EMPTY"); // NOI18N
        }
    }

}
