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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 */
public class DefaultTagRelationContainerIdTest {
    
    public DefaultTagRelationContainerIdTest() {
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
        String containerId = "hello-world";
        
        DefaultTagRelationContainerId.getDefault().generateId(path, container, containerId);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGeneratedIdThrowsBecauseContainerIsNULL() {
        Class  path        = DefaultTagRelationContainerIdTest.class;
        Class  container   = null;
        String containerId = "hello-world";
        
        DefaultTagRelationContainerId.getDefault().generateId(path, container, containerId);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGeneratedIdThrowsBecauseContainerIdIsNULL() {
        Class  path        = DefaultTagRelationContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String containerId = null;
        
        DefaultTagRelationContainerId.getDefault().generateId(path, container, containerId);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGeneratedIdThrowsBecauseContainerIdIsEMPTY() {
        Class  path        = DefaultTagRelationContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String containerId = "";
        
        DefaultTagRelationContainerId.getDefault().generateId(path, container, containerId);
    }

    @Test
    public void testGenerateIdWithPathAndContainerAndContainerId() {
        Class  path        = DefaultTagRelationContainerIdTest.class;
        Class  container   = AnchorPane.class;
        String containerId = "1234567890";
        
        String result = DefaultTagRelationContainerId.getDefault().generateId(path, container, containerId);
        System.out.println(result);
        
        assertTrue(result.startsWith(path.getCanonicalName()));
        assertTrue(result.contains("_AnchorPane_"));
        assertTrue(result.contains("_1234567890"));
    }
    
}
