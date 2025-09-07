package Coffee;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private CoffeeMachine coffeeMachine;

    @PostConstruct
    public void makeCoffee(){
        System.out.println(coffeeMachine.brew());
    }
}
