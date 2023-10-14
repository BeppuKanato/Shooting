// package application.Bullet.Bullets;
package Bullet.Bullets;
// import application.Point;
// import application.Bullet.Bullet;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import Bullet.Bullet;
import Bullet.BulletParameters;
import Common.Point;

public class HypoCycloidBullet extends Bullet {
	private double bulletSpeed = 0.5;
	private double hitBox = 5;
	
	private double a = 1;
    private Point targetPos;

	public HypoCycloidBullet (Pane root, BulletParameters bulletParams) {
		super(bulletParams);
		this.bulletShape = new Circle(0, 0, 10);
		this.bulletShape.setFill(this.GetBulletParams().GetColor());
        this.targetPos = targetPos;
		root.getChildren().add(bulletShape);
	}
	
	@Override
	public void BulletMove (double timer) {
		BulletParameters bulletParams = this.GetBulletParams();

        double smallRadius = 25;
        double bigRadius = smallRadius * 4;
        double moveSpeed = timer * bulletParams.GetSpeed();

        double moveX = 200 + ((bigRadius - smallRadius) * Math.cos(moveSpeed) + smallRadius * Math.cos((bigRadius - smallRadius) * moveSpeed / smallRadius));
        double moveY = 100 + ((bigRadius - smallRadius) * Math.sin(moveSpeed) - smallRadius * Math.sin((bigRadius - smallRadius) * moveSpeed / smallRadius));
		
		bulletParams.SetPosition(moveX, moveY);
	}

	@Override
	public void BulletRemove () {
	}
}
