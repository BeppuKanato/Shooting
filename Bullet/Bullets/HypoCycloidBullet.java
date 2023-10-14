// package application.Bullet.Bullets;
package Bullet.Bullets;
// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Common.Point;

public class HypoCycloidBullet extends Bullet {
	private double bulletSpeed = 0.1;
	private double hitBox = 5;
	
	private double a = 1;
    private Point targetPos;

	public HypoCycloidBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		super(owner, moveTrigger);
		this.color = color;
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(color);
		this.SetSpeed(this.bulletSpeed);
		this.SetHitBox(this.hitBox);
        this.targetPos = targetPos;
		root.getChildren().add(bulletShape);

		this.SetPosition(position.GetX(), position.GetY());
	}
	
	@Override
	public void BulletMove (double timer) {

        double smallRadius = 0.2;
        double bigRadius = 0.6;
        double distance = 0.1;
        double moveSpeed = timer * this.GetSpeed();

        double moveX = this.GetPosition().GetX()  + ((bigRadius - smallRadius) * Math.cos(moveSpeed) + distance * Math.cos((bigRadius - smallRadius) * moveSpeed / smallRadius));
        double moveY = this.GetPosition().GetY() + ((bigRadius - smallRadius) * Math.sin(moveSpeed) - distance * Math.sin((bigRadius - smallRadius) * moveSpeed / smallRadius));
		
		this.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
