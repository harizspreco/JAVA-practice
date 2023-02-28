import java.util.*;

public class GameHelper{
	private static final String ALPHABET = "abcdefg";
	private static final int GRID_LENGTH = 7;
	private static final int GRID_SIZE = 49;
	private static final int MAX_ATTEMPTS = 200;
	static final int HORIZONTAL_INCREMENT = 1;
	static final int VERTICAL_INCREMENT = GRID_LENGTH;

	private final int[] grid = new int(GRID_SIZE);
	private final Random random = new Random();
	private int startupCount = 0;

	public int getUserInput(String prompt){
		
	}
}