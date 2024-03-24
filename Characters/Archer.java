package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Archer extends Character {
    
    protected int arrows = 10;
    public boolean isAlive = true;

    public Archer(Coordinates coordinates) {
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

    @Override
    public void getStats() {
        super.getStats();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name + ", HP: " + getHp() + " Coords: " + coordinates.toString() + ", Arrows: " + arrows;
    }

    
}