package com.mediscreen.config;

import com.mediscreen.model.Note;
import com.mediscreen.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class NoteModelListener extends AbstractMongoEventListener<Note> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public NoteModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Note> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Note.noteSequence));
        }
    }


}
