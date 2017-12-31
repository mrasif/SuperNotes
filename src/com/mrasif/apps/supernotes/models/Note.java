package com.mrasif.apps.supernotes.models;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.utils.AppConfig;

import java.util.Date;

public class Note {
    private int id;
    private String title;
    private String body;
    private String created_at;
    private String updated_at;
    private int user_id;

    public Note() {
        this.id = -1;
        this.title = "";
        this.body = "";
        this.created_at = "";
        this.updated_at = "";
        this.user_id = -1;
    }

    public Note(String title, String body, int user_id) {
        this.id = -1;
        this.title = title;
        this.body = body;
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
        this.user_id = user_id;
    }

    public Note(int id, String title, String body, String created_at, String updated_at, int user_id) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser(){
        return ApiDatabase.getUser(this.user_id);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
