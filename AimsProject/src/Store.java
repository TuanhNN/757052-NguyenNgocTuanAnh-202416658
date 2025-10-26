public class Store {

    private DigitalVideoDisc[] itemsInStore;
    private int qtyInStore = 0; 
    private static final int MAX_ITEMS = 10000;

    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("Added DVD to store: " + disc.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int indexToRemove = -1;

        for (int i = 0; i < qtyInStore; i++) {

            if (itemsInStore[i].equals(disc)) { 
                indexToRemove = i;
                break; 
            }
        }

        if (indexToRemove != -1) {

            for (int i = indexToRemove; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }

            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--; 
            
            System.out.println("Removed DVD from store: " + disc.getTitle());
        } else {
            System.out.println("DVD not found in store: " + disc.getTitle());
        }
    }
}