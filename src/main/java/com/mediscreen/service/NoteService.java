package com.mediscreen.service;

import com.mediscreen.model.Note;
import com.mediscreen.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note) {

        noteRepository.insert(note);
    }

    public Collection<Note> getNotesByPatientId(Long patientId) {

        noteRepository.findByPatientId(patientId);
    }
}
