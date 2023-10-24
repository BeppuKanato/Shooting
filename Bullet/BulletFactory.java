package Bullet;

import java.nio.file.attribute.FileTime;

import Bullet.Bullet.BulletOwner;
import Bullet.Bullets.LinerBullet;
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
}
