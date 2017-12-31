package com.mrasif.apps.supernotes.scenes;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.applications.AppSignUp;
import java.net.URL;
import java.util.ResourceBundle;

import com.mrasif.apps.supernotes.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;

public class SignUpScene extends AppSignUp {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfUserId;

    @FXML
    private PasswordField pfPass;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfEmail;

    @FXML
    void btnCancel_Click(ActionEvent event) {
        close(event);
    }

    @FXML
    void btnSignUp_Click(ActionEvent event) {
        User user=new User(tfName.getText(),tfUserId.getText(),pfPass.getText(),tfEmail.getText());
        if(ApiDatabase.addUser(user)){
            JOptionPane.showMessageDialog(null,"Registration successfully !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
            close(event);
        }
        else {
            JOptionPane.showMessageDialog(null,"Registration failed !","Super Notes",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void pfPass_KeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            tfName.requestFocus();
        }
    }

    @FXML
    void tfEmail_KeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            User user=new User(tfName.getText(),tfUserId.getText(),pfPass.getText(),tfEmail.getText());
            if(ApiDatabase.addUser(user)){
                JOptionPane.showMessageDialog(null,"Registration successfully !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
                close(event);
            }
            else {
                JOptionPane.showMessageDialog(null,"Registration failed !","Super Notes",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    void tfName_KeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            tfEmail.requestFocus();
        }
    }

    @FXML
    void tfUserid_KeyPressed(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){
            pfPass.requestFocus();
        }
    }

    @FXML
    void initialize() {
        assert tfUserId != null : "fx:id=\"tfUserId\" was not injected: check your FXML file 'SignUpScene.fxml'.";
        assert pfPass != null : "fx:id=\"pfPass\" was not injected: check your FXML file 'SignUpScene.fxml'.";
        assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'SignUpScene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'SignUpScene.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'SignUpScene.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'SignUpScene.fxml'.";

    }
}
