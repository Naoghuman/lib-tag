package com.github.naoghuman.lib.tag.demo;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.core.TagContainerIdBuilder;
import com.github.naoghuman.lib.tag.demo.h2sql.core.H2SQLProvider;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        
        final HBox hbDesktop = new HBox(7.0);
        hbDesktop.setStyle("-fx-background-color:LIGHTGREEN; -fx-padding:14;"); // NOI18N
        
        hbDesktop.getChildren().add(this.getVBoxContainers());
        
        final Scene scene = new Scene(hbDesktop, 1280, 720);
        primaryStage.setTitle("Demo Lib-Tag v0.4.0"); // NOI18N
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();
            
            this.onActionCloseRequest();
        });

        primaryStage.show();
    }
    
    private VBox getVBoxContainers() {
        // Container
        final VBox vbContainers = new VBox(2.0d);
        vbContainers.setStyle("-fx-background-color:CADETBLUE; -fx-padding:14;"); // NOI18N
        
        // Header
        final Label lContainers = new Label("Containers");// NOI18N
        lContainers.setFont(Font.font(18.0d));
        vbContainers.getChildren().add(lContainers);
        
        // First FlowPane
        final Label lFlowPane1 = new Label("Nr.1");// NOI18N
        lFlowPane1.setFont(Font.font(12.0d));
        vbContainers.getChildren().add(lFlowPane1);
        
        final FlowPane flowPane1 = new FlowPane(7.0d, 7.0d);
        flowPane1.setId(TagContainerIdBuilder.create()
                .path(this.getClass())
                .container(FlowPane.class)
                .fxId("flowpane-nr-1") // NOI18N
                .build());
        flowPane1.setPrefSize(448.0d, 128.0d);
        flowPane1.setStyle("-fx-background-color:WHITE;"); // NOI18N
        vbContainers.getChildren().add(flowPane1);
        
        // Second FlowPane
        final Label lFlowPane2 = new Label("Nr.2");// NOI18N
        lFlowPane2.setFont(Font.font(12.0d));
        vbContainers.getChildren().add(lFlowPane2);
        
        final FlowPane flowPane2 = new FlowPane(7.0d, 7.0d);
        flowPane2.setId(TagContainerIdBuilder.create()
                .path(this.getClass())
                .container(FlowPane.class)
                .fxId("flowpane-nr-2") // NOI18N
                .build());
        flowPane2.setPrefSize(448.0d, 128.0d);
        flowPane2.setStyle("-fx-background-color:WHITE;"); // NOI18N
        vbContainers.getChildren().add(flowPane2);
        
        // Third FlowPane
        final Label lFlowPane3 = new Label("Nr.3"); // NOI18N
        lFlowPane3.setFont(Font.font(12.0d));
        vbContainers.getChildren().add(lFlowPane3);
        
        final FlowPane flowPane3 = new FlowPane(7.0d, 7.0d);
        flowPane3.setId(TagContainerIdBuilder.create()
                .path(this.getClass())
                .container(FlowPane.class)
                .fxId("flowpane-nr-3") // NOI18N
                .build());
        flowPane3.setPrefSize(448.0d, 128.0d);
        flowPane3.setStyle("-fx-background-color:WHITE;"); // NOI18N
        vbContainers.getChildren().add(flowPane3);
        
        return vbContainers;
    }
    
    private void onActionCloseRequest() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartDemoLibTag#onActionCloseRequest())"); // NOI18N
        
        H2SQLProvider.getDefault().shutdown();
        
        Platform.exit();
    }

}
