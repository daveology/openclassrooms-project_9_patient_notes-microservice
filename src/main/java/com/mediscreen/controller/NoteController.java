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
    public ResponseEntity addNote(@RequestBody Note note) {

        noteService.addNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/noteList/{patientId}")
    public ResponseEntity<Collection<Note>> getNotesByPatientId(@PathVariable Long patientId) {

        return ResponseEntity.ok(noteService.getNotesByPatientId(patientId));
    }

    @DeleteMapping("/note/{patientId}")
    public ResponseEntity deleteNoteById(@PathVariable Long patientId) {

        noteService.deleteNoteById(patientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/noteList")
    public ResponseEntity deleteNoteList() {

        noteService.deleteNoteList();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
