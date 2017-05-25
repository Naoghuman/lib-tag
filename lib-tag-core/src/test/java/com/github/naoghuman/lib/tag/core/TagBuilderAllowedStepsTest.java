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
package com.github.naoghuman.lib.tag.core;

/**
 *
 * @author Naoghuman
 */
public class TagBuilderAllowedStepsTest {
    
    TagBuilderAllowedStepsTest() {
        
       TagBuilder.create().id(0L).generationTime(0L).title("title").description("description").style("style").build();
       TagBuilder.create().id(0L)                   .title("title").description("description").style("style").build();
       TagBuilder.create().id(0L)                   .title("title")                           .style("style").build();
       TagBuilder.create().id(0L)                   .title("title")                                          .build();
       
       TagBuilder.create()       .generationTime(0L).title("title").description("description").style("style").build();
       TagBuilder.create()       .generationTime(0L).title("title").description("description")               .build();
       TagBuilder.create()       .generationTime(0L).title("title")                           .style("style").build();
       TagBuilder.create()       .generationTime(0L).title("title")                                          .build();
       
       TagBuilder.create()                          .title("title").description("description").style("style").build();
       TagBuilder.create()                          .title("title")                           .style("style").build();
       TagBuilder.create()                          .title("title")                                          .build();
       
    }
    
}






























