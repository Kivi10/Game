package Characters.Data;

public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + ", " + y;
    }

    public double distanceTo(Coordinates other) {
        // реализация расчета расстояния между координатами
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) 
        + Math.pow(this.y - other.getY(), 2));
    }

    public void moveTo(Coordinates other){
        int dX = other.getX() - this.x;
        int dY = other.getY() - this.getY();
        if (Math.abs(dX) > Math.abs(dY)) {
            x += Integer.signum(dX);
        } else {
            y += Integer.signum(dY);
        }
    }
}

