package com.mrasif.apps.supernotes.scenes;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.applications.AppLogin;

import java.net.URL;
import java.util.ResourceBundle;

import com.mrasif.apps.supernotes.applications.AppSignUp;
import com.mrasif.apps.supernotes.utils.AppKeys;
import com.mrasif.apps.supernotes.utils.SharedPreferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;


public class LoginScene extends AppLogin {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfUserId;

    @FXML
    private PasswordField pfPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnForgotPass;

    @FXML
    void btnForgotPass_OnClick(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"Option will available soon !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void btnLogin_Click(ActionEvent event) {
        if(ApiDatabase.login(tfUserId.getText(),pfPass.getText())){
            JOptionPane.showMessageDialog(null,"Login successfully !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
            SharedPreferences.putString(AppKeys.USER_NAME,tfUserId.getText());
//            close(event);
            new DashboardScene().startApp();
        }
        else {
            JOptionPane.showMessageDialog(null,"Login failed !","Super Notes",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void btnSignUp_Click(ActionEvent event) {
//        System.out.println("Before opening");
        new AppSignUp().startApp();
//        BaseDialog.showDialog(parentStage,"Registration",getClass().getResource("SignUpScene.fxml"),600,400);
//        System.out.println("after closing");
    }

    @FXML
    void pfPass_KeyPressed(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            if(ApiDatabase.login(tfUserId.getText(),pfPass.getText())){
                JOptionPane.showMessageDialog(null,"Login successfully !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
                SharedPreferences.putString(AppKeys.USER_NAME,tfUserId.getText());
//                close(event);
                new DashboardScene().startApp();
            }
            else {
                JOptionPane.showMessageDialog(null,"Login failed !","Super Notes",JOptionPane.ERROR_MESSAGE);
            }
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
        assert tfUserId != null : "fx:id=\"tfUserId\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert pfPass != null : "fx:id=\"pfPass\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'LoginScene.fxml'.";
        assert btnForgotPass != null : "fx:id=\"btnForgotPass\" was not injected: check your FXML file 'LoginScene.fxml'.";

    }
}
