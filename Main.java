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
    boolean victory = false;
while (!victory) {
    View.view();
    input.nextLine();
    for (Character human : allTeam) {
        if (holyTeam.contains(human)) {
            if (human.findNearestUnit(darkTeam) == null) {
                System.out.println("Светлая команда победила!!!");
                victory = true;
                break;
            }
            if (human instanceof Peasent) {
                human.step(holyTeam);
            }
            if (human instanceof Magician && human instanceof Monk) {
                Character nearstUnitDark = human.findNearestUnit(darkTeam);
                Character nearstUnitHoly = human.findNearestUnit(holyTeam);
                double distanceToTarget1 = human.distanceTo(nearstUnitDark);
                double distanceToTarget2 = human.distanceTo(nearstUnitHoly);
                if (distanceToTarget1 < distanceToTarget2) {human.step(darkTeam);}
                else {human.healing(holyTeam);}
            }
            human.step(darkTeam);
        } else {
            if (human.findNearestUnit(holyTeam) == null) {
                System.out.println("Темная команда победила!!!");
                victory = true;
                break;
            } 
            if (human instanceof Peasent) {
                human.step(darkTeam);
            }
            human.step(holyTeam);  
        }
    }
    System.out.println();
}

    }

    public String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);  
    }

    public static void init(){
        Random random = new Random();
        for (int i = 0; i < units; i++) {
            int randomType = random.nextInt(8);
            switch (randomType) {
                case 0:
                    darkTeam.add(new Archer(new Coordinates(i+1, 1)));
                    break;
                case 1:
                    darkTeam.add(new Magician(new Coordinates(i+1, 1)));
                    break;
                case 2:
                    darkTeam.add(new Warrior(new Coordinates(i+1, 1)));
                    break;
                case 3:
                    darkTeam.add(new Crossbowman(new Coordinates(i+1, 1)));
                    break;
                case 4:
                    darkTeam.add(new Spearman(new Coordinates(i+1, 1)));
                    break;
                case 5:
                    darkTeam.add(new Monk(new Coordinates(i+1, 1)));
                    break;
                case 6:
                    darkTeam.add(new Witch(new Coordinates(i+1, 1)));
                    break;
                case 7:
                    darkTeam.add(new Peasent(new Coordinates(i+1, 1)));
                    break;
                default:
                    darkTeam.add(new Archer(new Coordinates(i+1, 1)));
                    break;
            }
            
            randomType = random.nextInt(8);
            switch (randomType) {
                case 0:
                holyTeam.add(new Archer(new Coordinates(i+1, 10)));
                    break;
                case 1:
                    holyTeam.add(new Magician(new Coordinates(i+1, 10)));
                    break;
                case 2:
                    holyTeam.add(new Warrior(new Coordinates(i+1, 10)));
                    break;
                case 3:
                    holyTeam.add(new Crossbowman(new Coordinates(i+1, 10)));
                    break;
                case 4:
                    holyTeam.add(new Spearman(new Coordinates(i+1, 10)));
                    break;
                case 5:
                    holyTeam.add(new Monk(new Coordinates(i+1, 10)));
                    break;
                case 6:
                    holyTeam.add(new Witch(new Coordinates(i+1, 10)));
                    break;
                case 7:
                    holyTeam.add(new Peasent(new Coordinates(i+1, 10)));
                    break;
                default:
                    holyTeam.add(new Archer(new Coordinates(i+1, 10)));
                    break;
            }
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
