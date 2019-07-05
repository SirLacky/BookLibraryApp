package com.github.sirlacky.BookLibraryApp;

import org.junit.jupiter.api.Test;

import static com.github.sirlacky.BookLibraryApp.BookByCategory.getBookByCategorie;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookByCategoryTest {

    @Test
    void testGetBookByCategorie() {
        String expected = "[BookByCategory{isbn='0226285103', title='The Religion of Java', publisher='University of Chicago Press', publishedDate=0, description='Written with a rare combination of analysis and speculation, this comprehensive study of Javanese religion is one of the few books on the religion of a non-Western people which emphasizes variation and conflict in belief as well as similarity and harmony. The reader becomes aware of the intricacy and depth of Javanese spiritual life and the problems of political and social integration reflected in the religion. The Religion of Java will interest specialists in Southeast Asia, anthropologists and sociologists concerned with the social analysis of religious belief and ideology, students of comparative religion, and civil servants dealing with governmental policy toward Indonesia and Southeast Asia.', pageCount=392, thumbnailUrl='null', language='en', previewLink='http://books.google.pl/books?id=-SYM4PW-YAgC&printsec=frontcover&dq=java&hl=&cd=2&source=gbs_api', authors=[Clifford Geertz], categories=[Religion]}]";
        String actual = getBookByCategorie("Religion").toString();
        assertEquals(expected, actual, "Category Religion should reply with String of book with title The Religion of Java");
    }

}