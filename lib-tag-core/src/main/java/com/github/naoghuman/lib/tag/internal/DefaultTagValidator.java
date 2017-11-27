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

import java.util.Optional;

import com.github.naoghuman.lib.tag.core.TagValidator;

/**
 * The default implementation from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagValidator} 
 * for the validation in context from a {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <p>
 * Will be used in the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * and in the {@code Class} {@link com.github.naoghuman.lib.tag.internal.DefaultTag}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTag
 */
public final class DefaultTagValidator implements TagValidator {

    private static final Optional<DefaultTagValidator> INSTANCE = Optional.of(new DefaultTagValidator());

    /**
     * Returns a singleton instance from the {@code Class} <code>DefaultTagValidator</code>.
     *
     * @return a singleton instance from this {@code Class}.
     */
    public static final DefaultTagValidator getDefault() {
        return INSTANCE.get();
    }

    private DefaultTagValidator() {

    }

}
