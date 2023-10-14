// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;

// import application.Bullet.Bullet;
import Bullet.Bullet;

public class EnemyBulletManager {
	private static EnemyBulletManager instance;
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();
	
	private EnemyBulletManager () {

	}

	public static EnemyBulletManager GetInstance() {
		if (instance == null) {
			instance = new EnemyBulletManager();
		}
		return instance;
	}
	
	public void AddBullets (Bullet bullet) {
		enemyBullets.add(bullet);
	}

	public void CheckRemoveBullet (Pane root) {
		for (Bullet bullet : enemyBullets) {
			bullet.BulletRemove();
			if (!bullet.GetEnable()) {
				RemoveBullets(bullet);
				bullet.DeleteShape(root);
			}
		}
	}
	
	public void RemoveBullets (Bullet bullet) {
		enemyBullets.remove(bullet);
	}
	
	public void DrawBullets () {
		for (Bullet bullet : enemyBullets) {
			bullet.DrawBullet();
		}
	}
	
	public void BulletsMove (double timer) {
		for (Bullet bullet : enemyBullets) {
			bullet.BulletMove(timer);
		}
	}
}
