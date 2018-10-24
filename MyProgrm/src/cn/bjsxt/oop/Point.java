package cn.bjsxt.oop;

public class Point {
	double x,y,z;
	
	
//	通过构造器构造该类的对象，并初始化对象的属性
	public Point(double _x, double _y, double _z){ //构造器的方法名必须和类名一致
		x = _x;
		y = _y;
		z = _z;
	}
//	设置坐标的方法
	public void setX(double _x){
		x = _x;
	}
	
	public void setY(double _y){
		y = _y;
	}
	
	public void setZ(double _z){
		z = _z;
	}
	
	public double distance(Point p){
		double result = Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z)); //算两点间直线距离
		return result;
	}
	public static void main(String[] args){
		Point p = new Point(3,4,8);//		生成具有特定坐标的点对象
		Point p2 = new Point(10,5,14);

		p.setX(10);      //	设置p的坐标X
		p.setY(5);       //	设置p的坐标Y
		p.setZ(12);      //	设置p的坐标Z
	
		System.out.println(p.x);
		System.out.println(p.y);
		System.out.println(p.z);
		System.out.println(p.distance(p2));  //算p点与p2点之间的距离
	}

}
