package Character.EnemyChars;

import Character.Enemy;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.LinerBullet;
import Bullet.Bullets.SpiralBullet;


public class EA extends Enemy{
    private double speed = 1;
    private double hitBox = 36;
    private int shootRate = 10000;

    public EA (Pane root, int maxHP, double firstPosX, double firstPosY) {
		super(maxHP, firstPosX, firstPosY);
		
		this.color = Color.BLUE;
		this.charShape.setFill(this.color);

        this.SetSpeed(this.speed);
        this.SetHitBox(this.hitBox);
        this.SetShootRate(this.shootRate);
		
		root.getChildren().add(this.charShape);//this.charShape);
	}

    @Override
    public void CharMove (double timer) {
        double moveY = 100 + 50 * (Math.sin(timer * this.GetSpeed()));
        double moveX = 200 + 120 * Math.sin((timer / 6) * this.GetSpeed());

        //this.SetPosition(this.GetPosition().GetX() - 1, moveY);
        this.SetPosition(moveX, moveY);
    }

    @Override
    public void CharShoot(Pane root) {
        if (this.GetShootDelay() > 0) {
			this.SetShootDelay(this.GetShootDelay() - 1);
        }
        if (this.GetShootDelay() == 0) {
            double posX = this.GetPosition().GetX() + 16;
            double posY = this.GetPosition().GetY() + 10;
            
            Point bulletPosition = new Point();
            
            bulletPosition.SetX(posX);
            bulletPosition.SetY(posY);

            Point targePosition = new Point();

            targePosition.SetX(this.GetPosition().GetX());
            targePosition.SetY(810);
            
            CreateNewBulllet(root, bulletPosition, targePosition);

            this.SetShootDelay(this.GetShootRate());
		}
    }

    private void CreateNewBulllet (Pane root, Point position, Point targetPos) {
		// Bullet newBullet = new PlayerBullet(root, position);
		// new LinerBullet(root, position, targetPos, BulletOwner.ENEMY, Color.BLUE);
        // new SpiralBullet(root, position, BulletOwner.ENEMY, Color.BLUE);	
	}
}
