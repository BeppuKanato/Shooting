package Attack.EA;

import java.util.Random;
import java.util.ArrayList;
import Attack.Attack;
import Bullet.Bullet;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.List;

public class EAAttack_5 extends Attack{
    private int NUM_BULLETS = 2;
    private double startAngle = 0;

    int test = 0;

    private boolean decreTrigger = true;

    private List<Bullet> bulletList = new ArrayList<Bullet>();

    public EAAttack_5(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 0;
        this.attackDelay = 0;
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 150, moveTrigger);
    }

    @Override
    public void Attack (Pane root, Character attackChar) {
        Point firstPos = new Point();

        firstPos.SetX(200);
        firstPos.SetY(100);

        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        startAngle+=0.1;
        if (attackDelay <= 0) {
            Random random = new Random();
            for (int i = 0; i < this.NUM_BULLETS; i++) {
                double direction = startAngle + 2 * Math.PI * i / NUM_BULLETS;
                this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction, 10));
            }

            // if (decreTrigger) {
            //     this.NUM_BULLETS --;
            // }
            // else {
            //     this.NUM_BULLETS++;
            // }
            // if (this.NUM_BULLETS <= 18) {
            //     this.decreTrigger = false;
            // }
            // if (this.NUM_BULLETS >= 36) {
            //     this.decreTrigger = true;
            // }

            attackDelay = attackRate;
            for (Bullet bullet : bulletList) {
                bullet.SetMoveTrigger(true);
            }
            bulletList.removeAll(bulletList);
        }
    }
}
