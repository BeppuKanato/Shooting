package Common;

import Common.Point;

public class MathUtils {
    public static double GetDistance (Point point1, Point point2) {
        double diffPowX = CalcDiffPow(point1.GetX(), point2.GetX(), 2);
        double diffPowY = CalcDiffPow(point1.GetY(), point2.GetY(), 2);

        double sum = diffPowX + diffPowY;

        double rtn = Math.sqrt(sum);

        return rtn;
    }

    public static Point CalcRoseCurve (double timer, int n, int m, int d) {
        double a = (double)m / d;

		double moveX = 200 + n * (Math.sin(timer * a) * Math.cos(timer));
		double moveY = 100 + n * (Math.sin(timer * a) * Math.sin(timer));

        Point rtn = new Point();

        rtn.SetX(moveX);
        rtn.SetY(moveY);

        return rtn;
    }

    public static Point CalcHypoCycloid (double timer, double smallRadius, int vertexNumber) {
        double bigRadius = smallRadius * vertexNumber;
        double moveSpeed = timer;

        double moveX = 200 + ((bigRadius - smallRadius) * Math.cos(moveSpeed) + smallRadius * Math.cos((bigRadius - smallRadius) * moveSpeed / smallRadius));
        double moveY = 100 + ((bigRadius - smallRadius) * Math.sin(moveSpeed) - smallRadius * Math.sin((bigRadius - smallRadius) * moveSpeed / smallRadius));

        Point rtn = new Point();

        rtn.SetX(moveX);
        rtn.SetY(moveY);
		
        return rtn;
    }

    public static Point CalcSpiral (double timer, int a) {
		double moveX = 200 + (a * timer * Math.cos(timer));
		double moveY = 100 + (a * timer * Math.sin(timer));

        Point rtn = new Point();

        rtn.SetX(moveX);
		rtn.SetY(moveY);

        return rtn;
    }

    public static double CalcDiffPow (double num1, double num2, int pow) {
        double diff = num2 - num1;
        double rtn = Math.pow(diff, pow);
        return rtn;
    }

    public static double GetDirection (Point point1, Point point2) {
		double rtn = Math.atan2(point2.GetY() - point1.GetY(), point2.GetX() - point1.GetX());

		return rtn;
	}
}
