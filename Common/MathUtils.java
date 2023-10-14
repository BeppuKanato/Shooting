package Common;

public class MathUtils {
    public static double GetDistance (Point point1, Point point2) {
        double diffPowX = CalcDiffPow(point1.GetX(), point2.GetX(), 2);
        double diffPowY = CalcDiffPow(point1.GetY(), point2.GetY(), 2);

        double sum = diffPowX + diffPowY;

        double rtn = Math.sqrt(sum);

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
