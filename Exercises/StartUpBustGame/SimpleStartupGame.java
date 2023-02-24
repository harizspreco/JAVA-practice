public class SimpleStartupGame{
	public static void main(String[] args){
		int numOfGuesses = 0;

		SimpleStartup dot = new SimpleStartup();

		
		java.util.Random random = new java.util.Random();
    	int locNum = random.nextInt(4 - 0) + 0;

    	int[] randLocs = new int[3];
    	for(int i = 0; i < 3; i++){
    		randLocs[i] = locNum;
    		locNum++;
    	}
    	dot.setLocationCells(randLocs);

 		while(true){
 			//get user input
 			java.util.Scanner in = new java.util.Scanner(System.in);
        	int userGuess = in.nextInt();
        	//increment number of gusses
 			numOfGuesses++;
 			//check user guess
 			String result = dot.checkYourself(userGuess);
 			if(result.equals("kill")){
 				break;
 			}

 		}
 		System.out.println("It took you "+ numOfGuesses +" times to kill the startUp!");
	}
}

class SimpleStartup{
	private int[] locationCells;
	private int numOfHits = 0;

	public String checkYourself(int guess){
		String result = "miss";

		for(int cell : locationCells){
			if(guess == cell){
				result = "hit";
				numOfHits++;
				break;
			}
		}

		if(numOfHits == locationCells.length){
			result = "kill";
		}

		System.out.println(result);
		return result;
	}

	public void setLocationCells(int[] locs){
		locationCells = locs;
	}
}