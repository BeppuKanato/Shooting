package Bullet;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.HypoCycloidBullet;
import Bullet.Bullets.LinerBullet;
import Bullet.Bullets.SpiralBullet;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BulletFactory {
    private static BulletFactory instance;

    public Bullet CreateLinerBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, boolean moveTrigger)  {
        LinerBullet bullet = new LinerBullet(root, position, targetPos, owner, color, moveTrigger);

        return bullet;
    }

    public Bullet CreateSpiralBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, double timer, boolean moveTrigger) {
        SpiralBullet bullet = new SpiralBullet(root, position, targetPos, owner, color, timer, moveTrigger);

        return bullet;
    }

    
    public Bullet CreateHypoCycloidBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, double timer, boolean moveTrigger) {
        HypoCycloidBullet bullet = new HypoCycloidBullet(root, position, targetPos, owner, color, timer, moveTrigger);

        return bullet;
    }
}
