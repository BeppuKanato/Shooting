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
	private int shootDelay;
	private int shootRate;
	
	private Point position = new Point();
	
	protected Shape charShape;
	protected Color color;
	
	public Character(int maxHP, double speed, int shootRate, double firstPosX, double firstPosY) {
		this.maxHP = maxHP;
		this.nowHP = maxHP;
		this.speed = speed;

		this.shootDelay = 0;
		this.shootRate = shootRate;
		
		this.position.SetX(firstPosX);
		this.position.SetY(firstPosY);
	}

	public int GetShootDelay () {
		return this.shootDelay;
	}

	public void SetShootDelay (int shootDelay) {
		this.shootDelay = shootDelay;
	}

	public int GetShootRate () {
		return this.shootRate;
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
