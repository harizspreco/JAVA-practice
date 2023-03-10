//Static variables - values shared between all instances of the class



class Duck{
	private int size = 0;
	/*private*/ static int duckCount = 0;

	public Duck(){
		duckCount++; //each time constructor is called/new instance is made, duckCount increment by one
	}

	public int getSize(){
		return size;
	}

	public void setSize(int s){
		size = s;
	}
}

class ConstantInit{
	//TWO ways of initializing static final variables

	//first: when you declare variable
	public static final int X = 10;

	//second: with static initializer
	public static final double Y;

	static {
		Y = Math.random();
	}
}


public class NumbersAndStatics{

	public static void main(String[] args){
		Duck duck1 = new Duck();
		Duck duck2 = new Duck();
		Duck duck3 = new Duck();

		System.out.println(duck1.duckCount+" "+duck2.duckCount+" "+duck3.duckCount); //should call duckCount on class directly, not like this
	}
}