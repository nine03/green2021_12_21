package ex1;
// 8번 문제
class PositivePoint extends Point {
	   public PositivePoint() {
	      super(0, 0);
	   }
	   public PositivePoint(int x, int y) {
	      super(x,y);
	      if(x<0 || y<0) {
	         super.move(0,0);
	      }
	   }
	   protected void move(int x, int y) {
	      if(x>0 && y>0) {
	         super.move(x, y);
	      }
	   }
	   public String toString() {
	      String tmp = "("+getX()+","+getY()+")의 점";
	      return tmp;
	   }
	   public static void main(String[] args) {
		   PositivePoint p = new PositivePoint();
		   p.move(10, 10);
		   System.out.println(p.toString()+"입니다.");
		   p.move(-5,5); // 객체 p는 음수 공간으로 이동되지 않음
		   System.out.println(p.toString()+"입니다.");
		   PositivePoint p2 = new PositivePoint(-10, -10);
		   System.out.println(p2.toString()+"입니다.");
		}
}
