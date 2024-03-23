package Characters;

import Characters.Data.Coordinates;

public class Witch extends Character{
    public Witch(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    @Override
    public void step() {
   }
    
}
