package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Spearman extends Character{

    protected int ammo = 10;

    public boolean isAlive = true;

    public Spearman(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name + ", HP: " + getHp() + " Coords: " + coordinates.toString() + ", Arrows: " + ammo;
    }

    public void step(ArrayList<Character> units) {
        if (this.health <= 0) {
            return; 
        }

        Character nearestEnemy = findNearestUnit(units);

    if (Math.abs(super.coordinates.getX() - nearestEnemy.coordinates.getX()) <= 7 && 
        Math.abs(super.coordinates.getY() - nearestEnemy.coordinates.getY()) <= 7  && 
        nearestEnemy.health > 0) {
        attack(nearestEnemy);
    } else {
        coordinates.moveTo(nearestEnemy.coordinates);
    }
    }   

    protected void increaseArrows(){
        ammo++;
    }
   
}
