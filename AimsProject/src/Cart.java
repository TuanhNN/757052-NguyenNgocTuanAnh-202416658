
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println(disc.getTitle() + " has been added.");
		} else {
			System.out.println("The cart is almost full! Could not add " + disc + " and the remaining.");
		}
	}
	
	// Overloading
	public void addDigitalVideoDisc(DigitalVideoDisc...dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println(disc.getTitle() + " has been added.");
			} else {
				System.out.println("The cart is almost full! Could not add " + disc + " and the remaining.");
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}

	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemOrdered[i] == disc) {
				itemOrdered[i] = itemOrdered[qtyOrdered - 1];
				itemOrdered[qtyOrdered - 1] = null;
			}
		}
		System.out.println(disc.getTitle() + " has been removed");
		qtyOrdered--;
	}
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemOrdered[i].getCost();
		}
		return totalCost;
	}
	
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Order Items:");
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc disc = itemOrdered[i];
			totalCost += itemOrdered[i].getCost();
			System.out.println(disc.toString());
		}
		System.out.println("TOtal cost: " + totalCost + " $");
		System.out.println("**************************************************");
	}
	
	public void search(int id) {
	    boolean found = false;
	    for (int i = 0; i < qtyOrdered; i++) {
	        DigitalVideoDisc disc = itemOrdered[i];
	        if (disc.getId() == id) {
	            System.out.println("Found item: " + disc.toString());
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("ERROR: No DVD found with ID: " + id);
	    }
	}

	public void search(String title) {
	    boolean found = false;
	    System.out.println("Search results for title: \"" + title + "\"");
	    
	    for (int i = 0; i < qtyOrdered; i++) {
	        DigitalVideoDisc disc = itemOrdered[i];
	        
	        if (disc.isMatch(title)) {
	            System.out.println("Found match: " + disc.toString());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("ERROR: No DVD found matching title criteria.");
	    }
	}
}
