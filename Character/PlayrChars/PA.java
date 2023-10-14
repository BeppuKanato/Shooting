// package application.Character.PlayrChars;
package Character.PlayrChars;

// import application.Point;
// import application.Bullet.Bullet;
// import application.Bullet.Bullets.PlayerBullet;
// import application.Character.Player;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import Bullet.Bullet;
import Bullet.Bullets.PlayerBullet;
import Character.Player;
import Point.Point;

//PA = plyerA
public class PA extends Player{

	public PA (Pane root, int maxHP, double speed) {
		super(maxHP, speed);
		
		this.color = Color.RED;
		this.charShape.setFill(this.color);
		
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
		
		if (isSpace) {
			double posX = this.GetPosition().GetX() + 16;
			double posY = this.GetPosition().GetY() - 10;
			
			Point bulletPosition = new Point();
			
			bulletPosition.SetX(posX);
			bulletPosition.SetY(posY);
			
			CreateNewBulllet(root, bulletPosition);
		}
	}
	
	private void CreateNewBulllet (Pane root, Point position) {
		// Bullet newBullet = new PlayerBullet(root, position);
		new PlayerBullet(root, position);	
	}
}
//this.SetPoint(this.GetPoint().GetX(), this.GetPoint().GetY() + this.GetSpeed());