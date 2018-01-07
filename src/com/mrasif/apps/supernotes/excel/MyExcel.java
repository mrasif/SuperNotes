package com.mrasif.apps.supernotes.excel;

import com.mrasif.apps.supernotes.models.Note;

import java.io.FileOutputStream;
import java.util.List;

public class MyExcel {
    public void generate(List<Note> notes) throws Exception {
        FileOutputStream fos=new FileOutputStream("myexcel.xls");
        String data="<table>" +
                "<tr><th><font color=\"green\">Title</font></th><th><font color=\"green\" width=\"300\">Body</font></th></tr>";
        for (Note note:notes){
            data+="<tr><td>"+note.getTitle()+"</td><td>"+note.getBody()+"</td></tr>";
        }
        data+="</table>";
        fos.write(data.getBytes());
        fos.flush();
        fos.close();
    }
}
