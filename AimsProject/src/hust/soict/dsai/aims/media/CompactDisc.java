package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, int length, String director, String artist, List<Track> tracks,  float cost) {
		super(title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}



	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}



	public String getArtist() {
		return artist;
	}
	
	// ADD n REMOVE track
	public void addTrack(Track trackName) {
		if(!tracks.contains(trackName)) {
			tracks.add(trackName);
		} else {
			System.out.println("This track has already been in this tracklist!");
		}
	}
	 public void removeTrack(Track trackName) {
		 if(tracks.contains(trackName)) {
			 tracks.remove(trackName);
		 } else {
			System.out.println("Not exist this track to remove!");
		}
	 }
	 
	 public int getLength() {
		 int sumL = 0;
		 for(Track t : tracks ) {
			 sumL += t.getLength();
		 }
		 return sumL;
	 }
	 
	 @Override
	 public void play() {
		 System.out.println("Playing CD: " + this.getTitle());
		 System.out.println("CD's length: " + this.getLength());
		 
		 for (Track track : tracks) {
			 track.play();
		 }
	 }
	 
	 @Override
	    public String toString() {
	        return this.getId() + " - CD: " + this.getTitle() +
	                " - Category: " + this.getCategory() +
	                " - Artist" + this.getArtist() +
	                " - Length: " + this.getLength() + " seconds" + 
	                " - Cost: " + this.getCost() + "$";
	    }
	 
}
