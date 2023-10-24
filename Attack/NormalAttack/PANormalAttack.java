package Attack.NormalAttack;

import java.beans.BeanProperty;

import Attack.AttackType;
import Attack.AttackTypes.LinerAttack;
import Bullet.BulletParameters;
import Bullet.Bullet.BulletOwner;
import Character.Character;
import Common.MathUtils;
import Common.Point;
import Manager.PlayerBulletManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PANormalAttack extends NormalAttack{
    private AttackType attack;

    public PANormalAttack () {
        attack = new LinerAttack(5, BulletOwner.PLAYER, Color.RED, true);
    }
    @Override
    public void ExeuteAttack(Pane root, boolean isSpace, Character attackChar) {
        if (isSpace) {
            attack.Attack(root, attackChar);
        }
    }
}
