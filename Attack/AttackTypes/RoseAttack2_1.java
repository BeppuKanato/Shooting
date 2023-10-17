package Attack.AttackTypes;

import java.beans.BeanProperty;

import Attack.AttackType;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class RoseAttack2_1 extends AttackType{

    private double moveBaseTimer = 0;
    private double addTimer = 0.15;
    private int period;

    public RoseAttack2_1(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
        this.attackRate = 170;
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
            bulletParam.SetMoveTrigger(false);
            if (period > 0) {
                Point target = new Point();
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
                firstPos.SetX(firstPos.GetX() + 200);
                firstPos.SetY(firstPos.GetY() + 100);
                if (firstPos.GetX() < 200) {
                    target.SetX(firstPos.GetX() * 250);
                }
                else {
                    target.SetX(firstPos.GetX() * -250);
                }
                target.SetY(firstPos.GetY() * 1000);
                moveBaseTimer += addTimer;
                enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, target);
                period--;
            }
            else {
                bulletParam.SetMoveTrigger(true);
                period = (int)(2 * Math.PI / addTimer);
                attackDelay = attackRate;
            }
        }
    }
}
