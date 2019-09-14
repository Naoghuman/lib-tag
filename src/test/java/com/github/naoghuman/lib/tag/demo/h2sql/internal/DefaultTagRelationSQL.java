package com.github.naoghuman.lib.tag.demo.h2sql.internal;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.core.Tag;
import com.github.naoghuman.lib.tag.core.TagRelation;
import com.github.naoghuman.lib.tag.demo.h2sql.core.TagRelationSQL;
import java.sql.Connection;
import java.util.ArrayList;

public final class DefaultTagRelationSQL implements TagRelationSQL {
    
    private Connection connection;

    @Override
    public void initialize(Connection connection) {
        LoggerFacade.getDefault().info(this.getClass(), "DefaultTagRelationSQL#initialize(Connection)"); // NOI18N
        
        this.connection = connection;
    }

    @Override
    public void createOrUpdate(TagRelation tagRelation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void createOrUpdate(ArrayList<TagRelation> tagRelations) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Tag> read(String containerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(TagRelation tagRelation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(ArrayList<TagRelation> tagRelations) {
        // TODO Auto-generated method stub
        
    }

}
