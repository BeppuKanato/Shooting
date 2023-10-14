// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
// import application.Bullet.Bullet;
import Bullet.Bullet;
import Bullet.Bullet.BulletOwner;
import Bullet.BulletFactory;
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
			if (!bullet.GetBulletParams().GetEnable()) {
				RemoveBullets(bullet);
				bullet.DeleteShape(root);
			}
		}
	}

	public void CreateLinerBullet (Pane root, Point position, Point targetPos, BulletOwner owner, Color color, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateLinerBullet(root, position, targetPos, owner, color, moveTrigger));
	}

	public void CreateSpiralBullet (Pane root, Point position, Point tartPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateSpiralBullet(root, position, tartPos, owner, color, timer, moveTrigger));
	}

	public void CreateHypoCycloidBullet (Pane root, Point position, Point tartPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateHypoCycloidBullet(root, position, tartPos, owner, color, timer, moveTrigger));
	}

	public void CreateRoseCurveBullet (Pane root, Point position, Point tartPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateRoseCurveBullet(root, position, tartPos, owner, color, timer, moveTrigger));
	}

	public void CreateParabolaBullet (Pane root, Point position, Point tartPos ,BulletOwner owner, Color color, double timer, boolean moveTrigger) {
		this.AddBullets(bulletFactory.CreateParabolaBullet(root, position, tartPos, owner, color, timer, moveTrigger));
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
			if (bullet.GetBulletParams().GetMoveTrigger()) {
				bullet.BulletMove(timer);
			}
		}
	}
}
