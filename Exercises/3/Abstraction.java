abstract class Animal{
	//abstract class must be extended(BUT can have static methods)
	//CAN contain abstract and non-abstract methods
	//non-abstract class CAN'T hava abstract methods
	//abstract class cannot be instantiated

	abstract void roam();
	abstract void makeNoise();
	abstract void eat();

	//first concrete class(subclass of abstract class) must implement body for every abstract method
}