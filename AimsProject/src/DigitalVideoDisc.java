
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDigitalVideodDiscs = 0;
	private int id;

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}

	public DigitalVideoDisc(String title, float cost) {
		super();
		this.title = title;
		this.cost = cost;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost, int length) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		this.length = length;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		
		nbDigitalVideodDiscs++;
		this.id = nbDigitalVideodDiscs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
	}


	public boolean isMatch(String title) {

	    String searchTitle = title.toLowerCase();
	    String discTitle = this.title.toLowerCase();

	    String[] searchWords = searchTitle.split(" ");
	    
	    for (String word : searchWords) {

	        if (!discTitle.contains(word)) {
	            return false;
	        }
	    }

	    return true;
	}
}
