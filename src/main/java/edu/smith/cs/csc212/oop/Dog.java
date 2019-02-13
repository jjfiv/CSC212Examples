package edu.smith.cs.csc212.oop;

public class Dog {
  String name;
  String color;
  int age;
  
  // Creating a constructor.
  public Dog(String n, String c, int a) {
    this.name = n;
    this.color = c;
    this.age = a;
  }
  

  // Busy busy busy.
  public static void main(String[] args) {
    Dog pet = new Dog("Buddy", "honey", 13);
    System.out.println(pet.name + " is " + pet.age
        + " years old and is " + pet.color + "-colored.");

    // My sister’s dog, named after Bruins goalie.
    pet = new Dog("Tuukka", "Black, brown, and white", 4);
    System.out.println(pet.name + " is " + pet.age
        + " years old and is " + pet.color + "-colored."); 
   
  }
}
