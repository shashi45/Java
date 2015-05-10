Wrappers:
=======


—The Wrapper API Servers Two primary purposes: 

Wrapper classes are Immutable.

1) It provides a mechanism to “wrap” primitive to objects where these can be used in activities reserved for objects like adding to collection and used as return type where the method return type is of type object.

2) To provide utility functions for primitives like converting primitives to string objects and primitives and string objects to different bases like binary, octal and hexadecimal.



— Boolean, Byte, Sort, Integer, Long, Character, Double and Float.

—Character class contains only one arg constructor of type char.

— Float has overloaded constructor with float, double or String.

Ex: 

Float float1 = new Float(1.1);

Float float1 = new Float(1.1f);

Float float1 = new Float(“1.1”);

-Classes which take String throw NumberFormatException.



———>1) Primitives are converted to Wrapper classes in two ways: 

a)******Using the Wrapper class Constructor: 

—All the classes except Character provides two constructors one which accepts the primitive of type being constructed and one that takes String

Ex: Integer integer = new Integer(1);

      Integer integer = new Integer(“1”);



b)******ValueOf() Method: 

—Two Static ValueOf() method present in most of the wrapper classes is the other way to create a wrapper object.

—-Both the methods accept String as argument.

- One which takes only String and one which takes String and additional argument radix which indicates in which base the first argument is.

Ex: 

Integer in = Integer.valueOf(“111”,2);

Float f = Float.valueOf(“1.1”);



———>2) Wrapper Conversion Utilities

a) xxxValue()

Converts the value of the wrapped numeric to primitive. Each of the six numeric wrapper class has six methods.

Ex: 

Integer in = new Integer(1);

byte b = in.byteValue();



b) parseXxx() and valueOf(): one method arg is String and another takes string and radix.

the six parseXxx() methods for each numeric wrapper type.

Ex: 

double d = Double.parseDouble(“1.1”);

double d = Double.parseDouble(“100.10”, 2);



*****toString(): 

String d = Double.toString(2.2);

Integer and Long provides third toString(int,int);

Ex: 

String s = Long.toString(254,16);



———Integer and Long converts the base 10 to other bases.( toXxxString(int or long)        )

String s = Integer.toHexString(254);

String s = Integer.toOctalString(254);

=
