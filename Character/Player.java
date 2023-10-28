// package application.Character;
package Character;
import Common.Point;
// import application.Point;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public abstract class Player extends Character{
	private Point p1 = new Point();
	private Point p2 = new Point();
	private Point p3 = new Point();

	private double radius = 10;
	
	private void SetShapeSize (double p1_x, double p1_y, double p2_x, double p2_y, double p3_x, double p3_y) {
		this.p1.SetX(p1_x);
		this.p1.SetY(p1_y);
		this.p2.SetX(p2_x);
		this.p2.SetY(p2_y);
		this.p3.SetX(p3_x);
		this.p3.SetY(p3_y);
	}
	
	public Player (int maxHP, double firstPosX, double firstPosY) {
		super(maxHP, firstPosX, firstPosY);
		this.charShape = new Circle(0, 0, radius);
	}
	
	public abstract void CharMove (boolean isUp, boolean isDown, boolean isRight, boolean isLeft);
	public abstract void CharShoot (Pane root, boolean isSpace);
}
