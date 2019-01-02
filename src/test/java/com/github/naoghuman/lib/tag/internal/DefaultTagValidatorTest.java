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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class to test the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.TagValidator} which is 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 */
public class DefaultTagValidatorTest {
    
    public DefaultTagValidatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDefault() {
        DefaultTagValidator defaultTagValidator = DefaultTagValidator.getDefault();
        assertNotNull(defaultTagValidator);
    }
    
    @Test
    public void testRequireNonNullNothingHappen() {
        DefaultTagValidator defaultTagValidator = DefaultTagValidator.getDefault();
        
        String objectToCheck = "hello world";
        defaultTagValidator.requireNonNull(objectToCheck);
    }
    
    @Test(expected = NullPointerException.class)
    public void testRequireNonNullThrowsBecauseNULL() {
        DefaultTagValidator defaultTagValidator = DefaultTagValidator.getDefault();
        
        String objectToCheck = null;
        defaultTagValidator.requireNonNull(objectToCheck);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRequireNonNullThrowsBecauseEMPTY() {
        DefaultTagValidator defaultTagValidator = DefaultTagValidator.getDefault();
        
        String objectToCheck = "";
        defaultTagValidator.requireNonNullAndNotEmpty(objectToCheck);
    }
    
}
