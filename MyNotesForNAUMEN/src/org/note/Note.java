package org.note;

public class Note {

    private String titleNote;
    private String bodyNote;

    public Note() {

    }

    public Note(String titleNote, String bodyNote) {
        this.titleNote = titleNote;
        this.bodyNote = bodyNote;
    }

    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public void setBodyNote(String bodyNote) {
        this.bodyNote = bodyNote;
    }
}