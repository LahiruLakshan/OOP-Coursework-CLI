public class SchoolFootballClub extends FootballClub {

	private String schoolName;

	public SchoolFootballClub(String schoolName, String nameOfTheClub, String location, int numOfMembers, String lastDayOfPlaying, int numOfPlayedMatches, int wins, int draws, int defeats, int numOfGoalsScored, int numOfGoalsReceived, int numOfGoalsDifference, int numOfPoints ) {
		super(nameOfTheClub, location, numOfMembers, lastDayOfPlaying, numOfPlayedMatches, wins, draws, defeats, numOfGoalsScored, numOfGoalsReceived, numOfGoalsDifference, numOfPoints);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
