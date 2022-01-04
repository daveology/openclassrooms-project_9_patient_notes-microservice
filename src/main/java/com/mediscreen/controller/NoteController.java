package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping("/note/add")
    public Note addNote(@RequestBody Note note) {

        return noteService.addNote(note);
    }

    @GetMapping("/noteList/{patientId}")
    public ResponseEntity<Collection<Note>> getNotesByPatientId(@PathVariable Long patientId) {

        return ResponseEntity.ok(noteService.getNotesByPatientId(patientId));
    }

    @DeleteMapping("/note/{noteId}")
    public ResponseEntity deleteNoteById(@PathVariable Long noteId) {

        noteService.deleteNoteById(noteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/noteList")
    public ResponseEntity deleteNoteList() {

        noteService.deleteNoteList();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
