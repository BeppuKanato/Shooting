package Attack.NormalAttack;

import java.beans.BeanProperty;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Common.MathUtils;

public class EANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);
    private BulletParameters bulletType2Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;

    private int bulletType2Counter;

    public EANormalAttack () {
        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
        bulletType2Counter = this.GetPeriod();
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace) {
        BulletType2(root);
    }

    private void BulletType1 (Pane root,boolean isSpace) {
        int shootRate = 10;
        double moveBaseTimer = 0;
        Point target = new Point();
        target.SetX(0);
        target.SetY(0);
        if (this.bulletType1ShootDelay > 0) {
            this.bulletType1ShootDelay -= 1;
        }
        else if (bulletType1ShootDelay <= 0) {
            for (int i = 0; i <= (2 * Math.PI / 0.1); i++) {
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
                moveBaseTimer += addTimer;
                playerBulletManager.CreateLinerBullet(root, bulletType1Param, firstPos, target);
            }    
            this.bulletType1ShootDelay = shootRate;
        }
    }
    private void BulletType2 (Pane root) {
        if (bulletType2Counter > 0) {
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
            enemyBulletManager.CreateLinerBullet(root, bulletType2Param, firstPos, target);
            bulletType2Counter--;
        }
        else {
            bulletType2Param.SetMoveTrigger(true);
        }
    }
}
