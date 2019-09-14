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
package com.github.naoghuman.lib.tag.core;

/**
 * This {@code Interface} contains the default method {@code generateId(Class, Class, String)}
 * which allowed the developer to generate an unique {@code Id} and returned it 
 * as a {@link java.lang.String}.
 * <p>
 * The main point from this {@code Interface} is the possibility to generate an unique 
 * {@code Id} for a relation between a {@link com.github.naoghuman.lib.tag.core.Tag}
 * and the JavaFX container where the {@code Tag} will be embbeded.
 *
 * @author  Naoghuman
 * @since   0.3.0
 * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
 * @see     com.github.naoghuman.lib.tag.core.TagRelation
 */
public interface TagContainerId {
    
    /**
     * Generates an (unique) {@code Id} as an {@link java.lang.String} which can 
     * be used as a {@code relation Id} between a {@link com.github.naoghuman.lib.tag.core.Tag} 
     * and a JavaFX container.
     * 
     * The format from the {@code Id} is:
     * <ul>
     * <li>path.getCanonicalName() + '_' + container.getSimpleName() + '_' + fxId</li>
     * </ul>
     * 
     * Example:
     * <ul>
     * <li>com.github.naoghuman.lib.tag.internal.DefaultIdGeneratorTest_AnchorPane_832531206890821</li>
     * </ul>
     * 
     * Internal {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}
     * will be used to validate if {@code path}, {@code container} and {@code fxId} 
     * isn't NULL. The parameter {@code containerId} will be checked additional if 
     * it isn't EMPTY.
     * 
     * @param   path        usually the path from the class where the {@code Tag} used.
     * @param   container   usually the type of the JavaFX component where the {@code Tag} should be embbeded.
     * @param   fxId        the {@code JavaFX-Id} from the JavaFX component.
     * @return  the generated {@code Id}.
     * @throws  IllegalArgumentException if the fxId is EMPTY.
     * @throws  NullPointerException     if path, container or fxId is NULL.
     * @since   0.3.0
     * @version 0.4.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
     * @see     com.github.naoghuman.lib.tag.internal.DefaultTagValidator
     * @see     java.lang.System#nanoTime()
     */
    public String generateId(final Class path, final Class container, final String fxId);
    
}
