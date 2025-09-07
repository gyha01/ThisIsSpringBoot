package org.example.springbootchapter1.coffee;

/*
public class DripCoffeeMachine {
    public String brew(){
        return "Brewing coffee with Drip Coffee Machine";
    }
}
*/

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dripCoffeeMachine")
public class DripCoffeeMachine implements CoffeeMachine{
    @Override
    public String brew(){
        return "Brewing coffee with Drip Coffee Machine";
    }
}