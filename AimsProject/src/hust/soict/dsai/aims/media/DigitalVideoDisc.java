package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	//Constructor
	public DigitalVideoDisc(String title, String category, String director,int length, float cost) {
		super(title, category, cost, length, director);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	// for search by title
	public boolean isMatch(String title) {

	    String searchTitle = title.toLowerCase();
	    String discTitle = this.getTitle().toLowerCase();

	    String[] searchWords = searchTitle.split(" ");
	    
	    for (String word : searchWords) {

	        if (!discTitle.contains(word)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD's length: " + this.getLength());
	}
	
	@Override
    public String toString() {
        return this.getId() + " - DVD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Director: " + this.getDirector() +
                " - DVD length: " + this.getLength() +
                " - Cost: " + this.getCost() + "$";
    }
}
