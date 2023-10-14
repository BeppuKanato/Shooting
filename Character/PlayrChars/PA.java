// package application.Character.PlayrChars;
package Character.PlayrChars;

// import application.Point;
// import application.Bullet.Bullet;
// import application.Bullet.Bullets.PlayerBullet;
// import application.Character.Player;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.management.openmbean.OpenDataException;
import javax.swing.text.Position;

import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.LinerBullet;
import Character.Player;
import Common.Point;

//PA = plyerA
public class PA extends Player{
	private double speed = 3;
	private double hitBox = 36;
	private int shootRate = 10;

	public PA (Pane root, int maxHP, double firstPosX, double firstPosY) {
		super(maxHP, firstPosX, firstPosY);
		
		this.color = Color.RED;
		this.charShape.setFill(this.color);
		this.SetSpeed(this.speed);
		this.SetHitBox(this.hitBox);
		this.SetShootRate(this.shootRate);
		
		root.getChildren().add(this.charShape);//this.charShape);
	}

	@Override
	public void CharMove(boolean isUp, boolean isDown, boolean isRight, boolean isLeft) {
		double moveX = 0;
		double moveY = 0;
		if (isUp) {
			moveY -= this.GetSpeed();
		}
		if (isDown) {
			moveY += this.GetSpeed();
		}
		if (isRight) {
			moveX += this.GetSpeed();
		}
		if (isLeft) {
			moveX -= this.GetSpeed();
		}
		this.UpdateCharPosition(moveX, moveY);
	}
	
	private void UpdateCharPosition (double moveX, double moveY) {
		this.SetPosition(this.GetPosition().GetX() + moveX, this.GetPosition().GetY() + moveY);
	}
	
	@Override
	public void CharShoot (Pane root, boolean isSpace) {
 		if (this.GetShootDelay() > 0) {
			this.SetShootDelay(this.GetShootDelay() - 1);
		}
		if (isSpace) {
			if (this.GetShootDelay() == 0) {
				double posX = this.GetPosition().GetX() + 16;
				double posY = this.GetPosition().GetY() - 10;
				
				Point bulletPosition = new Point();
				
				bulletPosition.SetX(posX);
				bulletPosition.SetY(posY);

				Point targetPos = new Point();

				targetPos.SetX(this.GetPosition().GetX());
				targetPos.SetY(-10);
				
				CreateNewBulllet(root, bulletPosition, targetPos);

				this.SetShootDelay(this.GetShootRate());
			}
		}
	}
	
	private void CreateNewBulllet (Pane root, Point position, Point targetPos) {
		// Bullet newBullet = new PlayerBullet(root, position);
		new LinerBullet(root, position, targetPos, BulletOwner.PLAYER, Color.RED);	
	}
}
//this.SetPoint(this.GetPoint().GetX(), this.GetPoint().GetY() + this.GetSpeed());