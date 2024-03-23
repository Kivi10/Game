package Characters;

import java.util.ArrayList;

import Characters.Data.Coordinates;

public class Warrior extends Character {

    public Warrior(Coordinates coordinates) {
        super(coordinates);
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
   
    public void step(ArrayList<Character> enemies) {
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
