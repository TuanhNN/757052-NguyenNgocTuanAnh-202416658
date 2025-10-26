
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
}
