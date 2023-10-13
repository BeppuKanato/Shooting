// package application;

// import application.Manager.BulletManager;
// import application.Manager.PlayerManager;

import Manager.BulletManager;
import Manager.PlayerManager;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class GameLoop extends AnimationTimer{
	private GameSetting gameSetting = GameSetting.GetInstance();
	private PlayerManager playerManager = PlayerManager.GetInstance();
	private BulletManager bulletManager = BulletManager.GetInstance();
	
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;
	private boolean isRightPressed = false;
	private boolean isLeftPressed = false;
	private boolean isSpacePressed = false;
	
	
	private final long TARGET_FPS;
	private final long INTERVAL;
	private GameScreen gameScreen;
	
	private long lastUpdateTime = 0;
	
	public GameLoop (GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.TARGET_FPS = gameSetting.GetFPS();
		this.INTERVAL = 1_000_000_000L / this.TARGET_FPS;
	}
	@Override
	public void handle (long now) {
		if (now - lastUpdateTime >= INTERVAL) {
			
			this.PlayerControlle();
			this.playerManager.PlayerMove(this.isUpPressed, this.isDownPressed, this.isRightPressed, this.isLeftPressed);
			this.playerManager.PlayerShoot(this.gameScreen.GetPane(), this.isSpacePressed);
			
			this.bulletManager.MoveBullets();
			
			this.gameScreen.DrawGameScreen();
			
			lastUpdateTime = now;
		}
	}
	
	private void PlayerControlle () {
		this.gameScreen.GetScene().setOnKeyPressed(event -> {
			KeyCode key = event.getCode();
			switch (key) {
			case UP:
				System.out.println("UP");
				this.isUpPressed = true;
				break;
			case DOWN:
				System.out.println("DOWN");
				this.isDownPressed = true;
				break;
			case RIGHT:
				System.out.println("RIGHT");
				this.isRightPressed = true;
				break;
			case LEFT:
				System.out.println("LEFT");
				this.isLeftPressed = true;
				break;
			case SPACE:
				System.out.println("SPACE");
				this.isSpacePressed = true;
				break;
			}
		});
		
		this.gameScreen.GetScene().setOnKeyReleased(event -> {
			KeyCode key = event.getCode();
			switch (key) {
			case UP:
				System.out.println("UP");
				this.isUpPressed = false;
				break;
			case DOWN:
				System.out.println("DOWN");
				this.isDownPressed = false;
				break;
			case RIGHT:
				System.out.println("RIGHT");
				this.isRightPressed = false;
				break;
			case LEFT:
				System.out.println("LEFT");
				this.isLeftPressed = false;
				break;
			case SPACE:
				System.out.println("SPACE");
				this.isSpacePressed = false;
				break;
			}
		});
		
	}
}
