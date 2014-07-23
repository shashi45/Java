package myclasses.demos.corejava.string;

public class StringApp {
	public static void main(String[] args) {
		//Strings are immutable objects, that means once created and can never be changed.
		//Strings are objects and can be instantiated just like any other class.
		String newString = new String("firstString");  //1
		//A String can also assigned a value using string literals.
		String stringLit = "String literals";			//2
		//There is a subtle difference in the above two ways of creation.
		// 1) creates a new string every time and that too in the heap section of the memory but not in the 
		//permgen space(String pool).
		// 2) if the string already presents in the string pool it just assigns the reference, 
		// else creates a new string in the string pool and assigns it to the string variable. 
		newString.intern();	//3
		// 3) Adds the string to the string pool.
	}
}
