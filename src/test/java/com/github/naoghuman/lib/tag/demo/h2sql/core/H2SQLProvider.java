package com.github.naoghuman.lib.tag.demo.h2sql.core;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.demo.h2sql.internal.DefaultTagRelationSQL;
import com.github.naoghuman.lib.tag.demo.h2sql.internal.DefaultTagSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import org.flywaydb.core.Flyway;

public final class H2SQLProvider {
    
    private final static String DB_DRIVER     = "org.h2.Driver";
    private final static String DB_CONNECTION = "jdbc:h2:file:./db/demo-lib-tag";
    private final static String DB_USER       = "sa";
    private final static String DB_PASSWORD   = "";
    
    private final static Optional<H2SQLProvider> INSTANCE = Optional.of(new H2SQLProvider());
    
    public static H2SQLProvider getDefault() {
        return INSTANCE.get();
    }
    
    private Connection connection;
    
    private TagSQL         tagSQL;
    private TagRelationSQL tagRelationSQL;
    
    private H2SQLProvider() {
        
    }
    
    public TagSQL getTagSQL() {
        return null;
    }
    
    public TagRelationSQL getTagRelationSQL() {
        return null;
    }
    
    public void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "H2SQLProvider#initialize()"); // NOI18N
        
        LoggerFacade.getDefault().debug(this.getClass(), "## Start migration Flyway #####################################################"); // NOI18N
        Flyway.configure()
                .dataSource(DB_CONNECTION, DB_USER, DB_PASSWORD)
                .locations("") // Default package // NOI18N
                .load()
                .migrate();
        LoggerFacade.getDefault().debug(this.getClass(), "## End migration Flyway #######################################################"); // NOI18N
        
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        tagSQL = new DefaultTagSQL();
        tagSQL.initialize(connection);
        
        tagRelationSQL = new DefaultTagRelationSQL();
        tagRelationSQL.initialize(connection);
    }
    
    public void shutdown() {
        LoggerFacade.getDefault().debug(this.getClass(), "H2SQLProvider#shutdown())"); // NOI18N
        
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
