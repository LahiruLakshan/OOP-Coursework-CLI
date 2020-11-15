public class SchoolFootballClub extends FootballClub {

	private String schoolName;

	public SchoolFootballClub(String schoolName, String nameOfTheClub, String location, int numOfMembers, String matchDate, int numOfPlayedMatches, int won, int drawn, int lost, int numOfGoalsScored, int numOfGoalsReceived, int numOfGoalsDifference, int numOfPoints ) {
		super(nameOfTheClub, location, numOfMembers, matchDate, numOfPlayedMatches, won, drawn, lost, numOfGoalsScored, numOfGoalsReceived, numOfGoalsDifference, numOfPoints);
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
