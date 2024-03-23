package Characters;

import Characters.Data.Coordinates;

public class Magician extends Character{

    public Magician(Coordinates coordinates) {
        super(coordinates);
        super.health = 100;
        super.maxHealth = 100;
        super.strength = 15;
        super.armor = 30;
        super.initiative = 2;
    }

    @Override
    public void step() {
   }
   
}
