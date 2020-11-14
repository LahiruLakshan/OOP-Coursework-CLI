public class UniversityFootballClub extends FootballClub {

	private String universityName;

	public UniversityFootballClub(String universityName, String nameOfTheClub, String location, int numOfMembers, String lastDayOfPlaying , int numOfPlayedMatches, int wins, int draws, int defeats, int numOfGoalsScored, int numOfGoalsReceived, int numOfGoalsDifference, int numOfPoints) {
		super(nameOfTheClub, location, numOfMembers, lastDayOfPlaying, numOfPlayedMatches, wins, draws, defeats, numOfGoalsScored,numOfGoalsReceived, numOfGoalsDifference, numOfPoints);
		this.universityName = universityName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}
