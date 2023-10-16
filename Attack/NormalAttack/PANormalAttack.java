package Attack.NormalAttack;

import java.beans.BeanProperty;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters(5, BulletOwner.PLAYER, new double[10], 5, Color.RED, 150, true);
    private BulletParameters bulletType2Param = new BulletParameters(5, BulletOwner.PLAYER, new double[10], 5, Color.YELLOW, 150, true);
    private BulletParameters bulletType3Param = new BulletParameters(5, BulletOwner.PLAYER, new double[10], 5, Color.YELLOW, 150, false);

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;
    public PANormalAttack () {
        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace) {
        this.moveBaseTimer += 0.1;
        BulletType1(root, isSpace);
        BulletType2(root, isSpace);
    }

    private void BulletType1 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (this.bulletType1ShootDelay > 0) {
            this.bulletType1ShootDelay -= 1;
        }
        if (isSpace) {
			if (bulletType1ShootDelay == 0) {
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
    }

    private void BulletType2 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (this.bulletType2ShootDelay > 0) {
            this.bulletType2ShootDelay -= 1;
        }
        if (isSpace) {
			if (bulletType2ShootDelay == 0) {
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
    }

    private void BulletType3 (Pane root,boolean isSpace) {
        int shootRate = 10;
        if (isSpace) {
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
}
