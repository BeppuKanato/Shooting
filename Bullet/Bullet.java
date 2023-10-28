// package application.Bullet;
package Bullet;

// import application.Point;
// import application.Manager.BulletManager;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.layout.Pane;
import Manager.PlayerBulletManager;

import java.util.DuplicateFormatFlagsException;

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
	private boolean moveTrigger;
	private int lifeTime;
	private BulletParameters bulletParams;
	private double speed;

	protected Shape bulletShape;
	protected Point firstPos;
	
	public Bullet (BulletParameters bulletParams, Point firstPos) {
		this.bulletParams = bulletParams;
		bulletPos.SetX(firstPos.GetX());
		bulletPos.SetY(firstPos.GetY());
		this.firstPos = firstPos; 
		this.speed = bulletParams.GetSpeed();
		this.enable = true;
		this.moveTrigger = bulletParams.GetMoveTrigger();
		this.lifeTime = this.bulletParams.GetLifeTime();
		if (this.bulletParams.GetOwner() == BulletOwner.PLAYER) {
			playerBulletManager.AddBullets(this);
		}
		else if (this.bulletParams.GetOwner() == BulletOwner.ENEMY) {
			enemyBulletsManager.AddBullets(this);
		}
	}

	public double GetSpeed () {
		return this.speed;
	}

	public void SetSpeed (double speed) {
		this.speed = speed;
	}

	public boolean GetMoveTrigger () {
		return this.moveTrigger;
	}

	public void SetMoveTrigger (boolean moveTrigger) {
		this.moveTrigger = moveTrigger;
	}

	public Point GetBulletPos () {
		return this.bulletPos;
	}

	public Shape GetBulletShape () {
		return this.bulletShape;
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

	public int GetLifeTime () {
		return this.lifeTime;
	}

	public void SetLifeTime (int lifeTime) {
		this.lifeTime = lifeTime;
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

	public void RotateShape (Point center, double radian) {
		this.bulletShape.getTransforms().add(new Rotate(radian,  center.GetX(), center.GetY()));
	}

	public abstract void SetDirectin (double direction);
}
