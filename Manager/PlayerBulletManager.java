// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Manager.EnemyManager;
// import application.Bullet.Bullet;
import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import Bullet.BulletFactory;
import Bullet.BulletParameters;
import Common.Point;

public class PlayerBulletManager {
	private static PlayerBulletManager instance;
	private List<Bullet> playerBullets = new ArrayList<Bullet>();
	private EnemyManager enemyManager = EnemyManager.GetInstance();
	private BulletFactory bulletFactory = new BulletFactory();

	private PlayerBulletManager () {
	}

	public static PlayerBulletManager GetInstance() {
		if (instance == null) {
			instance = new PlayerBulletManager();
		}
		return instance;
	}

	public void IsCollidingWithEnemy (Pane root) {
		for (Bullet bullet : playerBullets) {
			if (bullet.GetEnable()) {
				enemyManager.IsCollidingWithBullet(bullet, root);
			}
		}
	}
	
	public void AddBullets (Bullet bullet) {
		playerBullets.add(bullet);
	}

	public void CheckRemoveBullet (Pane root) {
		for (Bullet bullet : playerBullets) {
			bullet.BulletRemove();
			if (!bullet.GetEnable()) {
				bullet.DeleteShape(root);
				// RemoveBullets(bullet);
			}
		}
	}

	public void CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos, double direction) {
		bulletFactory.CreateLinerBullet(root, bulletParameters, firstPos, direction);
	}
	
	public void RemoveBullets (Bullet bullet) {
		playerBullets.remove(bullet);
	}
	
	public void DrawBullets () {
		for (Bullet bullet : playerBullets) {
			if (bullet.GetEnable()) {
				bullet.DrawBullet();
			}
		}
	}
	
	public void BulletsMove (double timer) {
        for (Bullet bullet : playerBullets) {
			if (bullet.GetEnable()) {
				if (bullet.GetBulletParams().GetMoveTrigger()) {
					bullet.BulletMove(timer);
				}
			}
        }
	}
}
