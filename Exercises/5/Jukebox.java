import java.util.*;

public class Jukebox {
	public static void main(String[] args){
		new Jukebox().go();
		new Jukebox().goWithLabmda();
	}

	public void go(){
		List<SongV2> songList = MockSongs.getSongsV2();
		//Collections.sort(songList);
		TitleComparator titleComparator = new TitleComparator();
		Collections.sort(songList,titleComparator); // or songList.sort(titleComparator); 
		System.out.println(songList);

		ArtistComparator artistComparator = new ArtistComparator();
		Collections.sort(songList,artistComparator);
		System.out.println(songList);
	}

	public void goWithLabmda(){
		List<SongV2> songList = MockSongs.getSongsV2();
		songList.sort((one,two) -> one.getTitle().compareTo(two.getTitle()));
		System.out.println("Sorted with lambda, by title" + songList);

		//sort by BPM
		songList.sort((one,two) -> Integer.compare(one.getBpm(), two.getBpm()));
		System.out.println("Sorted with lambda, by BPM" + songList);

		//sort by title in descending order
		songList.sort((one,two) -> two.getTitle().compareTo(one.getTitle()));
		System.out.println("Sorted with lambda, by title, descending" + songList);

		//we put songList in HashSet constructor to build a new set
		Set<SongV2> songSet = new HashSet<>(songList);
		System.out.println("Printing out HashSet: " + songSet); //Still have duplicates! So, we need to override SongV2 eqals and hashCode methods
		//Now it works!
	}
}

//we need to "extend/implement" Comparable in order to be able to sort SongV2 objects
//Comparable have compareTo() method that we need to implement in our class
//We will implement it so it can sort song objects by title.
class SongV2 implements Comparable<SongV2>{
	private String title;
	private String artist;
	private int bpm;

	//override equals method
	public boolean equals(Object o){
		SongV2 other = (SongV2) o;
		return title.equals(other.getTitle());
	}

	//override hashCode method
	public int hashCode(){
		return title.hashCode();
	}

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

class ArtistComparator implements Comparator<SongV2>{
	public int compare(SongV2 o1, SongV2 o2){
		return o1.getArtist().compareTo(o2.getArtist());
	}
}

class TitleComparator implements Comparator<SongV2>{
	public int compare(SongV2 o1, SongV2 o2){
		return o1.getTitle().compareTo(o2.getTitle());
	}
}

class MockSongs {
	public static List<SongV2> getSongsV2() {
		List<SongV2> songs = new ArrayList<>();
		songs.add(new SongV2("somersault", "zero 7", 147));
		songs.add(new SongV2("cassidy", "grateful dead", 158));
		songs.add(new SongV2("$10", "hitchhiker", 140));
		songs.add(new SongV2("$10", "hitchhiker", 140));
		songs.add(new SongV2("havana", "cabello", 105));
		songs.add(new SongV2("Cassidy", "grateful dead", 158));
		songs.add(new SongV2("50 ways", "simon", 102));
		songs.add(new SongV2("50 ways", "simon", 102));
		return songs;
	}
}