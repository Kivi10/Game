package Characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character target) {
        int damage = this.strength * 2;
        target.receiveDamage(damage);
    }

    public void heal() {
    }
    
}
