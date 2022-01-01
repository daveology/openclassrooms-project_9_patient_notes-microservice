package com.mediscreen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "note")
public class Note {

    @Transient
    public static final String noteSequence = "note_sequence";

    @Id
    @Field("id")
    private Long id;
    @Field(name = "patientId")
    private Long patientId;
    @Field(name = "noteDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate noteDate;
    @Field(name = "content")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note(){}

    public Note(Long id, Long patientId, LocalDate noteDate, String content) {
        this.id = id;
        this.patientId = patientId;
        this.noteDate = noteDate;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(patientId, note.patientId) && Objects.equals(noteDate, note.noteDate) && Objects.equals(content, note.content);
    }
}
