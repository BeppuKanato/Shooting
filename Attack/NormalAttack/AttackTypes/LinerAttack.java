package Attack.NormalAttack.AttackTypes;

import java.beans.BeanProperty;

import Attack.AttackType;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LinerAttack extends AttackType{

    public LinerAttack(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 10;
        this.attackDelay = 0;
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 150, moveTrigger);
    }

    @Override
    public void Attack (Pane root) {
        int attackRate = 10;
        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        if (attackDelay <= 0) {
            Point playerPos = this.playerManager.GetPlayerPos();
            double posX = playerPos.GetX() + 30;
            double posY = playerPos.GetY() - 10;
            
            Point firstBulletPos = new Point();
            
            firstBulletPos.SetX(posX);
            firstBulletPos.SetY(posY);

            Point targetPos = new Point();

            targetPos.SetX(posX);
            targetPos.SetY(-10);

            this.playerBulletManager.CreateLinerBullet(root, bulletParam, firstBulletPos, targetPos);

            this.attackDelay = attackRate;
            
        }
    }
}
