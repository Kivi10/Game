package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Monk extends Character {

    public boolean isAlive = true;
    
    public Monk(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    public void step(ArrayList<Character> enemies) {
        if (this.health <= 0) {
            return; 
        }

        Character nearestEnemy = findNearestEnemy(enemies);

    if (Math.abs(super.coordinates.getX() - nearestEnemy.coordinates.getX()) <= 1 && 
        Math.abs(super.coordinates.getY() - nearestEnemy.coordinates.getY()) <= 1  && 
        nearestEnemy.health > 0) {
        attack(nearestEnemy);
    } else {
        coordinates.moveTo(nearestEnemy.coordinates);
    }
    }   

}
