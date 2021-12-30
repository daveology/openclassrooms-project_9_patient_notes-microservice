package com.mediscreen.repository;

import com.mediscreen.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface NoteRepository extends MongoRepository<Note, String> {

    Collection<Note> findByPatientId(Long patientId);
}
