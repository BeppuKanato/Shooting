// package application.Bullet;
package Bullet;

// import application.Point;
// import application.Manager.BulletManager;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.layout.Pane;
import Manager.PlayerBulletManager;
import Common.Point;
import Manager.EnemyBulletManager;

public abstract class Bullet {
	private PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
	private EnemyBulletManager enemyBulletsManager = EnemyBulletManager.GetInstance();
	
	public static enum BulletOwner {
		PLAYER,
		ENEMY
	}
	
	private double speed;
	private Point position = new Point();
	private BulletOwner owner;
	private boolean enable;
	private	double hitBox;
	protected Shape bulletShape;
	protected Color color;
	
	public Bullet (Point position ,BulletOwner owner) {
		this.position.SetX(position.GetX());
		this.position.SetY(position.GetY());
		this.owner = owner;
		this.enable = true;
		if (this.owner == BulletOwner.PLAYER) {
			playerBulletManager.AddBullets(this);
		}
		else if (this.owner == BulletOwner.ENEMY) {
			enemyBulletsManager.AddBullets(this);
		}
	}
	
	public BulletOwner GetOwner () {
		return this.owner;
	}
	
	public double GetSpeed () {
		return this.speed;
	}

	public void SetSpeed (double speed) {
		this.speed = speed;
	}

	public boolean GetEnable () {
		return this.enable;
	}

	public void SetEnable (boolean enable) {
		this.enable = enable;
	}

	public double GetHitBox () {
		return this.hitBox;
	}

	public void SetHitBox (double hitBox) {
		this.hitBox = hitBox;
	}
	
	public void DrawBullet () {
		this.bulletShape.setTranslateX(this.position.GetX());
		this.bulletShape.setTranslateY(this.position.GetY());
	}
	
	public Point GetPosition () {
		return this.position;
	}
	
	public void SetPosition (double x, double y) {
		this.position.SetX(x);
		this.position.SetY(y);
	}
	
	public abstract void BulletMove (double timer);

	public abstract void BulletRemove ();

	public void DeleteShape (Pane root) {
		root.getChildren().remove(this.bulletShape);
	}
}
