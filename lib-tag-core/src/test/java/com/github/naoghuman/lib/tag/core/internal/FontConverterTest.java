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

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 */
public class FontConverterTest {
    
    public FontConverterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test (expected = NullPointerException.class)
    public void testConvertToStringThrowNullPointerException() {
        FontConverter instance = new FontConverter();
        instance.convertToString(null);
    }

    @Test
    public void testConvertToString() {
        Font value = Font.font("System", FontWeight.NORMAL, FontPosture.REGULAR, 10);
        FontConverter instance = new FontConverter();
        String result = instance.convertToString(value);
        assertEquals("System;System Regular;Regular;10.0", result);
    }
    
    @Test (expected = NullPointerException.class)
    public void testConvertFromStringThrowNullPointerException() {
        FontConverter instance = new FontConverter();
        instance.convertFromString(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testConvertFromStringThrowIllegalArgumentException() {
        FontConverter instance = new FontConverter();
        instance.convertFromString("");
    }

    @Test
    public void testConvertFromString() {
        System.out.println("convertFromString");
        String value = "System;System Regular;Regular;10.0";
        FontConverter instance = new FontConverter();
        Font result = instance.convertFromString(value);
        assertEquals("System",         result.getFamily());
        assertEquals("System Regular", result.getName());
        assertEquals("Regular",        result.getStyle());
        assertEquals(10.0d,            result.getSize(), 0d);
    }
    
}
