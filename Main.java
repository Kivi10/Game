import Characters.Warrior;
import Characters.Data.Coordinates;
import Characters.Data.TeamCreator;

public class Main {
    public static void main(String[] args) {
        Coordinates coor1 = new Coordinates(1, 1);
        Coordinates coor2 = new Coordinates(7, 9);
        TeamCreator team1 = new TeamCreator();
        TeamCreator team2 = new TeamCreator();
        team1.createTeam(10, coor1);
        team2.createTeam(10, coor2);
        team1.getTeamList();
        team2.getTeamList();
        Warrior bob = new Warrior("Bob", coor1);
        bob.findNearestEnemy(team2);
        bob.step(team2);
    }
}
