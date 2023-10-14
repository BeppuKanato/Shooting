// package application;

// import application.Manager.BulletManager;
// import application.Manager.PlayerManager;

import Manager.BulletManager;
import Manager.EnemyManager;
import Manager.PlayerManager;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class GameLoop extends AnimationTimer{
	private GameSetting gameSetting = GameSetting.GetInstance();
	private PlayerManager playerManager = PlayerManager.GetInstance();
	private BulletManager bulletManager = BulletManager.GetInstance();
	private EnemyManager enemyManager = EnemyManager.GetInstance();
	
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;
	private boolean isRightPressed = false;
	private boolean isLeftPressed = false;
	private boolean isSpacePressed = false;
	
	
	private final long TARGET_FPS;
	private final long INTERVAL;
	private long startTime;
	private GameScreen gameScreen;
	
	private long lastUpdateTime = 0;
	
	public GameLoop (GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.TARGET_FPS = gameSetting.GetFPS();
		this.INTERVAL = 1_000_000_000L / this.TARGET_FPS;
		startTime = System.currentTimeMillis();
	}
	@Override
	public void handle (long now) {
		if (now - lastUpdateTime >= INTERVAL) {

			long currentTime = System.currentTimeMillis();
			long elapsedTime = currentTime -startTime;

			this.gameScreen.DrawGameScreen();
			
 			this.PlayerControlle();
			this.playerManager.PlayerMove(this.isUpPressed, this.isDownPressed, this.isRightPressed, this.isLeftPressed);
			this.playerManager.PlayerShoot(this.gameScreen.GetPane(), this.isSpacePressed);
			
			this.bulletManager.BulletsMove();
			this.bulletManager.CheckRemoveBullet(this.gameScreen.GetPane());

			this.enemyManager.EnemysMove(elapsedTime / 100);
			this.enemyManager.EnemysShoot(this.gameScreen.GetPane());
			
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
