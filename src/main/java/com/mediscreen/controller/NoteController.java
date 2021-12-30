package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    public ResponseEntity addNote(@RequestBody Note note) {

        noteService.addNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
