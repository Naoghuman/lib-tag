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

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 */
public class ColorConverterTest {
    
    public ColorConverterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test (expected = NullPointerException.class)
    public void testConvertToStringThrowNullPointerException() {
        ColorConverter instance = new ColorConverter();
        instance.convertToString(null);
    }
    
    @Test
    public void testConvertToString() {
        ColorConverter instance = new ColorConverter();
        Color value = new Color(1.0d, 0.5d, 1.0d, 0.5d);
        String result = instance.convertToString(value);
        assertEquals("1.0;0.5;1.0;0.5", result);
    }
    
    @Test (expected = NullPointerException.class)
    public void testConvertFromStringThrowNullPointerException() {
        ColorConverter instance = new ColorConverter();
        instance.convertFromString(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConvertFromStringThrowIllegalArgumentException() {
        ColorConverter instance = new ColorConverter();
        instance.convertFromString("");
    }

    @Test
    public void testConvertFromString() {
        ColorConverter instance = new ColorConverter();
        Color result = instance.convertFromString("1.0;0.5;1.0;0.5");
        assertEquals(1.0d, result.getRed(),     0.0d);
        assertEquals(0.5d, result.getGreen(),   0.0d);
        assertEquals(1.0d, result.getBlue(),    0.0d);
        assertEquals(0.5d, result.getOpacity(), 0.0d);
    }
    
}
