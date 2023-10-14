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

	private BulletParameters bulletParams;
	protected Shape bulletShape;
	
	public Bullet (BulletParameters bulletParams) {
		this.bulletParams = bulletParams;
		if (this.bulletParams.GetOwner() == BulletOwner.PLAYER) {
			playerBulletManager.AddBullets(this);
		}
		else if (this.bulletParams.GetOwner() == BulletOwner.ENEMY) {
			enemyBulletsManager.AddBullets(this);
		}
	}

	public BulletParameters GetBulletParams () {
		return this.bulletParams;
	}
	
	public void DrawBullet () {
		this.bulletShape.setTranslateX(this.bulletParams.GetPosition().GetX());
		this.bulletShape.setTranslateY(this.bulletParams.GetPosition().GetY());
	}
	
	public abstract void BulletMove (double timer);

	public abstract void BulletRemove ();

	public void DeleteShape (Pane root) {
		root.getChildren().remove(this.bulletShape);
	}
}
