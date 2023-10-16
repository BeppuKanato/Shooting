package Attack.NormalAttack;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.EnemyManager;
import Manager.PlayerBulletManager;
import Manager.PlayerManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class NormalAttack {
    protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    protected EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance();
    protected PlayerManager playerManager = PlayerManager.GetInstance();
    protected EnemyManager enemyManager = EnemyManager.GetInstance();
    protected double moveBaseTimer = 0;

    public abstract void ExeuteAttack(Pane root, boolean isSpace);

    public void BulletParamSetting (BulletParameters bulletParameters, double speed, BulletOwner owner, boolean moveTrigger, double[] shapeSize, double hitBox, Color color) {
        bulletParameters.SetSpeed(speed);
        bulletParameters.SetOwner(owner);
        bulletParameters.SetMoveTrigger(moveTrigger);
        bulletParameters.SetShapeSize(shapeSize);
        bulletParameters.SetHitBox(hitBox);
        bulletParameters.SetColor(color);
    }
}
