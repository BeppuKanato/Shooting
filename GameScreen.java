// package application;

// import application.Manager.BulletManager;
// import application.Manager.PlayerManager;
import Manager.BulletManager;
import Manager.PlayerManager;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameScreen {
	private GameSetting gameSetting = GameSetting.GetInstance();
	private PlayerManager playerManager = PlayerManager.GetInstance();
	private BulletManager bulletManager = BulletManager.GetInstance();
	
	private Pane gameRoot;
	private Scene gameScene;
	
	
	public GameScreen(Stage gameStage) {
		CreateScene();
		gameStage.setScene(gameScene);
	}
	
	private void CreateScene() {
		this.gameRoot = new Pane();
		this.gameScene = new Scene(gameRoot, gameSetting.GetScreenWidth(), gameSetting.GetScreenHeight());
	}
	
	public Pane GetPane () {
		return this.gameRoot;
	}
	
	public Scene GetScene() {
		return this.gameScene;
	}
	
	public void DrawGameScreen () {
		playerManager.DrawPlayer();
		bulletManager.DrawBullets();
	}
}
