package com.github.naoghuman.lib.tag.demo;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.demo.h2sql.core.H2SQLProvider;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartDemoLibTag extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void init() throws Exception {
        LoggerFacade.getDefault().info(this.getClass(), "StartDemoLibTag#init()"); // NOI18N
        
        super.init();
        
        H2SQLProvider.getDefault().initialize();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().debug(this.getClass(), "StartDemoLibTag#start(Stage))"); // NOI18N
        
        AnchorPane apBackground = new AnchorPane();
        
        Scene scene = new Scene(apBackground, 640, 360);

        primaryStage.setTitle("Demo Lib-Tag"); // NOI18N
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();
            
            this.onActionCloseRequest();
        });

        primaryStage.show();
    }
    
    private void onActionCloseRequest() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartDemoLibTag#onActionCloseRequest())"); // NOI18N
        
        H2SQLProvider.getDefault().shutdown();
        
        Platform.exit();
    }

}
