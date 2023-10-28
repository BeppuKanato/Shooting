package Attack.EA;

import java.util.Random;
import java.lang.foreign.AddressLayout;
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

public class EAAttack_9 extends Attack{
    private int NUM_BULLETS = 20;
    private double startAngle = 0;

    private double addSpeeds[] = {0, 0.8, 1.5};

    private List<Bullet> bulletList;

    public EAAttack_9(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 30;
        this.attackDelay = 0;
        bulletList = new ArrayList<Bullet>();
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 300, moveTrigger);
    }

    @Override
    public void Attack (Pane root, Character attackChar) {
        Point firstPos = new Point();

        firstPos.SetX(attackChar.GetPosition().GetX() - 150);
        firstPos.SetY(attackChar.GetPosition().GetY());

        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        if (attackDelay <= 0) {
            Random random = new Random();
            for (int i = 0; i < this.NUM_BULLETS; i++) {
                double direction = Math.toRadians(startAngle) + 2 * Math.PI * i / NUM_BULLETS;
                this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction, 10));
                // Point size = new Point();
                // size.SetX(10);
                // size.SetY(200);
                // this.bulletList.add(enemyBulletManager.CreateRectangularBullet(root, bulletParam, firstPos, direction, size));
            }
            // startAngle += random.nextInt(50 - 5) + 5;
            attackDelay = attackRate;
            for (Bullet bullet : bulletList) {
                bullet.SetMoveTrigger(true);
            }
            bulletList.removeAll(bulletList);
        }
    }
}
