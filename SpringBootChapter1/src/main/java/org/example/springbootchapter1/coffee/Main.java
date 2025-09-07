package org.example.springbootchapter1.coffee;

public class Main {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        //coffeeMaker.setCoffeeMachine(new DripCoffeeMachine());
        coffeeMaker.makeCoffee();

        //coffeeMaker.setCoffeeMachine(new EspressoMachine());
        coffeeMaker.makeCoffee();
    }
}
