class XCoppy{
	public static void main(String[] args){
		int orig = 42;
		XCoppy x = new XCoppy();
		int y = x.go(orig);
		System.out.println(orig + " " + y);
	}

	int go(int arg){
		arg = arg * 2;
		return arg;
	}
}