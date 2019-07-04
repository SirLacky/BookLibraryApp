package com.github.sirlacky.BookLibraryApp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class BookByCategory {

    private String isbn;
    private String title;
    private String publisher;
    private int publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
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
        return "BookByCategory{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", authors=" + authors +
                ", categories=" + categories +
                '}';
    }

    public static List<BookByCategory> getBookByCategorie(String categorie) {

        List<BookByCategory> listOfBookSortedByCategory = new ArrayList<>();

        Logger logger = Logger.getLogger(BookByCategory.class.getName());
        try {

            String filename = "\\src\\main\\resources\\JSON\\books.json";
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
            absoluteFilePath = workingDirectory + File.separator + filename;
            File file = new File(absoluteFilePath);

            byte[] jsonData = Files.readAllBytes(Paths.get(absoluteFilePath));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = null;
            rootNode = objectMapper.readTree(jsonData);
            Book book = new Book();
            JsonNode items = rootNode.path("items");
            Iterator<JsonNode> elements = items.elements();


            while (elements.hasNext()) {
                JsonNode nextElement = elements.next();
                BookByCategory bookByCategory = new BookByCategory();
                if (nextElement.has("volumeInfo")) {
                    JsonNode volumeInfo = nextElement.path("volumeInfo");

                    if (volumeInfo.has("categories")) {
                        JsonNode categories = volumeInfo.path("categories");

                        if (categories.toString().contains(categorie)) {


                            if (volumeInfo.has("industryIdentifiers")) {
                                JsonNode industryIdentifiers = volumeInfo.path("industryIdentifiers");
                                bookByCategory.setIsbn(industryIdentifiers.findValue("identifier").asText());

                            }
                            if (volumeInfo.has("title")) {
                                JsonNode title = volumeInfo.path("title");
                                bookByCategory.setTitle(title.asText());
                            }
                            if (volumeInfo.has("publisher")) {
                                JsonNode publisher = volumeInfo.path("publisher");
                                bookByCategory.setPublisher(publisher.asText());
                            }
                            if (volumeInfo.has("publishedDate")) {
                                JsonNode publishedDate = volumeInfo.path("publishedDate");
                                bookByCategory.setPublishedDate(publishedDate.asInt());
                            }
                            if (volumeInfo.has("description")) {
                                JsonNode description = volumeInfo.path("description");
                                bookByCategory.setDescription(description.asText());
                            }
                            if (volumeInfo.has("pageCount")) {
                                JsonNode pageCount = volumeInfo.path("pageCount");
                                bookByCategory.setPageCount(pageCount.asInt());
                            }
                            if (volumeInfo.has("thumbnailUrl")) {
                                JsonNode thumbnailUrl = volumeInfo.path("thumbnailUrl");
                                bookByCategory.setThumbnailUrl(thumbnailUrl.asText());
                            }
                            if (volumeInfo.has("language")) {
                                JsonNode language = volumeInfo.path("language");
                                bookByCategory.setLanguage(language.asText());
                            }
                            if (volumeInfo.has("previewLink")) {
                                JsonNode previewLink = volumeInfo.path("previewLink");
                                bookByCategory.setPreviewLink(previewLink.asText());
                            }
                            if (volumeInfo.has("authors")) {
                                JsonNode authors = volumeInfo.path("authors");

                                if (authors.isArray()) {
                                    List<String> authorsList = new ArrayList<>();
                                    for (JsonNode node : authors) {
                                        authorsList.add(node.asText());
                                    }
                                    bookByCategory.setAuthors(authorsList);
                                }

                            }
                            if (volumeInfo.has("categories")) {
                                JsonNode cat = volumeInfo.path("categories");

                                if (cat.isArray()) {
                                    List<String> catList = new ArrayList<>();
                                    for (JsonNode node : cat) {
                                        catList.add(node.asText());
                                    }
                                    bookByCategory.setCategories(catList);
                                }

                            }

                            listOfBookSortedByCategory.add(bookByCategory);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("For category: " + categorie + " found entries: " + listOfBookSortedByCategory.size());
        return listOfBookSortedByCategory;
    }
}
