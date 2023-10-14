// package application.Manager;
package Manager;

import java.util.ArrayList;
import java.util.List;

// import application.Bullet.Bullet;
import Bullet.Bullet;

public class BulletManager {
	private static BulletManager instance;
	private List<Bullet> playerBullets = new ArrayList<Bullet>();
	private List<Bullet> enemyBullets = new ArrayList<Bullet>();
	
	private BulletManager () {

	}

	public static BulletManager GetInstance() {
		if (instance == null) {
			instance = new BulletManager();
		}
		return instance;
	}
	
	public void AddBullets (Bullet bullet) {
		switch (bullet.GetOwner().ordinal()) {
		case 0:
			AddBulletsList(playerBullets, bullet);
			break;
		case 1:
			AddBulletsList(enemyBullets, bullet);
			break;
		}
	}

	public void CheckRemoveBullet () {
		for (Bullet bullet : playerBullets) {
			boolean rtn = bullet.BulletRemove();
			if (rtn) {
				RemoveBullets(bullet);
			}
		}
		for (Bullet bullet : enemyBullets) {
			boolean rtn = bullet.BulletRemove();
			if (rtn) {
				RemoveBullets(bullet);
			}
		}
	}
	
	public void RemoveBullets (Bullet bullet) {
		switch (bullet.GetOwner().ordinal()) {
		case 0:
			RemoveBulletsList(playerBullets, bullet);
			break;
		case 1:
			RemoveBulletsList(enemyBullets, bullet);
			break;
		}
	}
	
	public void DrawBullets () {
		DrawBulletsList (playerBullets);
		DrawBulletsList (enemyBullets);
	}
	
	public void MoveBullets () {
		MoveBulletsList(playerBullets);
		MoveBulletsList(enemyBullets);
	}
	
	
	private void AddBulletsList (List<Bullet> list,Bullet bullet) {
		list.add(bullet);
	}
	
	private void RemoveBulletsList (List<Bullet> list, Bullet bullet) {
		list.remove(bullet);
	}
	
	private void DrawBulletsList (List<Bullet> bullets) {
		for (Bullet bullet : bullets) {
			bullet.DrawBullet();
		}
	}
	
	private void MoveBulletsList (List<Bullet> bullets) {
		for (Bullet bullet : bullets) {
			bullet.BulletMove();
		}
	}
}
