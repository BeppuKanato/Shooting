// package application.Bullet.Bullets;
package Bullet.Bullets;

import javafx.geometry.Pos;
// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.text.Position;

import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.MathUtils;
import Common.Point;

public class SpiralBullet extends Bullet {
	private double bulletSpeed = 1;
	private double hitBox = 5;
	
	private double a = 1;
	private Point targetPos;

	public SpiralBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(bulletParams.GetColor());

		this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParams = this.GetBulletParams();

		double moveSpeed = timer * bulletParams.GetSpeed();
		double moveX = 200 + (a * moveSpeed * Math.cos(timer));
		double moveY = 100 + (a * moveSpeed * Math.sin(timer));
		
		this.SetBulletPos(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
