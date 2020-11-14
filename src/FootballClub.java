import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub> {

	private String lastDayOfPlaying = "Not played yet";
	private String groundName;
	private int wins;
	private int draws;
	private int defeats;
	private int numOfGoalsScored;
	private int numOfGoalsReceived;
	private int numOfGoalsDifference;
	private int numOfPoints;
	private int numOfPlayedMatches;


	public FootballClub(String nameOfTheClub, String location, int numOfMembers) {		//create a club
		super(nameOfTheClub, location, numOfMembers);
	}
	//for premier league table
	public FootballClub(String nameOfTheClub, String location, int numOfMembers, String lastDayOfPlaying, int numOfPlayedMatches, int wins , int draws, int defeats, int numOfGoalsScored, int numOfGoalsReceived, int numOfGoalsDifference, int numOfPoints) {
		super(nameOfTheClub, location, numOfMembers);
		this.lastDayOfPlaying = lastDayOfPlaying;
		this.wins = wins;
		this.draws = draws;
		this.defeats = defeats;
		this.numOfGoalsScored = numOfGoalsScored;
		this.numOfGoalsReceived = numOfGoalsReceived;
		this.numOfGoalsDifference = numOfGoalsDifference;
		this.numOfPoints = numOfPoints;
		this.numOfPlayedMatches = numOfPlayedMatches;
	}

	public FootballClub(String nameOfTheClub, String location, int numOfMembers, String lastDayOfPlaying, String groundName, int numOfGoalsScored, int numOfGoalsReceived) {
		super(nameOfTheClub, location, numOfMembers);
		this.lastDayOfPlaying = lastDayOfPlaying;
		this.groundName = groundName;
		this.numOfGoalsScored = numOfGoalsScored;
		this.numOfGoalsReceived = numOfGoalsReceived;
	}
//	public FootballClub(String firstTeam, String location, int wins, int draws, int defeats, int i, int points, int i1, String date) {
	//		super(firstTeam,location);
	//		this.lastDayOfPlaying = lastDayOfPlaying;
	//		this.wins = wins;
	//		this.draws = draws;
	//		this.defeats = defeats;
	//		this.numOfScored = i;
	//		this.numOfPoints = points;
	//		this.numOfPlayedMatches = i1;
	//	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getDefeats() {
		return defeats;
	}

	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}

	public int getNumOfGoalsScored() {
		return numOfGoalsScored;
	}

	public void setNumOfGoalsScored(int numOfGoalsScored) {
		this.numOfGoalsScored = numOfGoalsScored;
	}

	public int getNumOfGoalsReceived() {
		return numOfGoalsReceived;
	}

	public void setNumOfGoalsReceived(int numOfGoalsReceived) {
		this.numOfGoalsReceived = numOfGoalsReceived;
	}

	public int getNumOfPlayedMatches() {
		return numOfPlayedMatches;
	}

	public void setNumOfPlayedMatches(int numOfPlayedMatches) {
		this.numOfPlayedMatches = numOfPlayedMatches;
	}

	public String getLastDayOfPlaying() {
		return lastDayOfPlaying;
	}

	public void setLastDayOfPlaying(String lastDayOfPlaying) {
		this.lastDayOfPlaying = lastDayOfPlaying;
	}

	public int getNumOfGoalsDifference() {
		return numOfGoalsDifference;
	}

	public void setNumOfGoalsDifference(int numOfGoalsDifference) {
		this.numOfGoalsDifference = numOfGoalsDifference;
	}

	public int getNumOfPoints() {
		return numOfPoints;
	}

	public void setNumOfPoints(int numOfPoints) {
		this.numOfPoints = numOfPoints;
	}

	public String getGroundName() {
		return groundName;
	}

	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}


	@Override
	public String toString() {
		return "FootballClub{" +
				"lastDayOfPlaying='" + lastDayOfPlaying + '\'' +
				", groundName='" + groundName + '\'' +
				", numOfGoalsScored=" + numOfGoalsScored +
				", numOfGoalsReceived=" + numOfGoalsReceived +
				'}';
	}

	@Override
	public int compareTo(FootballClub fbc) {
		if (getNumOfPoints() > fbc.getNumOfPoints()){
			return 1;
		}else if (getNumOfPoints() == fbc.getNumOfPoints()){
			if (getNumOfGoalsDifference() > fbc.getNumOfGoalsDifference()){
				return 1;
			}else if (getNumOfGoalsDifference() == fbc.getNumOfGoalsDifference()){
				return 0;
			}else {
				return -1;
			}
		}else {
			return -1;
		}

	}
}
