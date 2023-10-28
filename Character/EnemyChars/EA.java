package Character.EnemyChars;

import Character.Enemy;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Attack.AttackExe;
import Attack.EA.EANormalAttack;
import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.CircleLinerBullet;


public class EA extends Enemy{
    private double speed = 2;
    private double hitBox = 36;
    private int shootRate = 10000;

    private AttackExe normalAttack;

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
        // this.normalAttack.ExecuteMove(this);
        // this.SetPosition(targetPos.GetX(), targetPos.GetY());
    }

    @Override
    public void CharShoot(Pane root, double timer) {
        this.normalAttack.ExeuteAttack(root, true, this);
	}
}
