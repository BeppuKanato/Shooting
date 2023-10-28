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

public class EAAttack_7 extends Attack{
    private double moveBaseTimer = 0;
    private double addTimer = 0.15;
    private int period;
    private List<Bullet> bulletList = new ArrayList<Bullet>();

    public EAAttack_7(double speed, BulletOwner owner, Color color, boolean  moveTrigger) {
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
            Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 5, 1);
            firstPos.SetX(firstPos.GetX() + attackChar.GetPosition().GetX());
            firstPos.SetY(firstPos.GetY() + attackChar.GetPosition().GetY());

            moveBaseTimer += addTimer;

            Point basePos = new Point();
            basePos.SetX(attackChar.GetPosition().GetX());
            basePos.SetY(attackChar.GetPosition().GetY());

            double direction = MathUtils.GetDirection(basePos, firstPos);
            this.bulletList.add(enemyBulletManager.CreateLinerBullet(root, bulletParam, firstPos, direction, 10));            

            attackDelay = attackRate;
            for (Bullet bullet : bulletList) {
                bullet.SetMoveTrigger(true);
            }
            bulletList.removeAll(bulletList);
        }
    }
}
