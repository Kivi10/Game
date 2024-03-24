package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Crossbowman extends Character{
    
    public boolean isAlive = true;

    protected int arrows = 10;
    
    public Crossbowman(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    public void step(ArrayList<Character> enemies) {
        if (this.health <= 0 || this.arrows <= 0) {
            return; 
        }

        Character nearestEnemy = findNearestEnemy(enemies);
        if (nearestEnemy != null) {
            attack(nearestEnemy); 
            arrows --;
        }
    }
}
