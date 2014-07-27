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
		// ------------
		// Section 1
		// Creating a new String
		{
			// Strings objects can be instantiated just like any other objects .
			String newString = new String("firstString"); // 1
			// A String can also assigned a value using string literals.
			String stringLit = "String literal"; // 2
			// There is a subtle difference in the above two ways of creation.
			// 1) creates a new string every time and that too in the heap
			// section
			// of the memory but not in the
			// permgen space(String pool).
			// 2) if the string already presents in the string pool it just
			// assigns
			// the reference,
			// else creates a new string in the string pool and assigns it to
			// the
			// string variable.
			newString.intern(); // 3
			// 3) Adds the string to the string pool.

			// Note: We said string objects are immutable, but how about string
			// references?
			// Answer is string references are not immutable, that means we can
			// point the reference to any string object without actually
			// creating or
			// manipulating a string.
		}
		// -----------------------------
		// Section 2
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

			// String concat v/s '+' operator
			// A string can be concatenated either using string.concat() method
			// or
			// '+' operator.
			// Their are subtle differences between both.

			// We can add anything to a string using + operator.
			// for example we are adding null to a
			String s4 = null;
			s4 = s4 + "string4";
			System.out.println("adding null and string4 and the output is : "
					+ s4);
			// the above statement prints "nullstring2" as output.

			// above example using concat statement
			String s5 = null;
			try {
				s5 = s5.concat("string5");
				System.out.println("concatenating null with string5: " + s5);
			} catch (Exception e) {
				System.out.println("exception: " + e);
			}
			// The output for the above statements is a NPE, that is if we see
			// the
			// implementation of the concat method in the
			// java.lang.String class they were checking for length of the
			// argument
			// of the input string we are passing.
			// which is the ideal behavior, we cannot concat a null reference to
			// a
			// string object.

			// Using '+' operator we can add any type to a string.
			// Example...
			String s6 = 1 + "two";

			System.out.println("Output of 1+two is " + s6);

			// the above example is adding an integer 1 to string two.
			// ------------
			// SubSection 1
			{
				// The main difference between concat and '+' is String concat
				// methods concatenates two strings but
				// '+' operator adds any type to a string.
				// Adding null to another string using concat methods results in
				// NPE.
				boolean b = true;
				String s7 = b + "false";
				System.out.println("s7: " + s7);

				System.out.println("adding 1 + 2----> " + 1 + 2
						+ "   adding (1 +2)----> " + (1 + 2));
				// The above statement is the best example for what happens if
				// we try to add 1 and 2 with out parenthesis.

				// The below example is from SCJP
				String s11 = "spring ";
				String s22 = s11 + "summer ";
				s11.concat("fall ");
				s22.concat(s11);
				s11 += "winter ";
				// Guess the output
				System.out.println(s11 + " " + s22);

			}
			// Just like what happened with concat method, toLowerCase() and
			// toUpperCase() methods creates a new string object by making the
			// characters to
			// either lower case or upper case letters.
			// Example
			String s8 = "java";
			s8.toUpperCase();
			System.out
					.println("converting the lower case of s8 to uppercase without assigning the output to any reference variable: "
							+ s8);
			s8 = s8.toUpperCase();
			System.out
					.println("converting the lower case of s8 to uppercase and assigning the output to same variable: "
							+ s8);
			// Observer the output of both the above cases.

		}
		// --------------------------
		// Section 3
		{
			// Other string methods.

			//

			// replace(char old, char new)
			String s9 = "JaVa";
			s9 = s9.replace('a', 'A');
			System.out.println("repacing 'a' with 'A' in string JaVa: " + s9);

			// charAt(int index)
			String s10 = "java";
			System.out.println("char at 2: " + s10.charAt(2));

			// equalsIgnoreCase(String s)
			String s11 = "Java";
			System.out.println("Ignoring cases: "
					+ s11.equalsIgnoreCase("JAVA"));

			// length()
			// String class has a separate method which returns the length of
			// the string.
			String s12 = "java";
			System.out.println("Length of the string: " + s12.length());
			// toString()
			// Might be wondering why there toString() method in String class
			// which would be doing nothing but to print the same string object
			// on which we are calling.
			// That is becasue just to maintain consistancy, since all the
			// objects have to invoke
			// tostring method for meaningful representation of the object.
			// trim()
			// removes the leading or trailing whitespaces of the string.
			String s13 = " Java ";
			System.out
					.println("String before whitespace-->" + s13 + "<-- "
							+ "String after whitespaces trimed-->" + s13.trim()
							+ "<--");

			// toCharArray();
			// This method returns the new character array which would be the copy of the original string's char array,
			// whose length is the length of the string.

			//*****In string implementation every string is treated as a sequence of characters.

			// This method inturn uses another method which servers the same purpose which is getChars(...) only
			//difference is the arguments, check the example below;
		String s14 = "toCharArray";
		char[] cArray = s14.toCharArray();
		for(char ch : cArray){
			System.out.print(ch+" ");
		}

		// getChars(...);
		// i) getChars(char dst[], int dstBegin);
		// copies the string chars startign from the dstBegin.

		// getChars(int srcBegin, int srcEnd, char dst[], dstBegin);
		// The arguments for this method are
		// srcBegin: index of the start of the char to be copied.
		// srcEnd: 	index of the end of the char to be copied.
		//dst: is the destination array.
		String s15= "getChars";
		char[] newChar = new char[s15.length()];
		s14.getChars(0,s15.length(),newChar,2);
		for(char ch : newChar){
			System.out.print(ch+" ");
		}

		}

		// ---------------------------
		//section 4
		//subString();
		{
			//What is subString and how it works in java.
			//SubString methods returns us a part of the string based on the boundaries we mention.

		}

		String s131 = "Java";
		char[] c = new char[s131.length()];
		c = s131.toCharArray();
		s131.getChars(0, 4, c, 0);
		System.out.println(" java: " + c[1]);
		System.out.println("10 * 5 " + 10 * 5);
	}
}
