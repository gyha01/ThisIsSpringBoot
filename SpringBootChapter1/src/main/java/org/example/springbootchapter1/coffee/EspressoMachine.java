package org.example.springbootchapter1.coffee;

/*
public class EspressoMachine {
    public String brew(){
        return "Brewing coffee with Espresso Machine";
    }
}
*/


import org.springframework.stereotype.Component;

@Component
public class EspressoMachine implements CoffeeMachine{

    @Override
    public String brew(){
        return "Brewing coffee with Espresso Machine";
    }
}
