// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import Manager.EnemyManager;
// import application.Bullet.Bullet;
import Bullet.Bullet;

public class PlayerBulletManager {
	private static PlayerBulletManager instance;
	private List<Bullet> playerBullets = new ArrayList<Bullet>();
	private EnemyManager enemyManager = EnemyManager.GetInstance();

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
			enemyManager.IsCollidingWithBullet(bullet, root);
		}
	}
	
	public void AddBullets (Bullet bullet) {
		playerBullets.add(bullet);
	}

	public void CheckRemoveBullet (Pane root) {
		for (Bullet bullet : playerBullets) {
			bullet.BulletRemove();
			if (!bullet.GetEnable()) {
				RemoveBullets(bullet);
				bullet.DeleteShape(root);
			}
		}
	}
	
	public void RemoveBullets (Bullet bullet) {
		playerBullets.remove(bullet);
	}
	
	public void DrawBullets () {
		for (Bullet bullet : playerBullets) {
			bullet.DrawBullet();
		}
	}
	
	public void BulletsMove (double timer) {
        for (Bullet bullet : playerBullets) {
            bullet.BulletMove(timer);
        }
	}
}
