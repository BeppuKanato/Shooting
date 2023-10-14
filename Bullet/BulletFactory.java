package Bullet;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.LinerBullet;
import Bullet.Bullets.SpiralBullet;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BulletFactory {
    private PlayerBulletManager playerBulletManager = PlayerBulletManager.GetInstance();
    private EnemyBulletManager enemyBulletManager = EnemyBulletManager.GetInstance(); 

    public void CreateLinerBuller (Pane root, Point position, Point targetPos, BulletOwner owner, Color color)  {
        LinerBullet bullet = new LinerBullet(root, position, targetPos, owner, color);

        this.AddBulletToBulletList(bullet);
    }

    public void CreateSpiralBullet (Pane root, Point position, BulletOwner owner, Color color, double timer) {
        SpiralBullet bullet = new SpiralBullet(root, position, owner, color, timer);

        this.AddBulletToBulletList(bullet);
    }

    private void AddBulletToBulletList (Bullet bullet) {
        switch (bullet.GetOwner().ordinal()) {
            case 0:
                playerBulletManager.AddBullets(bullet);
                break;
            case 1:
                enemyBulletManager.AddBullets(bullet);
                break;
        }
    }
}
