package ru.gamesphere;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    int id;
    private String name;
    private int year;
    private int pages;
    private Author author;
}
