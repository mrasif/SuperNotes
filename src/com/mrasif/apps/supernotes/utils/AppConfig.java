package com.mrasif.apps.supernotes.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppConfig {

    public static String getDatabasePath(){
        String dbPath = System.getProperty("user.home") + File.separator + "supernotes" + File.separator+ "data" + File.separator;
        File file=new File(dbPath);
        if(!file.exists()){
            file.mkdirs();
        }
        dbPath="data.jdb";
        return dbPath;
    }

    public static List<String> getMigration(){
        List<String> sqls=new ArrayList<>();
        sqls.add("CREATE TABLE IF NOT EXISTS `users` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`username` TEXT UNIQUE," +
                "`password` TEXT," +
                "`name` TEXT," +
                "`email` TEXT," +
                "`created_at` Date," +
                "`updated_at` Date" +
                ");");
        sqls.add("CREATE TABLE IF NOT EXISTS `notes` (" +
                "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`title` TEXT," +
                "`body` TEXT," +
                "`user_id` INTEGER," +
                "`created_at` Date," +
                "`updated_at` Date," +
                "CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                ");");
        return sqls;
    }

    public static Date stringToDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }

}
