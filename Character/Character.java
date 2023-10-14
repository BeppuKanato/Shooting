// package application.Character;
package Character;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
// import application.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Character {
	protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
	protected EnemyBulletManager enemyBulletsManager = EnemyBulletManager.GetInstance();

	private int maxHP;
	private int nowHP;
	private double speed;
	private int shootDelay;
	private int shootRate;
	private double hitBox;
	
	private Point position = new Point();
	
	protected Shape charShape;
	protected Color color;
	
	public Character(int maxHP, double firstPosX, double firstPosY) {
		this.maxHP = maxHP;
		this.nowHP = maxHP;

		this.shootDelay = 0;
		this.shootRate = shootRate;
		
		this.position.SetX(firstPosX);
		this.position.SetY(firstPosY);
	}

	public int GetShootDelay () {
		return this.shootDelay;
	}

	public void SetShootDelay (int shootDelay) {
		this.shootDelay = shootDelay;
	}

	public int GetShootRate () {
		return this.shootRate;
	}

	public void SetShootRate (int shootRate) {
		this.shootRate = shootRate;
	}
	
	public double GetSpeed () {
		return this.speed;
	}

	public void SetSpeed (double speed) {
		this.speed = speed;
	}

	public double GetHitBox () {
		return this.hitBox;
	}

	public void SetHitBox (double hitBox) {
		this.hitBox = hitBox;
	}
	
	public void DrowChar() {
		this.charShape.setTranslateX(this.position.GetX());
		this.charShape.setTranslateY(this.position.GetY());
	}
	
	public Point GetPosition() {
		return this.position;
	}
	
	public void SetPosition(double x, double y) {
		this.position.SetX(x);
		this.position.SetY(y);
	}
}
