package Bullet;

import Bullet.Bullet.BulletOwner;
import Common.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BulletParameters {
	
	private double speed;
	private Point position = new Point();
	private BulletOwner owner;
	private boolean enable;
    private Point targetPos = new Point();
    private double[] shapeSizes;
    private double hitBox;
	private Color color;

	private boolean moveTrigger;

    public boolean GetMoveTrigger () {
		return this.moveTrigger;
	}

	public void SetMoveTrigger (boolean moveTrigger) {
		this.moveTrigger = moveTrigger;
	}

	public Point GetPosition () {
		return this.position;
	}

	public void SetPosition (double x, double y) {
		this.position.SetX(x);
		this.position.SetY(y);
	}
	
	public BulletOwner GetOwner () {
		return this.owner;
	}

    public void SetOwner (BulletOwner owner) {
        this.owner = owner;
    }
	
	public double GetSpeed () {
		return this.speed;
	}

	public void SetSpeed (double speed) {
		this.speed = speed;
	}

	public boolean GetEnable () {
		return this.enable;
	}

	public void SetEnable (boolean enable) {
		this.enable = enable;
	}

    public double[] GetShapeSizes () {
        return this.shapeSizes;
    }

    public void SetShapeSize (double[] shapeSizes) {
        this.shapeSizes = shapeSizes;
    }

    public double GetHitBox () {
        return this.hitBox;
    }

    public void SetHitBox (double hitBox) {
        this.hitBox = hitBox;
    }

	public Color GetColor () {
		return this.color;
	}

	public void SetColor (Color color) {
		this.color = color;
	}
}
