package Characters;


import java.util.ArrayList;
import java.util.Random;

import Characters.Data.Coordinates;
import Characters.Data.Names;
import Characters.Data.Spell;
import Characters.Data.Step;

public abstract class Character implements Step{
    protected String name = getName();

    public boolean isAlive = true;

    protected int level;
    protected int experience;

    protected int health = 100;
    protected int maxHealth = 100;
    protected int strength;
    protected int armor;
    protected int ammo;
    protected int mana;
    protected int speed = 1;

    protected Coordinates coordinates;

    protected int initiative;


    public Character(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Character() {
        super();
    }
    public void step(){
        
    }

    public boolean deathCheck(){
        if (this.health <= 0) {
            isAlive = false;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name + ", HP: " + getHp() + " Coords: " + coordinates.toString();
    }

    public void getStats() {
        System.out.println(toString() + ':'+ " Level: " + level + "; Health: " + health +"; Strength: " + strength + "\n"); 
    }

    public void getCoordinates(Character character){
        System.out.println(character.coordinates);
    }

    public void attack(Character target){
        int damage = this.strength;
        target.receiveDamage(damage);
    }

    public void castSpell(Spell spell, Character target) {
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public void heal(int amount) {
        if (this.health < this.maxHealth) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    public void healing(ArrayList<Character> teamates) {
    } 

    public Character findNearestUnit(ArrayList<Character> units) {
        double nearestDistance = Double.MAX_VALUE;
        Character nearestUnit = null;
        
        for (int i = 0; i < units.size(); i++) {
            double distance = this.coordinates.distanceTo(units.get(i).coordinates);
            if (distance < nearestDistance && units.get(i).health > 0) {
                nearestDistance = distance;
                nearestUnit = units.get(i);
            }
        }

        return nearestUnit;
    }

    public double distanceTo(Character target){
        double distanceToTarget = distanceTo(target);
        return distanceToTarget;
    }

    public void healComrade(Character target, int amount) {
        target.heal(amount);
    }

    public int getInitiative() {
        return initiative;
    }

    public int[] getCoords(){
        int[] coords = new int[2];
        coords[0] = coordinates.getX();
        coords[1] = coordinates.getY();
        return coords;
    }

    public int getHp(){
        return health;
    }

    public int getSpeed(){
        return speed;
    }

    public String getInfo(){
        return this.getClass().getSimpleName();
    }

    private String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);  
    }

    public void step(ArrayList<Character> holyTeam) {
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }

}
