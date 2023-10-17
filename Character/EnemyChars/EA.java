package Character.EnemyChars;

import Character.Enemy;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Attack.NormalAttack.EANormalAttack;
import Attack.NormalAttack.NormalAttack;
import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.LinerBullet;
import Bullet.Bullets.SpiralBullet;


public class EA extends Enemy{
    private double speed = 1;
    private double hitBox = 36;
    private int shootRate = 10000;

    private NormalAttack normalAttack;

    public EA (Pane root, int maxHP, double firstPosX, double firstPosY) {
		super(maxHP, firstPosX, firstPosY);
		
		this.color = Color.BLUE;
		this.charShape.setFill(this.color);

        this.SetSpeed(this.speed);
        this.SetHitBox(this.hitBox);
        this.SetShootRate(this.shootRate);
		
		root.getChildren().add(this.charShape);//this.charShape);

        this.normalAttack = new EANormalAttack();
	}

    @Override
    public void CharMove (double timer) {
        double moveY = 100 + 50 * (Math.sin(timer * this.GetSpeed()));
        double moveX = 200 + 120 * Math.sin((timer / 6) * this.GetSpeed());

        this.SetPosition(moveX, moveY);
    }

    @Override
    public void CharShoot(Pane root, double timer) {
        this.normalAttack.ExeuteAttack(root, true);
	}
}
