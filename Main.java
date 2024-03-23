import Characters.Archer;
import Characters.Peasent;
import Characters.Data.Coordinates;
import Characters.Data.TeamCreator;

public class Main {
    public static void main(String[] args) {
        Coordinates coor1 = new Coordinates(0, 0);
        Coordinates coor2 = new Coordinates(0, 9);
        TeamCreator team1 = new TeamCreator();
        TeamCreator team2 = new TeamCreator();
        team1.createTeam(10, coor1);
        team2.createTeam(10, coor2);
        team1.getTeamList();
        team2.getTeamList();
        
    }
}
