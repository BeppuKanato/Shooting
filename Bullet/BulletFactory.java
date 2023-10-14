package Bullet;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.HypoCycloidBullet;
import Bullet.Bullets.LinerBullet;
import Bullet.Bullets.ParabolaBullet;
import Bullet.Bullets.RoseCurveBullet;
import Bullet.Bullets.SpiralBullet;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BulletFactory {
    private static BulletFactory instance;

    public Bullet CreateLinerBullet (Pane root, BulletParameters bulletParameters)  {
        LinerBullet bullet = new LinerBullet(root, bulletParameters);

        return bullet;
    }

    public Bullet CreateSpiralBullet (Pane root, BulletParameters bulletParams) {
        SpiralBullet bullet = new SpiralBullet(root, bulletParams);

        return bullet;
    }

    
    public Bullet CreateHypoCycloidBullet (Pane root, BulletParameters bulletParams) {
        HypoCycloidBullet bullet = new HypoCycloidBullet(root, bulletParams);

        return bullet;
    }

    public Bullet CreateRoseCurveBullet (Pane root, BulletParameters bulletParams) {
        RoseCurveBullet bullet = new RoseCurveBullet(root, bulletParams);

        return bullet;
    }

    public Bullet CreateParabolaBullet (Pane root, BulletParameters bulletParams) {
        ParabolaBullet bullet = new ParabolaBullet(root, bulletParams);

        return bullet;
    }
}
