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

public class RoseAttack4_1 extends AttackType{

    private double moveBaseTimer = 0;
    private double addTimer = 0.12;
    private int period;

    public RoseAttack4_1(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
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
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 4, 1);
                firstPos.SetX(firstPos.GetX() + 200);
                firstPos.SetY(firstPos.GetY() + 100);

                moveBaseTimer += addTimer;

                Point basePos = new Point();
                basePos.SetX(200);
                basePos.SetY(100);

                double direction = MathUtils.GetDirection(basePos, firstPos);
                enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction);
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
