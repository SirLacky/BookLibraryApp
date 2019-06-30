
package com.github.sirlacky.BookLibraryApp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("requestedUrl")
    @Expose
    private String requestedUrl;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getRequestedUrl() {
        return requestedUrl;
    }

    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Book{" +
                "requestedUrl='" + requestedUrl + '\'' +
                ", items=" + items +
                '}';
    }
}
