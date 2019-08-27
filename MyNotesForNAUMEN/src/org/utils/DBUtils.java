package org.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.note.Note;


public class DBUtils {


    public static List<Note> queryNote(Connection conn) throws SQLException {
        String sql = "Select a.titleNote, a.bodyNote from mynote a ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Note> list = new ArrayList<Note>();
        while (rs.next()) {
            String titleNote = rs.getString("titleNote");

            String bodyNote = rs.getString("bodyNote");
            Note note = new Note();

            note.setTitleNote(titleNote);
            note.setBodyNote(bodyNote);
            list.add(note);
        }
        return list;
    }

    public static List<Note> findNote(Connection conn, String word) throws SQLException {

        String sql = "Select a.titleNote, a.bodyNote from mynote a ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        List<Note> list1 = new ArrayList<Note>();
        while (rs.next()) {

            String titleNote = rs.getString("titleNote");

            String bodyNote = rs.getString("bodyNote");
            Note note = new Note();

            if (titleNote.contains(word)||bodyNote.contains(word)){
                note.setTitleNote(titleNote);
                note.setBodyNote(bodyNote);
                list1.add(note);

            }

        }

        return list1;
    }

    public static void insertNote(Connection conn, Note note) throws SQLException {
        String sql = "Insert into mynote(titleNote,bodyNote) values (?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, note.getTitleNote());
        pstm.setString(2, note.getBodyNote());

        pstm.executeUpdate();
    }

    public static void deleteNote(Connection conn, String titleNote) throws SQLException {
        String sql = "Delete From mynote where titleNote= ?";



        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, titleNote);

        System.out.println(titleNote + " 1");


        pstm.executeUpdate();
    }

}
