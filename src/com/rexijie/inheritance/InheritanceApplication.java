package com.rexijie.inheritance;


interface Organism {
    void live();
    void eat();
    void die();
}

class Alive implements Organism {

    Alive() {
        System.out.println("Its Alive!!");
    }

    public void survive() {
        System.out.println("in Alive class");
        System.out.println("Living thing is surviving");
    }

    @Override
    public void live() {
        System.out.println("Organism is alive");
    }

    @Override
    public void eat() {
        System.out.println("Organism is eating");
    }

    @Override
    public void die() {
        System.out.println("Organism is dead");
    }
}

// Final Classes can't be extended
final class Animal extends Alive {
    private final String name;

    public Animal(String name) {
        super();
        this.name  = name;
    }

    public void live() {
        System.out.println(this.name + " Is Alive");
    }

    public void eat() {
        System.out.println(this.name + " is eating");
    }

    public void die() {
        System.out.println(this.name + " Is Dead");
    }
}

//class Dog extends Animal { Will not work
//
//}


public class InheritanceApplication {

    public static void main(String[] args) {
        Animal dog = new Animal("The dog");
        dog.live();
        dog.survive();
        dog.eat();
        dog.die();

        Alive liveOrganism =  new Animal("The cat");
        liveOrganism.live();
        liveOrganism.eat();
        liveOrganism.survive();
        liveOrganism.die();
    }
}
