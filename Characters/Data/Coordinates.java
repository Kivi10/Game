package Characters.Data;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public double distanceTo(Coordinates other) {
        // реализация расчета расстояния между координатами
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) 
        + Math.pow(this.y - other.getY(), 2));
    }
}

