package Attack.NormalAttack;

import java.beans.BeanProperty;

import Attack.AttackType;
import Attack.AttackTypes.HypoAttack_3;
import Attack.AttackTypes.HypoAttack_4;
import Attack.AttackTypes.HypoAttack_5;
import Attack.AttackTypes.ParabolaAttack;
import Attack.AttackTypes.RoseAttack1_1;
import Attack.AttackTypes.RoseAttack2_1;
import Attack.AttackTypes.RoseAttack3_1;
import Attack.AttackTypes.RoseAttack3_2;
import Attack.AttackTypes.RoseAttack4_1;
import Attack.AttackTypes.RoseAttack4_3;
import Attack.AttackTypes.RoseAttack5_1;
import Attack.AttackTypes.RoseAttack5_3;
import Attack.AttackTypes.SpiralAttack;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class EANormalAttack extends NormalAttack{
    private AttackType attack;

    public EANormalAttack () {
        attack = new RoseAttack1_1(5, BulletOwner.ENEMY, Color.BLUE, false);
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        attack.Attack(root, attackChar);
    }
}
