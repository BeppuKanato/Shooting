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
	
	private double moveBaseTimer = 0;
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

	public void CreateLinerBullet (Pane root, BulletParameters bulletParameters, Point firstPos, Point targetPos) {
		bulletFactory.CreateLinerBullet(root, bulletParameters, firstPos, targetPos);
	}

	public void CreateSpiralBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		bulletFactory.CreateSpiralBullet(root, bulletParameters, firstPos);
	}

	public void CreateHypoCycloidBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		bulletFactory.CreateHypoCycloidBullet(root, bulletParameters, firstPos);
	}

	public void CreateRoseCurveBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		bulletFactory.CreateRoseCurveBullet(root, bulletParameters, firstPos);
	}

	public void CreateParabolaBullet (Pane root, BulletParameters bulletParameters, Point firstPos) {
		bulletFactory.CreateParabolaBullet(root, bulletParameters, firstPos);
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
		boolean moved = false;
		for (Bullet bullet : enemyBullets) {
			if (bullet.GetEnable()) {
				if (bullet.GetBulletParams().GetMoveTrigger()) {
					bullet.BulletMove(moveBaseTimer);
					moved = true;
				}
			}
		}
		if (moved) {
			moveBaseTimer += 0.05;
		}
	}
}
