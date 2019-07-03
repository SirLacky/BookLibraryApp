package com.github.sirlacky.BookLibraryApp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class AuthorRating {

    private String author;
    private double averageRating;

    @Override
    public String toString() {
        return "AuthorRating{" +
                "author='" + author + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public static AuthorRating getRatingByAuthor(String authorName) {

        double finalRating = 0;

        try {

            byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\SirLackyDom\\Desktop\\Projekty Programowanie\\BookLibraryApp\\src\\main\\resources\\JSON\\books.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = null;
            rootNode = objectMapper.readTree(jsonData);
            Book book = new Book();
            JsonNode items = rootNode.path("items");
            Iterator<JsonNode> elements = items.elements();

            int i = 0;
            double rating = 0;



            while (elements.hasNext()) {
                JsonNode nextElement = elements.next();

                if (nextElement.has("volumeInfo")) {
                    JsonNode volumeInfo = nextElement.path("volumeInfo");

                    if (volumeInfo.has("averageRating") && volumeInfo.has("authors")) {
                        JsonNode authors = volumeInfo.path("authors");
                        JsonNode averageRating = volumeInfo.path("averageRating");
                        if (authors.toString().contains(authorName)) {
                            if (averageRating.isDouble()) {
                                rating += averageRating.asDouble();
                                i++;
                                System.out.println("Znaleziono wyszukań: "+i);
                            }
                        }
                    }
                }
            }

            finalRating = rating / i;
            System.out.println("Dla autora: "+authorName);
            System.out.println("Srednia ocena wynosi: "+Math.round(finalRating));



        } catch (IOException e) {
            e.printStackTrace();
        }
        AuthorRating authorRating = new AuthorRating();
        authorRating.setAuthor(authorName);
        authorRating.setAverageRating(finalRating);

        return authorRating;
    }
}
