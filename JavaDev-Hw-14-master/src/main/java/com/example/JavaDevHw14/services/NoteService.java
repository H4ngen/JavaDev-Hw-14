package com.example.JavaDevHw14.services;

import com.example.JavaDevHw14.entities.Note;
import com.example.JavaDevHw14.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(note -> notes.add(note));
        return notes;
    }

    public Note add(Note note){
        if (!Objects.isNull(note)) {
            return noteRepository.save(note);
        }
        return null;
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        Note currentNote = noteRepository.findById(note.getId()).get();
        currentNote.setTitle(note.getTitle());
        currentNote.setContent(note.getContent());
        noteRepository.save(currentNote);
    }

    public Optional<Note> getById(Long id) {
        return noteRepository.findById(id);
    }
}