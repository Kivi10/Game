package Characters.Data;

import java.util.ArrayList;
import java.util.Random;

import Characters.Archer;
import Characters.Character;
import Characters.Crossbowman;
import Characters.Magician;
import Characters.Monk;
import Characters.Spearman;
import Characters.Warrior;

public class TeamCreator{

    private int size;

    private static final Random random = new Random();

    ArrayList<Character> team = new ArrayList<>();

    public static Character createRandomCharacter(String name, Coordinates coordinates) {
        int randomType = random.nextInt(8);

        switch (randomType) {
            case 0:
                return new Archer(name, coordinates);
            case 1:
                return new Magician(name, coordinates);
            case 2:
                return new Warrior(name, coordinates);
            case 3:
                return new Crossbowman(name, coordinates);
            case 4:
                return new Spearman(name, coordinates);
            case 5:
                return new Monk(name, coordinates);
            case 6:
                return new Crossbowman(name, coordinates);
            case 7:
                return new Crossbowman(name, coordinates);
            default:
                return new Archer(name, coordinates); 
        }
    }

    public ArrayList<Character> createTeam(int teamSize, Coordinates teamCoordinates) {
        for (int i = 0; i < teamSize; i++) {
            String name = getName();
            Coordinates coordinates = new Coordinates(teamCoordinates.getX() + i, teamCoordinates.getY());
            team.add(createRandomCharacter(name, coordinates));
            size ++;
        }
        return team;
    }

    public String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);  
    }

    public void getTeamList(){
        for (Character mate : team) {
            System.out.println(mate);
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    public Character get(int index){
        return team.get(index);
    }

}
