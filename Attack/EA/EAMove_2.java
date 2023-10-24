package Attack.EA;

import Attack.Move;
import Character.Character;
import Common.Point;

public class EAMove_2 extends Move{
    private double moveBaseTimer = 0;
    private double addTimer = 0.1;

    private int angleList[] = {30, 180, 350, 200};

    private double moveRate = 100;
    private double moveDelay = 0;

    private double moveTime = 50;

    private int angleIndex = 0;

    @Override
    public void Move(Character moveChar) {

        if (moveDelay > 0) {
            moveDelay--;
        }
        if (moveDelay <= 0) {
            if (moveTime > 0) {
                double moveX = moveChar.GetPosition().GetX() + moveChar.GetSpeed() * Math.cos(Math.toRadians(this.angleList[this.angleIndex]));
                double moveY = moveChar.GetPosition().GetY() + moveChar.GetSpeed() * Math.sin(Math.toRadians(this.angleList[this.angleIndex]));

                Point targetPos = new Point();
                targetPos.SetX(moveX);
                targetPos.SetY(moveY);
                // this.enemyManager.EnemysMove(moveX, targetPos);

                moveChar.SetPosition(targetPos.GetX(), targetPos.GetY());
                moveTime--;
            }
            else {
                this.ChangeAngleIndex();
                moveTime = 100;
                moveDelay = moveRate;
            }
        }
    }

    private void ChangeAngleIndex () {
        if (this.angleList.length - 1 == this.angleIndex) {
            this.angleIndex = 0;
        }
        else {
            this.angleIndex++;
        }
    }
}
