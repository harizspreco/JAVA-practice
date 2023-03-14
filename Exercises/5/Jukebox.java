import java.util.*;

public class Jukebox {
	public static void main(String[] args){
		new Jukebox().go();
	}

	public void go(){
		List<SongV2> songList = MockSongs.getSongsV2();
		Collections.sort(songList);
		System.out.println(songList);
	}
}

//we need to "extend/implement" Comparable in order to be able to sort SongV2 objects
//Comparable have compareTo() method that we need to implement in our class
//We will implement it so it can sort song objects by title.
class SongV2 implements Comparable<SongV2>, Comparator<SongV2>{
	private String title;
	private String artist;
	private int bpm;

	//compareTo() method implementation
	public int compareTo(SongV2 s){
		return title.compareTo(s.getTitle());
	}

	public SongV2(String title, String artist, int bpm){
		this.title = title;
		this.artist = artist;
		this.bpm = bpm;
	}

	public String getTitle(){
		return title;
	}

	public String getArtist(){
		return artist;
	}

	public int getBpm(){
		return bpm;
	}

	public String toString(){
		return title;
	}
}

class MockSongs {
	public static List<SongV2> getSongsV2() {
		List<SongV2> songs = new ArrayList<>();
		songs.add(new SongV2("somersault", "zero 7", 147));
		songs.add(new SongV2("cassidy", "grateful dead", 158));
		songs.add(new SongV2("$10", "hitchhiker", 140));
		songs.add(new SongV2("havana", "cabello", 105));
		songs.add(new SongV2("Cassidy", "grateful dead", 158));
		songs.add(new SongV2("50 ways", "simon", 102));
		return songs;
	}
}