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

import javafx.scene.layout.AnchorPane;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class to test the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.internal.DefaultTagContainerId} which is 
 * {@link com.github.naoghuman.lib.tag.core.TagRelationContainerId}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelationContainerId
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTagContainerId
 */
public class DefaultTagContainerIdTest {
    
    public DefaultTagContainerIdTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = NullPointerException.class)
    public void testGeneratedIdThrowsBecausePathIsNULL() {
        Class  path        = null;
        Class  container   = AnchorPane.class;
        String fxId        = "hello-world";
        
        DefaultTagContainerId.getDefault().generateId(path, container, fxId);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGeneratedIdThrowsBecauseContainerIsNULL() {
        Class  path        = DefaultTagContainerIdTest.class;
        Class  container   = null;
        String fxId        = "hello-world";
        
        DefaultTagContainerId.getDefault().generateId(path, container, fxId);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGeneratedIdThrowsBecauseContainerIdIsNULL() {
        Class  path        = DefaultTagContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String fxId        = null;
        
        DefaultTagContainerId.getDefault().generateId(path, container, fxId);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGeneratedIdThrowsBecauseContainerIdIsEMPTY() {
        Class  path        = DefaultTagContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String fxId        = "";
        
        DefaultTagContainerId.getDefault().generateId(path, container, fxId);
    }

    @Test
    public void testGenerateIdWithPathAndContainerAndContainerId() {
        Class  path        = DefaultTagContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String fxId        = "1234567890";
        
        String result = DefaultTagContainerId.getDefault().generateId(path, container, fxId);
        System.out.println(result);
        
        assertTrue(result.startsWith(path.getCanonicalName()));
        assertTrue(result.contains("_AnchorPane_"));
        assertTrue(result.contains("_1234567890"));
    }
    
}
