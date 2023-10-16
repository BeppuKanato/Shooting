// package application.Manager;
package Manager;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.PopupMenuUI;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
// import application.Bullet.Bullet;
import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import Bullet.BulletFactory;
import Bullet.BulletParameters;
import Common.Point;

public class EnemyBulletManager {
	private static EnemyBulletManager instance;
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();
	private BulletFactory bulletFactory = new BulletFactory();
	
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
				// RemoveBullets(bullet);
				bullet.DeleteShape(root);
			}
		}
	}

	public void CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		this.AddBullets(bulletFactory.CreateLinerBullet(root, bulletParameters, firstPos));
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
		enemyBullets.remove(bullet);
	}
	
	public void DrawBullets () {
		for (Bullet bullet : enemyBullets) {
			if (bullet.GetEnable()) {
				bullet.DrawBullet();
			}
		}
	}
	
	public void BulletsMove (double timer) {
		for (Bullet bullet : enemyBullets) {
			if (bullet.GetEnable()) {
				if (bullet.GetBulletParams().GetMoveTrigger()) {
					bullet.BulletMove(timer);
				}
			}
		}
	}
}
