package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	private int qtyOrdered = 0;

	public void addMedia(Media media) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else if (itemOrdered.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart!");
        } else {
            itemOrdered.add(media);
            System.out.println(media.getTitle() + " has been added!");
            qtyOrdered += 1;
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
	

	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Order Items:");
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			Media disc = itemOrdered.get(i);
			totalCost += itemOrdered.get(i).getCost();
			System.out.println(disc.toString());
		}
		System.out.println("TOtal cost: " + totalCost + " $");
		System.out.println("**************************************************");
	}
	
	// search by id
	public void search(int id) {
	    boolean found = false;
	    for (int i = 0; i < qtyOrdered; i++) {
	        Media disc = itemOrdered.get(i);
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
	        Media disc = itemOrdered.get(i);
	        
	        if (disc.isMatch(title)) {
	            System.out.println("Found match: " + disc.toString());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("ERROR: No DVD found matching title.");
	    }
	}
	
	public void searchByCategory(String category) {
        boolean found = false;
        for (Media media : itemOrdered) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no media matching the \"" + category + "\" category were found!");
        }
    }
	
	public void sortByTitle() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemOrdered.iterator();
        iterator = itemOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
	}
	
	public void sortByCost() {
        Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemOrdered.iterator();
        iterator = itemOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
	
	
	public void empty() {
        if (itemOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            qtyOrdered = 0;
            itemOrdered.clear();
            System.out.println("Order created.");
            System.out.println("Now your current cart will be empty!");
            System.out.println();
        }
    }

	
	public Media searchToRemove(String title) {
		for (Media media : itemOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}

}
