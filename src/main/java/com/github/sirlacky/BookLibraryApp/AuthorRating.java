package com.github.sirlacky.BookLibraryApp;

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


}
