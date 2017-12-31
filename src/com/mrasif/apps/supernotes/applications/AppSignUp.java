package com.mrasif.apps.supernotes.applications;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppSignUp extends Application {
    protected Parent root;
    protected Stage parentStage;
    public void startApp(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void close(ActionEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void close(KeyEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.parentStage=stage;
        this.root = FXMLLoader.load(getClass().getResource("/com/mrasif/apps/supernotes/scenes/SignUpScene.fxml"));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/mrasif/apps/supernotes/res/logo.png")));
        stage.setTitle("Sign Up");
        stage.resizableProperty().setValue(Boolean.FALSE);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setResizable(true);
//        stage.setAlwaysOnTop(true);
//        stage.setMaximized(true);
//        stage.setFullScreen(true);
        stage.setScene(new Scene(root, 600, 400));
//        stage.show();
        stage.showAndWait();
    }
}
