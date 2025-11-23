package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	private int qtyOrdered = 0;

	public void addMedia(Media...mediaList) {
		for (Media media : mediaList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered.add(media);
				qtyOrdered++;
				System.out.println(media.getTitle() + " has been added.");
			} else {
				System.out.println("The cart is almost full! Could not add " + media.getTitle() + " and the remaining.");
				break;
			}
		}
	}


	
	public void removeMedia(Media media) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemOrdered.get(i) == media) {
				itemOrdered.remove(media);
			}
		}
		System.out.println(media.getTitle() + " has been removed");
		qtyOrdered--;
	}
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemOrdered.get(i).getCost();
		}
		return totalCost;
	}
	
	/***
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
	
	// search by id
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

	// search by title
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
	***/
}
