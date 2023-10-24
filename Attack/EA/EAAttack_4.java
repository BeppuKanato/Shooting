package Attack.EA;

import java.util.Random;
import java.util.ArrayList;
import Attack.Attack;
import Bullet.Bullet;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.MathUtils;
import Common.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.List;

public class EAAttack_4 extends Attack{
    private int NUM_BULLETS = 36;
    private double startAngle = 0;

    private boolean isWait = false;

    private double waitTime = 30;

    private List<Bullet> bulletList = new ArrayList<Bullet>();

    public EAAttack_4(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 60;
        this.attackDelay = 0;
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 150, true);
    }

    @Override
    public void Attack (Pane root, Character attackChar) {
        Point firstPos = new Point();

        firstPos.SetX(200);
        firstPos.SetY(100);

        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        if (attackDelay <= 0) {
            Random random = new Random();
            for (int i = 0; i < this.NUM_BULLETS; i++) {
                double direction = startAngle + 2 * Math.PI * i / NUM_BULLETS;
                this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction));
            }
            isWait = true;
            attackDelay = attackRate;
        }

        if (isWait) {
            waitTime--;
            if (waitTime <= 0) {
                for (Bullet bullet : bulletList) {
                    double direction = MathUtils.GetDirection(bullet.GetBulletPos(), playerManager.GetPlayerPos());
                    bullet.SetDirectin(direction);
                }
                bulletList.removeAll(bulletList);
                attackDelay = attackRate;
                isWait = false;
                waitTime = 30;
            }
        }
    }
}
