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

import com.github.naoghuman.lib.tag.core.TagRelation;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class to test the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.TagRelation} which is 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTagRelation}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTagRelation
 */
public class DefaultTagRelationTest {
    
    public DefaultTagRelationTest() {
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
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsBecauseIdIsNULL() {
        Long id            = null;
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        DefaultTagRelation.create(id, tagId, containerId);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsBecauseTagIdIsNULL() {
        Long id            = System.nanoTime();
        Long tagId         = null;
        String containerId = "123-id";
        
        DefaultTagRelation.create(id, tagId, containerId);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsBecauseContainerIdIsNULL() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = null;
        
        DefaultTagRelation.create(id, tagId, containerId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsBecauseContainerIdIsEMPTY() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "";
        
        DefaultTagRelation.create(id, tagId, containerId);
    }
    
    // #########################################################################

    @Test
    public void testGetId() {
        Long id            = 123456789L;
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getId());
    }

    @Test
    public void testSetId() {
        Long id            = 123456789L;
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getId());
        
        result.setId(54321L);
        assertEquals(54321L, result.getId());
    }

    @Test(expected = NullPointerException.class)
    public void testSetIdThrowsBecauseItIsNULL() {
        Long id            = 123456789L;
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getId());
        
        result.setId(null);
    }

    @Test
    public void testIdProperty() {
        Long id            = 123456789L;
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertNotNull(result.idProperty());
        
        assertEquals(123456789L, result.idProperty().get());
    }
    
    // #########################################################################

    @Test
    public void testGetTagId() {
        Long id            = System.nanoTime();
        Long tagId         = 123456789L;
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getTagId());
    }

    @Test
    public void testSetTagId() {
        Long id            = System.nanoTime();
        Long tagId         = 123456789L;
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getTagId());
        
        result.setTagId(54321L);
        assertEquals(54321L, result.getTagId());
    }

    @Test(expected = NullPointerException.class)
    public void testSetTagIdThrowsBecauseItIsNULL() {
        Long id            = System.nanoTime();
        Long tagId         = 123456789L;
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals(123456789L, result.getTagId());
        
        result.setTagId(null);
    }

    @Test
    public void testTagIdProperty() {
        Long id            = System.nanoTime();
        Long tagId         = 123456789L;
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertNotNull(result.tagIdProperty());
        
        assertEquals(123456789L, result.tagIdProperty().get());
    }
    
    // #########################################################################

    @Test
    public void testGetContainerId() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals("123-id", result.getContainerId());
    }

    @Test
    public void testSetContainerId() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals("123-id", result.getContainerId());
        
        result.setContainerId("hello-world");
        assertEquals("hello-world", result.getContainerId());
    }

    @Test(expected = NullPointerException.class)
    public void testSetContainerIdThrowsBecauseItIsNULL() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals("123-id", result.getContainerId());
        
        result.setContainerId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetContainerIdThrowsBecauseItIsEMPTY() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals("123-id", result.getContainerId());
        
        result.setContainerId("");
    }

    @Test
    public void testContainerIdProperty() {
        Long id            = System.nanoTime();
        Long tagId         = System.nanoTime();
        String containerId = "123-id";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertNotNull(result.containerIdProperty());
        
        assertEquals("123-id", result.containerIdProperty().get());
    }
    
    // #########################################################################

    @Test
    public void testEquals() {
        TagRelation result1 = DefaultTagRelation.create(123L, 456L, "hello-world");
        TagRelation result2 = DefaultTagRelation.create(123L, 456L, "hello-world");
        assertEquals(result1, result2);
        
        TagRelation result3 = DefaultTagRelation.create(111L, 456L, "hello-world");
        assertNotEquals(result1, result3);
        
        TagRelation result4 = DefaultTagRelation.create(123L, 444L, "hello-world");
        assertNotEquals(result1, result4);
        
        TagRelation result5 = DefaultTagRelation.create(123L, 456L, "hi-world");
        assertNotEquals(result1, result5);
    }

    @Test
    public void testToString() {
        Long id            = 123L;
        Long tagId         = 456L;
        String containerId = "hello-world";
        
        TagRelation result = DefaultTagRelation.create(id, tagId, containerId);
        assertEquals("TagRelation [id=123, tagId=456, containerId=hello-world]", result.toString());
    }
    
}
