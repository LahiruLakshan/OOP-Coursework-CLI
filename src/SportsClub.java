import java.io.Serializable;

public class SportsClub implements Serializable {

	private String nameOfTheClub;
	private String location;
	private int numOfMembers;

	public SportsClub(String nameOfTheClub, String location, int numOfMembers) {
		this.nameOfTheClub = nameOfTheClub;
		this.location = location;
		this.numOfMembers = numOfMembers;
	}

	public String getNameOfTheClub() {
		return nameOfTheClub;
	}

	public void setNameOfTheClub(String nameOfTheClub) {
		this.nameOfTheClub = nameOfTheClub;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}
}
