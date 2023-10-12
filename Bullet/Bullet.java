// package application.Bullet;
package Bullet;

// import application.Point;
// import application.Manager.BulletManager;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import Manager.BulletManager;
import Point.Point;

public class Bullet {
	private BulletManager bulletManager = new BulletManager();
	
	public static enum BulletOwner {
		PLAYER,
		ENEMY
	}
	
	private float speed;
	private Point position = new Point();
	private BulletOwner owner;
	
	protected Shape bulletShape;
	protected Color color;
	
	public Bullet (Point position ,BulletOwner owner, float speed) {
		this.position = position;
		this.owner = owner;
		this.speed = speed;
		
		bulletManager.AddBullets(this);
	}
	
	public BulletOwner GetOwner () {
		return this.owner;
	}
	
	public float GetSpeed () {
		return this.speed;
	}
	
	public void DrawBullet () {
		this.bulletShape.setTranslateX(this.position.GetX());
		this.bulletShape.setTranslateY(this.position.GetY());
	}
	
	public Point GetPosition () {
		return this.position;
	}
	
	public void SetPosition (float x, float y) {
		this.position.SetX(x);
		this.position.SetY(y);
	}
	
	public void BulletMove () {
		System.out.println("BulletクラスのMoveです");
	}
}
