package Attack.EA;

import java.beans.BeanProperty;

import Attack.Attack;
import Attack.AttackExe;
import Attack.Move;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class EANormalAttack extends AttackExe{
    private Move move;

    private List<Attack> attackList = new ArrayList<Attack>();


    public EANormalAttack () {
        attackList.add(new EAAttack_9(5, BulletOwner.ENEMY, Color.BLUE, false));
        attackList.add(new EAAttack_10(5, BulletOwner.ENEMY, Color.BLUE, false));
        move = new EAMove_2();
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        for (Attack attack : attackList) {
            attack.Attack(root, attackChar);
        }
        // test.Attack(root, attackChar);
    }

    @Override
    public void ExecuteMove(Character moveChar) {
        move.Move(moveChar);
    }
}
