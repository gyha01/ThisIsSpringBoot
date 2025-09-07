package org.example.springbootchapter1.coffee;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeMaker {
    /* EspressoMachine일 때
    private EspressoMachine espressoMachine;

    public CoffeeMaker(){
        this.espressoMachine = new EspressoMachine();
    }

    public void makeCoffee(){
        System.out.println(espressoMachine.brew());
    }
    */
/*
    private DripCoffeeMachine dripCoffeeMachine;

    public CoffeeMaker(){
        this.dripCoffeeMachine = new DripCoffeeMachine();
    }

    public void makeCoffee(){
        System.out.println(dripCoffeeMachine.brew());
    }
    */

    /*
    private CoffeeMachine coffeeMachine;

   public void setCoffeeMachine(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }*/

    @Autowired
    private List<CoffeeMachine> coffeeMachines;

    @PostConstruct
    public void makeCoffee(){
        for(CoffeeMachine coffeeMachine : coffeeMachines) {
            System.out.println(coffeeMachine.brew());
        }
    }
}
