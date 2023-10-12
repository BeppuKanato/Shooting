// package application.Character;
package Character;
// import application.Point;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import Point.Point;

public class Player extends Character{
	private Point p1 = new Point();
	private Point p2 = new Point();
	private Point p3 = new Point();
	
	private void SetShapeSize (float p1_x, float p1_y, float p2_x, float p2_y, float p3_x, float p3_y) {
		this.p1.SetX(p1_x);
		this.p1.SetY(p1_y);
		this.p2.SetX(p2_x);
		this.p2.SetY(p2_y);
		this.p3.SetX(p3_x);
		this.p3.SetY(p3_y);
	}
	
	public Player (int maxHP, float speed) {
		super(maxHP, speed);
		
		this.SetShapeSize(0, 800, 36, 800, 18, (800-36));
		this.charShape = new Polygon(p1.GetX(), p1.GetY(), p2.GetX(), p2.GetY(), p3.GetX(), p3.GetY());
	}
	
	public void CharMove (boolean isUp, boolean isDown, boolean isRight, boolean isLeft) {
		System.out.println("playerクラス");
	}
	public void CharShoot (Pane root, boolean isSpace) {
		System.out.println("playerクラス");
	}
}
