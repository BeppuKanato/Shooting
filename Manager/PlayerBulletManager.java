// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Manager.EnemyManager;
// import application.Bullet.Bullet;
import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import Bullet.BulletFactory;
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

	public void CreateLinerBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateLinerBullet(root, position, targetPos, owner, color, moveTrigger));
	}

	public void CreateSpiralBullet (Pane root, Point position, Point targetPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateSpiralBullet(root, position, targetPos, owner, color, timer, moveTrigger));
	}

	public void CreateHypoCycloidBullet (Pane root, Point position, Point tartPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateHypoCycloidBullet(root, position, tartPos, owner, color, timer, moveTrigger));
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
			if (bullet.GetMoveTrigger()) {
            	bullet.BulletMove(timer);
			}
        }
	}
}
