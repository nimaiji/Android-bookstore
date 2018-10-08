package BookCore;

import java.util.List;

public class Account extends User {
    Cart cart;
    List<Book> willingToSellBooks;
    String phoneNumber;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Book> getWillingToSellBooks() {
        return willingToSellBooks;
    }

    public void setWillingToSellBooks(List<Book> willingToSellBooks) {
        this.willingToSellBooks = willingToSellBooks;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
