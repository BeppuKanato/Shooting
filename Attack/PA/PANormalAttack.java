package Attack.PA;

import java.beans.BeanProperty;

import Attack.Attack;
import Attack.AttackExe;
import Attack.PA.*;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PANormalAttack extends AttackExe{
    private Attack attack;

    public PANormalAttack () {
        attack = new PAAttack_1(5, BulletOwner.PLAYER, Color.RED, true);
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        if (isSpace) {
            attack.Attack(root, attackChar);
        }
    }

    @Override 
    public void ExecuteMove(Character moveChar) {
        
    }
}
