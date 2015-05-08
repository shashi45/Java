Arrays:
========

**What is an Array?
- Arrays are object in Java which store multiple variables of same type.
- It can either primitives or Object references, irrespective it is primitive array or object
  array it stores the array object on the heap.
- There is not such thing called primitive array, the correct way to put it is primitive of array.

** Arrays are efficient but most of the times we use collections which are type of arrays.
- Collections offers more flexible ways to work on the object, it expands dynamically.
- Choice would be based on what you want, fast insertion deletion searching etc.


** Just like any other object, these steps are to be followed to create an array.

1) Declare an array variable
2) Construct an array object.
3) initialize an array object.

** Declaring an array variable:

Java supports two type,
- 1 Dimensional Array
- 2 Dimensional Array.

* 1 Dimensional Array:
======================
- Again just like any other object variabel array variable is a bit holder containing bits
  which represents a way to get to the object on the heap.

Syntax:
  - int[] primitiveArray;
  - Object[] objectArray;

- The distinction between normal object to array object is with the brackets after the type.
- We can also put the brackets after the declaration type, like
  int primitiveArray[];
  Which is not recommended.
- Recommended syntax:
   int[] primitiveArray;
   Because it is more readable, the above declaration can be read as, int Array Object not
   int primitiveArray.

* 2 Dimensional Array:
======================

- Array of Arrays
- Similarly 2D arrays can be declared as

  int[][] twoDArray;
  int[] twoDArrayNotRecommended[];    //Not recommended

***** Common errors

- int[5] commonErrorArrayDeclaration;   // This way of declaration is not correct because,
                                        // JVM doesn't allocate memory until we instantiate the object.


** Constructing an Array(construct, create, instantiate etc.):

- Constructing an array is nothing but creating an array on the heap.
- While creating an array, we must tell the JVM to how much space it should allocate
  for that array.

  int[] primitiveArray;           //Declaration
  primitiveArray = new int[10]    //Construction
  Creates an array on the heap which holds 10 elements since it is not initialized it will
  hold default values for  the above example the default value of int is 0.
- Similarly for objects.

* Constructing a multidimensional array:

int[][] twoDArrayConstruction = new int[2][]; //Array of Arrays.
****Only the first brackets are given some value because what JVM wants while creating an
    array is the size for its memory allocation and only the first bracket is enough for that.

- So the JVM creates two objects on the heap.

- twoDArrayConstruction[0] = new int[3];
  twoDArrayConstruction[1] = new int[1];


** Initializing an array:
=========================

- Initializing an array is nothing but populating the values into it.
- For a non-primitive variables it never actually holds the object, it just holds references.

******Watch:
If we try to access out of range index or [-1] we get ArrayIndexOutOfBoundsExcepiton.
ex: int[] iarray = new int[1];
          iarray[1] = 1;
          iarray[-1] =1; //Both the above statements throws ArrayIndexOutOfBoundsExcepiton.

  ****Declaration, construction and initialization in one line.

  int i = {1,2,3};
  Object o = {new Object(), new Car()};

** Anonymous Array:

 new int[] {1,2,3};   // This type of initialization dosen't need to assign to any reference variable.
                      // Just in time array: when you want to pass an array as argument to a method
                      // we can just pass this type of anonymous array, where in you dont really
                      // want a reference type.

***** What kind of an array elements can be stored in an array:

-- Array of Primitives:
- Primitive arrays can accept all the elements which can be prompted implicitly to declared
  array type.
  Ex:
        int[] i = new int[3];
        byte b = 1;
        i[0] = b;
        char c = 'c';
        i[1] = c;

-- Array of Object Reference: The object that passes IS-A test can be assigned to an element.
- If the declared array type is a super class type or interface type then the array can
  hold all the elements which are sub class of the declared type.

  interface Vehicle{}
  class Car implements Vehicle{}
  class BMW extends Car{}

    Vehicle[] vehicle = {new BMW(), new Car()};
*** Do's and Don't
* Array type cannot be assigned to primitive type or Object type.
  int[] array = {1};
  int i = array; //compilation error.
  int in = 1;
  Car[] car = in; //complilation error.
  Car[] car1 = array; //complilation error.*******Should pass IS-A test.

  
