package com.mrasif.apps.supernotes.scenes;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.applications.AppDashboard;
import com.mrasif.apps.supernotes.excel.MyExcel;
import com.mrasif.apps.supernotes.models.Note;
import com.mrasif.apps.supernotes.models.User;
import com.mrasif.apps.supernotes.pdf.MyPdf;
import com.mrasif.apps.supernotes.utils.AppKeys;
import com.mrasif.apps.supernotes.utils.SharedPreferences;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;

public class DashboardScene extends AppDashboard {

    private User user;
    private List<Note> notes;
    private int selectedIndex;
    private boolean new_note;
    private boolean edit_note;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem miNewNote;

    @FXML
    private MenuItem miSaveNote;

    @FXML
    private MenuItem miDeleteNote;

    @FXML
    private MenuItem miClear;

    @FXML
    private MenuItem miQuit;

    @FXML
    private MenuItem miBackup;

    @FXML
    private MenuItem miRestore;

    @FXML
    private MenuItem miAbout;

    @FXML
    private MenuItem miDevelopers;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private ListView<String> lvNotes;

    @FXML
    private MenuItem cmiNewNote;

    @FXML
    private MenuItem cmiDeleteNote;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea taNote;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblDetails;

    @FXML
    private MenuItem miExportPdf;

    @FXML
    private MenuItem miExportExcel;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void miExportExcel_Click(ActionEvent event) {
        try {
            new MyExcel().generate(ApiDatabase.getNotes(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void miExportPdf_Click(ActionEvent event) {
        try {
            new MyPdf().generate(ApiDatabase.getNotes(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void miAbout_Click(ActionEvent event) {

    }

    @FXML
    void miBackup_Click(ActionEvent event) {

    }

    @FXML
    void miClear_Click(ActionEvent event) {
        tfTitle.setText("");
        taNote.setText("");
        new_note=true;
        edit_note=false;
        lblDetails.setText("User: "+user.getName()+"\n" +
                "Username: " +user.getUsername()+"\n" +
                "Email: " +user.getEmail()+"\n" +
                "Total Notes: "+ user.getNotes().size() +"\n"+
                "Created at: "+user.getCreated_at()+"\n" +
                "Updated at: "+user.getUpdated_at());
    }

    @FXML
    void miDeleteNote_Click(ActionEvent event) {
        if (selectedIndex<0){
            return;
        }
        Note note=notes.get(selectedIndex);
        if(ApiDatabase.deleteNote(note)){
            lvNotes.getContextMenu().hide();
            JOptionPane.showMessageDialog(null,"Deleted !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
            tfTitle.setText("");
            taNote.setText("");
            loadList();
        }
        else {
            JOptionPane.showMessageDialog(null,"Not deleted !","Super Notes",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void miDevelopers_Click(ActionEvent event) {

    }

    @FXML
    void miNewNote_Click(ActionEvent event) {
        tfTitle.setText("");
        taNote.setText("");
        new_note=true;
        edit_note=false;
    }

    @FXML
    void miQuit_Click(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void miRestore_Click(ActionEvent event) {

    }

    @FXML
    void miSaveNote_Click(ActionEvent event) {
        if (tfTitle.getText().equals("")){
            return;
        }
        if(new_note){
            Note note=new Note(tfTitle.getText(),taNote.getText(),user.getId());
            if(ApiDatabase.addNote(note)){
                JOptionPane.showMessageDialog(null,"Saved !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
                loadList();
            }
            else {
                JOptionPane.showMessageDialog(null,"Not saved !","Super Notes",JOptionPane.ERROR_MESSAGE);
            }
        }

        if(edit_note){
            Note note=notes.get(selectedIndex);
            note.setTitle(tfTitle.getText());
            note.setBody(taNote.getText());
            if(ApiDatabase.updateNote(note)){
                JOptionPane.showMessageDialog(null,"Updated !","Super Notes",JOptionPane.INFORMATION_MESSAGE);
                loadList();
                edit_note=false;
            }
            else {
                JOptionPane.showMessageDialog(null,"Not updated !","Super Notes",JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @FXML
    void initialize() {
        assert miNewNote != null : "fx:id=\"miNewNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miSaveNote != null : "fx:id=\"miSaveNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miDeleteNote != null : "fx:id=\"miDeleteNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miClear != null : "fx:id=\"miClear\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miQuit != null : "fx:id=\"miQuit\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miBackup != null : "fx:id=\"miBackup\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miRestore != null : "fx:id=\"miRestore\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miAbout != null : "fx:id=\"miAbout\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miDevelopers != null : "fx:id=\"miDevelopers\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert x2 != null : "fx:id=\"x2\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert lvNotes != null : "fx:id=\"lvNotes\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert cmiNewNote != null : "fx:id=\"cmiNewNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert cmiDeleteNote != null : "fx:id=\"cmiDeleteNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert taNote != null : "fx:id=\"taNote\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert lblDetails != null : "fx:id=\"lblDetails\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miExportPdf != null : "fx:id=\"miExportPdf\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert miExportExcel != null : "fx:id=\"miExportExcel\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        user= ApiDatabase.getUser(SharedPreferences.getString(AppKeys.USER_NAME));
        loadList();
        lvNotes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                selectedIndex=lvNotes.getSelectionModel().getSelectedIndex();
                Note note=notes.get(selectedIndex);
                tfTitle.setText(note.getTitle());
                taNote.setText(note.getBody());
                new_note=false;
                edit_note=true;
                lblDetails.setText("User: "+note.getUser().getName()+"\n" +
                        "Created at: "+note.getCreated_at()+"\n" +
                        "Updated at: "+note.getUpdated_at());
            }
        });
    }

    private void loadList(){
        selectedIndex=-1;
        new_note=true;
        edit_note=false;
        tfTitle.setText("");
        taNote.setText("");
        notes=user.getNotes();
        ObservableList<String> observableList=FXCollections.observableArrayList();
        for (Note note:notes){
            observableList.add(note.getTitle());
        }
        lvNotes.setItems(observableList);
        lblDetails.setText("User: "+user.getName()+"\n" +
                "Username: " +user.getUsername()+"\n" +
                "Email: " +user.getEmail()+"\n" +
                "Total Notes: "+ user.getNotes().size() +"\n"+
                "Created at: "+user.getCreated_at()+"\n" +
                "Updated at: "+user.getUpdated_at());
    }

}
