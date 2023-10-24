package Attack.EA;

import java.beans.BeanProperty;

import Attack.Attack;
import Attack.AttackExe;
import Attack.Move;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class EANormalAttack extends AttackExe{
    private Attack attack;
    private Attack test;
    private Move move;

    public EANormalAttack () {
        attack = new EAAttack_3(5, BulletOwner.ENEMY, Color.BLUE, false);
        test = new EAAttack_4(3, BulletOwner.ENEMY, Color.BLUE, false);
        move = new EAMove_2();
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        attack.Attack(root, attackChar);
        test.Attack(root, attackChar);
    }

    @Override
    public void ExecuteMove(Character moveChar) {
        move.Move(moveChar);
    }
}
