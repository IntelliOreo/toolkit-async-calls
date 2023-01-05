package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Note {
    @Id
    @SequenceGenerator(
            name = "note_id_sequence",
            sequenceName = "note_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "note_id_sequence"
    )
    private Integer id;
    private String title;
    private String body;
    private LocalDate date;
    private Integer rating;

    public Note(Integer id, String title, String body, Integer rating, LocalDate date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.date = date;
    }

    public Note() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String content) {
        this.body = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        if (rating != note.rating) return false;
        if (!title.equals(note.title)) return false;
        if (!body.equals(note.body)) return false;
        return date.equals(note.date);
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + rating;
        return result;
    }
}
