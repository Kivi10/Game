package Characters;


import java.util.ArrayList;
import java.util.Random;

import Characters.Data.Coordinates;
import Characters.Data.Names;
import Characters.Data.Step;

public abstract class Character implements Step{
    protected String name = getName();

    protected int level;
    protected int experience;

    protected int health;
    protected int maxHealth;
    protected int strength;
    protected int armor;
    protected int speed = 1;

    protected Coordinates coordinates;

    protected int initiative;


    public Character(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Character() {
        super();
    }

    @Override
    public void step() {
   }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name;
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
    };

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(this.name + " был повержен!");
        }
    }

    public void heal(int amount) {
        if (this.health < this.maxHealth) {
            this.health = Math.min(this.maxHealth, this.health + amount);
            System.out.println(this.getClass().getSimpleName() + " был вылечен на " + amount + " единиц здоровья.");
        }
    }

    public Character findNearestEnemy(ArrayList<Character> enemies) {
        double nearestDistance = Double.MAX_VALUE;
        Character nearestEnemy = null;
        
        for (int i = 0; i < enemies.size(); i++) {
            double distance = this.coordinates.distanceTo(enemies.get(i).coordinates);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestEnemy = enemies.get(i);
            }
        }

        System.out.println("Ближайший противник для " + this.name + " - " + nearestEnemy.name);
        return nearestEnemy;
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

}
