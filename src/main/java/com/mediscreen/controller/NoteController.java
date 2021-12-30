package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    public void addNote(@RequestBody Note note) {

        noteService.addNote(note);
    }
}
