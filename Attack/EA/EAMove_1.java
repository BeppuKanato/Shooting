package Attack.EA;

import Attack.Move;
import Character.Character;
import Common.Point;

public class EAMove_1 extends Move{
    private double moveBaseTimer = 0;
    private double addTimer = 0.1;
    @Override
    public void Move(Character moveChar) {
        moveBaseTimer += addTimer;
        double moveY = 100 + 50 * (Math.sin(this.moveBaseTimer * moveChar.GetSpeed()));
        double moveX = 200 + 120 * Math.sin((this.moveBaseTimer / 6) * moveChar.GetSpeed());

        Point targetPos = new Point();
        targetPos.SetX(moveX);
        targetPos.SetY(moveY);
        // this.enemyManager.EnemysMove(moveX, targetPos);

        moveChar.SetPosition(targetPos.GetX(), targetPos.GetY());
    }
}
