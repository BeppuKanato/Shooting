package Bullet;

import java.nio.file.attribute.FileTime;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.DialogBullet;
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

    public Bullet CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos, double direction)  {
        LinerBullet bullet = new LinerBullet(root, bulletParameters, firstPos, direction);

        return bullet;
    }

    public Bullet CreateSpiralBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
        SpiralBullet bullet = new SpiralBullet(root, bulletParams, firstPos);

        return bullet;
    }

    
    public Bullet CreateHypoCycloidBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
        HypoCycloidBullet bullet = new HypoCycloidBullet(root, bulletParams, firstPos);

        return bullet;
    }

    public Bullet CreateRoseCurveBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
        RoseCurveBullet bullet = new RoseCurveBullet(root, bulletParams, firstPos);

        return bullet;
    }

    public Bullet CreateParabolaBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
        ParabolaBullet bullet = new ParabolaBullet(root, bulletParams, firstPos);

        return bullet;
    }

    public Bullet CreateDialogBullet (Pane root, BulletParameters bulletParams, Point firstPos) {
        DialogBullet bullet = new DialogBullet(root, bulletParams, firstPos);
        
        return bullet;
    }
}
