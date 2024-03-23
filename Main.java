import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Characters.Character;
import Characters.Archer;
import Characters.Crossbowman;
import Characters.Magician;
import Characters.Monk;
import Characters.Peasent;
import Characters.Spearman;
import Characters.Warrior;
import Characters.Witch;
import Characters.Data.Coordinates;
import Characters.Data.Names;

public class Main {
    public static ArrayList<Character> darkTeam = new ArrayList<>();
    public static ArrayList<Character> holyTeam = new ArrayList<>();
    public static ArrayList<Character> allTeam = new ArrayList<>();
    public static int units = 10;

    public static void main(String[] args) {
        init();
        Scanner input = new Scanner(System.in);
        allTeam = sortTeam();
        while(true){
            View.view();
            input.nextLine();
            for (Character human : allTeam) {
                if (holyTeam.contains(human)) {human.step();}
                else human.step();
            }
        }

    }

    public String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);  
    }

    public static void init(){
        for (int i = 0; i < units; i++) {
            darkTeam.add(createRandomCharacter(new Coordinates(i+1, 1)));
            holyTeam.add(createRandomCharacter(new Coordinates(i+1, 10)));
        }
    }

    public static Character createRandomCharacter(Coordinates coordinates) {
        Random random = new Random();
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
                return new Witch(coordinates);
            case 7:
                return new Peasent(coordinates);
            default:
                return new Archer(coordinates); 
        }
    }
    public static ArrayList<Character> sortTeam(){
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(darkTeam);
        list.addAll(holyTeam);
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (o2.getSpeed() == o1.getSpeed()) return (int)(o2.getHp() - o1.getHp());
                else return (int)(o2.getSpeed() - o1.getSpeed());
            }
        });
        return list;
    }
}
