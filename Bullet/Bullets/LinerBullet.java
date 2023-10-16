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

	public LinerBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
		this.targetPos = new Point();
		targetPos.SetX(200);
		targetPos.SetY(-120);
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParam = this.GetBulletParams();
		double direction = MathUtils.GetDirection(this.GetBulletPos(), targetPos);

		double moveX = this.GetBulletPos().GetX() + bulletParam.GetSpeed() * Math.cos(direction);
		double moveY = this.GetBulletPos().GetY() + bulletParam.GetSpeed() * Math.sin(direction);
		
		this.SetBulletPos(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
		BulletParameters bulletParam = this.GetBulletParams();
		double distance = MathUtils.GetDistance(this.GetBulletPos(), targetPos);
		if (distance <= 10) {
			this.SetEnable(false);
		}
	}
}
