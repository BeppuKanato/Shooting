package Attack;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.EnemyManager;
import Manager.PlayerBulletManager;
import Manager.PlayerManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class AttackExe {
    protected PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    protected EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance();
    protected PlayerManager playerManager = PlayerManager.GetInstance();
    protected EnemyManager enemyManager = EnemyManager.GetInstance();

    public abstract void ExeuteAttack(Pane root, boolean isSpace, Character attackChar);
    public abstract void ExecuteMove(Character moveChar);

    protected double addTimer = 0.15;
    protected double moveBaseTimer;
    private int period = (int)(2 * Math.PI / this.addTimer);

    public int GetPeriod () {
        return this.period;
    }
}
