package oops;

public class abstration { // Original class name retained
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.eat();
        horse.walk();

        Chicken chicken = new Chicken();
        chicken.eat();
        chicken.walk();

        Mustang mustang = new Mustang();
        mustang.eat();
        mustang.walk(); // Redundant, inherits implementation from Horse
    }
}

abstract class Animal { // Original class name retained
    public Animal() {
        // Consider separate method for color or remove this line
        System.out.println("Animal constructor called");
    }

    public void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk(); // Just an idea, no implementation
}

class Horse extends Animal {

    public Horse() {
        System.out.println("Horse constructor called");
    }

    @Override // Explicitly indicate method override
    public void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Mustang extends Horse {

    public Mustang() {
        System.out.println("Mustang constructor called");
    }

    // Redundant, inherits move() from Horse
}

class Chicken extends Animal {

    public Chicken() {
        System.out.println("Chicken constructor called");
    }

    @Override
    public void walk() {
        System.out.println("Walks on 2 legs");
    }
}
