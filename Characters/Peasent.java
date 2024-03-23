package Characters;

import Characters.Data.Coordinates;

public class Peasent extends Character{

    public Peasent(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.health = 100;
        super.maxHealth = 100;
        super.strength = 5;
        super.armor = 15;
        super.initiative = 0;
    }

    public void attack(){};
    public void heal(){};

    @Override
    public void step() {
   }
   
}