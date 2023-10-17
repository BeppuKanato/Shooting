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

    public static Point ClacQuadratic (int a, int b, int c, int x) {
        double moveY = a * Math.pow(x, 2) + b * x + c;

        Point rtn = new Point();

        rtn.SetX(x);
        rtn.SetY(moveY);

        return rtn;
    }

    public static Point CalcRoseCurve (double timer, int n, int m, int d) {
        double a = (double)m / d;

		double moveX = n * (Math.sin(timer * a) * Math.cos(timer));
		double moveY = n * (Math.sin(timer * a) * Math.sin(timer));

        Point rtn = new Point();

        rtn.SetX(moveX);
        rtn.SetY(moveY);

        return rtn;
    }

    public static Point CalcHypoCycloid (double timer, double smallRadius, int vertexNumber) {
        double bigRadius = smallRadius * vertexNumber;

        double moveX = (bigRadius - smallRadius) * Math.cos(timer) + smallRadius * Math.cos((bigRadius - smallRadius) * timer / smallRadius);
        double moveY = (bigRadius - smallRadius) * Math.sin(timer) - smallRadius * Math.sin((bigRadius - smallRadius) * timer / smallRadius);

        Point rtn = new Point();

        rtn.SetX(moveX);
        rtn.SetY(moveY);
		
        return rtn;
    }

    public static Point CalcSpiral (double timer, int a) {
		double moveX = a * timer * Math.cos(timer);
		double moveY = a * timer * Math.sin(timer);

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
