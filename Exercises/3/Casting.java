//In java every class is subclass of Object class. Some of them implicitly and some of them explicitly

public class Casting{
	public static void main(String[] args){
		Object o = new Dog();
		//o.roam()  -this won't work, classes higher in inheritance tree doesen't know about methods from subclasses

		Dog d = (Dog) o; //IF we are SURE o is actually Dog type, we can cast it into a Dog reference type
		d.roam(); // now we can use Dog methods
	}
}

class Dog{
	void roam(){
		System.out.println("Dog roam");
	}
}

