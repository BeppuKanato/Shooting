package Attack;

import Bullet.BulletParameters;
import Character.Character;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.EnemyManager;
import Manager.PlayerBulletManager;
import Manager.PlayerManager;
import javafx.scene.layout.Pane;

public abstract class Attack {
    protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    protected EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance();
    protected PlayerManager playerManager = PlayerManager.GetInstance();
    protected EnemyManager enemyManager = EnemyManager.GetInstance();

    protected BulletParameters bulletParam;
    protected int attackDelay;
    protected int attackRate;

    public abstract void Attack(Pane root, Character attackChar);
}
