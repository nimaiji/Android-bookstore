package BookCore;

import android.content.Context;

import java.util.List;

public class Book{

    String name;
    List<Account> authors,translators;
    int pageCount;
    Publisher publisher;
    Address address;
    List<Category> categories;
    Price price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Account> authors) {
        this.authors = authors;
    }

    public List<Account> getTranslators() {
        return translators;
    }

    public void setTranslators(List<Account> translators) {
        this.translators = translators;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}