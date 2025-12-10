package hust.soict.dsai.aims;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.StoreScreen;
public class Aims {
    public Store store = new Store();
    public Cart cart = new Cart();
        public static void main(String[] args) {
        Store store = new Store();
        
        try {
            store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
            store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
            store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
            store.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
            store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 22.99f));
            store.addMedia(new Book("1984", "Dystopian", 14.99f));
            store.addMedia(new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 29.99f));
            store.addMedia(new Book("The Great Gatsby", "Classic", 12.99f));
            store.addMedia(new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f));
            store.addMedia(new Book("To Kill a Mockingbird", "Classic", 14.99f));  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        new StoreScreen(store);
    }

}