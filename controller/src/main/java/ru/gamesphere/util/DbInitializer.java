package ru.gamesphere.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInitializer {

    public static void initDb() {
        String createAuthors = """
                create table if not exists author
                (
                    id          BIGSERIAL PRIMARY KEY,
                    name        CHARACTER VARYING(30) NOT NULL,
                    second_name CHARACTER VARYING(30) NOT NULL,
                    birth_year  int                   NOT NULL
                )
                """;

        String createBooks = """
                create table if not exists books
                (
                    id        BIGSERIAL PRIMARY KEY,
                    name      CHARACTER VARYING(30) NOT NULL,
                    year      int                   NOT NULL,
                    pages     int                   NOT NULL,
                    author_id int references author(id) NOT NULL
                )
                """;

        String createAuthor = """
                insert into author (name, second_name, birth_year)
                values (?, ?, ?)
                """;
        String createBook = """
                 insert into books (name, year, pages, author_id)
                 values (?, ?, ?, ?)
                """;

        try (Connection connection = ConnectionManager.getConnection()) {
            connection.createStatement().execute(createAuthors);
            connection.createStatement().execute(createBooks);

            PreparedStatement createAuthorStatement = connection.prepareStatement(createAuthor);

            createAuthorStatement.setString(1, "Alexander");
            createAuthorStatement.setString(2, "Pushkin");
            createAuthorStatement.setInt(3, 1799);
            createAuthorStatement.execute();

            createAuthorStatement.setString(1, "Alexander");
            createAuthorStatement.setString(2, "Griboedov");
            createAuthorStatement.setInt(3, 1795);
            createAuthorStatement.execute();

            createAuthorStatement.setString(1, "Fedor");
            createAuthorStatement.setString(2, "Dostoevskiy");
            createAuthorStatement.setInt(3, 1821);
            createAuthorStatement.execute();

            PreparedStatement createBookStatement = connection.prepareStatement(createBook);

            createBookStatement.setString(1, "The Golden Fish");
            createBookStatement.setInt(2, 1835);
            createBookStatement.setInt(3, 100);
            createBookStatement.setInt(4, 1);
            createBookStatement.execute();

            createBookStatement.setString(1, "Grief from the mind");
            createBookStatement.setInt(2, 1825);
            createBookStatement.setInt(3, 300);
            createBookStatement.setInt(4, 2);
            createBookStatement.execute();

            createBookStatement.setString(1, "Essays");
            createBookStatement.setInt(2, 1800);
            createBookStatement.setInt(3, 123);
            createBookStatement.setInt(4, 2);
            createBookStatement.execute();

            createBookStatement.setString(1, "The Idiot");
            createBookStatement.setInt(2, 1869);
            createBookStatement.setInt(3, 250);
            createBookStatement.setInt(4, 3);
            createBookStatement.execute();

            createBookStatement.setString(1, "Crime and Punishment");
            createBookStatement.setInt(2, 1866);
            createBookStatement.setInt(3, 400);
            createBookStatement.setInt(4, 3);
            createBookStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
