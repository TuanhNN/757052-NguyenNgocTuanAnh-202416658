package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();

        DigitalVideoDisc d1 = new DigitalVideoDisc("The Godfather", "Crime", "Coppola", 175, 25.50f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Tarantino", 154, 22.00f);
        DigitalVideoDisc d3 = new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148, 29.99f);

        myStore.addDVD(d1);
        myStore.addDVD(d2);
        myStore.addDVD(d3);

        myStore.removeDVD(d2); 

        DigitalVideoDisc d4 = new DigitalVideoDisc("Avatar", "Sci-Fi", "Cameron", 162, 30.00f);
        myStore.removeDVD(d4);

        myStore.addDVD(d4); 
    }
}