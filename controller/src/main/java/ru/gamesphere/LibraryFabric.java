package ru.gamesphere;

import ru.gamesphere.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class LibraryFabric {

    public Library createLibrary(String authorSurname) {
        String SQL = """
                select books.id    as book_id,
                       books.name  as book_name,
                       year,
                       pages,
                       author.id as author_id,
                       author.name as author_name,
                       second_name,
                       birth_year
                from books
                         full join author on books.author_id = author.id
                where author.second_name = ?
                """;
        ArrayList<Book> books = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, authorSurname);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("book_id");
                String name = resultSet.getString("book_name");
                int year = resultSet.getInt("year");
                int pages = resultSet.getInt("pages");
                int authorId = resultSet.getInt("author_id");
                String authorName = resultSet.getString("author_name");
                String secondName = resultSet.getString("second_name");
                int birthYear = resultSet.getInt("birth_year");

                books.add(new Book(id, name, year, pages, new Author(authorId, authorName, secondName, birthYear)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Library(books);
    }
}
