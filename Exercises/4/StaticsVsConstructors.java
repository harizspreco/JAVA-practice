//In this example it is IMPORTANT to notice that statcics run before constructors, even Child's static initializer
//runned before its parent class constructor!

class SuperStatic{
	static int x;

	static {
		x = 3;
		System.out.println("SuperStatic static initializer - print"); //1
	}

	public SuperStatic(){
		System.out.println("SuperStatic constructor - print"); //3
	}
}

class Child extends SuperStatic{
	static{
		System.out.println("Child static initializer - print"); //2
	}

	public Child(){
		System.out.println("Child constructor - print"); //4
	}
}

public class StaticsVsConstructors{
	public static void main(String[] args){
		Child child = new Child();
	}
}