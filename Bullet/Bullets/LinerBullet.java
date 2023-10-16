// package application.Bullet.Bullets;
package Bullet.Bullets;

import javafx.geometry.Pos;
// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.MathUtils;
import Common.Point;

public class LinerBullet extends Bullet {
	private Point targetPos;

	public LinerBullet (Pane root, BulletParameters bulletParams, Point firstPos, Point targetPos) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
		this.targetPos = new Point();
		this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParam = this.GetBulletParams();
		double direction = MathUtils.GetDirection(this.GetBulletPos(), targetPos);
		double moveX = this.GetBulletPos().GetX() + bulletParam.GetSpeed() * Math.cos(direction);
		double moveY = this.GetBulletPos().GetY() + bulletParam.GetSpeed() * Math.sin(direction);
		
		this.SetBulletPos(moveX, moveY);

		this.SetLifeTime(this.GetLifeTime() - 1);
	}

	@Override
	public void BulletRemove () {
		// BulletParameters bulletParam = this.GetBulletParams();
		// double distance = MathUtils.GetDistance(this.GetBulletPos(), targetPos);
		if (this.GetLifeTime() < 0 ) {
			this.SetEnable(false);
		}
	}
}
