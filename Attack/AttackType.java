package Attack;

import Bullet.BulletParameters;
import Manager.EnemyBulletManager;
import Manager.EnemyManager;
import Manager.PlayerBulletManager;
import Manager.PlayerManager;
import javafx.scene.layout.Pane;

public abstract class AttackType {
    protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    protected EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance();
    protected PlayerManager playerManager = PlayerManager.GetInstance();
    protected EnemyManager enemyManager = EnemyManager.GetInstance();

    protected BulletParameters bulletParam;
    protected int attackDelay;
    protected int attackRate;

    public abstract void Attack(Pane root);
}
