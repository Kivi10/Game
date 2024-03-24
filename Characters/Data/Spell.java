package Characters.Data;

public enum Spell {
    FIREBALL(2),
    HEAL(2),
    RESURRECTION(10);

    private int manaCost;

    Spell(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }
}
