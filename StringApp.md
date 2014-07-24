StringApp.java
==============

Strings and Memory:

* Strings are one of the important classes in java, if not handled properly can cause sever memory issues.
* Optimum memory utilization is essentially one of the key goals of effective programing.
* As the application grows the  string utilization grows and some times there will be lot of redundancy.
* For this JVM has come up with a 'string constant pool' concept, which is a special part of Heap itself.
What happens is whenever the compiler comes across any string literal it first checks in the string pool
and if it finds it refers to that string in the string pool else creates a new one.
        This way we can eliminate redundancy of strings by not creating the same string again and again.

* Inorder for this string constant pool to hold good the string class has to be immutable.
Just above we said that any string in the String pool can be referenced by many, so any one can change
without the knowledge of others and causes the system to break. For this the string class is made final
and not allowing anyone to change once created.

Why String is immutable in java?

* We cannot achieve string constant pool without making String class as final.
* String is most commonly used type in java,
i) Opening network connections where hostname and port numbers as strings
ii) Database URLs as strings for opening connections
iii) Can be used in file I/O where we pass the file name as strings
etc...
Any malicious manipulations on the above string variables would lead to serious security threats. Any one
who has access to these strings can easy manipulate them knowing or unknowingly and can gain access to
that variable.
Because of immutability we dont have to worry those kind of threats.
* Since string is immutable this allows to cache hashcode. That means the hashcode is not gonna change
even for multiple invocations.
* Strings are also used in class loading mechanisms where the class names are stored in the form of strings.
If not immutable the class names can be easily changed and that again would pose a serious threat.
