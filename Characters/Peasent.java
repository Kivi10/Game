package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Peasent extends Character{

    public boolean isAlive = true;

    public Peasent(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
    }

    public void attack(){};
    public void heal(){};

    public void step(ArrayList<Character> teamates) {
        if (this.health <= 0) {
            return; 
        }
        giveArrow(teamates);
    }   
   
    public void giveArrow(ArrayList<Character> teamates){
        Character teamate = findNearestCharacter(teamates);
        if (teamate == null) {
            return;
        }
        coordinates.moveTo(teamate.coordinates);
        if (Math.abs(super.coordinates.getX() - teamate.coordinates.getX()) <= 1 && 
        Math.abs(super.coordinates.getY() - teamate.coordinates.getY()) <= 1  && 
        teamate.health > 0) {
            if (teamate instanceof Archer) {
            Archer archer = (Archer) teamate;
            archer.increaseArrows(); 
            }
            if (teamate instanceof Crossbowman) {
                Crossbowman crossbowman = (Crossbowman) teamate;
                crossbowman.increaseArrows(); 
            }
            if (teamate instanceof Spearman) {
                Spearman spearman = (Spearman) teamate;
                spearman.increaseArrows(); 
            }
        }
    }

    public Character findNearestCharacter(ArrayList<Character> units) {
    double nearestDistance = Double.MAX_VALUE;
    Character nearestCharacter = null;

    for (int i = 0; i < units.size(); i++) {
        Character unit = units.get(i);
        double distance = this.coordinates.distanceTo(unit.coordinates);
        if (unit instanceof Archer || unit instanceof Spearman || unit instanceof Crossbowman) {
            if (distance < nearestDistance && unit.health > 0) {
                nearestDistance = distance;
                nearestCharacter = unit;
            }
        }
    }

    return nearestCharacter;
}
}