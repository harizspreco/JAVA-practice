import java.util.*;

public class Jukebox {
	public static void main(String[] args){
		new Jukebox().go();
	}

	public void go(){
		List<SongV2> songList = MockSongs.getSongsV2();
		for(SongV2 song : songList){
			System.out.println(song.toString());
		}

		//Collections.sort(songList);
		//System.out.println(songList);
	}
}

class SongV2{
	private String title;
	private String artist;
	private int bpm;

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