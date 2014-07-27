package myclasses.demos.corejava.string;

public class StringApp {
	public static void main(String[] args) {
		// Strings are a sequence of characters.
		// This being said strings are backed by the char array in the implementation.
		// Each character in the string is of size 16 bit(char is 16 bit in java
		// just to support rich international set of characters.).
		// Strings are immutable objects, that means once created and can never be changed.
		// ------------
		// Section 1
		// Creating a new String
		{
			// Strings objects can be instantiated just like any other objects .
			String newString = new String("firstString"); // 1
			// A String can also assigned a value using string literals.
			String stringLit = "String literal"; // 2
			// There is a subtle difference in the above two ways of creation.
			// 1) creates a new string every time and that too in the heap section
			// of the memory but not in the permgen space(String pool).
			// 2) if the string already presents in the string pool it just assigns  the reference,
			// else creates a new string in the string pool and assigns it to the string variable.
			newString.intern(); // 3
			// 3) Adds the string to the string pool.

			// Note: We said string objects are immutable, but how about string references?
			// Answer is string references are not immutable, that means we can
			// point the reference to any string object without actually creating or manipulating a string.
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
			// s1 = s1.concat(" concatenating with string2") is not merely adding s1
			// to the other string. But the JVM creates two more new string
			// objects one is " concatenating with string2" and one more
			// new string which is final concatenated string, "string1 concatenating with string2".
			// That means there are total of 3 strings
			// i) "string1"
			// ii) " concatenating with string2"
			// iii) "string1 concatenating with string2"
			// ******The perfect example to see the immutability of the string is from below example...

			String s2 = "Hello";
			s2.concat(" World");
			System.out.println("Expecting Hello World and got--> " + s2);

			// The above statement prints Just Hello, this is because since
			// String is immutable concat method is not
			// just adding string "World" to string "Hello" but creating a new string as we discussed above,
			// so above we are creating a new String "Hello World" but not
			// assigning to any variable and it is lost instantly.
			// We are trying to print s2 which is still referring to "Hello" object.
			// ------------------------------------------
			// String concatenation using '+'
//******** + operator is internally implemented using either by StringBuffer of StringBuilder.
			// We can concatenate two strings using '+' operator too and that
			// can be done as follows

			String s3 = "Hello";
			s3 = "Hello" + " World";
			System.out
					.println("String concatenation using '+' operator: " + s3);

			// String concat v/s '+' operator
			// A string can be concatenated either using string.concat() method or '+' operator.
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
System.out.println("");
		// getChars(...);
		// i) getChars(char dst[], int dstBegin);
		// copies the string chars startign from the dstBegin.

		// getChars(int srcBegin, int srcEnd, char dst[], dstBegin);
		// The arguments for this method are
		// srcBegin: index of the start of the char to be copied.
		// srcEnd: 	index of the end of the char to be copied.
		// dst: is the destination array.
		// dstBegin: start index of the destination array.

		/**
		* srcBegin >= 0
		* srcEnd   <= string lenght
		* dstBegin >= 0
		* dstBegin <= dstBegin+(srcBegin - srcEnd)
		* throws an IndexOutOfBoundException if the above conditions are not met.
		*/

		String s15= "getChars";
		char[] newChar = new char[s15.length()+2];
		s15.getChars(0,s15.length(),newChar,2);

		for(char ch : newChar){
			System.out.print(ch+" ");
		}
System.out.println("");
		}

		// ---------------------------
		//section 4
		//subString();
		{
			//What is subString and how it works in java.
			//SubString methods returns us a part of the string based on the boundaries we mention.
			//	There are two overloaded methods in the substring()
			// i) substring(beginIndex); Which takes beginIndex and prints the substring starts from begin
			// index to end of the string.
			// ii) subString(beginIndex, endIndex); returns a substring starts at the beginIndex and
			//  ends at endIndex.

			/**
			* beginIndex: Inclusive
			* endIndex  : Exclusive
			* beginIndex >= 0
			* endIndex   <= string length
			* beginIndex < endIndex
			*/
			//What happens if the beginIndex is equal to the length of the string.
			String s16 = "JavaSubString";
			System.out.println("subStr1: "+ s16.substring(s16.length()));
			// In the above print statement the substring's beginIndex is equal to the length of the string and output is an empty string.

			System.out.println("subStr1: "+ s16.substring(4));// i)
			System.out.println("subStr2: "+ s16.substring(0,s16.length())); // ii)

			// i) The first print statement prints the substring starting from 4 and end of the string.
			// ii) the second print statemnt prints the substring starting from 0 to end of the string.

			// We have seen the behavior of the substring method, but How does it works?
			// If we seen the Implementation class, it always creates a new string, this is because of the fact that string is an immutable class.
			// Again while creating the new substring it makes use of the value[] which is used to store the original character array.
			// What is wrong in using the original array here, irrespective of how small is our substring array it will still be allocated the same amount of
			// memory space as that of the original array. If our original array is too big then our substring will end up having the same space.This causes memory leaks.
			// And the worst part of all is the original string wont be available for garbage collection too.
			// ***** There is still a work around for this, we can trim the empty spaces by passing the substring into one of the strings class constructor, which has the
			// capability to do this. It checks if the array size is greater than the string size, if so it trims by copying the array.

			String s17 = new String(s16.substring(4));
			System.out.println("Substring using work around: "+ s17);

			// Another way is to call the intern method on the substring which will creates a fetch the substring from the string pool and if it not there it creates a
			// new string substring it the pool.

			System.out.println("Internalizing the substring: "+ s16.substring(4).intern());
			// Strings intern methods puts the string in the string pool
		}

		// Section 5
		// StringBuffer and StringBulder
		{
			// As we were discussing the string class is immutable, that means once created we cannot change it.
			// But what if we have to make lot of modifications to the string, in this scenario we cannot use string,
			// since we end up created multiple string objects.
			// 	So if we have to do lot of string modifications we can use StringBuffer and StringBulder classes.
			// These have some methods which helps in changing the contents of the string.

			// ****** The common use of these classes is in File I/O's where we have to handle large blocks of strings.

			// So why two classes StringBuffer and StringBuilder
			// The main difference between these two is
			// StringBuffer 														StringBufilder
			//Thread-Safe(Methods are synchronized)			Not Thread-Safe(Methods are not synchronized)


			//Important methods in StringBuffer and StringBuilder

			StringBuffer sb = new StringBuffer("Core");
			sb.append("Java");
			System.out.println("StringBuffer: "+ sb);
			// Unlike the String, append method just appends to the existing string instead of creating a new string object every time.

			//delete(strIndex, endIndex);
			// strIndex: inclusive
			// endIndex: endIndex

			StringBuffer sb2 = new StringBuffer("012345");
			sb2.delete(0, 3);
			System.out.println("delete 0 to 3: "+ sb2);

			//insert(offset, String)  ----Overloaded method, offsetExclusive.
			StringBuffer sb3 = new StringBuffer("CoreJava");
			sb3.insert(4, " ");
			System.out.println("Insert space before Java: "+ sb3);
			//reverse()
			StringBuffer sb4 = new StringBuffer("Java");
			System.out.println("reverse: "+ sb4.reverse());

			//toString
			StringBuffer sb5 = new StringBuffer("toString");
			System.out.println("toString returns string object: "+sb5.toString());

		}


	}
}
