public class Constructors{
	public static void main(String[] args){
		//Person person = new Person();
		//person.printName();

		Student student = new Student("Hariz", 23);
		student.printName();
		student.printAge();
	}
}

class Person{
	String name = "Hare";

	public Person(String newName){
		name = newName;
	}
	public Person(){}

	void printName(){
		System.out.println("My name is " + name);
	}
}

class Student extends Person{
	int age;

	public Student(){
		//to avoid repeating yourself(same logic in few constructors, make one REAL constr. that calls super() and all the work. USE this())
		this("Hariz", 23);

	}


	public Student(String newName, int newAge){
		super(newName);
		//imagine more code here
		age = newAge;
	}

	void printAge(){
		System.out.println("I am "+ age + " years old");
	}

	
}

