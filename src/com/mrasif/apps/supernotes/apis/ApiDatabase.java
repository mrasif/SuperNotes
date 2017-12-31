package com.mrasif.apps.supernotes.apis;

import com.mrasif.apps.supernotes.models.Note;
import com.mrasif.apps.supernotes.models.User;
import com.mrasif.apps.supernotes.utils.AppConfig;
import com.mrasif.apps.supernotes.utils.AppKeys;
import com.mrasif.apps.supernotes.utils.MyCryptography;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiDatabase {
    public static boolean Migrate(){
        return Dao.getDatabase().createDatabase(AppConfig.getMigration());
    }

    public static boolean addUser(User user){
        return Dao.getDatabase().executeNonQuery("INSERT INTO users(name,username,password,email,created_at,updated_at) " +
                "VALUES('"+user.getName()+"','"+user.getUsername()+"','"+ MyCryptography.encrypt(AppKeys.SECRET_KEY,user.getPassword())+"','"+user.getEmail()+"','"+user.getCreated_at()+"','"+user.getUpdated_at()+"')");
    }

    public static boolean updateUser(User user){
        return Dao.getDatabase().executeNonQuery("UPDATE users SET name='"+user.getName()+"', email='"+user.getEmail()+"', updated_at='"+AppConfig.dateToString(new Date())+"' WHERE username='"+user.getUsername()+"'");
    }

    public static boolean deleteUser(User user){
        return Dao.getDatabase().executeNonQuery("DELETE FROM users WHERE username='"+user.getUsername()+"'");
    }

    public static boolean changePassword(String username, String old_password, String new_password){
        return Dao.getDatabase().executeNonQuery("UPDATE users SET password='"+new_password+"' WHERE username='"+username+"' AND password='"+old_password+"'");
    }

    public static boolean login(String username, String password){
        boolean flag=false;
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT username FROM users WHERE username='"+username+"' AND password='"+MyCryptography.encrypt(AppKeys.SECRET_KEY,password)+"'");
        try {
            if(rs.next()){
                if(rs.getString("username").equals(username)){
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static User getUser(int id){
        User user=new User();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM users WHERE id="+id+"");
        try {
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCreated_at(rs.getString("created_at"));
                user.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUser(String username){
        User user=new User();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM users WHERE username='"+username+"'");
        try {
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCreated_at(rs.getString("created_at"));
                user.setUpdated_at(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean addNote(Note note){
        return Dao.getDatabase().executeNonQuery("INSERT INTO notes(title,body,created_at,updated_at,user_id) " +
                "VALUES('"+URLEncoder.encode(note.getTitle())+"','"+ URLEncoder.encode(note.getBody())+"','"+note.getCreated_at()+"','"+note.getUpdated_at()+"',"+note.getUser_id()+")");
    }

    public static boolean updateNote(Note note){
        return Dao.getDatabase().executeNonQuery("UPDATE notes SET title='"+URLEncoder.encode(note.getTitle())+"', body='"+URLEncoder.encode(note.getBody())+"', updated_at='"+AppConfig.dateToString(new Date())+"' WHERE id="+note.getId()+" AND user_id="+note.getUser_id());
    }

    public static boolean deleteNote(Note note){
        return Dao.getDatabase().executeNonQuery("DELETE FROM notes WHERE id="+note.getId()+" AND user_id="+note.getUser_id());
    }

    public static Note getNote(int user_id){
        Note note=new Note();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM notes WHERE user_id="+user_id);
        try {
            if (rs.next()){
                note=new Note(rs.getInt("id"),URLDecoder.decode(rs.getString("title")), URLDecoder.decode(rs.getString("body")),rs.getString("created_at"),rs.getString("updated_at"),rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    public static List<Note> getNotes(int user_id){
        List<Note> notes=new ArrayList<>();
        ResultSet rs=Dao.getDatabase().executeSQLQuery("SELECT * FROM notes WHERE user_id="+user_id);
        try {
            while (rs.next()){
                notes.add(new Note(rs.getInt("id"),URLDecoder.decode(rs.getString("title")),URLDecoder.decode(rs.getString("body")),rs.getString("created_at"),rs.getString("updated_at"),rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

}
