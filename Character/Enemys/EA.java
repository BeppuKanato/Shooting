package Character.Enemys;

import Character.Enemy;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class EA extends Enemy{
    public EA (Pane root, int maxHP, double speed) {
		super(maxHP, speed);
		
		this.color = Color.BLUE;
		this.charShape.setFill(this.color);
		
		root.getChildren().add(this.charShape);//this.charShape);
	}

    @Override
    public void CharMove () {
    }

    @Override
    public void CharShoot(Pane root) {
    }
}
