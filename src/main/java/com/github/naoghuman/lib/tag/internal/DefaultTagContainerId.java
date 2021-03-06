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

import com.github.naoghuman.lib.tag.core.TagContainerId;
import java.util.Optional;

/**
 * The default implementation from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagContainerId}.
 *
 * @author Naoghuman
 * @since   0.3.0
 * @version 0.4.0
 * @see    com.github.naoghuman.lib.tag.core.TagContainerId
 */
public class DefaultTagContainerId implements TagContainerId {

    private static final String UNDERLINE = "_"; // NOI18N
    
    private static final Optional<DefaultTagContainerId> INSTANCE = Optional.of(new DefaultTagContainerId());

    /**
     * Returns a singleton instance from the {@code Class} <code>DefaultTagContainerId</code>.
     *
     * @return a singleton instance from this {@code Class}.
     * @since   0.3.0
     * @version 0.4.0
     */
    public static final DefaultTagContainerId getDefault() {
        return INSTANCE.get();
    }

    private DefaultTagContainerId() {

    }

    @Override
    public String generateId(final Class path, final Class container, final String fxId) {
        DefaultTagValidator.requireNonNull(path);
        DefaultTagValidator.requireNonNull(container);
        DefaultTagValidator.requireNonNullAndNotEmpty(fxId);
        
        final StringBuilder sb = new StringBuilder();
        sb.append(path.getCanonicalName());
        sb.append(UNDERLINE);
        sb.append(container.getSimpleName());
        sb.append(UNDERLINE);
        sb.append(fxId);
        
        return sb.toString();
    }
    
}
