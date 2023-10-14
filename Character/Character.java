// package application.Character;
package Character;
import Point.Point;
// import application.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Character {
	private int maxHP;
	private int nowHP;
	private double speed;
	
	private Point position = new Point();
	
	protected Shape charShape;
	protected Color color;
	
	public Character(int maxHP, double speed) {
		this.maxHP = maxHP;
		this.nowHP = maxHP;
		this.speed = speed;
		
		this.position.SetX(200);
		this.position.SetY(600);
	}
	
	public double GetSpeed () {
		return this.speed;
	}
	
	public void DrowChar() {
		this.charShape.setTranslateX(this.position.GetX());
		this.charShape.setTranslateY(this.position.GetY());
	}
	
	public Point GetPosition() {
		return this.position;
	}
	
	public void SetPosition(double x, double y) {
		this.position.SetX(x);
		this.position.SetY(y);
	}
}
