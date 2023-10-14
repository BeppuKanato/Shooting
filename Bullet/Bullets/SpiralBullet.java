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
import Common.MathUtils;
import Common.Point;

public class SpiralBullet extends Bullet {
	private double bulletSpeed = 8;
	private double hitBox = 5;
	
	private double a = 1;

	public SpiralBullet (Pane root, Point position, BulletOwner owner, Color color, double timer) {
		super(position, owner);
		this.color = color;
		double moveX = this.GetPosition().GetX() + (a * timer * Math.cos(timer));
		double moveY = this.GetPosition().GetY() + (a * timer * Math.sin(timer));
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(color);
		this.SetSpeed(this.bulletSpeed);
		this.SetHitBox(this.hitBox);
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {

		// double moveX = this.GetPosition().GetX() + this.GetSpeed() * Math.cos(direction);
		// double moveY = this.GetPosition().GetY() + this.GetSpeed() * Math.sin(direction);

		double moveX = this.GetPosition().GetX() + (a * timer * Math.cos(timer));
		double moveY = this.GetPosition().GetY() + (a * timer * Math.sin(timer));
		
		this.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
