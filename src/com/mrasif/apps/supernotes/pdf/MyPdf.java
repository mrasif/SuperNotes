package com.mrasif.apps.supernotes.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mrasif.apps.supernotes.models.Note;

import java.io.FileOutputStream;
import java.util.List;

public class MyPdf {
    public void generate(List<Note> notes) throws Exception{
        Document document=new Document();
        document.addAuthor("Asif");
        document.addTitle("Notes");
        PdfWriter.getInstance(document,new FileOutputStream("mypdf.pdf"));
        document.open();

        PdfPTable table=new PdfPTable(5);
        table.addCell("User Name");
        table.addCell("Title");
        table.addCell("Body");
        table.addCell("Created at");
        table.addCell("Updated at");

        for (Note note:notes){
            table.addCell(note.getUser().getName());
            table.addCell(note.getTitle());
            table.addCell(note.getBody());
            table.addCell(note.getCreated_at());
            table.addCell(note.getUpdated_at());
        }

        document.add(table);


        document.close();
        System.out.println("Pdf generated...");
    }
}
