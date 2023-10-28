// package application.Bullet.Bullets;
package Bullet.Bullets;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.MathUtils;
import Common.Point;

public class RotateRectangularBullet extends Bullet {
	private double direction;

	public RotateRectangularBullet (Pane root, BulletParameters bulletParams, Point firstPos, double directoin, Point size) {
		super(bulletParams, firstPos);
		this.bulletShape = new Rectangle(0.0, 0.0, size.GetX(), size.GetY());
		this.bulletShape.getTransforms().add(new Rotate(45, this.GetBulletPos().GetX(), this.GetBulletPos().GetY()));
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
		this.direction = directoin;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		// double moveX = this.GetBulletPos().GetX() + this.GetSpeed() * Math.cos(this.direction);
		// double moveY = this.GetBulletPos().GetY() + this.GetSpeed() * Math.sin(this.direction);

		// this.SetBulletPos(moveX, moveY);
		Point center = new Point();
		center.SetX(0);
		center.SetY(0);
		this.RotateShape(center, this.GetSpeed());
		this.SetLifeTime(this.GetLifeTime() - 1);
	}

	@Override
	public void BulletRemove () {
		if (this.GetLifeTime() < 0 ) {
			this.SetEnable(false);
		}
	}

	@Override
	public void SetDirectin (double direction) {
		this.direction = direction;
	}
}
