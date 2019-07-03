package com.github.sirlacky.BookLibraryApp;

import java.util.List;

public class BookByISBN {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private int publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private double averageRating;
    private List<String> authors;
    private List<String> categories;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "BookByISBN{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", averageRating=" + averageRating +
                ", authors=" + authors +
                ", categories=" + categories +
                '}';
    }

    }
