// package application;

public class GameSetting {
	private static GameSetting instance;
	private int screenWidth;
	private int screenHeight;
	private long FPS;
	
	private GameSetting () {
		screenWidth = 400;
		screenHeight = 800;
		FPS = 60_000_000L;
	}
	
	public static GameSetting GetInstance () {
		if (instance == null) {
			instance = new GameSetting();
		}
		return instance;
	}
	
	public int GetScreenWidth () {
		return this.screenWidth;
	}
	public int GetScreenHeight () {
		return this.screenHeight;
	}
	public long GetFPS () {
		return this.FPS;	
	}
}
