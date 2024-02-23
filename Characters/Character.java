package Characters;

public abstract class Character {
    protected String name;

    protected int level;
    protected int experience;

    protected int health;
    protected int maxHealth;
    protected int strength;
    protected int armor;

    public Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + this.name;
    }

    public void getStats() {
        System.out.println(toString() + ':'+ " Level: " + this.level + "; Health: " + this.health +"; Strength: " + this.strength + "\n"); 
    }

    public void attack(Character target){
        int damage = this.strength;
        target.receiveDamage(damage);
    };

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(this.getClass().getSimpleName() + " был повержен!");
        }
    }

    public void heal(int amount) {
        if (this.health < this.maxHealth) {
            this.health = Math.min(this.maxHealth, this.health + amount);
            System.out.println(this.getClass().getSimpleName() + " был вылечен на " + amount + " единиц здоровья.");
        }
    }

    public void healComrade(Character target, int amount) {
        target.heal(amount);
    }

}
