package com.mediscreen.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("note")
public class Note {

    private Long patientId;
    private String content;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note(){}

    public Note(Long patientId, String content) {
        this.patientId = patientId;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(patientId, note.patientId) && Objects.equals(content, note.content);
    }
}
