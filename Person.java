public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age  = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String toString() {
    return(getName() + "  " + getAge());
  }


  public static void main(String args[]) {

    Person p = new Person(args[0],Integer.parseInt(args[1]));

    System.out.println("Name: " + p.getName() + "  Age: " + p.getAge());

    System.out.println(p);
  }
}

