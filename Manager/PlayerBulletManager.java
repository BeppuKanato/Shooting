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

	public void CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos, Point targetPos) {
		this.AddBullets(bulletFactory.CreateLinerBullet(root, bulletParameters, firstPos, targetPos));
	}

	public void CreateSpiralBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		this.AddBullets(bulletFactory.CreateSpiralBullet(root, bulletParameters, firstPos));
	}

	public void CreateHypoCycloidBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		this.AddBullets(bulletFactory.CreateHypoCycloidBullet(root, bulletParameters, firstPos));
	}

	public void CreateRoseCurveBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		this.AddBullets(bulletFactory.CreateRoseCurveBullet(root, bulletParameters, firstPos));
	}

	public void CreateParabolaBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		this.AddBullets(bulletFactory.CreateParabolaBullet(root, bulletParameters, firstPos));
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
