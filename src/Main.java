import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final LeagueManager leagueManager = new PremierLeagueManager();
	final static Scanner USER_INPUT = new Scanner(System.in);
	private static boolean checkerResult;
	private static String clubName;
	private static String clubLocation;
	private static int clubMembers;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		leagueManager.dataLoadInFile("premierLeagueClubsList.txt");
		System.out.println("******************************************************** Welcome To Premier League Championship Manager ********************************************************");

		do {
			Scanner input = new Scanner(System.in);
			startMenu();
			String select = input.next();

			switch (select){

				case "1":
					System.out.println("\n------------------------------------------------------ Add a new football Club -----------------------------------------------------");
					addANewFootballClub();
					checkerResult = true;
				//	decision();
					break;

				case "2":
					System.out.println("\n-------------------------------------------------- Removing a vehicle from the parking lot --------------------------------------------------");
					leagueManager.deleteAClub();
					checkerResult = true;
			//		decision();
					break;

				case "3":
					System.out.println("\n-------------------------------------------------- Display the various statistics for a selected club --------------------------------------------------");
//					selectedClubDetails();
					checkerResult = true;
			//		decision();
					break;

				case "4":
					System.out.println("\n-------------------------------------------------- Premier League Table --------------------------------------------------");
					leagueManager.displayPremierLeagueTable();
					checkerResult = true;
				//	decision();
					break;

				case "5":
					System.out.println("\n-------------------------------------------------- Played match details --------------------------------------------------");
					matchDetails();
					checkerResult = true;
				//	decision();
					break;

				case "6":
					leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
					System.out.println("\n************************************************************* End the Programme *************************************************************");
					checkerResult = false;
					break;

				default:
					System.out.println("Invalid Input");
				//	decision();
			}

		}while (checkerResult);
	}




	private static void startMenu() {

		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: Menu Options ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("\t\t1. Create a new football club and add it in the premier league. ");
		System.out.println("\t\t2. Delete (relegate) an existing club from the premier league.");
		System.out.println("\t\t3. Display the various statistics for a selected club.");
		System.out.println("\t\t4. Display the Premier League Table.");
		System.out.println("\t\t5. Add a played match.");
		System.out.println("\t\t6. Exit the Programme.");
		System.out.print("Select the number you want(1 to 7) : ");

	}

	private static void decision() {
		Scanner inputStr = new Scanner(System.in);
		while (true) {
			System.out.print("\n\tE - Exit the Programme\n\tC - Continue the programme\nChoose the decision you want : ");
			String endDecision = inputStr.next();

			if (endDecision.equalsIgnoreCase("e")) {
				System.out.println("\n******************************************************** End the Programme ********************************************************");
				checkerResult = false;
				break;
			} else if (endDecision.equalsIgnoreCase("c")) {
				checkerResult = true;
				break;
			} else {
				System.out.println("I can't understand your choose");
			}
		}
	}


	private static void addANewFootballClub() {
		
		inputClubName();
		inputClubLocation();
		inputClubMembers();

		SportsClub sportsClub1 = new FootballClub("Leicester City", "London", 32);
		SportsClub sportsClub2 = new FootballClub("Chelsea", "America", 23);
		SportsClub sportsClub3 = new FootballClub("Everton", "Mexico", 30);
		SportsClub sportsClub4 = new FootballClub("Manchester United", "Africa", 33);
		SportsClub sportsClub5 = new FootballClub("Aston Villa", "Russia", 31);
		SportsClub sportsClub6 = new FootballClub("Fulham", "France", 32);
		leagueManager.addFootballClubToPremierLeague(sportsClub1);
		leagueManager.addFootballClubToPremierLeague(sportsClub2);
		leagueManager.addFootballClubToPremierLeague(sportsClub3);
		leagueManager.addFootballClubToPremierLeague(sportsClub4);
		leagueManager.addFootballClubToPremierLeague(sportsClub5);
		leagueManager.addFootballClubToPremierLeague(sportsClub6);
	}

	private static void inputClubName() {
		boolean duplicate;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("1. Enter the name of the club          : ");
			clubName = input.nextLine();
			checkerResult = stringsChecker(clubName);
			for (SportsClub club:PremierLeagueManager.premierLeagueClubsList){
				checkerResult = !club.getNameOfTheClub().equals(clubName);
				System.out.println(checkerResult ? "": "Each group must have 11 or more members!");
			}
		}while (!checkerResult);
	}

	private static void inputClubLocation() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("2. Enter the name of the club location : ");
			clubLocation = input.nextLine();
			checkerResult = stringsChecker(clubLocation);
		}while (!checkerResult);
	}

	private static void inputClubMembers() {
		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.print("3. Number of team members : ");
				clubMembers = input.nextInt();
				checkerResult = (clubMembers >= 11);
				System.out.println(checkerResult ? "": "Each group must have 11 or more members!");
			}catch (RuntimeException e){
				System.out.println("Please enter integer input!");
				checkerResult = false;
			}
		}while (!checkerResult);
	}


	private static void matchDetails(){

		leagueManager.addPlayedMatchDetails("12/12/2019"," Emirates Stadium, London","Manchester United",12,6, "Team A");
		leagueManager.addPlayedMatchDetails("12/12/2019"," Emirates Stadium, London","Everton",6,12, "Team B");

		leagueManager.addPlayedMatchDetails("28/11/2019"," Emirates Stadium, London","Chelsea",8,10, "Team A");
		leagueManager.addPlayedMatchDetails("28/11/2019"," Emirates Stadium, London","Manchester United",10,8,"Team B");

		leagueManager.addPlayedMatchDetails("01/10/2019"," Emirates Stadium, London","Manchester United",8,8, "Team A");
		leagueManager.addPlayedMatchDetails("01/10/2019"," Emirates Stadium, London","Chelsea",8,8, "Team B");

		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Chelsea",8,5, "Team A");
		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Leicester City",5,8, "Team B");

		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Aston Villa",14,6, "Team A");
		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Leicester City",6,14, "Team B");

		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Aston Villa",3,3, "Team A");
		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",3,3, "Team B");

		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Fulham",10,3, "Team A");
		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",3,10, "Team B");

		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Fulham",10,10, "Team A");
		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",10,10, "Team B");
	}

	public static boolean stringsChecker(String value) {    //string checker

		if (!(value == null || value.trim().isEmpty())){		//https://www.programiz.com/java-programming/examples/string-empty-null
			if (value.matches("^[ A-Za-z]+$")){		//https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only/24191088
				return true;
			}else {
			System.out.println("Please enter a valid input!(Don't enter Integers)");
				return false;
			}
		}else {
				System.out.println("Please enter an input!");
				return false;
		}
	}
}
