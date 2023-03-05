public class SimpleStartupGame{
	public static void main(String[] args){
		int numOfGuesses = 0;

		SimpleStartup dot = new SimpleStartup();

		
		java.util.Random random = new java.util.Random();
    	int locNum = random.nextInt(5);

    	int[] randLocs = new int[3];
    	for(int i = 0; i < 3; i++){
    		randLocs[i] = locNum;
    		locNum++;
    	}
    	dot.setLocationCells(randLocs);

 		while(true){
 			//get user input
 			GameHelper helper = new GameHelper();
        	int userGuess = helper.getUserInput("Enter number between 0 and 6");
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
