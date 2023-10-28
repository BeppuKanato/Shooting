package Manager;

import java.util.List;

import Bullet.Bullet;
import javafx.scene.transform.Rotate;
import Character.Player;
import Common.MathUtils;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PlayerManager {
	private static PlayerManager instance;
	
	private Player player;
	double testRad = 0;

	private PlayerManager () {

	}
	
	public static PlayerManager GetInstance() {
		if (instance == null) {
			instance = new PlayerManager();
		}
		return instance;
	}
	
	public void DrawPlayer () {
		this.player.DrowChar();
	}
	
	public void PlayerMove(boolean isUp, boolean isDown, boolean isRight, boolean isLeft) {
		this.player.CharMove(isUp, isDown, isRight, isLeft);
	}
	
	public void PlayerShoot (Pane root, boolean isSpace) {
		this.player.CharShoot(root, isSpace);
	} 
	
	public void SetPlayer (Player player) {
		this.player = player;
	}

	public Point GetPlayerPos () {
		return this.player.GetPosition();
	}

	public void IsCollidingWithBullet (Bullet bullet, Pane root) {
		boolean isHit = CheckCollision(bullet);
		if (isHit) {
			bullet.DeleteShape(root);
		}
    }

    private boolean CheckCollision (Bullet bullet) {
		boolean rtn = false;

		if (bullet.GetBulletShape() instanceof Circle) {
			rtn = CheckWithCircleCollision(bullet, player.GetHitBox());
		}
		else if (bullet.GetBulletShape() instanceof Rectangle) {
			rtn = CheckWithRectCollision(bullet, player.GetHitBox());
		}

        return rtn;
    }

	private boolean CheckWithCircleCollision (Bullet bullet, double playerHitBox) {
		double distance = MathUtils.GetDistance(bullet.GetBulletPos(), player.GetPosition());

		double hitBoxSum = bullet.GetBulletParams().GetHitBox() + playerHitBox;

        boolean rtn = false;

        if (distance < hitBoxSum) {
            rtn = true;
        }

        return rtn;
	}

	private boolean CheckWithRectCollision (Bullet bullet, double playerHitBox) {
		//0:左上,1:右上:2右下,3左下
		Point vertex[] = new Point[4];

		boolean rtn = false;
		Rectangle bulletShape = (Rectangle)bullet.GetBulletShape();

		testRad += 0.01;
		bullet.GetBulletShape().getTransforms().add(new Rotate(1, bulletShape.getWidth() / 2, bulletShape.getHeight() / 2));

		double rectCenterX = bullet.GetBulletPos().GetX() + bulletShape.getWidth() / 2;
		double rectCenterY = bullet.GetBulletPos().GetY() + bulletShape.getHeight() / 2;

		Point centerPos = new Point();
		centerPos.SetX(rectCenterX);
		centerPos.SetY(rectCenterY);

		double radian = Math.toRadians(bulletShape.getRotate());

		vertex[0] = MathUtils.CalcRotateMatrix(bullet.GetBulletPos().GetX(),
										bullet.GetBulletPos().GetY(), 
										radian);
		// vertex[0] = MathUtils.CalcRotateMatrix(rectCenterX,
		// 								-rectCenterY, 
		//  								radian);

		vertex[1] = MathUtils.CalcRotateMatrix((bullet.GetBulletPos().GetX() + bulletShape.getWidth()), 
										bullet.GetBulletPos().GetY(), 
										radian);
		// vertex[1] = MathUtils.CalcRotateMatrix(rectCenterX, 
		// 								bullet.GetBulletPos().GetY(), 
		// 								radian);


										
		vertex[2] = MathUtils.CalcRotateMatrix((bullet.GetBulletPos().GetX() + bulletShape.getWidth()), 
										(bullet.GetBulletPos().GetY() + bulletShape.getHeight()), 
										radian);
		// vertex[2] = MathUtils.CalcRotateMatrix(rectCenterX, 
		// 								rectCenterY, 
		// 								radian);

		vertex[3] = MathUtils.CalcRotateMatrix(bullet.GetBulletPos().GetX(),
										(bullet.GetBulletPos().GetY() + bulletShape.getHeight()), 
										radian);
		// vertex[3] = MathUtils.CalcRotateMatrix(-rectCenterX,
		// 								rectCenterY, 
		// 								radian);
		
		// if (radian % 360 != 0) {
		// 	for (int i = 0; i < 4; i++) {
		// 		vertex[i].SetX(vertex[i].GetX() + bullet.GetBulletPos().GetX());
		// 		vertex[i].SetY(vertex[i].GetX() + bullet.GetBulletPos().GetY());
		// 	}			
		// }

		Point zeroOne = MathUtils.SubVector(vertex[0], vertex[1]);
		Point oneP = MathUtils.SubVector(vertex[1], player.GetPosition());

		
		Point oneTwo = MathUtils.SubVector(vertex[1], vertex[2]);
		Point twoP = MathUtils.SubVector(vertex[2], player.GetPosition());
		
		Point twoThree = MathUtils.SubVector(vertex[2], vertex[3]);
		Point threeP = MathUtils.SubVector(vertex[3], player.GetPosition());
		
		Point threeZero = MathUtils.SubVector(vertex[3], vertex[0]);
		Point zeroP = MathUtils.SubVector(vertex[0], player.GetPosition());

		double cross1 = zeroOne.GetX() * oneP.GetY() - zeroOne.GetY() * oneP.GetX();
		double cross2 = oneTwo.GetX() * twoP.GetY() - oneTwo.GetY() * twoP.GetX();
		double cross3 = twoThree.GetX() * threeP.GetY() - twoThree.GetY() * threeP.GetX();
		double cross4 = threeZero.GetX() * zeroP.GetY() - threeZero.GetY() * zeroP.GetX();
		
		if ((cross1 > 0 && cross2 > 0 && cross3 > 0 && cross4 > 0) || (cross1 < 0 && cross2 < 0 && cross3 < 0 && cross4 < 0)) {
			// rtn = true;
			System.out.println("In Rect");
		}

		// double distance = MathUtils.GetDistance(centerPos, player.GetPosition());

		// double distanceX = MathUtils.GetDistanceX(centerPos.GetX(), player.GetPosition().GetX());
		// double distanceY = MathUtils.GetDistanceY(centerPos.GetY(), player.GetPosition().GetY());
		// // System.out.println("距離 = " +distance+"判定" +(playerHitBox + bulletShape.getHeight() / 2));

		// if (distanceX <= (playerHitBox + bulletShape.getWidth() / 2) && distanceY <= (playerHitBox + bulletShape.getHeight() / 2)) {
		// 	// rtn = true;
		// 	rtn = false;	
		// 	System.out.println("OK");
		// }
		return rtn;
	}
}
