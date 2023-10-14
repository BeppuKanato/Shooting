package Character;

// import application.Point;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import Point.Point;

public class Enemy extends Character{
	private Point p1 = new Point();
	private Point p2 = new Point();
	private Point p3 = new Point();
	
	private void SetShapeSize (double p1_x, double p1_y, double p2_x, double p2_y, double p3_x, double p3_y) {
		this.p1.SetX(p1_x);
		this.p1.SetY(p1_y);
		this.p2.SetX(p2_x);
		this.p2.SetY(p2_y);
		this.p3.SetX(p3_x);
		this.p3.SetY(p3_y);
	}
	
	public Enemy (int maxHP, double speed) {
		super(maxHP, speed);
		
        this.charShape = new Rectangle(36, 36);
	}
	
	public void CharMove () {
	}
	public void CharShoot (Pane root) {
        
	}
}
