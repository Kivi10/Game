package Characters;

import Characters.Data.Coordinates;
import Characters.Data.TeamCreator;

public class Archer extends Character {
    
    protected int arrows = 10;
    boolean isAlive = true;

    public Archer(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.health = 100;
        super.maxHealth = 100;
        super.strength = 15;
        super.armor = 30;
        super.initiative = 3;
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

    public void step(TeamCreator enemies) {
        if (this.health <= 0 || this.arrows <= 0) {
            System.out.println("Пропуск хода.");
            return; 
        }

        Character nearestEnemy = findNearestEnemy(enemies);
        if (nearestEnemy != null) {
            attack(nearestEnemy); 
            arrows --;
            System.out.println("Персонаж " + this.name + " выстрелил в " + nearestEnemy.name);
        }
    }

    @Override
    public void getStats() {
        super.getStats();
    }
}