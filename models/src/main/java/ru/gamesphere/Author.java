package ru.gamesphere;

import lombok.*;

@Data
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private String secondName;
    int birthYear;
}
