package myclasses.demos.corejava.string;

public class StringApp {
	public static void main(String[] args) {
		// Strings are a sequence of characters.
		// This being said strings are backed by the char array in the
		// implementation.
		// Each character in the string is of size 16 bit(char is 16 bit in java
		// just to support rich international set of characters.).
		// Strings are immutable objects, that means once created and can never
		// be changed.
		// Strings objects can be instantiated just like any other objects .
		String newString = new String("firstString"); // 1
		// A String can also assigned a value using string literals.
		String stringLit = "String literal"; // 2
		// There is a subtle difference in the above two ways of creation.
		// 1) creates a new string every time and that too in the heap section
		// of the memory but not in the
		// permgen space(String pool).
		// 2) if the string already presents in the string pool it just assigns
		// the reference,
		// else creates a new string in the string pool and assigns it to the
		// string variable.
		newString.intern(); // 3
		// 3) Adds the string to the string pool.

		// Note: We said string objects are immutable, but how about string
		// references?
		// Answer is string references are not immutable, that means we can
		// point the reference to any string object without actually creating or
		// manipulating a string.

		// //////////Section 2
		{
			// String concat method
			// we can concat two string in java and that can done as follows.
			String s1 = "string1";
			s1 = s1.concat(" concatenating with string2");
			System.out.println("Concating s1 with string2: " + s1);
			// the above statement will print
			// "string1 concatenating with strings2".
			// *****But the String class is an immutable class, then how can it
			// concatenate one string with other?
			// s1 = s1.concat(" concatenating with string2") is not merely
			// adding s1
			// to the other string. But the JVM creates two more new string
			// objects one is " concatenating with string2" and one more
			// new string which is final concatenated string,
			// "string1 concatenating with string2".
			// That means there are total of 3 strings
			// i) "string1"
			// ii) " concatenating with string2"
			// iii) "string1 concatenating with string2"
			// ******The perfect example to see the immutability of the string
			// is from below example...

			String s2 = "Hello";
			s2.concat(" World");
			System.out.println("Expecting Hello World and got--> " + s2);

			// The above statement prints Just Hello, this is because since
			// String is immutable concat method is not
			// just adding string "World" to string "Hello" but creating a new
			// string as we discussed above,
			// so above we are creating a new String "Hello World" but not
			// assigning to any variable and it is lost instantly.
			// We are trying to print s2 which is still referring to "Hello"
			// object.
			// ------------------------------------------
			// String concatenation using '+'

			// We can concatenate two strings using '+' operator too and that
			// can be done as follows

			String s3 = "Hello";
			s3 = "Hello" + " World";
			System.out
					.println("String concatenation using '+' operator: " + s3);

		}

		// String concat v/s '+' operator
		// A string can be concatenated either using string.concat() method or
		// '+' operator.
		// Their are subtle differences between both.

		// We can add anything to a string using + operator.
		// for example we are adding null to a
		String s4 = null;
		s4 = s4 + "string4";
		System.out.println("adding null and string4 and the output is : " + s4);
		// the above statement prints "nullstring2" as output.

		// above example using concat statement
		String s5 = null;
		try {
			s5 = s5.concat("string5");
			System.out.println("concatenating null with string5: " + s5);
		} catch (Exception e) {
			System.out.println("exception: " + e);
		}
		// The output for the above statements is a NPE, that is if we see the
		// implementation of the concat method in the
		// java.lang.String class they were checking for length of the argument
		// of the input string we are passing.
		// which is the ideal behavior, we cannot concat a null reference to a
		// string object.

		// Using '+' operator we can add any type to a string.
		// Example...
		String s6 = 1 + "two";
		
		System.out.println("Output of 1+two is " + s6);
		
		// the above example is adding an integer 1 to string two.
		
		// The main difference between concat and '+' is String concat methods concatenates two strings but 
		// '+' operator adds any type to a string. 
		// Adding null to another string using concat methods results in NPE.
		boolean b = true;
		String s7 = b + "false";
		System.out.println("s7: "+s7);
		
		System.out.println("adding 1 + 2----> "+ 1+2+ "   adding (1 +2)----> "+ (1+2));
		//The above statement is the best example for what happens if we try to add 1 and 2 with out parenthesis.
		
		//The below example is from SCJP
		String s1 = "spring ";
        String s2 = s1 + "summer ";
        s1.concat("fall ");
        s2.concat(s1);
        s1 += "winter ";
        System.out.println(s1 + " " + s2);

	}
}
