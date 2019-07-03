package com.github.sirlacky.BookLibraryApp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
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
    public static BookByISBN getBookByISBN(String isbn) {
        BookByISBN bookByISBN = new BookByISBN();

        try {

            byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\SirLackyDom\\Desktop\\Projekty Programowanie\\BookLibraryApp\\src\\main\\resources\\JSON\\books.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = null;
            rootNode = objectMapper.readTree(jsonData);
            Book book = new Book();
            JsonNode items = rootNode.path("items");
            Iterator<JsonNode> elements = items.elements();


            while (elements.hasNext()) {
                JsonNode nextElement = elements.next();
                BookByISBN bookByISBN1 = new BookByISBN();
                if (nextElement.has("volumeInfo")) {
                    JsonNode volumeInfo = nextElement.path("volumeInfo");

                    if (volumeInfo.has("industryIdentifiers")) {
                        JsonNode industryIdentifiers = volumeInfo.path("industryIdentifiers");

                        if (industryIdentifiers.toString().contains(isbn)) {

                            if (volumeInfo.has("industryIdentifiers")) {
                                JsonNode industryIdentifiersNumber = volumeInfo.path("industryIdentifiers");
                                bookByISBN.setIsbn(industryIdentifiersNumber.findValue("identifier").asText());
                            }
                            if (volumeInfo.has("title")) {
                                JsonNode title = volumeInfo.path("title");
                                bookByISBN.setTitle(title.asText());
                            }
                            if (volumeInfo.has("publisher")) {
                                JsonNode publisher = volumeInfo.path("publisher");
                                bookByISBN.setPublisher(publisher.asText());
                            }
                            if (volumeInfo.has("publishedDate")) {
                                JsonNode publishedDate = volumeInfo.path("publishedDate");
                                bookByISBN.setPublishedDate(publishedDate.asInt());
                            }
                            if (volumeInfo.has("description")) {
                                JsonNode description = volumeInfo.path("description");
                                bookByISBN.setDescription(description.asText());
                            }
                            if (volumeInfo.has("pageCount")) {
                                JsonNode pageCount = volumeInfo.path("pageCount");
                                bookByISBN.setPageCount(pageCount.asInt());
                            }
                            if (volumeInfo.has("thumbnailUrl")) {
                                JsonNode thumbnailUrl = volumeInfo.path("thumbnailUrl");
                                bookByISBN.setThumbnailUrl(thumbnailUrl.asText());
                            }
                            if (volumeInfo.has("language")) {
                                JsonNode language = volumeInfo.path("language");
                                bookByISBN.setLanguage(language.asText());
                            }
                            if (volumeInfo.has("previewLink")) {
                                JsonNode previewLink = volumeInfo.path("previewLink");
                                bookByISBN.setPreviewLink(previewLink.asText());
                            }
                            if (volumeInfo.has("averageRating")) {
                                JsonNode averageRating = volumeInfo.path("averageRating");
                                bookByISBN.setAverageRating((averageRating.asDouble()));
                            }
                            if (volumeInfo.has("authors")) {
                                JsonNode authors = volumeInfo.path("authors");

                                if (authors.isArray()) {
                                    List<String> authorsList = new ArrayList<>();
                                    for (JsonNode node : authors) {
                                        authorsList.add(node.asText());
                                    }
                                    bookByISBN.setAuthors(authorsList);
                                }

                            }
                            if (volumeInfo.has("categories")) {
                                JsonNode cat = volumeInfo.path("categories");

                                if (cat.isArray()) {
                                    List<String> catList = new ArrayList<>();
                                    for (JsonNode node : cat) {
                                        catList.add(node.asText());
                                    }
                                    bookByISBN.setCategories(catList);
                                }
                            }
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return bookByISBN;
    }
    }
