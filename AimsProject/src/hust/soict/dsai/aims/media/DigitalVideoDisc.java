package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

	private static int nbDigitalVideodDiscs = 0;

	//Constructor
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category ,cost);
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
}
