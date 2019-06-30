package com.github.sirlacky.BookLibraryApp;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;

@RestController
public class BooksResource {

    @RequestMapping("/")
    public Book getBooks() throws FileNotFoundException {


        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("C:\\Users\\SirLackyDom\\Desktop\\Projekty Programowanie\\BookLibraryApp\\src\\main\\resources\\JSON\\books.json"));
        Book book = gson.fromJson(reader, Book.class);

        return book;


    }
}
