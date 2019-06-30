package com.github.sirlacky.BookLibraryApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@SpringBootApplication
public class BookLibraryApp {

    public static void main(String[] args){
        SpringApplication.run(BookLibraryApp.class,args);



    }

}
