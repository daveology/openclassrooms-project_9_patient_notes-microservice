package com.mediscreen.repository;

import com.mediscreen.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, String> {

    Optional<Collection<Note>> findByPatientId(Long patientId);
}
