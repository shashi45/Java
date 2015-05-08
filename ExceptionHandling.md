Exception Handling:
===================

* Error detection and handling may be the most important ingredient of any robust application.

* What is an Exception?
- Exception is an Event or occurrence which alters the normal program flow.
  When an exception is even occurs an exception is said to be thrown and the code which is
  responsible to be handle that code will catch that exception.
- Exception handling is nothing but telling the JVM to what code to run once it comes across
  the exception.

  Syntax:

  try{
   // This is where the code which might throw the exception goes.
  }catch(Exception ex){
    //This is where we handle the exception, the code that has to run once the exception occurs.
  }//It can be followed by multiple catches.


  * try block should be followed by catch block or finally block.
  * can have multiple catch blocks, but should be in an order.

* Exception handlers are bad place to cleanup the code because for example if are trying to
  close any resources in catch block then we have to repeat the same code in all the blocks.
  This would lead to redundancy of the code.
* To address the above problem Java offers FINALLY block.
** Finally
  - Finally block is executed irrespective of whether the exception was thrown or not.
  - Even if there is a return statement in the try block and is executed right after the return executes.
* Finally is the right place to close the network connection, cleanup your code.
********The only time when the finally block wont be executed is when we execute
        System.exit();
        
** If the exception is thrown try runs and if the exception is not thrown even then try runs.
** If the exception is thrown back to the calling method then in that scenario there is no
   need of using catch block after try block, we directly use finally block.

   try{
     //Code which can throw exception.
   } finally {
     //clean up code.
   }

** Illegal try/catch declaration
   =============================

- try{
  //Code which can throw exception.
  }
  //Without catch block.
-- Try block has to be followed with catch or finally block.
   Its legal to omit either catch or finally but not both.

- try{
  //Code which can throw exception.
  }
  //Some code
  catch (MyException){
    //handle the exception
  }
-- catch block has to follow immediately after try block.


** Propagating Uncaught Exception.
=================================

* We can do two thing with the exception, either we can handle it or throw it back to
  the calling method if there is no catch clause for that exception.
*** If the method doesn't have the catch block for that exception then the method is said
    to be ducking the exception(or passing the buck).

** Call Stack: Call stack is the chain of methods that your program executes to get to the
   current method.
  - The latest method call will be at the top of the stack.
- So what happens when exception is ducked?
  so when the exception is ducked it is passed down to the previous methods where the
  exception is handled and this kind of passing down the exception is called exception propagation.
** If an exception never handled will cause the application to stop.

** So what happens when an exception is thrown?
   When an exception is thrown an object of a that particular exception is instantiated and
   handed back to the catch block as an argument.


                      Object
                        |
               _______Throwable_______
               |                      |
          Error                    ___Exception____
                                  |                |
                          RuntimeException         CompiletimeException
                           (unchecked)                (checked)


* Exception and Error are derived from Throwable
* Error: Error represents unusual situations that are not caused by program errors like
         JVM running out of memory.
  Application wont be able to handle Errors so there is no point handling it.
*** Errors are not Exception.
* Exceptions: Caused by program errors.
* Errors:     Caused by non program errors.

** Handling Class Hierarchy of Exception.

* we can catch more than one exception using single catch class.
Ex: simple example is Exception, which is the super class of all the exception.

  try{
    //Code that throws exception.
  }catch(Exception exp){
    System.out.println("Excepiton: " + exp)
  }

** This is not the correct way of doing, off course we can find out what kind of exception is
   been thrown.
******* This reduces the reliability of the program because it depicts that the handler doesn't
        know how to handle the exception.
* Its all depends on the requirement, if we have to handle all the exception in same way then
it is better to catch the super class exception.

* Or if we have to do a special treatment for one particular exception and treat the same for
  all the others then we handle that particular exception at the top and super class exception
  at the bottom.
  This way when ever the exception is thrown Java will try to find that particular exception,
  if it doesn't finds one then it goes down to another until it finds one.
  This type of matching is called Exception Matching.
                                  ==================

******** If the Exceptions that are handled are of same type then the order in which we catch the
         exception matters.

***** An exception can be declared by using throws keyword.
***** Declaring an exception is nothing but propagating the exception.
***** Unhandled checked exceptions has to be declared.
***** No need to handle or declare unChecked exceptions.

* Since Errors are not exceptions we probably wont catch or handle them, we can but its not
  mandatory. This is because we cannot do anything once we get an Error like OutOfMemoryError
  VirtualMachineError.


***********  Two categories of exceptions and errors

- JVM Exceptions : Those exceptions or errors thrown by JVM.
- Programmatic Exception :  Those exceptions that are thrown by application.

JVM Exceptions: NPE, this exception would occur when we use a reference variable which has
a  value null. So there is no way that the compiler would be knowing to enforce this excepiton.
StackOverflowError, this exception would be thrown when the JVM runs out of memory to store
                    the call stack.
  Only JVM know when this these kind of errors will occur.

Programmatic Exception: created by application/API developer.
NumberFormatException, IllegalArgumentException
