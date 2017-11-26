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
package com.github.naoghuman.lib.tag.internal;

import java.util.Optional;
import com.github.naoghuman.lib.tag.core.TagRelationIdGenerator;

/**
 *
 * @author Naoghuman
 */
public class DefaultTagRelationtIdGenerator implements TagRelationIdGenerator {

    private static final String UNDERLINE = "_"; // NOI18N
    
    private static final Optional<DefaultTagRelationtIdGenerator> INSTANCE = Optional.of(new DefaultTagRelationtIdGenerator());

    /**
     * Returns a singleton instance from the {@code Class} <code>DefaultTagRelationtIdGenerator</code>.
     *
     * @return a singleton instance from this {@code Class}.
     */
    public static final DefaultTagRelationtIdGenerator getDefault() {
        return INSTANCE.get();
    }

    private DefaultTagRelationtIdGenerator() {

    }
    
    @Override
    public String generateId() {
        return String.valueOf(System.nanoTime());
    }

    @Override
    public String generateId(final Class path, final Class type) {
        return this.generateId(path, type, Optional.empty());
    }

    @Override
    public String generateId(final Class path, final Class type, final Optional<String> additional) {
        DefaultValidator.getDefault().requireNonNull(path);
        DefaultValidator.getDefault().requireNonNull(type);
        
        final StringBuilder sb = new StringBuilder();
        sb.append(path.getCanonicalName());
        sb.append(UNDERLINE);
        sb.append(type.getSimpleName());
        
        if (additional.isPresent()) {
            sb.append(UNDERLINE);
            sb.append(additional.get());
        }
        
        sb.append(UNDERLINE);
        sb.append(System.nanoTime());
        
        return sb.toString();
    }
    
}
