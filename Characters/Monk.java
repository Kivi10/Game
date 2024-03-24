package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;
import Characters.Data.Spell;

public class Monk extends Character {

    public boolean isAlive = true;
    
    public Monk(Coordinates coordinates) {
        super(coordinates);
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
        super.mana = 10;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name + ", HP: " + getHp() + " Coords: " + coordinates.toString() + ", Mana: " + mana;
    }

    public void step(ArrayList<Character> units) {
        if (this.health <= 0) {
            return; 
        }

        Character nearestEnemy = findNearestUnit(units);

    if (Math.abs(super.coordinates.getX() - nearestEnemy.coordinates.getX()) <= 5 && 
        Math.abs(super.coordinates.getY() - nearestEnemy.coordinates.getY()) <= 5  && 
        nearestEnemy.health > 0) {
            castSpell(Spell.FIREBALL, nearestEnemy);
    } else {
        coordinates.moveTo(nearestEnemy.coordinates);
    }
    }   

    public void healing(ArrayList<Character> teamates) {
        if (this.health <= 0) {
            return; 
        }
        healSpells(teamates);
    }   
   
    public void healSpells(ArrayList<Character> teamates){
        Character teamate = findNearestUnit(teamates);
        if (teamate == null) {
            return;
        }
        coordinates.moveTo(teamate.coordinates);
        if (Math.abs(super.coordinates.getX() - teamate.coordinates.getX()) <= 1 && 
        Math.abs(super.coordinates.getY() - teamate.coordinates.getY()) <= 1  && 
        teamate.health > 0) {
            castSpell(Spell.HEAL, teamate);
        }
        if (Math.abs(super.coordinates.getX() - teamate.coordinates.getX()) <= 1 && 
        Math.abs(super.coordinates.getY() - teamate.coordinates.getY()) <= 1  && 
        teamate.health <= 0) {
            castSpell(Spell.RESURRECTION, teamate);
        }
    }

     public void castSpell(Spell spell, Character target) {
        if (spell.getManaCost() <= this.mana) {
            switch (spell) {
                case FIREBALL:
                    target.health -= this.strength;
                    break;
                case HEAL:
                    target.health += 30;
                    break;
                case RESURRECTION:
                    target.health = maxHealth;
                    break;
            }
            this.mana -= spell.getManaCost();
        } else {
            this.mana +=1;
        }
    }

}
