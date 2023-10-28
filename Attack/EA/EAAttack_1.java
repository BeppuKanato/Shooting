package Attack.EA;

import java.beans.BeanProperty;
import java.util.ArrayList;

import javax.print.DocPrintJob;

import Attack.Attack;
import Bullet.Bullet;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class EAAttack_1 extends Attack{

    private double moveBaseTimer = 0;
    private double addTimer = 0.15;
    private int period;
    private List<Bullet> bulletList = new ArrayList<Bullet>();

    public EAAttack_1(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 0;
        this.attackDelay = 0;
        this.bulletParam = new BulletParameters(speed, owner, new double[10], 5, color, 150, moveTrigger);

        this.period = (int)(2 * Math.PI / addTimer);
    }

    @Override
    public void Attack (Pane root, Character attackChar) {
        if (this.attackDelay > 0) {
            this.attackDelay -= 1;
        }
        if (attackDelay <= 0) {
            if (period > 0) {
                Point target = new Point();
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 1, 1);
                firstPos.SetX(firstPos.GetX() + 200);
                firstPos.SetY(firstPos.GetY() + 100);

                moveBaseTimer += addTimer;

                Point basePos = new Point();
                basePos.SetX(200);
                basePos.SetY(100);

                double direction = MathUtils.GetDirection(basePos, firstPos);
                this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction, 10));
                period--;
            }
            else {
                period = (int)(2 * Math.PI / addTimer);
                attackDelay = attackRate;
                for (Bullet bullet : bulletList) {
                    bullet.SetMoveTrigger(true);
                }
                bulletList.removeAll(bulletList);
            }
        }
    }
}
