import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final LeagueManager leagueManager = new PremierLeagueManager();
	final static Scanner USER_INPUT = new Scanner(System.in);
	private static boolean validationCheck;
	private static String clubName;
	private static String clubLocation;
	private static int clubMembers;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		leagueManager.dataLoadInFile("premierLeagueClubsList.txt");
		System.out.println("******************************************************** Welcome To Premier League Championship Manager ********************************************************");

		boolean loop = true;
		do {
			Scanner input = new Scanner(System.in);
			startMenu();
			String select = input.next();

			switch (select){

				case "1":
					System.out.println("\n------------------------------------------------------ Add a new football Club -----------------------------------------------------");
					addANewFootballClub();
					break;

				case "2":
					System.out.println("\n-------------------------------------------------- Removing a vehicle from the parking lot --------------------------------------------------");
					leagueManager.deleteAClub();
					break;

				case "3":
					System.out.println("\n-------------------------------------------------- Display the various statistics for a selected club --------------------------------------------------");
//					selectedClubDetails();
					break;

				case "4":
					System.out.println("\n-------------------------------------------------- Premier League Table --------------------------------------------------");
					leagueManager.displayPremierLeagueTable();
					break;

				case "5":
					System.out.println("\n-------------------------------------------------- Played match details --------------------------------------------------");
					matchDetails();
					break;

				case "6":
					leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
					System.out.println("\n************************************************************* End the Programme *************************************************************");
					loop = false;
					break;

				default:
					System.out.println("Invalid Input");
				//	decision();
			}

		}while (loop);
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
				validationCheck = false;
				break;
			} else if (endDecision.equalsIgnoreCase("c")) {
				validationCheck = true;
				break;
			} else {
				System.out.println("I can't understand your choose");
			}
		}
	}


	private static void addANewFootballClub() {

		if (PremierLeagueManager.premierLeagueClubsList.size() < 20){
			inputClubName();
			inputClubLocation();
			inputClubMembers();
			SportsClub footballClub = new FootballClub(clubName,clubLocation,clubMembers);
			leagueManager.addFootballClubToPremierLeague(footballClub);
		}else {
			System.out.println("Can't create a club for the Premier League! \nThe 20 teams that must participate in the Premier League are complete.");
		}

//		SportsClub sportsClub1 = new FootballClub("Leicester City", "London", 32);
//		SportsClub sportsClub2 = new FootballClub("Chelsea", "America", 23);
//		SportsClub sportsClub3 = new FootballClub("Everton", "Mexico", 30);
//		SportsClub sportsClub4 = new FootballClub("Manchester United", "Africa", 33);
//		SportsClub sportsClub5 = new FootballClub("Aston Villa", "Russia", 31);
//		SportsClub sportsClub6 = new FootballClub("Fulham", "France", 32);
//		leagueManager.addFootballClubToPremierLeague(sportsClub1);
//		leagueManager.addFootballClubToPremierLeague(sportsClub2);
//		leagueManager.addFootballClubToPremierLeague(sportsClub3);
//		leagueManager.addFootballClubToPremierLeague(sportsClub4);
//		leagueManager.addFootballClubToPremierLeague(sportsClub5);
//		leagueManager.addFootballClubToPremierLeague(sportsClub6);
	}

	private static void inputClubName() {
		boolean duplicate = true;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("1. Enter the name of the club          : ");
			clubName = input.nextLine();
			validationCheck = stringsChecker(clubName);
			for (SportsClub club:PremierLeagueManager.premierLeagueClubsList){
				if (club.getNameOfTheClub().equalsIgnoreCase(clubName)){
					System.out.println("This Club name is Already Register in League!");
					duplicate = false;
					break;
				}else{
					duplicate = true;
				}
			}
			validationCheck = duplicate && validationCheck;
		}while (!validationCheck);
	}

	private static void inputClubLocation() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("2. Enter the name of the club location : ");
			clubLocation = input.nextLine();
			validationCheck = stringsChecker(clubLocation);
		}while (!validationCheck);
	}

	private static void inputClubMembers() {
		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.print("3. Enter the Number of team members    : ");
				clubMembers = input.nextInt();
				validationCheck = (clubMembers >= 11);
				System.out.println(validationCheck ? "": "Each group must have 11 or more members!");
			}catch (RuntimeException e){
				System.out.println("Please enter integer input!");
				validationCheck = false;
			}
		}while (!validationCheck);
	}


	private static void matchDetails(){
		
		inputMatchDate();
		inputClubName("First Team");
		inputScore("First Team");
		inputClubName("Second Team");
		inputScore("Second Team");

//		leagueManager.addPlayedMatchDetails("12/12/2019"," Emirates Stadium, London","Manchester United",12,6, "Team A");
//		leagueManager.addPlayedMatchDetails("12/12/2019"," Emirates Stadium, London","Everton",6,12, "Team B");
//
//		leagueManager.addPlayedMatchDetails("28/11/2019"," Emirates Stadium, London","Chelsea",8,10, "Team A");
//		leagueManager.addPlayedMatchDetails("28/11/2019"," Emirates Stadium, London","Manchester United",10,8,"Team B");
//
//		leagueManager.addPlayedMatchDetails("01/10/2019"," Emirates Stadium, London","Manchester United",8,8, "Team A");
//		leagueManager.addPlayedMatchDetails("01/10/2019"," Emirates Stadium, London","Chelsea",8,8, "Team B");
//
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Chelsea",8,5, "Team A");
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Leicester City",5,8, "Team B");
//
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Aston Villa",14,6, "Team A");
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Leicester City",6,14, "Team B");
//
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Aston Villa",3,3, "Team A");
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",3,3, "Team B");
//
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Fulham",10,3, "Team A");
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",3,10, "Team B");
//
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Fulham",10,10, "Team A");
//		leagueManager.addPlayedMatchDetails("17/09/2019"," Emirates Stadium, London","Manchester United",10,10, "Team B");
	}

	private static void inputMatchDate() {    //https://stackoverflow.com/questions/15491894/regex-to-validate-date-format-dd-mm-yyyy
//		if (((entryDate != null) && (!entryDate.equals("")) && (entryDate.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")))){
//			dateConvertToInteger(realDate,entryDate);
//			if (stopYear < exitYear || stopYear == exitYear && stopMonth < exitMonth || stopYear == exitYear && stopMonth == exitMonth && stopDay <= exitDay){
//				realDate = entryDate;
//				return true;
//			}else {
//				System.out.println("Date Error!");
//				return false;
//			}
//		}else {
//			System.out.println("Please enter valid time!");
//			return false;
//		}
	}


	private static void inputClubName(String team) {
	}
	private static void inputScore(String teamScore) {
	}


	public static boolean stringsChecker(String value) {    //string checker

		if (!(value == null || value.trim().isEmpty())){		//https://www.programiz.com/java-programming/examples/string-empty-null
			if (value.matches("^[ A-Za-z]+$")){		//https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only/24191088
				return true;
			}else {
			System.out.println("Please enter a valid input!(Only Strings)");
				return false;
			}
		}else {
				System.out.println("Please enter an input!");
				return false;
		}
	}
}
