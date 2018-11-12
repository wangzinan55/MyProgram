package study163;



class Tiger{
	int color;
	int height,weight;
	
	public Tiger(int color,int height,int weight) {
		this.color = color;
		this.height = height;
		this.weight = weight;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}else {
			if (obj instanceof Tiger) {
				Tiger c = (Tiger)obj;
				if (c.color == this.color && c.height == this.height && c.weight == this.weight) {
					return true;
				}
			}
		}
		return false;
	}
	
}


public class TestEquals {
	public static void main (String[] args) {
		Tiger c1 = new Tiger(1, 2, 3);
		Tiger c2 = new Tiger(1, 2, 3);
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
	}
}
