package testFile_java;

class Point{
	double X,Y,Z;
	
	//重构方法，无返回值，点最好用double型
	public Point(double _x, double _y, double _z) {
		X = _x;
		Y = _y;
		Z = _z;
	}
	
	public void setX(double _x) {
		X = _x;
	}
	
	public void setY(double _y) {
		Y = _y;
	}
	
	public void setZ(double _z) {
		Z = _z;
	}
	
	//计算点与点的距离比较灵活
	public double getDistance(Point p) {
		return (X - p.X) * (X - p.X) + (Y - p.Y) * (Y - p.Y) + (Z - p.Z) * (Z - p.Z);
	}	
	
}

public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(1.0, 2.0 , 3.0);
		Point p1 = new Point(0.0, 0.0, 0.0);
		System.out.println(p.getDistance(p1));
		System.out.println("-----------------------");
		p.setX(3.0);
		p.setY(4.0);
		p.setZ(5.0);
		System.out.println(p.getDistance(new Point(1.0, 1.0, 1.0)));
	}
}
