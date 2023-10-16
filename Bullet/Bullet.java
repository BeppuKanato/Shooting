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
	
	private Point bulletPos = new Point();
	private boolean enable;
	private BulletParameters bulletParams;
	protected Shape bulletShape;
	
	public Bullet (BulletParameters bulletParams, Point firstPos) {
		this.bulletParams = bulletParams;
		bulletPos.SetX(firstPos.GetX());
		bulletPos.SetY(firstPos.GetY());
		this.enable = true;
		if (this.bulletParams.GetOwner() == BulletOwner.PLAYER) {
			playerBulletManager.AddBullets(this);
		}
		else if (this.bulletParams.GetOwner() == BulletOwner.ENEMY) {
			enemyBulletsManager.AddBullets(this);
		}
	}

	public Point GetBulletPos () {
		return this.bulletPos;
	}

	public void SetBulletPos (double x, double y) {
		this.bulletPos.SetX(x);
		this.bulletPos.SetY(y);
	}

	public boolean GetEnable () {
		return this.enable;
	}

	public void SetEnable (boolean enable) {
		this.enable = enable;
	}

	public BulletParameters GetBulletParams () {
		return this.bulletParams;
	}
	
	public void DrawBullet () {
		this.bulletShape.setTranslateX(this.bulletPos.GetX());
		this.bulletShape.setTranslateY(this.bulletPos.GetY());
	}
	
	public abstract void BulletMove (double timer);

	public abstract void BulletRemove ();

	public void DeleteShape (Pane root) {
		root.getChildren().remove(this.bulletShape);
	}
}
