package Characters;

import Characters.Data.Coordinates;
import Characters.Data.TeamCreator;

public class Warrior extends Character {

    public Warrior(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.health = 100;
        super.maxHealth = 100;
        super.strength = 10;
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
   
    public void step(TeamCreator enemies) {
        if (this.health <= 0) {
            System.out.println("Пропуск хода.");
            return; 
        }

        Character nearestEnemy = findNearestEnemy(enemies);

    if (Math.abs(super.coordinates.getX() - nearestEnemy.coordinates.getX()) <= 1 && Math.abs(super.coordinates.getY() - nearestEnemy.coordinates.getY()) <= 1) {
        System.out.println("Нанесение урона.");
        attack(nearestEnemy);
    } else {
        coordinates.moveTo(nearestEnemy.coordinates);
    }
    }   
}
