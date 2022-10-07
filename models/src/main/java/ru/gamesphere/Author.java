package ru.gamesphere;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String name;
    private String secondName;
    int birthYear;
}
