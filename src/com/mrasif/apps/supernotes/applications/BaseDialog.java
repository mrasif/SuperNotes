package com.mrasif.apps.supernotes.applications;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BaseDialog {
    public static void showDialog(Stage stage,String title, URL fxml, int width, int height){
        Stage dialog = new Stage();
        dialog.setTitle(title);
        try {
            dialog.setScene(new Scene(FXMLLoader.load(fxml),width,height));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }
}
