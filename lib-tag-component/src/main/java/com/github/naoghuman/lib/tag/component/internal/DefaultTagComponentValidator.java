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
package com.github.naoghuman.lib.tag.component.internal;

import java.util.Optional;

import com.github.naoghuman.lib.tag.core.TagValidator;

/**
 * The default implementation from the {@code Interface} {@link com.github.naoghuman.lib.tag.component.core.TagComponentValidator} 
 * for the validation for the different gui components in this library.
 * <p>
 * Will be used per default in the fluent builders 
 * {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder}, 
 * {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder} and 
 * {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentValidator
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
 */
public final class DefaultTagComponentValidator implements TagValidator {

    private static final Optional<DefaultTagComponentValidator> INSTANCE = Optional.of(new DefaultTagComponentValidator());

    /**
     * Returns a singleton instance from the {@code Class} <code>DefaultTagComponentValidator</code>.
     *
     * @author Naoghuman
     * @return a singleton instance from this {@code Class}.
     * @since  0.3.0
     */
    public static final DefaultTagComponentValidator getDefault() {
        return INSTANCE.get();
    }

    private DefaultTagComponentValidator() {

    }

}
