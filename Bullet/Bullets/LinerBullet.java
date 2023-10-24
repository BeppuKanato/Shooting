// package application.Bullet.Bullets;
package Bullet.Bullets;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.MathUtils;
import Common.Point;

public class LinerBullet extends Bullet {
	private double direction;

	public LinerBullet (Pane root, BulletParameters bulletParams, Point firstPos, double directoin) {
		super(bulletParams, firstPos);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
		this.direction = directoin;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParam = this.GetBulletParams();
		double moveX = this.GetBulletPos().GetX() + bulletParam.GetSpeed() * Math.cos(this.direction);
		double moveY = this.GetBulletPos().GetY() + bulletParam.GetSpeed() * Math.sin(this.direction);
		
		// double moveX = this.firstPos.GetX() + bulletParam.GetSpeed() * Math.cos(this.direction);
		// double moveY = this.firstPos.GetY() + bulletParam.GetSpeed() * Math.sin(this.direction);

		this.SetBulletPos(moveX, moveY);

		this.SetLifeTime(this.GetLifeTime() - 1);
	}

	@Override
	public void BulletRemove () {
		if (this.GetLifeTime() < 0 ) {
			this.SetEnable(false);
		}
	}
}
