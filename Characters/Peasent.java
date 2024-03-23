package Characters;

import Characters.Data.Coordinates;

public class Peasent extends Character{

    public Peasent(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    public void attack(){};
    public void heal(){};

    @Override
    public void step() {
   }
   
}