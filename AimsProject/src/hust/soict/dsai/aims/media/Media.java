package hust.soict.dsai.aims.media;


import java.util.Comparator;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private static int nbMedia = 0;
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(String title) {
		super();
		this.title = title;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Media)) return false;
		
		Media media = (Media) o;
		return this.getTitle() == media.getTitle();
	}

	@Override
	public String toString() {
        return "Media: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }

	public void play() {
		// TODO Auto-generated method stub
	}
	
	
}
	