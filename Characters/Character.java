package Characters;


import Characters.Data.Coordinates;
import Characters.Data.Step;
import Characters.Data.TeamCreator;

public abstract class Character implements Step{
    protected String name;

    protected int level;
    protected int experience;

    protected int health;
    protected int maxHealth;
    protected int strength;
    protected int armor;

    protected Coordinates coordinates;

    protected int initiative;


    public Character(String name, Coordinates coordinates) {
        this.name = name;
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

    public Character findNearestEnemy(TeamCreator enemies) {
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

}
