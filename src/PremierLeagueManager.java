import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager{

	final static public int MAX_TEAMS = 20;
	public static List<SportsClub> premierLeagueClubsList = new ArrayList<>();
	public List<SportsClub> listOfMatchesTeamA = new ArrayList<>();
	public List<SportsClub> listOfMatchesTeamB = new ArrayList<>();


	@Override
	public void addFootballClubToPremierLeague(SportsClub sportsClub) {
		premierLeagueClubsList.add(sportsClub);
		System.out.println("Data Added");
	}

	@Override
	public void deleteAClub() {
		if (premierLeagueClubsList.size() > 1){
			premierLeagueClubsList.sort(Collections.reverseOrder());
			SportsClub lastTeam = premierLeagueClubsList.get(premierLeagueClubsList.size() -1);

			String bodyFormat = "│ %-25s │ %-15s │ %-6s │ %-3s │ %-5s │ %-4s │ %-4s │ %-4s │ %-4s │ %-6s │%n";
			System.out.format("┌───────────────────────────┬─────────────────┬────────┬─────┬───────┬──────┬──────┬──────┬──────┬────────┐%n");
			System.out.format("│ Relegated Club Name       │ Location        │ Played │ Won │ Drawn │ Lost │ GF   │ GA   │ GD   │ Points │%n");
			System.out.format("┢━──────────────────────────╈─────────────────╈────────╈─────╈───────╈──────╈──────╈──────╈──────╈────────┪%n");
			System.out.format(bodyFormat,lastTeam.getNameOfTheClub(),lastTeam.getLocation(),((FootballClub) lastTeam).getNumOfPlayedMatches(),
					((FootballClub) lastTeam).getWins(),((FootballClub) lastTeam).getDraws(),((FootballClub) lastTeam).getDefeats(),
					((FootballClub) lastTeam).getNumOfGoalsScored(),((FootballClub) lastTeam).getNumOfGoalsReceived(),((FootballClub) lastTeam).getNumOfGoalsDifference(),((FootballClub) lastTeam).getNumOfPoints() );
			System.out.format("┗━──────────────────────────┻─────────────────┻────────┻─────┻───────┻──────┻──────┻──────┻──────┻────────┛%n");

			premierLeagueClubsList.remove(premierLeagueClubsList.size() - 1);
		}else {
			System.out.println("Only one team in the Premier League Championship");
		}
	}

	@Override
	public void displayVariousStatistics() {


	}

	@Override
	public void displayPremierLeagueTable() {

		String bodyFormat = "║ %-8s ║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔══════════╦═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
		System.out.format("║ Position ║ Club Name                 ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
		System.out.format("╠══════════╬═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");						//https://coolsymbol.com/  <- for symbols

		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub sportsClub: premierLeagueClubsList) {

			System.out.format(bodyFormat,premierLeagueClubsList.indexOf(sportsClub) + 1,sportsClub.getNameOfTheClub(),sportsClub.getLocation(),((FootballClub) sportsClub).getNumOfPlayedMatches(),
					((FootballClub) sportsClub).getWins(),((FootballClub) sportsClub).getDraws(),((FootballClub) sportsClub).getDefeats(),
					((FootballClub) sportsClub).getNumOfGoalsScored(),((FootballClub) sportsClub).getNumOfGoalsReceived(),((FootballClub) sportsClub).getNumOfGoalsDifference(),((FootballClub) sportsClub).getNumOfPoints() );
		}
		System.out.format("╚══════════╩═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");
	}


	public void addPlayedMatchDetails(String date, String stadium, String team, int teamGoals, int otherTeamGoals, String teamNum) {
		SportsClub clubUpdate;

		for (SportsClub sportsClub:premierLeagueClubsList){
			if (sportsClub.getNameOfTheClub().contains(team)){
				int match = ((FootballClub) sportsClub).getNumOfPlayedMatches() + 1;
				int won = ((FootballClub) sportsClub).getWins();
				int drawn = ((FootballClub) sportsClub).getDraws();
				int lost = ((FootballClub) sportsClub).getDefeats();
				int goalsScore = ((FootballClub) sportsClub).getNumOfGoalsScored() + teamGoals;
				int goalsReceived = ((FootballClub) sportsClub).getNumOfGoalsReceived() + otherTeamGoals;
				int goalsDifference = goalsScore - goalsReceived;
				int points = ((FootballClub) sportsClub).getNumOfPoints();

				if (teamGoals > otherTeamGoals){
					won += 1;
					points += 3;
				}else if (teamGoals == otherTeamGoals){
					drawn += 1;
					points += 1;
				}else {
					lost += 1;
				}
				clubUpdate = new FootballClub(team,sportsClub.getLocation(),sportsClub.getNumOfMembers(),date,stadium,teamGoals,otherTeamGoals);

				if (teamNum.equals("Team A")){
					listOfMatchesTeamA.add(clubUpdate);
					System.out.println(listOfMatchesTeamA.toString());
				}else {
					listOfMatchesTeamB.add(clubUpdate);
					System.out.println(listOfMatchesTeamB.toString());
				}

				clubUpdate = new FootballClub(team,sportsClub.getLocation(),sportsClub.getNumOfMembers(),date,match,won,drawn,lost,goalsScore,goalsReceived,goalsDifference,points);
				premierLeagueClubsList.set(premierLeagueClubsList.indexOf(sportsClub),clubUpdate);
			}
		}
	}

	@Override
	public void dataSaveToFile(String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(premierLeagueClubsList);
		oos.close();
		fos.close();
	}

	@Override
	public void dataLoadInFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		premierLeagueClubsList = (ArrayList) ois.readObject();
		ois.close();
		fis.close();
	}
}
