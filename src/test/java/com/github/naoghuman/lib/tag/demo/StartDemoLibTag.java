package com.github.naoghuman.lib.tag.demo;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tag.core.Tag;
import com.github.naoghuman.lib.tag.core.TagContainerIdBuilder;
import com.github.naoghuman.lib.tag.demo.h2sql.core.H2SQLProvider;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

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
        
        hbDesktop.getChildren().add(this.getSectionContainers());
        hbDesktop.getChildren().add(this.getSectionExistingTags());
        hbDesktop.getChildren().add(this.getSectionTag());
        
        final Scene scene = new Scene(hbDesktop, 1280, 720);
        primaryStage.setTitle("Demo Lib-Tag v0.4.0"); // NOI18N
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();
            
            this.onActionCloseRequest();
        });

        primaryStage.show();
    }
    
    private VBox getSectionContainers() {
        // Container
        final VBox vbContainers = new VBox(2.0d);
        vbContainers.setStyle("-fx-background-color:LIGHTBLUE; -fx-padding:14;"); // NOI18N
        HBox.setHgrow(vbContainers, Priority.ALWAYS);
        
        // Header
        final Label lContainers = new Label("JavaFX Containers");// NOI18N
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
        flowPane1.setPrefSize(336.0d, 112.0d);
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
        flowPane2.setPrefSize(336.0d, 112.0d);
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
        flowPane3.setPrefSize(336.0d, 112.0d);
        flowPane3.setStyle("-fx-background-color:WHITE;"); // NOI18N
        vbContainers.getChildren().add(flowPane3);
        
        return vbContainers;
    }
    
    private VBox getSectionExistingTags() {
        final VBox vbExistingTags = new VBox(2.0d);
        vbExistingTags.setStyle("-fx-background-color:BEIGE; -fx-padding:14;"); // NOI18N
        HBox.setHgrow(vbExistingTags, Priority.ALWAYS);
        
        // Header
        final Label lExistingTags = new Label("Existing Tags");// NOI18N
        lExistingTags.setFont(Font.font(18.0d));
        vbExistingTags.getChildren().add(lExistingTags);
        
        // ListView
        final ListView<Tag> lvExistingTags = new ListView();
        final Callback callbackTopics = (Callback<ListView<Tag>, ListCell<Tag>>) (ListView<Tag> listView) -> new ListCell<Tag>() {
            @Override
            protected void updateItem(Tag tag, boolean empty) {
                super.updateItem(tag, empty);
                
                this.setGraphic(null);
                
                if (tag == null || empty) {
                    this.setText(null);
                } else {
                    this.setText(tag.getTitle());
                }
            }
        };
        lvExistingTags.setCellFactory(callbackTopics);
        lvExistingTags.setOnMouseClicked(event -> {
            // Show the Tag
            if (
                    event.getClickCount() == 1
                    && !lvExistingTags.getSelectionModel().isEmpty()
            ) {
                final Tag tag = lvExistingTags.getSelectionModel().getSelectedItem();
                this.onActionShowTag(tag);
            }
        });
        vbExistingTags.getChildren().add(lvExistingTags);
        
        return vbExistingTags;
    }
    
    private VBox getSectionTag() {
        final VBox vbTag = new VBox(2.0d);
        vbTag.setStyle("-fx-background-color:PALETURQUOISE; -fx-padding:14;"); // NOI18N
        HBox.setHgrow(vbTag, Priority.ALWAYS);
        
        // Header
        final Label lTag = new Label("Tag");// NOI18N
        lTag.setFont(Font.font(18.0d));
        vbTag.getChildren().add(lTag);
        
        // Id
        final Label lId = new Label("Id");// NOI18N
        lId.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lId);
        
        final TextField tfId = new TextField();
        tfId.setDisable(true);
        vbTag.getChildren().add(tfId);
        
        // GenerationTime
        final Label lGenerationTime = new Label("GenerationTime");// NOI18N
        lGenerationTime.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lGenerationTime);
        
        final TextField tfGenerationTime = new TextField();
        tfGenerationTime.setDisable(true);
        vbTag.getChildren().add(tfGenerationTime);
        
        // Title
        final Label lTitle = new Label("Title");// NOI18N
        lTitle.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lTitle);
        
        final TextField tfTitle = new TextField();
        vbTag.getChildren().add(tfTitle);
        
        // Description
        final Label lDescription = new Label("Description");// NOI18N
        lDescription.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lDescription);
        
        final TextField tfDescription = new TextField();
        vbTag.getChildren().add(tfDescription);
        
        // Style
        final Label lStyle = new Label("Style");// NOI18N
        lStyle.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lStyle);
        
        final TextField tfStyle = new TextField();
        vbTag.getChildren().add(tfStyle);
        
        // MarkAsChanced
        final Label lMarkAsChanced = new Label("MarkAsChanced");// NOI18N
        lMarkAsChanced.setFont(Font.font(12.0d));
        vbTag.getChildren().add(lMarkAsChanced);
        
        final CheckBox cbMarkAsChanged = new CheckBox();
        cbMarkAsChanged.setDisable(true);
        vbTag.getChildren().add(cbMarkAsChanged);
       
        return vbTag;
    }
    
    private void onActionCloseRequest() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartDemoLibTag#onActionCloseRequest())"); // NOI18N
        
        H2SQLProvider.getDefault().shutdown();
        
        Platform.exit();
    }
    
    private void onActionShowTag(final Tag tag) {
        LoggerFacade.getDefault().debug(this.getClass(), "StartDemoLibTag#onActionShowTag(Tag))"); // NOI18N
        
        // show the data from the tag into the tag-components.
    }

}
