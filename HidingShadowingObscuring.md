
What is Hiding?

* we can only hide static methods and static variables,How? Why?

What is Overloading?

* We can only overload instance variables, How?

Overloading v/s Hiding,  Example on referencial variables?
======================

Shadowing:
==========

What is Shadowing?
****In Java reference variable is chosen based on the reference type. When shadowing the scopes
    overlap.
* We can only shadow instance variables, How?
* Same class level variables, Example?
* Shadowing super class variables
i) Sub s = new Sub();
ii) Base b = s;

***** Overcome shadowing: By using the keywords this and super.

Obscuring:
==========
What is Obscuring?

* If two classes with same name trying to access same field.




Hiding:
=======
Hiding: Hiding in java means subclass defines a class method (static method) with the same signature as that of the super class,  then in this scenario the super class’s  static method is been hidden by the subclass.
Overloading: overloading in java means subclass defines a instance method with the same signature as that of the super class, then in this scenario the super class’s instance method is  been overridden by the sub class.

Difference between hiding and overloading
	•	Hiding is only done on the class method, whereas overloading is done with respect to the instance method.
	•	In hiding the scope of the method (static method) is been hidden, whereas overloading we are rewriting the method to behave in differently with respect to the sub class.
  Example:
//Super class
package com.java.practice.hiding;

public class Vehicle {
public static void moving(){
System.out.println("vehicle is moving");
}
}
//Sub Class
package com.java.practice.hiding;

public class Car extends Vehicle{
public static void moving(){
System.out.println("car is moving");
}

public static void main(String[] args) {

	Vehicle v = new Vehicle();
	Car c = new Car();

//	Bad practice

	Vehicle.moving();
	Car.moving();
}
}

Here in the above example the 	Car.moving() is hiding with the scope of the Vehicle.moving(). Hold on for a minute isn’t this called the overloading. Well, as I mentioned in the above difference we are using static methods here and as a matter of fact Static Methods are not Polymorphic in nature period. So, This comes unde hiding but not overloading.

*********************************************************
Shadowing:
==========
Shadowing: A variable is said to be shadowed when there is another variable with the same name in its scope. There are two scenarios in which we can explain the concept of the shadowing.
	•	In a java class if we have a local variable which has same name as that of the instance variable the local variable shadows the instance variable. This is called as the shadowing.
	•	In java class when we have a super class instance variable and a sub class extending the super class has same signature of its instance variable as that of the super class then the sub class instance variable is said to be shadowed.

 Example:
//Scenario i.

package com.java.practice.shadowing;

public class IntanceDemo {

	String name = "instance name";

	public void setName(){
		String name = "local name";
//		the local variable name is shadowing the instance variable name so we get output as
//		name: local name
		System.out.println("name: "+ name);
//		we are explicitly calling the with the keyword this which makes to print the intance variable so we get output as
//		name:instance name
		System.out.println("name:"+ this.name);
	}

	public static void main(String[] args) {
		IntanceDemo intanceDemo = new IntanceDemo();
		intanceDemo.setName();

	}
}
// scenario ii.
//Super Class

package com.java.practice.shadowing;

public class Vehicle {

	String name = "Vehicle";
}



//Child Class

package com.java.practice.shadowing;

public class Car extends Vehicle{

	String name = "Car";
public static void main(String[] args) {

	Car c = new Car();
	Vehicle v = new Vehicle();
// c.name is shadowing the name instance of the super class
	System.out.println("CAR NAME    :    "+c.name);// car
	System.out.println("VEHICLE NAME:    "+v.name);// Vehicle

}
}

Obscuring:
==========

Obscuring: Obscuring in java is said to be occurred when a variable has the same name as that of the type and both are in the same scope. So in order to differentiate between two we write the type with the complete package.

Example:
package com.java.practice.obscuring;

public class Obscuring {

	static String System; // bad practice but this is for the example purpose.

	public static void main(String[] args) {

		System.out.println("Example of Obscuring" + System); //It gives compile time error because the System variable is obscuring the java.lang.System.
	}
}

So, in order to get rid of compile time error we will mention the complete package.
package com.java.practice.obscuring;

public class Obscuring {

	static String System; // bad practice but this is for the example purpose.

	public static void main(String[] args) {

		java.lang.System.out.println("Example of Obscuring" + System); //It gives compile time error because the System variable is obscuring the java.lang.System.
	}
}
