package Bullet;

import java.nio.file.attribute.FileTime;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.CircleLinerBullet;
import Bullet.Bullets.RotateRectangularBullet;
import Common.Point;
import Manager.EnemyBulletManager;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BulletFactory {
    private static BulletFactory instance;

    public Bullet CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos, double direction, double radius)  {
        CircleLinerBullet bullet = new CircleLinerBullet(root, bulletParameters, firstPos, direction, radius);

        return bullet;
    }

    public Bullet CreateRectangularBullet (Pane root, BulletParameters bulletParameters, Point firstPos, double direction, Point size)  {
        RotateRectangularBullet bullet = new RotateRectangularBullet(root, bulletParameters, firstPos, direction, size);
        
        return bullet;
    }
}
