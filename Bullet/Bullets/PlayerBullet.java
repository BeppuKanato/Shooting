// package application.Bullet.Bullets;
package Bullet.Bullets;

// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Point.Point;

public class PlayerBullet extends Bullet {
	public PlayerBullet (Pane root, Point position) {
		super(position, BulletOwner.PLAYER, 8);
		this.color = Color.RED;
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(color);
		
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove () {
		System.out.println("Move");
		double moveX = this.GetPosition().GetX();
		double moveY = this.GetPosition().GetY() - this.GetSpeed();
		
		this.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
		if (this.GetPosition().GetY() < -10) {
			this.SetEnable(false);
		}
	}
}
