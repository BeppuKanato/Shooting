package Attack.NormalAttack;

import java.beans.BeanProperty;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters();
    private BulletParameters bulletType2Param = new BulletParameters();

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;
    public PANormalAttack () {
        this.BulletParamSetting(bulletType1Param, 5, BulletOwner.PLAYER, true, new double[10], 5, Color.RED);
        this.BulletParamSetting(bulletType2Param, 1, BulletOwner.PLAYER, true, new double[10], 5, Color.RED);

        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace) {
        this.moveBaseTimer += 0.1;
        BulletType1(root, isSpace);
    }

    private void BulletType1 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (this.bulletType1ShootDelay > 0) {
            this.bulletType1ShootDelay -= 1;
        }
        if (isSpace) {
			if (bulletType1ShootDelay == 0) {
                Point playerPos = this.playerManager.GetPlayerPos();
				double posX = playerPos.GetX() + 16;
				double posY = playerPos.GetY() - 10;
				
				Point firstBulletPos = new Point();
				
				firstBulletPos.SetX(posX);
				firstBulletPos.SetY(posY);

				Point targetPos = new Point();

				targetPos.SetX(playerPos.GetX());
				targetPos.SetY(-10);

                this.playerBulletManager.CreateLinerBullet(root, bulletType1Param, firstBulletPos);

                this.bulletType1ShootDelay = shootRate;
            }
        }
    }

    private void BulletType2 (double timer) {
        int shootRate = 5 ;
        if (this.bulletType2ShootDelay > 0) {
            this.bulletType2ShootDelay -= 1;
        }
        else {

        }
    }
}
