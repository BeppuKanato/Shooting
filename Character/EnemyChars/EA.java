package Character.EnemyChars;

import Character.Enemy;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 


public class EA extends Enemy{
    double count = 0;
    public EA (Pane root, int maxHP, double speed, int shootRate, double firstPosX, double firstPosY) {
		super(maxHP, speed, shootRate, firstPosX, firstPosY);
		
		this.color = Color.BLUE;
		this.charShape.setFill(this.color);
		
		root.getChildren().add(this.charShape);//this.charShape);
	}

    @Override
    public void CharMove (long timer) {
        double baseTime = timer / 1.2;
        double moveY = 100 + (50 * Math.sin(baseTime));

        double moveX = 200 + (100 * Math.sin(baseTime));

        // this.SetPosition(this.GetPosition().GetX() - 0.5, moveY);
        this.SetPosition(moveX, moveY);
    }

    @Override
    public void CharShoot(Pane root) {
    }
}
