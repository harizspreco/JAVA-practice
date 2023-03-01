import java.util.ArrayList;

public class StartupBust{
	GameHelper helper = new GameHelper();
	ArrayList<Startup> startups = new ArrayList<Startup>();
	int numOfGuesses = 0;

	public static void main(String[] args){
		StartupBust game = new StartupBust();
		game.setUpGame();
		game.startPlaying();
	}

	private void setUpGame(){
		Startup one = new Startup();
		one.setName("firma1");
		startups.add(one);

		Startup two = new Startup();
		two.setName("firma2");
		startups.add(two);

		Startup three = new Startup();
		three.setName("firma3");
		startups.add(three);

		System.out.println("Your goal is to sink all three startups");
		System.out.println("firma1, firma2, firma3");
		System.out.println("Try to sink them all in fewest number of guesses");

		for(Startup startup : startups){
			ArrayList<String> newLocation = helper.placeStartup(3);
			startup.setLocationCells(newLocation);
		}
	}

	private void startPlaying(){
		while(!startups.isEmpty()){
			String userGuess = helper.getUserInput("Enter a guess: ");
			checkUserInput(userGuess);
		}
		finishGame();
	}

	private void checkUserInput(String userGuess){
		numOfGuesses++;
		String result = "miss";

		for(Startup startupToTest : startups){
			result = startupToTest.checkYourself(userGuess);

			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")){
				startups.remove(startupToTest);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame(){
		System.out.println("All startups are dead! Your stocks are worthless");
		if(numOfGuesses<18){
			System.out.println("It only took you "+numOfGuesses+" guesses.");
			System.out.println("You got out before your options sunk.");
		}else{
			System.out.println("Took you long enough. "+numOfGuesses+" guesses.");
			System.out.println("Fish are dancing with your options");
		}
	}

}