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

import com.github.naoghuman.lib.tag.core.Tag;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class to test the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.Tag} which is 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTag}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTag
 */
public class DefaultTagTest {
    
    public DefaultTagTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // #########################################################################

    @Test
    public void testCreate() {
        Long id             = System.nanoTime();
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsBecauseIdIsNULL() {
        Long id             = null;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        DefaultTag.create(id, title, generationTime, description, style);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsBecauseTitleIsNULL() {
        Long id             = System.nanoTime();
        String title        = null;
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        DefaultTag.create(id, title, generationTime, description, style);
    }

//    @Test
//    public void testCreateGenerationTimeIsOptionalEmpty() {
//        Long id             = System.nanoTime();
//        String title        = null;// XXX muesste ein fehler
//        
//        Long   generationTime = 1L;
//        String description    = "description";
//        String style          = "-fx-style";
//        
//        Tag result = DefaultTag.create(id, title, generationTime, description, style);
//        assertNotNull(result);
//        assertEquals(Optional.empty(), result.getGenerationTime());
//    }

//    @Test
//    public void testCreateDescriptionTimeIsOptionalEmpty() {
//        Long id             = System.nanoTime();
//        String title        = null;
//        
//        Long   generationTime = 1L;
//        String description    = "description";
//        String style          = "-fx-style";
//        
//        Tag result = DefaultTag.create(id, title, generationTime, description, style);
//        assertNotNull(result);
//        assertEquals(Optional.empty(), result.getDescription());
//    }

//    @Test
//    public void testCreateStyleTimeIsOptionalEmpty() {
//        Long id             = System.nanoTime();
//        String title        = null;
//        
//        Long   generationTime = 1L;
//        String description    = "description";
//        String style          = "-fx-style";
//        
//        Tag result = DefaultTag.create(id, title, generationTime, description, style);
//        assertNotNull(result);
//        assertEquals(Optional.empty(), result.getStyle());
//    }
    
    // #########################################################################

    @Test
    public void testGetId() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals(123456789L, result.getId());
    }

    @Test
    public void testSetId() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals(123456789L, result.getId());
        
        result.setId(54321L);
        assertEquals(54321L, result.getId());
    }

    @Test(expected = NullPointerException.class)
    public void testSetIdThrowsBecauseItIsNULL() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals(123456789L, result.getId());
        
        result.setId(null);
    }
    
    // TODO add read-only-long-property
    // TODO change in DefaultTAgRealation to read-only-properties
    
    // #########################################################################

    @Test
    public void testGetTitle() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals("hello tag", result.getTitle());
    }

    @Test
    public void testSetTitle() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals("hello tag", result.getTitle());
        
        result.setTitle("new tag title");
        assertEquals("new tag title", result.getTitle());
    }

    @Test(expected = NullPointerException.class)
    public void testSetTitleThrowsBecauseItIsNULL() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals("hello tag", result.getTitle());
        
        result.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTitleThrowsBecauseItIsEMPTY() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 1L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertEquals("hello tag", result.getTitle());
        
        result.setTitle("");
    }
    
    // #########################################################################

    @Test
    public void testGetGenerationTime() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getGenerationTime().isPresent());
        assertEquals(generationTime, result.getGenerationTime().get());
    }

    @Test
    public void testSetGenerationTime() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getGenerationTime().isPresent());
        assertEquals(generationTime, result.getGenerationTime().get());
        
        Long newGenerationTime = 54321L;
        result.setGenerationTime(newGenerationTime);
        assertTrue(result.getGenerationTime().isPresent());
        assertEquals(newGenerationTime, result.getGenerationTime().get());
    }

    @Test
    public void testSetGenerationTimeNullInConstructorIsOptionalEmpty() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = null;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertFalse(result.getGenerationTime().isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testSetGenerationTimeThrowsBecauseItIsNULL() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getGenerationTime().isPresent());
        assertEquals(generationTime, result.getGenerationTime().get());
        
        result.setGenerationTime(null);
    }
    
    // #########################################################################

    @Test
    public void testGetDescription() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getDescription().isPresent());
        assertEquals("description", result.getDescription().get());
    }

    @Test
    public void testSetDescription() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getDescription().isPresent());
        assertEquals("description", result.getDescription().get());
        
        result.setDescription("new description");
        assertTrue(result.getDescription().isPresent());
        assertEquals("new description", result.getDescription().get());
    }

    @Test
    public void testSetDescriptionNullInConstructorIsOptionalEmpty() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = null;
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertFalse(result.getDescription().isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testSetDescriptionThrowsBecauseItIsNULL() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getDescription().isPresent());
        assertEquals("description", result.getDescription().get());
        
        result.setDescription(null);
    }
    
    // #########################################################################

//    @Test
    public void testGetStyle() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getStyle().isPresent());
        assertEquals("-fx-style", result.getStyle().get());
    }

    @Test
    public void testSetStyle() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getStyle().isPresent());
        assertEquals("-fx-style", result.getStyle().get());
        
        result.setStyle("new -fx-style");
        assertTrue(result.getStyle().isPresent());
        assertEquals("new -fx-style", result.getStyle().get());
    }

    @Test
    public void testSetStyleNullInConstructorIsOptionalEmpty() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = null;
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertFalse(result.getStyle().isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testSetStyleThrowsBecauseItIsNULL() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertTrue(result.getStyle().isPresent());
        assertEquals("-fx-style", result.getStyle().get());
        
        result.setStyle(null);
    }
    
    // #########################################################################

    @Test
    public void testIsMarkAsChanged() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertFalse(result.isMarkAsChanged());
    }

    @Test
    public void testSetMarkAsChanged() {
        Long id             = 123456789L;
        String title        = "hello tag";
        
        Long   generationTime = 987654321L;
        String description    = "description";
        String style          = "-fx-style";
        
        Tag result = DefaultTag.create(id, title, generationTime, description, style);
        assertNotNull(result);
        assertFalse(result.isMarkAsChanged());
        
        result.setMarkAsChanged(true);
        assertTrue(result.isMarkAsChanged());
    }
    
    // #########################################################################

//    @Test
//    public void testCompareTo() {
//        System.out.println("compareTo");
//        Tag other = null;
//        DefaultTag instance = null;
//        int expResult = 0;
//        int result = instance.compareTo(other);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        DefaultTag instance = null;
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        DefaultTag instance = null;
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        DefaultTag instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
    // #########################################################################
    
}
