package com.mrasif.apps.supernotes;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.excel.MyExcel;
import com.mrasif.apps.supernotes.pdf.MyPdf;
import com.mrasif.apps.supernotes.scenes.LoginScene;
import javafx.application.Application;

public abstract class Main extends Application{
    public static void main(String[] args) throws InterruptedException {
        ApiDatabase.Migrate();
        new LoginScene().startApp();
    }
}
