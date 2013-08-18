// Java language

public class Person {                      // classes with mains are "applications" 
                                           // and need to be public
                                           // most classes will be public anyway
                                           // unless they appear farther below in the same file
  private String name;                     // declare one private member, String is built-in class
  private int age;                         // declare another private member
                                           // classes are start with upper-case letter
                                           // instances/variables start with lower-case letter
                                           // methods start with lower-case letter
                       
  public Person(String name, int age) {    // constructor is same name as class, hence upper-case
                                           // two parameters are provided as data 
    this.name = name;                      // "this" is a reference to the current object
                                           // this.name is the storage above
                                           // r.h.s. name is parameter
    this.age  = age;                       // backup this data too
  }

  public String getName() {                // accessor method, without using prototypes
    return name;                           // return the data above
  }
  
  public int getAge() {                    // ditto
    return age;
  }

  public String toString() {               // all Java objects inherit a toString() method in Java
                                           // but can overload this method to do own formatting
    return(getName() + "  " + getAge());   // "+" is the String concantenation operator and
                                           // is polymorphic (i.e. int getAge() converted)
  }
  
  // the main is run from the command line: java Person myName 30
  // and Person is an application which then must have a main
  public static void main(String args[]) {
    
    // construct a new Person using the data from the command line:
    Person p = new Person(args[0],Integer.parseInt(args[1]));
    
    // this is how to print to the console in Java
    // the "+" operator forms one String for the println 
    System.out.println("Name: " + p.getName() + "  Age: " + p.getAge());
    
    // Java will automatically call p.toString() to format the object
    // In our case, we've overloaded it with our own code so it looks good
    System.out.println(p);
  }
}

