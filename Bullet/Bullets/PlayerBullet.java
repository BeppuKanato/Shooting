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
		super(position, BulletOwner.PLAYER, 80);
		this.color = Color.RED;
		this.bulletShape = new Circle(100, 100, 10);
		this.bulletShape.setFill(color);
		
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove () {
		System.out.println("Move");
		float moveX = this.GetPosition().GetX();
		float moceY = this.GetPosition().GetY() - this.GetSpeed();
		
		this.GetPosition().SetX(moveX);
		this.GetPosition().SetY(moceY);
	}
}
