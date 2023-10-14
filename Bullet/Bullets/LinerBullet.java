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

	public LinerBullet (Pane root, BulletParameters bulletParams) {
		super(bulletParams);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
		this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParam = this.GetBulletParams();
		double direction = MathUtils.GetDirection(bulletParam.GetPosition(), targetPos);

		double moveX = bulletParam.GetPosition().GetX() + bulletParam.GetSpeed() * Math.cos(direction);
		double moveY = bulletParam.GetPosition().GetY() + bulletParam.GetSpeed() * Math.sin(direction);
		
		bulletParam.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
		BulletParameters bulletParam = this.GetBulletParams();
		double distance = MathUtils.GetDistance(bulletParam.GetPosition(), targetPos);
		if (distance <= 10) {
			bulletParam.SetEnable(false);
		}
	}
}
