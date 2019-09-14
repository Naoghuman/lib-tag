package com.github.naoghuman.lib.tag.demo.h2sql.core;

import java.sql.Connection;
import java.util.ArrayList;

import com.github.naoghuman.lib.tag.core.Tag;
import com.github.naoghuman.lib.tag.core.TagRelation;

public interface TagSQL {
    
    public final static String ID = "id"; // NOI18N
    
    public void initialize(Connection connection); 
    
    public void createOrUpdate(Tag tag);
    public void createOrUpdate(ArrayList<Tag> tags);
    
    public Tag read(Long tagId); 
    public Tag read(TagRelation tagRelation); 
//    public ArrayList<Tag> read(ArrayList<Long> tagIds); 
    public ArrayList<Tag> read(ArrayList<TagRelation> tagRelations); 
    
    public void delete(Tag tag); 
    public void delete(ArrayList<Tag> tags); 
    
}
