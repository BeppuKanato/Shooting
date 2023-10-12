// package application;
	
// import application.Character.Player;
// import application.Character.PlayrChars.PA;
// import application.Manager.PlayerManager;
import javafx.application.Application;
import javafx.stage.Stage;

import Character.Player;
import Character.PlayrChars.PA;
import Manager.PlayerManager;

import javafx.stage.Stage;

public class Main extends Application {
	private PlayerManager playerManager = PlayerManager.GetInstance();
	
	public static void main(String[] args) {
		launch(args);
	}
 
	@Override
	public void start(Stage primaryStage) {
		GameScreen gameScreen = new GameScreen(primaryStage);
		
		this.InitializeGame(gameScreen);
		primaryStage.show();
		
		GameLoop gameLoop = new GameLoop(gameScreen);
		gameLoop.start();
	}
	
	private void InitializeGame (GameScreen gameScreen) {
		Player player = new PA(gameScreen.GetPane(), 10, (float)3);
		playerManager.SetPlayer(player);
	}
}
