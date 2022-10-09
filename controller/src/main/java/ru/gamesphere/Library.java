package ru.gamesphere;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Library {
    private List<Book> books;
}
