package com.mediscreen.service;

import com.mediscreen.model.Note;
import com.mediscreen.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    public Note addNote(Note note) {

        Note newNote = new Note();
        newNote.setPatientId(note.getPatientId());
        newNote.setNoteDate(note.getNoteDate());
        newNote.setContent(note.getContent());
        newNote.setId(sequenceGenerator.generateSequence(Note.noteSequence));
        return noteRepository.save(newNote);
    }

    public Collection<Note> getNotesByPatientId(Long patientId) {

        Collection<Note> newNotes = new ArrayList<>();
        Optional<Collection<Note>> notes = noteRepository.findByPatientId(patientId);
        if (notes.isPresent()) {
            return notes.get();
        }

        return newNotes;
    }

    public void deleteNoteById(Long patientId) {

        noteRepository.deleteById(patientId.toString());
    }

    public void deleteNoteList() {

        noteRepository.deleteAll();
    }
}
