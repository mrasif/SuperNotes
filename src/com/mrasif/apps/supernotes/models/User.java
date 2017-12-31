package com.mrasif.apps.supernotes.models;

import com.mrasif.apps.supernotes.apis.ApiDatabase;
import com.mrasif.apps.supernotes.utils.AppConfig;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String created_at;
    private String updated_at;

    public User() {

    }

    public User(String name, String username, String password, String email) {
        this.id = -1;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
    }

    public User(int id, String name, String username, String password, String email, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Note> getNotes(){
        return ApiDatabase.getNotes(this.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
