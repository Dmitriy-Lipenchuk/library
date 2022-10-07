package ru.gamesphere;

import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LibraryFabric libraryFabric = new LibraryFabric();
        Library library = libraryFabric.createLibrary(scanner.next());

        Gson gson = new Gson();

        System.out.println(gson.toJson(library));
    }
}
