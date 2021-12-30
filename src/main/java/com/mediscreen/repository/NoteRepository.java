package com.mediscreen.repository;

import com.mediscreen.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {


}
