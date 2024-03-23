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

    public static Character createRandomCharacter(Coordinates coordinates) {
        int randomType = random.nextInt(8);

        switch (randomType) {
            case 0:
                return new Archer(coordinates);
            case 1:
                return new Magician(coordinates);
            case 2:
                return new Warrior(coordinates);
            case 3:
                return new Crossbowman(coordinates);
            case 4:
                return new Spearman(coordinates);
            case 5:
                return new Monk(coordinates);
            case 6:
                return new Crossbowman(coordinates);
            case 7:
                return new Crossbowman(coordinates);
            default:
                return new Archer(coordinates); 
        }
    }

    public ArrayList<Character> createTeam(int teamSize, Coordinates teamCoordinates) {
        for (int i = 0; i < teamSize; i++) {
            Coordinates coordinates = new Coordinates(teamCoordinates.getX() + i, teamCoordinates.getY());
            team.add(createRandomCharacter(coordinates));
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
