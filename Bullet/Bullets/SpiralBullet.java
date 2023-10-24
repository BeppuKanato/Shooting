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
	private Point targetPos;

	public SpiralBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(bulletParams.GetColor());

		this.firstPos = firstPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParams = this.GetBulletParams();
		// double moveSpeed = timer * bulletParams.GetSpeed();
		Point move = MathUtils.CalcSpiral(timer, 15);
		// double moveX = 200 + (a * timer * Math.cos(timer));
		// double moveY = 100 + (a * timer * Math.sin(timer));

		double moveX = firstPos.GetX() + move.GetX();
		double moveY = firstPos.GetY() + move.GetY();
		
		this.SetBulletPos(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
