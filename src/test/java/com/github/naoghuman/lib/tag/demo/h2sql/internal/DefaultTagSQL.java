package com.github.naoghuman.lib.tag.demo.h2sql.internal;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.core.Tag;
import com.github.naoghuman.lib.tag.core.TagRelation;
import com.github.naoghuman.lib.tag.demo.h2sql.core.TagSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class DefaultTagSQL implements TagSQL {
    
    private Connection connection;

    @Override
    public void initialize(Connection connection) {
        LoggerFacade.getDefault().info(this.getClass(), "DefaultTagSQL#initialize(Connection)"); // NOI18N
        
        this.connection = connection;
        
        try (final Statement stmt = connection.createStatement()) {
            final ResultSet rs = stmt.executeQuery("SELECT id, generationTime, title, description, style FROM Tag"); // NOI18N
            while (rs.next()) {
                System.out.println(
                        " - Tag {id="         + rs.getLong(ID)               // NOI18N
                        + ", generationTime=" + rs.getLong("generationTime") // NOI18N
                        + ", title="          + rs.getString("title")        // NOI18N
                        + ", description="    + rs.getString("description")  // NOI18N
                        + ", style="          + rs.getString("style")        // NOI18N
                        + "}"                                                // NOI18N
                        );
            }
        } catch (SQLException e) {
            LoggerFacade.getDefault().error(this.getClass(), e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void createOrUpdate(Tag tag) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void createOrUpdate(ArrayList<Tag> tags) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Tag read(Long tagId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tag read(TagRelation tagRelation) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Tag> read(ArrayList<TagRelation> tagRelations) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Tag tag) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(ArrayList<Tag> tags) {
        // TODO Auto-generated method stub
        
    }

}
