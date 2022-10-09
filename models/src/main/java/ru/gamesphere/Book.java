package ru.gamesphere;

import lombok.*;

@Data
@AllArgsConstructor
public class Book {
    int id;
    private String name;
    private int year;
    private int pages;
    private Author author;
}
