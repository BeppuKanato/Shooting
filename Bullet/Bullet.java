// package application.Bullet;
package Bullet;

// import application.Point;
// import application.Manager.BulletManager;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.layout.Pane;
import Manager.BulletManager;
import Point.Point;

public class Bullet {
	private BulletManager bulletManager = BulletManager.GetInstance();
	
	public static enum BulletOwner {
		PLAYER,
		ENEMY
	}
	
	private double speed;
	private Point position = new Point();
	private BulletOwner owner;
	private boolean enable;
	
	protected Shape bulletShape;
	protected Color color;
	
	public Bullet (Point position ,BulletOwner owner, double speed) {
		this.position.SetX(position.GetX());
		this.position.SetY(position.GetY());
		this.owner = owner;
		this.speed = speed;
		this.enable = true;
		
		bulletManager.AddBullets(this);
	}
	
	public BulletOwner GetOwner () {
		return this.owner;
	}
	
	public double GetSpeed () {
		return this.speed;
	}

	public boolean GetEnable () {
		return this.enable;
	}

	public void SetEnable (boolean enable) {
		this.enable = enable;
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
	
	public void BulletMove () {
		System.out.println("BulletクラスのMoveです");
	}

	public void BulletRemove () {
		System.out.println("BulletクラスのRemoveです");
	}

	public void DeleteShape (Pane root) {
		root.getChildren().remove(this.bulletShape);
	}
}
