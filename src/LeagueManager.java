import java.io.IOException;

public interface LeagueManager {
	void addFootballClubToPremierLeague(SportsClub sportsClub);
	void deleteAClub();
	void displayVariousStatistics();
	void displayPremierLeagueTable();
	void addPlayedMatchDetails(String date,String stadium, String team, int teamGoals, int otherTeamGoals, String teamNum);
	void dataSaveToFile(String fileName) throws IOException;
	void dataLoadInFile(String fileName) throws IOException, ClassNotFoundException;
}
