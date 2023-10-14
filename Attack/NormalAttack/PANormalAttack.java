package Attack.NormalAttack;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.paint.Color;

public class PANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters();
    private BulletParameters bulletType2Param = new BulletParameters();

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;
    public PANormalAttack (double x, double y) {
        this.BulletParamSetting(bulletType1Param, 1, x, y, BulletOwner.PLAYER, true, true, new double[10], 5, Color.RED);
        this.BulletParamSetting(bulletType2Param, 1, x, y, BulletOwner.PLAYER, true, true, new double[10], 5, Color.RED);

        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
    }
    @Override
    public void ExeuteAttack() {
        this.moveBaseTimer += 0.1;
    }

    private void BulletType1 (double timre) {
        int shootRate = 10;
        if (this.bulletType1ShootDelay > 0) {
            bulletType1ShootDelay = this.GetShootDelay(shootRate);
        }
        else {
            
        }
    }

    private void BulletType2 (double timer) {
        int shootRate = 5 ;
        if (this.bulletType2ShootDelay > 0) {
            bulletType2ShootDelay = this.GetShootDelay(shootRate);
        }
        else {

        }
    }
}
