package Attack.NormalAttack;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
import javafx.scene.paint.Color;

public abstract class NormalAttack {
    protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    protected EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance();
    protected double moveBaseTimer = 0;

    public abstract void ExeuteAttack();

    public int GetShootDelay(int shootRate) {
        return shootRate - 1;
    }

    public void BulletParamSetting (BulletParameters bulletParameters, double speed, double x, double y, BulletOwner owner, boolean enable, boolean moveTrigger, double[] shapeSize, double hitBox, Color color) {
        bulletParameters.SetSpeed(speed);
        bulletParameters.SetPosition(x, y);
        bulletParameters.SetOwner(owner);
        bulletParameters.SetEnable(enable);
        bulletParameters.SetMoveTrigger(moveTrigger);
        bulletParameters.SetShapeSize(shapeSize);
        bulletParameters.SetHitBox(hitBox);
        bulletParameters.SetColor(color);
    }
}
