// package application.Bullet.Bullets;
package Bullet.Bullets;

// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.Point;

public class ParabolaBullet extends Bullet {
	private double bulletSpeed = 0.5;
	private double hitBox = 5;

	private Point targetPos;

	public ParabolaBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(bulletParams.GetColor());

		// this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParams = this.GetBulletParams();
		double moveSpeed = timer * bulletParams.GetSpeed();

		double moveX = 200 * Math.cos(moveSpeed);

		double squaredmoveY = 4 * 50 * moveX;
		
		double moveY = Math.sqrt(squaredmoveY);

		this.SetBulletPos(moveX + 200, moveY + 100);
	}

	@Override
	public void BulletRemove () {
	}
}
