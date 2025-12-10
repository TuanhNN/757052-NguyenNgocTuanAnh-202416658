package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<>();

	public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
		super(title, category, cost, director, length);
		this.artist = artist;
	}


	public CompactDisc(String title, String artist, List<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String artist, List<Track> tracks) {
		super(title, category);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
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
}
