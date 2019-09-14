package com.github.naoghuman.lib.tag.demo.h2sql.core;

import java.sql.Connection;
import java.util.ArrayList;

import com.github.naoghuman.lib.tag.core.Tag;
import com.github.naoghuman.lib.tag.core.TagRelation;

public interface TagRelationSQL {

    public void initialize(Connection connection); 
    
    public void createOrUpdate(TagRelation tagRelation); 
    public void createOrUpdate(ArrayList<TagRelation> tagRelations);
    
    public ArrayList<Tag> read(String containerId);
    
    public void delete(TagRelation tagRelation);
    public void delete(ArrayList<TagRelation> tagRelations);
    
}
