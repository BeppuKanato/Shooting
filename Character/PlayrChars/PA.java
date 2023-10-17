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

import Attack.NormalAttack.NormalAttack;
import Attack.NormalAttack.PANormalAttack;
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

	private NormalAttack normalAttack;

	public PA (Pane root, int maxHP, double firstPosX, double firstPosY) {
		super(maxHP, firstPosX, firstPosY);
		
		this.color = Color.RED;
		this.charShape.setFill(this.color);
		this.SetSpeed(this.speed);
		this.SetHitBox(this.hitBox);
		this.SetShootRate(this.shootRate);
		
		root.getChildren().add(this.charShape);//this.charShape);

		this.normalAttack = new PANormalAttack();
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
		normalAttack.ExeuteAttack(root, isSpace, this);
	}
}