package Manager;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    public void EnemysShoot (Pane root, double timer) {
        for (Enemy enemy : enemys) {
            enemy.CharShoot(root, timer);
        }
    }

    public void IsCollidingWithBullet (Bullet bullet, Pane root) {
        System.out.println(bullet.GetBulletShape());

        for (Enemy enemy : enemys) {
            double distance = MathUtils.GetDistance(bullet.GetBulletPos(), enemy.GetPosition());
            boolean isHit = CheckCollision(distance, bullet, enemy.GetHitBox());
            if (isHit) {
                bullet.DeleteShape(root);
            }
        }
    }

    private boolean CheckCollision (double distance, Bullet bullet, double enemyHitBox) {
		boolean rtn = false;

		if (bullet.GetBulletShape() instanceof Circle) {
			rtn = CheckWithCircleCollision(distance, bullet.GetBulletParams().GetHitBox(), enemyHitBox);
		}

        return rtn;
    }

	private boolean CheckWithCircleCollision (double distance, double bulletHitBox, double enemyHitBox) {
		double hitBoxSum = bulletHitBox + enemyHitBox;

        boolean rtn = false;

        if (distance < hitBoxSum) {
            rtn = true;
        }

        return rtn;
	}
}
