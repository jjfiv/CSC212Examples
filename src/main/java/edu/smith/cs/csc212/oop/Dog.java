package edu.smith.cs.csc212.oop;

public class Dog {
  String name;
  String color;
  int age;
  
  public Dog() {
    // This is what you get if you don't have a constructor.
    // When we make a new one
  }
  
  // Creating a constructor.
  public Dog(String name, String color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }
  

  // Busy busy busy.
  public static void main(String[] args) {
    Dog pet = buddy();
    System.out.println(pet.name + " is " + pet.age
        + " years old and is " + pet.color + "-colored.");
    
    Dog nobody = new Dog();
    System.out.println(nobody.name + " is " + nobody.age
        + " years old and is " + nobody.color + "-colored.");
    
    pet = tuukka();
    System.out.println(pet.name + " is " + pet.age
        + " years old and is " + pet.color + "-colored.");
  }

  // Make an object to represent Buddy.
  public static Dog buddy() {
    return new Dog("Buddy", "Honey", 13);
  }
  
  // My sister’s dog, named after Bruins goalie.
  public static Dog tuukka() {
    Dog tuukka = new Dog();
    tuukka.name = "Tuukka";
    tuukka.color = "Black, brown, and white"; // I guess?
    tuukka.age = 4; // Don't quote me on this.
    return tuukka;
  }
}
