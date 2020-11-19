import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PremierLeagueGUIFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private final TableView<SportsClub> table = new TableView<SportsClub>();
	private final ObservableList<SportsClub> data = FXCollections.observableArrayList(PremierLeagueManager.premierLeagueClubsList);

	@Override
	public void start(Stage stage) throws Exception {
		mainWindow();
	}

	private void mainWindow(){
		Stage primaryStage = new Stage();

		// Main window elements( Button
		Button btnMortgage = new javafx.scene.control.Button("Premier League Table");        // Open button on mortgage Calculator.
		btnMortgage.setLayoutX(125);
		btnMortgage.setLayoutY(120);
		btnMortgage.setPrefWidth(250);
		btnMortgage.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

		Button btnFinance = new javafx.scene.control.Button("All Matches Table");      // Open button on Finance Calculator.
		btnFinance.setLayoutX(125);
		btnFinance.setLayoutY(200);
		btnFinance.setPrefWidth(250);
		btnFinance.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

		Button btnCloseWin = new Button("Exit");
		btnCloseWin.setLayoutX(300);
		btnCloseWin.setLayoutY(400);
		btnCloseWin.setPrefWidth(100);
		btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
		btnCloseWin.setOnAction(event -> primaryStage.close());

		AnchorPane mainLayout = new AnchorPane();
		mainLayout.setStyle("-fx-background-color: #e2cc37;");
		mainLayout.getChildren().addAll(btnMortgage, btnFinance,btnCloseWin);      // 3 buttons add to main window layout
		Scene mainScene = new Scene(mainLayout,500,500);

		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Premier League 2020");
		primaryStage.show();

		btnMortgage.setOnAction(event -> {      // Open action on mortgage Calculator.
			primaryStage.close();
			premierLeagueTable();

		});
		btnFinance.setOnAction(event -> {       // Open action on Finance Calculator.
			primaryStage.close();
			matchTable();

		});
	}

	private void premierLeagueTable() {

		Stage stage = new Stage();

		stage.setTitle("Premier League Ranked Table");
		stage.setWidth(1290);
		stage.setHeight(750);


		final Label label = new Label("Ranking Table 2020");
		Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30);
		label.setFont(font);


		table.setEditable(true);
		TableColumn position = new TableColumn("Position");
		position.setMinWidth(100);
		position.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("position"));

		TableColumn clubName = new TableColumn("Name Of the Club");
		clubName.setMinWidth(150);
		clubName.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("nameOfTheClub"));

		TableColumn location = new TableColumn("Location");
		location.setMinWidth(200);
		location.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("location"));

		TableColumn playMatch = new TableColumn("Played");
		playMatch.setMinWidth(100);
		playMatch.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("numOfPlayedMatches"));

		TableColumn won = new TableColumn("Won");
		won.setMinWidth(100);
		won.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("won"));

		TableColumn drawn = new TableColumn("Drawn");
		drawn.setMinWidth(100);
		drawn.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("drawn"));

		TableColumn lost = new TableColumn("Lost");
		lost.setMinWidth(100);
		lost.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("lost"));

		TableColumn goalsScore = new TableColumn("GF");
		goalsScore.setMinWidth(100);
		goalsScore.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("numOfGoalsDifference"));

		TableColumn goalsAgainst = new TableColumn("GA");
		goalsAgainst.setMinWidth(100);
		goalsAgainst.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("numOfGoalsReceived"));

		TableColumn goalsDifference = new TableColumn("GD");
		goalsDifference.setMinWidth(100);
		goalsDifference.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("numOfGoalsDifference"));

		TableColumn points = new TableColumn("Points");
		points.setMinWidth(100);
		points.setCellValueFactory(new PropertyValueFactory<SportsClub, Integer>("numOfPoints"));



		//Pass the data to a filtered list
		//FilteredList<SportsClub> club = new FilteredList(data, p -> true);
		//Set the table's items using the filtered list
		table.setItems(data);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		table.getColumns().addAll(position, clubName,location,playMatch,won,drawn,lost,goalsScore,goalsAgainst,goalsDifference,points);
		//Adding ChoiceBox and TextField here!
		ChoiceBox<String> choiceBox = new ChoiceBox();
		choiceBox.setStyle("-fx-font-size: 17;"+"-fx-font-family: Arial;"+"-fx-font-weight: bold;");
		choiceBox.getItems().addAll("Member ID", "Name", "Register Date");
		choiceBox.setValue("Member ID");

		Button btnBack = new Button("Back");
		btnBack.setFont(Font.font("Arial", FontWeight.BOLD, 17));
		btnBack.setLayoutX(900);
		btnBack.setLayoutY(400);
		btnBack.setPrefWidth(100);
		//btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
		btnBack.setOnAction(event -> {
			stage.close();
			PremierLeagueGUIFX premierLeagueGUIFX = new PremierLeagueGUIFX();
			premierLeagueGUIFX.mainWindow();
		});

//		Button sortBTN = new Button("Sort");
//		sortBTN.setFont(Font.font("Arial", FontWeight.BOLD, 17));
//		sortBTN.setLayoutX(900);
//		sortBTN.setLayoutY(400);
//		sortBTN.setPrefWidth(100);
//		//btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
//		sortBTN.setOnAction(event -> {
//			goalsScore.setSortable(true);
//			goalsScore.setSortType(TableColumn.SortType.DESCENDING);
//		});

//		TextField textField = new TextField();
//		textField.setPromptText("Search here!");
//		textField.setOnKeyReleased(keyEvent ->
//		{
//			switch (choiceBox.getValue())//Switch on choiceBox value
//			{
//				case "Member ID":
//					club.setPredicate(search -> search.getNameOfTheClub().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by Member Id
//					break;
//				case "Name":
//					//member.setPredicate(search -> search.getName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by Name
//					break;
//				case "Register Date":
//					//member.setPredicate(search -> search.getStartMembershipDate().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by Register Date
//					break;
//			}
//		});
//
//		choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
//		{//reset table and textfield when new choice is selected
//			if (newVal != null) {
//				textField.setText("");
//				club.setPredicate(null);//This is same as saying member.setPredicate(p->true);
//			}
//		});
		table.setMaxSize(1250,1000);
		HBox hBox = new HBox(50);//Add choiceBox and textField to hBox
		hBox.getChildren().addAll(btnBack,choiceBox);
		hBox.setAlignment(Pos.CENTER);//Center HBox
		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #29a233;");
		vbox.setMaxSize(500,1500);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, hBox);
		Scene scene = new Scene(vbox, 900, 500);
		//((Group) scene.getRoot()).getChildren().addAll(vbox,btnBack);

		stage.setScene(scene);
		stage.show();
	}

	private void matchTable() {
	}
}
