package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	 
	//Constructor
	public Book(String title, String string, float f) {
		super(title);
	}

	public Book(String title, String category, List<String> authors, float cost) {
		super(title, category, cost);
		this.authors = authors;
	}

	//
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		} else {
			System.out.println("This author has already been in this list!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("No author has been found to remove!");
		}
	}
	
	@Override
    public String toString() {
        return this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }

}
