package com.mediscreen.service;

import com.mediscreen.model.Note;
import com.mediscreen.repository.NoteRepository;
import com.mediscreen.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteServiceTests {

    @Autowired
    private NoteService noteService;
    @Test
    public void shouldAddNote() {

        Note expected = new Note();
        expected.setPatientId(99L);
        expected.setNoteDate(LocalDate.now());
        expected.setContent("Hémoglobine A1C");
        Note actual = noteService.addNote(expected);

        assertTrue(expected.equals(actual));
    }

    @Test
    public void shouldGetNoteListById() {

        Note expected = new Note();
        expected.setPatientId(99L);
        expected.setNoteDate(LocalDate.now());
        expected.setContent("Hémoglobine A1C");
        Note actual = noteService.addNote(expected);
        Collection<Note> noteList = noteService.getNotesByPatientId(actual.getPatientId());

        assertTrue(noteList.size() > 0);
    }

    @Test
    public void shouldDeletePatientList() {

        Note expected = new Note(99L, LocalDate.now(), "Hémoglobine A1C");
        Note actual = noteService.addNote(expected);
        noteService.deleteNoteList();
        Collection<Note> noteList = noteService.getNotesByPatientId(actual.getPatientId());

        assertTrue(noteList.isEmpty());
    }
}
