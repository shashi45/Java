Variable Scopes:
===============

* A reference variable in java is just a place holder which contains bits representing a way
to get to the object.

* The following are the places inside a class where we can declare a variable
As a filed variable(instance or static), static block, initialization block, constructor, method.
* Once we declare and initialize a variable, how long will that be available for accessing.

 Lets see an example:

  public class VaiableScope{

    //static variable
    static int s = 1;

    //instance variable
    int i = 1;
    static{
      int sBlock = 1;
    }

    //initialization block
    {
      int initBlock = 1;
    }

    //constructor
    public VariableScope(){
      this.i = 10;
    }

    //method
    public void method1(){
      //local variable
      int local = 1;

      //block variable
      {
        int block = 1;
      }
    }
  }

* In the above example each variable has a scope based on their location.
- s is a static variable, its scope starts when the class is first loaded
  and will be alive as long as the class stays loaded in the JVM.
- same applies for the static block too(There is a catch here on which one gets loaded first
  either it is static block or static variables).
- instance variable i they are created when a new instance of that class is created and its
  alive till the object is alive. Its the second long lived variable.
- Variable declared in the init block or constructors and the methods are the flavor of local
  variables. they scope of access is till something local to the blocks.


**** The higher level scope of the variable can be suppressed by the lower level scoped
     this concept is called shadowing the variable.

**** Common access errors
i) Accessing instance variables from a static constant.

class StaticContex{
  int i = 1;
  public static void main(String[] args){
    i++;//throws a compilation error.
  }
}

ii) Attempting to access a local variables in called method, which is declared in calling method.

  class MethodScope{
    public static void main(String[] args){

    }
    void meth1(){
      int m1 = 1;
      meth2();
    }

    void meth2(){
      m1 = 2;// throws a compilation error since m1 is out of scope in this context.
    }
  }
iii) Attempting to use the block level variabels out side their scope(out side the blocks).
other similar examples of blocked variables include, switches, try-catch, for, do and while loops.

****Initialization blocks are run when the classes are first loaded in case of static blocks
    and when an instance is created in case of initialization block.


- The static block code is run once every time when the class is loaded.
- The init block code is run once every time when the call to constructor of the super is made.
(That is every time a new instance is created.)
**********If a code has multiple blocks, the code is executed in the order which they appear.
