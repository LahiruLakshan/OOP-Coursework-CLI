public class FootballClub extends SportsClub implements Comparable<FootballClub> {

	private String matchDate = "Not played yet";
	private String matchVenue;
	private int won;
	private int drawn;
	private int lost;
	private int numOfGoalsScored;
	private int numOfGoalsReceived;
	private int numOfGoalsDifference;
	private int numOfPoints;
	private int numOfPlayedMatches;


	public FootballClub(String nameOfTheClub, String location, int numOfMembers) {		//create a club
		super(nameOfTheClub, location, numOfMembers);
	}
	//for premier league table
	public FootballClub(String nameOfTheClub, String location, int numOfMembers, String matchDate, int numOfPlayedMatches, int won, int drawn, int lost, int numOfGoalsScored, int numOfGoalsReceived, int numOfGoalsDifference, int numOfPoints) {
		super(nameOfTheClub, location, numOfMembers);
		this.matchDate = matchDate;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
		this.numOfGoalsScored = numOfGoalsScored;
		this.numOfGoalsReceived = numOfGoalsReceived;
		this.numOfGoalsDifference = numOfGoalsDifference;
		this.numOfPoints = numOfPoints;
		this.numOfPlayedMatches = numOfPlayedMatches;
	}

	public FootballClub(String nameOfTheClub, String location, int numOfMembers, String matchDate, String matchVenue, int numOfGoalsScored, int numOfGoalsReceived) {
		super(nameOfTheClub, location, numOfMembers);
		this.matchDate = matchDate;
		this.matchVenue = matchVenue;
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

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
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

	public int getNumOfPlayedMatches() {
		return numOfPlayedMatches;
	}

	public void setNumOfPlayedMatches(int numOfPlayedMatches) {
		this.numOfPlayedMatches = numOfPlayedMatches;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchVenue() {
		return matchVenue;
	}

	public void setMatchVenue(String matchVenue) {
		this.matchVenue = matchVenue;
	}


	@Override
	public String toString() {
		return "FootballClub{" +
				"lastDayOfPlaying='" + matchDate + '\'' +
				", groundName='" + matchVenue + '\'' +
				", numOfGoalsScored=" + numOfGoalsScored +
				", numOfGoalsReceived=" + numOfGoalsReceived +
				'}';
	}

	@Override
	public int compareTo(FootballClub fbc) {
		if (getNumOfPoints() > fbc.getNumOfPoints()){
			return 1;
		}else if (getNumOfPoints() == fbc.getNumOfPoints()){
			return Integer.compare(getNumOfGoalsDifference(), fbc.getNumOfGoalsDifference());
		}else {
			return -1;
		}

	}
}
