package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    private final NoteRepository noteRepository;

    public Main(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @DeleteMapping("/api/db/{noteId}")
    public void deleteNote(@PathVariable("noteId") Integer id){
        noteRepository.deleteById(id);
    }

    @PostMapping ("/api/db")
    public void postNote(@RequestBody NewNoteRequest request){
        Note note = new Note();
        note.setTitle(request.title());
        note.setRating(request.rating());
        note.setBody(request.body());
        note.setDate(LocalDate.now());
        noteRepository.save(note);
    }

    record NewNoteRequest(
            String title,
            String body,
            Integer rating

    ){}

    @GetMapping("/api/db")
    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    @GetMapping("/")
    public String greetHome(){
        return "GET request should be made to /api/";
    }
}
