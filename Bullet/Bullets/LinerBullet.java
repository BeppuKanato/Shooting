// package application.Bullet.Bullets;
package Bullet.Bullets;

import javafx.geometry.Pos;
// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Common.MathUtils;
import Common.Point;

public class LinerBullet extends Bullet {
	private double bulletSpeed = 5;
	private double hitBox = 5;

	private Point targetPos;

	public LinerBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, boolean moveTrigger) {
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
		double direction = MathUtils.GetDirection(this.GetPosition(), targetPos);

		double moveX = this.GetPosition().GetX() + this.GetSpeed() * Math.cos(direction);
		double moveY = this.GetPosition().GetY() + this.GetSpeed() * Math.sin(direction);
		
		this.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
		double distance = MathUtils.GetDistance(this.GetPosition(), targetPos);
		if (distance <= 10) {
			this.SetEnable(false);
		}
	}
}
