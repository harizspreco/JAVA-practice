class Animal{
	void makeNoise(){
		System.out.println("Hellooo, I am animal class method");
	}
}

class Dog extends Animal{
	void makeNoise(){
		System.out.println("Hellooo, I am dog class method");
	}
}

class Cat extends Animal{
	void makeNoise(){
		System.out.println("Hellooo, I am cat class method");
	}
}

public class Polymorphism{
	public static void main(String[] args){
		Animal[] animals = new Animal[2];
		animals[0] = new Dog();
		animals[1] = new Cat();

		for(Animal animal : animals){
			animal.makeNoise();
		}
	}
}