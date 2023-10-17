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

public class RoseCurveBullet extends Bullet {
	private double bulletSpeed = 1;
	private double hitBox = 5;

	private Point targetPos;

	public RoseCurveBullet (Pane root, BulletParameters bulletParams, Point firstPosition) {
		super(bulletParams, firstPosition);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(bulletParams.GetColor());

		// this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParams = this.GetBulletParams();

		double a = (double)1 / 3;
		int n = 200;

		double moveSpeed = timer * bulletParams.GetSpeed();

		double moveX = 200 + n * (Math.sin(moveSpeed * a) * Math.cos(moveSpeed));
		double moveY = 100 + n * (Math.sin(moveSpeed * a) * Math.sin(moveSpeed));
		
		this.SetBulletPos(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
