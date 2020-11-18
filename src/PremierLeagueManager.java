import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager{

	public static List<SportsClub> premierLeagueClubsList = new ArrayList<>();
	public List<SportsClub> listOfMatchesTeamA = new ArrayList<>();
	public List<SportsClub> listOfMatchesTeamB = new ArrayList<>();


	@Override
	public void addFootballClubToPremierLeague(SportsClub footballClub) {
		if (premierLeagueClubsList.size() < 20){
			premierLeagueClubsList.add(footballClub);
			System.out.println("✔ Data added successfully!");
			System.out.println("Number of registered clubs			   : " + premierLeagueClubsList.size());
			System.out.println("Remaining space for clubs registration : " + (20 - premierLeagueClubsList.size()));
		}else {
			System.out.println("Can't create a club for the Premier League!");
		}
	}

	@Override
	public void deleteAClub() {
		if (premierLeagueClubsList.size() > 1){
			premierLeagueClubsList.sort(Collections.reverseOrder());
			SportsClub lastTeam = premierLeagueClubsList.get(premierLeagueClubsList.size() -1);

			String tableFormat = "║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
			System.out.format("╔═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
			System.out.format("║ Relegated Club Name       ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
			System.out.format("╠═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");
			System.out.format(tableFormat,lastTeam.getNameOfTheClub(),lastTeam.getLocation(),((FootballClub) lastTeam).getNumOfPlayedMatches(),
					((FootballClub) lastTeam).getWon(),((FootballClub) lastTeam).getDrawn(),((FootballClub) lastTeam).getLost(),
					((FootballClub) lastTeam).getNumOfGoalsScored(),((FootballClub) lastTeam).getNumOfGoalsReceived(),((FootballClub) lastTeam).getNumOfGoalsDifference(),((FootballClub) lastTeam).getNumOfPoints() );
			System.out.format("╚═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");

			premierLeagueClubsList.remove(premierLeagueClubsList.size() - 1);
			System.out.println("\nNumber of registered clubs			   : " + premierLeagueClubsList.size());
			System.out.println("Remaining space for clubs registration : " + (20 - premierLeagueClubsList.size()));
		}else {
			System.out.println("Only one team in the Premier League Championship");
		}
	}

	@Override
	public void displayVariousStatistics(String clubName) {
		System.out.println("----------------------------------------------- " + clubName + " Club Details -----------------------------------------------\n");
		String tableFormat = "║ %-8s ║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔══════════╦═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
		System.out.format("║ Position ║ Club Name                 ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
		System.out.format("╠══════════╬═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");						//https://coolsymbol.com/  <- for symbols

		boolean check = false;
		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub sportsClub: premierLeagueClubsList) {
			if (sportsClub.getNameOfTheClub().equalsIgnoreCase(clubName)){
				String GF = ((FootballClub) sportsClub).getNumOfGoalsDifference() > 0 ? "+"+((FootballClub) sportsClub).getNumOfGoalsDifference(): String.valueOf(((FootballClub) sportsClub).getNumOfGoalsDifference());
				check = ((FootballClub) sportsClub).getNumOfPlayedMatches() > 0;
				System.out.format(tableFormat, premierLeagueClubsList.indexOf(sportsClub) + 1, sportsClub.getNameOfTheClub(), sportsClub.getLocation(), ((FootballClub) sportsClub).getNumOfPlayedMatches(),
						((FootballClub) sportsClub).getWon(), ((FootballClub) sportsClub).getDrawn(), ((FootballClub) sportsClub).getLost(),
						((FootballClub) sportsClub).getNumOfGoalsScored(), ((FootballClub) sportsClub).getNumOfGoalsReceived(), GF, ((FootballClub) sportsClub).getNumOfPoints());
			}
		}
		System.out.format("╚══════════╩═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");
		int count = 0;
		int teamAResult;
		int teamBResult;
		String teamAMatchEnd;
		String teamBMatchEnd;
		if (check){
			System.out.println("----------------------------------------------- Matches played by "+clubName+" Club -----------------------------------------------\n");
			String matchFormat = "║   %-6s ║ %-10s ║ %-24s ║ %-25s ║ %-7s ║ %-25s ║%n";
			System.out.format("╔══════════╦════════════╦═══════════════════════════╦═══════════════════════════╦═════════╦═══════════════════════════╗%n");
			System.out.format("║ Match No ║ Date       ║ Stadium                   ║ Team Name                 ║ Result  ║ Team Name                 ║%n");
			System.out.format("╠══════════╬════════════╬═══════════════════════════╬═══════════════════════════╬═════════╬═══════════════════════════╣%n");						//https://coolsymbol.com/  <- for symbols
			for (SportsClub teamA : listOfMatchesTeamA) {
				SportsClub teamB = listOfMatchesTeamB.get(listOfMatchesTeamA.indexOf(teamA));
				if (teamA.getNameOfTheClub().equalsIgnoreCase(clubName)) {
					count++;
					teamAResult = ((FootballClub) teamA).getNumOfGoalsScored();
					teamBResult = ((FootballClub) teamB).getNumOfGoalsScored();
					if (teamAResult > teamBResult) {
						teamAMatchEnd = " (WON)";
						teamBMatchEnd = " (LOST)";
					} else if (teamAResult == teamBResult) {
						teamAMatchEnd = " (DRAWN)";
						teamBMatchEnd = " (DRAWN)";
					} else {
						teamBMatchEnd = " (WON)";
						teamAMatchEnd = " (LOST)";
					}

					System.out.format(matchFormat, count, ((FootballClub) teamA).getMatchDate(), ((FootballClub) teamA).getMatchVenue(), clubName + teamAMatchEnd, String.format("%02d", teamAResult) + " : " + String.format("%02d", teamBResult), teamB.getNameOfTheClub() + teamBMatchEnd);
				}
			}
			for (SportsClub teamA : listOfMatchesTeamB) {
				SportsClub teamB = listOfMatchesTeamA.get(listOfMatchesTeamB.indexOf(teamA));
				if (teamA.getNameOfTheClub().equalsIgnoreCase(clubName)) {
					count++;
					teamAResult = ((FootballClub) teamA).getNumOfGoalsScored();
					teamBResult = ((FootballClub) teamB).getNumOfGoalsScored();
					if (teamAResult > teamBResult) {
						teamAMatchEnd = " (WON)";
						teamBMatchEnd = " (LOST)";
					} else if (teamAResult == teamBResult) {
						teamAMatchEnd = " (DRAWN)";
						teamBMatchEnd = " (DRAWN)";
					} else {
						teamBMatchEnd = " (WON)";
						teamAMatchEnd = " (LOST)";
					}
					System.out.format(matchFormat, count, ((FootballClub) teamA).getMatchDate(), ((FootballClub) teamA).getMatchVenue(), clubName + teamAMatchEnd, String.format("%02d", teamAResult) + " : " + String.format("%02d", teamBResult), teamB.getNameOfTheClub() + teamBMatchEnd);
				}
			}
			System.out.format("╚══════════╩════════════╩═══════════════════════════╩═══════════════════════════╩═════════╩═══════════════════════════╝%n");
		}
	}

	@Override
	public void displayPremierLeagueTable() {

		String tableFormat = "║ %-8s ║ %-15s ║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔══════════╦═════════════════╦═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗ GF = \"Goals For\"%n");
		System.out.format("║ Position ║ Last Played Day ║ Club Name                 ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║ GA = \"Goals Against\"%n");
		System.out.format("╠══════════╬═════════════════╬═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣ GD = \"Goals Difference\"%n");						//https://coolsymbol.com/  <- for symbols

		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub sportsClub: premierLeagueClubsList) {
			String GF = ((FootballClub) sportsClub).getNumOfGoalsDifference() > 0 ? "+"+((FootballClub) sportsClub).getNumOfGoalsDifference(): String.valueOf(((FootballClub) sportsClub).getNumOfGoalsDifference());
			System.out.format(tableFormat,premierLeagueClubsList.indexOf(sportsClub) + 1,((FootballClub) sportsClub).getMatchDate(),sportsClub.getNameOfTheClub(),sportsClub.getLocation(),
					((FootballClub) sportsClub).getNumOfPlayedMatches(),((FootballClub) sportsClub).getWon(),((FootballClub) sportsClub).getDrawn(),((FootballClub) sportsClub).getLost(),
					((FootballClub) sportsClub).getNumOfGoalsScored(),((FootballClub) sportsClub).getNumOfGoalsReceived(),GF,((FootballClub) sportsClub).getNumOfPoints() );
		}
		System.out.format("╚══════════╩═════════════════╩═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");
	}


	public void addPlayedMatchDetails(String date, String stadium, String team, int teamGoals, int otherTeamGoals, String teamNum) {
		SportsClub clubUpdate;

		for (SportsClub sportsClub:premierLeagueClubsList){
			if (sportsClub.getNameOfTheClub().contains(team)){
				int match = ((FootballClub) sportsClub).getNumOfPlayedMatches() + 1;
				int won = ((FootballClub) sportsClub).getWon();
				int drawn = ((FootballClub) sportsClub).getDrawn();
				int lost = ((FootballClub) sportsClub).getLost();
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
				clubUpdate = new FootballClub(date,team,sportsClub.getLocation(),sportsClub.getNumOfMembers(),stadium,teamGoals,otherTeamGoals);

				if (teamNum.equalsIgnoreCase("Team A")){
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
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream outputStream = new ObjectOutputStream(file);
		outputStream.writeObject(premierLeagueClubsList);
		outputStream.writeObject(listOfMatchesTeamA);
		outputStream.writeObject(listOfMatchesTeamB);
		outputStream.flush();
		outputStream.close();
		file.close();
		System.out.println("Data saving is successful!");
	}

	@Override
	public void dataLoadInFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		premierLeagueClubsList = (ArrayList) ois.readObject();
		listOfMatchesTeamA = (ArrayList) ois.readObject();
		listOfMatchesTeamB = (ArrayList) ois.readObject();
		System.out.println("Data loaded successful!");
		ois.close();
		fis.close();
	}
}
