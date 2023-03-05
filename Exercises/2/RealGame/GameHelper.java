import java.util.*;

public class GameHelper{
	private static final String ALPHABET = "abcdefg";
	private static final int GRID_LENGTH = 7;
	private static final int GRID_SIZE = 49;
	private static final int MAX_ATTEMPTS = 200;
	static final int HORIZONTAL_INCREMENT = 1;
	static final int VERTICAL_INCREMENT = GRID_LENGTH;

	private final int[] grid = new int[GRID_SIZE];
	private final Random random = new Random();
	private int startupCount = 0;

	public String getUserInput(String prompt){
		System.out.print(prompt + ": ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toLowerCase();
	}

	public ArrayList<String> placeStartup(int startupSize){
		int[] startupCoords = new int[startupSize];
		int attempts = 0;
		boolean succes = false;

		startupCount++;
		int increment = getIncrement();

		while(!succes & attempts++ < MAX_ATTEMPTS){
			int location = random.nextInt(GRID_SIZE);

			for(int i = 0; i < startupCoords.length; i++){
				startupCoords[i] = location;
				location += increment;
			}
			//System.out.println("Trying "+ Array.toString(startupCoords));
			if(startupFits(startupCoords,increment)){
				succes = coordsAvailable(startupCoords);
			}
		}

		savePositionToGrid(startupCoords);
		ArrayList alphaCells = convertCoordsToAlphaFormat(startupCoords);
		//System.out.println("Placed at: "+ alphaCells);

		return alphaCells;
	}

	private boolean startupFits(int[] startupCoords, int increment){
		int finalLocation = startupCoords[startupCoords.length-1];
		if(increment == HORIZONTAL_INCREMENT){
			return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
		}else{
			return finalLocation < GRID_SIZE;
		}
	}

	private boolean coordsAvailable(int[] startupCoords){
		for(int coord : startupCoords){
			if(grid[coord] != 0){
				//System.out.println("position "+coord+" already taken");
				return false;
			}
		}
		return true;
	}

	private void savePositionToGrid(int[] startupCoords){
		for(int index : startupCoords){
			grid[index] = 1;
		}
	}

	private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords){
		ArrayList<String> alphaCells = new ArrayList<String>();
		for(int index : startupCoords){
			String alphaCoords = getAlphaCoordsFromIndex(index);
			alphaCells.add(alphaCoords);
		}
		return alphaCells;
	}

	private String getAlphaCoordsFromIndex(int index){
		int row = calcRowFromIndex(index);
		int column = index % GRID_LENGTH;
		String letter = ALPHABET.substring(column, column + 1); // convert to letter
		return letter + row;
	}

	private int calcRowFromIndex(int index) {
		return index / GRID_LENGTH;
	} 

	private int getIncrement() {
		if (startupCount % 2 == 0) { 
			return HORIZONTAL_INCREMENT; 
		} else { 
			return VERTICAL_INCREMENT; 
		}
	} 
}
	