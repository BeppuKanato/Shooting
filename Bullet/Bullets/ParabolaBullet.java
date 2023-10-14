// package application.Bullet.Bullets;
package Bullet.Bullets;

// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Common.Point;

public class ParabolaBullet extends Bullet {
	private double bulletSpeed = 0.5;
	private double hitBox = 5;

	private Point targetPos;

	public ParabolaBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		super(owner, moveTrigger);
		this.color = color;
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(color);
		this.SetSpeed(this.bulletSpeed);
		this.SetHitBox(this.hitBox);

		this.targetPos = targetPos;
		root.getChildren().add(bulletShape);

		this.SetPosition(position.GetX(), position.GetY());
	}
	
	@Override
	public void BulletMove (double timer) {

		double moveSpeed = timer * this.GetSpeed();

		double moveX = 200 * Math.cos(moveSpeed);

		double squaredmoveY = 4 * 50 * moveX;
		
		double moveY = Math.sqrt(squaredmoveY);

		this.SetPosition(moveX + 200, moveY + 100);
	}

	@Override
	public void BulletRemove () {
	}
}
