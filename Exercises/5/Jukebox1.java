import java.util.*;

public class Jukebox1 {
	public static void main(String[] args){
		new Jukebox1().go();
	}

	public void go(){
		List<String> songList = MockSongs.getSongsStrings();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
}

class MockSongs{
	public static List<String> getSongsStrings(){
		List<String> songs = new ArrayList<>();
		songs.add("somersault");
		songs.add("cassidy");
		songs.add("$10");
		songs.add("Cassidy");
		songs.add("50 Ways");
		return songs;
	}
}