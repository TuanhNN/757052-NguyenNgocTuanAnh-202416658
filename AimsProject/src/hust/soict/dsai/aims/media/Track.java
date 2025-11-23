package hust.soict.dsai.aims.media;

public class Track implements Playable {
	
	 private String title;
	 private int length;
	 
	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track's length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Track)) return false;

	    Track track = (Track) o;
	    return this.getTitle().equalsIgnoreCase(track.getTitle())
	        && this.getLength() == track.getLength();
	}
}
