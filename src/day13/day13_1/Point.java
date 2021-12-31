package day13_1;
//  예제 6 - 3
class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	public boolean equals(Object obj) {
		Point p = (Point)obj; 
		if(x == p.x && y == p.y) return true;
		else return false;
	}
}
