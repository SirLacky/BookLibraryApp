package com.github.sirlacky.BookLibraryApp;

import org.junit.jupiter.api.Test;

import static com.github.sirlacky.BookLibraryApp.AuthorRating.getRatingByAuthor;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRatingTest {

    @Test
    void testGetRatingByAuthor() {
        String expected = "AuthorRating{author='James William Bayley Money', averageRating=1.0}";
        String actual = getRatingByAuthor("James William Bayley Money").toString();
        assertEquals(expected, actual, "For James William Bayley Money average rating should be 1");
    }
}