package com.github.sirlacky.BookLibraryApp;

import org.junit.jupiter.api.Test;

import static com.github.sirlacky.BookLibraryApp.BookByISBN.getBookByISBN;
import static org.junit.jupiter.api.Assertions.*;

class BookByISBNTest {
    @Test
    void testGetBookByISBN() {
        String expected = "BookByISBN{isbn='0763715018', title='A Laboratory Course in Java', subtitle='null', publisher='Jones & Bartlett Learning', publishedDate=2001, description='CS1/C101 Introduction to Programming in Java Programming in Java Object-Oriented Programming.', pageCount=315, thumbnailUrl='null', language='en', previewLink='http://books.google.pl/books?id=FqRxixxvLwIC&printsec=frontcover&dq=java&hl=&cd=11&source=gbs_api', averageRating=0.0, authors=[Nell B. Dale], categories=[Computers]}";
        String actual = getBookByISBN("0763715018").toString();
        assertEquals(expected, actual, "ISBN 0763715018 should reply with String of book with title A Laboratory Course in Java");
    }
}