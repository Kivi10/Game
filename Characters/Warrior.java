package Characters;

import Characters.Data.Coordinates;

public class Warrior extends Character {

    public Warrior(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.health = 100;
        super.maxHealth = 100;
        super.strength = 15;
        super.armor = 30;
        super.initiative = 1;
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength * 2;
        target.receiveDamage(damage);
    }

    public void heal() {
    }
   
    @Override
    public void step() {
   }
   
}
