package hust.soict.dsai.aims.media;

public abstract class Media {
	
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
	}

	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Media)) return false;
		
		Media media = (Media) o;
		return this.getTitle().equalsIgnoreCase(media.getTitle());
	}
}
	