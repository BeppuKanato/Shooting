package Manager;

// package application.Manager;

// import application.Character.Player;
import Character.Player;
import javafx.scene.layout.Pane;

public class PlayerManager {
	private static PlayerManager instance;
	
	private Player player;

	private PlayerManager () {

	}
	
	public static PlayerManager GetInstance() {
		if (instance == null) {
			instance = new PlayerManager();
		}
		return instance;
	}
	
	public void DrawPlayer () {
		this.player.DrowChar();
	}
	
	public void PlayerMove(boolean isUp, boolean isDown, boolean isRight, boolean isLeft) {
		this.player.CharMove(isUp, isDown, isRight, isLeft);
	}
	
	public void PlayerShoot (Pane root, boolean isSpace) {
		this.player.CharShoot(root, isSpace);
	} 
	
	public void SetPlayer (Player player) {
		this.player = player;
	}
}
