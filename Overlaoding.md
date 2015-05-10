Overloading:
============

**** Factors that cause overloading a little tricky:
1) Widening
2) Autoboxing
3) Var-args

1) Widening:
============

- Whenever a class contains overloaded methods the compiler looks for which method to invoke.

Example:

    class OverloadingWideningScenarios{

      static void overload(int x){System.out.print("int argument")}
      static void overload(long x){System.out.print("long argument")}
      static void overload(double x){System.out.print("double argument")}
      public static void main(Stirng[] args){
        byte b = 1;
        short s = 1;
        long i = 1;
        float f =1f;
        overload(b);
        overload(s);
        overload(i);
        overload(f);
      }
    }

- the compiler widens whenever it doesn't find the exact match.
so the output would be
- int argument
- int argument
- long argument
- double argument

 Boxing and Var-args:
 ====================

- Lets take and example where we bring boxing into the picture.

    class WideningOverBoxing{
      static void overlaod(Integer i){System.out.print("Integer argument")}
      static void overlaod(long l){System.out.print("long argument")}
      public static void main(Stirng[] args){
        int i = 1;
        overload(i);
      }
    }

- What method would the compiler invoke?
The answer is be ---long that means the compiler chooses widening over boxing.
This is because boxing is a new feature introduced in java 5 and widening was an existing feature,
 so they don't want to break the existing code by giving priority boxing.


 ****Similarly for var-args

    class WideningOverVarargs{
      static void overlaod(int i1, int i2){System.out.print("int int argument")}
      static void overlaod(byte... b){System.out.print("byte var argument")}
      public static void main(Stirng[] args){
        byte b = 1;
        overload(b,b);
      }
    }

The output for the above code is --> int int arguments.

****Again widening prevails over var-args

******Widening prevails over Boxing
******Widening prevails over var-args
similarly
*******Boxing prevails over var-args


** Reference Variable:
=======================

****** Widening depends on IS-A test(We cannot widen one wrapper to another: compilation error).


** Between Widening and Boxing:

  class WidenAndBox{
    static void overload(Long x){System.out.print("Long")}
    public static void main(String[] args){
      byte b = 5;
      overload(5);
    }
  }


*** the above scenario fails and it throws a compilation error
