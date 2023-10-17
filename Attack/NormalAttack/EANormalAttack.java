package Attack.NormalAttack;

import java.beans.BeanProperty;

import Attack.AttackType;
import Attack.AttackTypes.HypoAttack_3;
import Attack.AttackTypes.HypoAttack_4;
import Attack.AttackTypes.HypoAttack_5;
import Attack.AttackTypes.RoseAttack2_1;
import Attack.AttackTypes.RoseAttack3_1;
import Attack.AttackTypes.RoseAttack3_2;
import Attack.AttackTypes.RoseAttack4_1;
import Attack.AttackTypes.RoseAttack4_3;
import Attack.AttackTypes.RoseAttack5_1;
import Attack.AttackTypes.RoseAttack5_3;
import Attack.AttackTypes.SpiralAttack;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.control.skin.ColorPickerSkin;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import Common.MathUtils;

public class EANormalAttack extends NormalAttack{
    private BulletParameters bulletType1Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);
    private BulletParameters bulletType2Param = new BulletParameters(5, BulletOwner.ENEMY, new double[10], 5, Color.BLUE, 150, false);

    private int bulletType1ShootDelay;
    private int bulletType2ShootDelay;

    private int bulletType2Counter;

    private AttackType attack;

    public EANormalAttack () {
        bulletType1ShootDelay = 0;
        bulletType2ShootDelay = 0;
        bulletType2Counter = this.GetPeriod();
        attack = new SpiralAttack(5, BulletOwner.ENEMY, Color.BLUE, false);
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        // BulletType2(root);
        attack.Attack(root, attackChar);
    }

    private void BulletType1 (Pane root,boolean isSpace) {
        int shootRate = 10;
        double moveBaseTimer = 0;
        Point target = new Point();
        target.SetX(0);
        target.SetY(0);
        if (this.bulletType1ShootDelay > 0) {
            this.bulletType1ShootDelay -= 1;
        }
        else if (bulletType1ShootDelay <= 0) {
            for (int i = 0; i <= (2 * Math.PI / 0.1); i++) {
                Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
                moveBaseTimer += addTimer;
                playerBulletManager.CreateLinerBullet(root, bulletType1Param, firstPos, target);
            }    
            this.bulletType1ShootDelay = shootRate;
        }
    }
    private void BulletType2 (Pane root) {
        if (bulletType2Counter > 0) {
            Point target = new Point();
            Point firstPos = MathUtils.CalcRoseCurve(moveBaseTimer, 150, 2, 1);
            if (firstPos.GetX() < 200) {
                target.SetX(firstPos.GetX() * 250);
            }
            else {
                target.SetX(firstPos.GetX() * -250);
            }
            target.SetY(firstPos.GetY() * 1000);
            moveBaseTimer += addTimer;
            enemyBulletManager.CreateLinerBullet(root, bulletType2Param, firstPos, target);
            bulletType2Counter--;
        }
        else {
            bulletType2Param.SetMoveTrigger(true);
        }
    }
}
