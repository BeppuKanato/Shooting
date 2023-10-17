package Attack.NormalAttack;

import java.beans.BeanProperty;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters(5, BulletOwner.PLAYER, new double[10], 5, Color.RED, 150, true);
    private BulletParameters bulletType2Param = new BulletParameters(5, BulletOwner.PLAYER, new double[10], 5, Color.YELLOW, 150, true);
    private BulletParameters bulletType3Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);
    private BulletParameters bulletType4Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;
    private int bulletType3ShootDelay;

    private int period;

    public PANormalAttack () {
        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
        bulletType3ShootDelay = 0;
        period = (int)(2 * Math.PI / this.addTimer);
        moveBaseTimer = 0;
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace) {
        if (isSpace) {
            BulletType1(root, isSpace);
            BulletType2(root, isSpace);
            // BulletType3(root, isSpace);
            // BulletType4(root);
        }
    }

    private void BulletType1 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (this.bulletType1ShootDelay > 0) {
            this.bulletType1ShootDelay -= 1;
        }
        if (bulletType1ShootDelay <= 0) {
            Point playerPos = this.playerManager.GetPlayerPos();
            double posX = playerPos.GetX() + 30;
            double posY = playerPos.GetY() - 10;
            
            Point firstBulletPos = new Point();
            
            firstBulletPos.SetX(posX);
            firstBulletPos.SetY(posY);

            Point targetPos = new Point();

            targetPos.SetX(posX);
            targetPos.SetY(-10);

            this.playerBulletManager.CreateLinerBullet(root, bulletType1Param, firstBulletPos, targetPos);

            this.bulletType1ShootDelay = shootRate;
            
        }
    }

    private void BulletType2 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (this.bulletType2ShootDelay > 0) {
            this.bulletType2ShootDelay -= 1;
        }
        else if (bulletType2ShootDelay <= 0) {
            Point playerPos = this.playerManager.GetPlayerPos();
            double posX = playerPos.GetX() - 10;
            double posY = playerPos.GetY() - 10;
            
            Point firstBulletPos = new Point();
            
            firstBulletPos.SetX(posX);
            firstBulletPos.SetY(posY);

            Point targetPos = new Point();

            targetPos.SetX(posX);
            targetPos.SetY(-10);

            this.playerBulletManager.CreateLinerBullet(root, bulletType2Param, firstBulletPos, targetPos);

            this.bulletType2ShootDelay = shootRate;
        }
    }

    private void BulletType3 (Pane root,boolean isSpace) {
        int shootRate = 10;
        double moveBaseTimer = 0;
        Point target = new Point();
        target.SetX(0);
        target.SetY(0);
        if (this.bulletType3ShootDelay > 0) {
            this.bulletType3ShootDelay -= 1;
        }
        else if (bulletType3ShootDelay <= 0) {
            for (int i = 0; i <= (2 * Math.PI / 0.1); i++) {
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
                moveBaseTimer += addTimer;
                playerBulletManager.CreateLinerBullet(root, bulletType3Param, firstPos, target);
            }    
            this.bulletType3ShootDelay = shootRate;
        }
    }
    private void BulletType4 (Pane root) {
        if (period > 0) {
            Point target = new Point();
            Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
            if (firstPos.GetX() < 200) {
                target.SetX(firstPos.GetX() * 250);
            }
            else {
                target.SetX(firstPos.GetX() * -250);
            }
            target.SetY(firstPos.GetY() * 1000);
            moveBaseTimer += addTimer;
            enemyBulletManager.CreateLinerBullet(root, bulletType4Param, firstPos, target);
            period--;
        }
        else {
            bulletType4Param.SetMoveTrigger(true);
        }
    }
}
