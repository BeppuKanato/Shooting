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

public class EAAttack_3 extends Attack{
    private int NUM_BULLETS = 20;
    private double startAngle = 0;

    private double addSpeeds[] = {0, 0.8, 1.5};

    private List<Bullet> bulletList;

    public EAAttack_3(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 30;
        this.attackDelay = 0;
        bulletList = new ArrayList<Bullet>();
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 300, moveTrigger);
    }

    @Override
    public void Attack (Pane root, Character attackChar) {
        Point firstPos = new Point();

        // firstPos.SetX(200);
        // firstPos.SetY(100);

        firstPos.SetX(attackChar.GetPosition().GetX());
        firstPos.SetY(attackChar.GetPosition().GetY());

        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        if (attackDelay <= 0) {
            Random random = new Random();
            for (int j = 0; j < 3; j ++) {
                bulletParam.SetSpeed(2 + this.addSpeeds[j]);
                for (int i = 0; i < this.NUM_BULLETS; i++) {
                    double direction = startAngle + 2 * Math.PI * i / NUM_BULLETS;
                    this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction));
                }
            }
            startAngle += random.nextInt(50 - 5) + 5;
            attackDelay = attackRate;
            for (Bullet bullet : bulletList) {
                bullet.SetMoveTrigger(true);
            }
            bulletList.removeAll(bulletList);
        }
    }
}
