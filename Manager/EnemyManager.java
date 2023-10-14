package Manager;

import java.util.ArrayList;
import java.util.List;

import Bullet.Bullet;
import javafx.scene.layout.Pane;

import Character.Enemy;
import Common.MathUtils;
import Common.Point;

public class EnemyManager {
    private static EnemyManager instance;

    private List<Enemy> enemys = new ArrayList<Enemy>();

    private EnemyManager () {

    }

    public static EnemyManager GetInstance () {
        if (instance == null) {
            instance = new EnemyManager();
        }
        return instance;
    }

    public void AddEnemys (Enemy enemy) {
        enemys.add(enemy);
    }

    public void DrawEnemys () {
        for (Enemy enemy : enemys) {
            enemy.DrowChar();
        }
    }

    public void EnemysMove (double timer) {
        for (Enemy enemy : enemys) {
            enemy.CharMove(timer);
        }
    }

    public void EnemysShoot (Pane root) {
        for (Enemy enemy : enemys) {
            enemy.CharShoot(root);
        }
    }

    public void IsCollidingWithBullet (Bullet bullet, Pane root) {
        for (Enemy enemy : enemys) {
            double distance = MathUtils.GetDistance(bullet.GetPosition(), enemy.GetPosition());
            boolean isHit = CheckCollision(distance, bullet.GetHitBox(), enemy.GetHitBox());
            if (isHit) {
                bullet.DeleteShape(root);
            }
        }
    }

    private boolean CheckCollision (double distance, double bulletHitBox, double enemyHitBox) {
        double hitBoxSum = bulletHitBox + enemyHitBox;

        boolean rtn = false;

        if (distance < hitBoxSum) {
            rtn = true;
        }

        return rtn;
    }
}
