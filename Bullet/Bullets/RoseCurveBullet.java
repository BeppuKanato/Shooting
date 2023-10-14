// package application.Bullet.Bullets;
package Bullet.Bullets;

// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Common.Point;

public class RoseCurveBullet extends Bullet {
	private double bulletSpeed = 1;
	private double hitBox = 5;

	private Point targetPos;

	public RoseCurveBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, double timer, boolean moveTrigger) {
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

		double a = (double)1 / 3;
		int n = 150;

		double moveSpeed = timer * this.GetSpeed();

		double moveX = 200 + n * (Math.sin(moveSpeed * a) * Math.cos(moveSpeed));
		double moveY = 100 + n * (Math.sin(moveSpeed * a) * Math.sin(moveSpeed));
		
		this.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
