package com.mediscreen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.model.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateNote() throws Exception {

        Note note = new Note();
        note.setPatientId(99L);
        note.setNoteDate(LocalDate.now());
        note.setContent("Hémoglobine A1C");

        mockMvc.perform(post("/note/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(note))
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldDeletePatientNotes() throws Exception {

        mockMvc.perform(delete("/note/" + 99L)).andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteNoteList() throws Exception {

        mockMvc.perform(delete("/noteList")).andExpect(status().isNoContent());
    }
}
