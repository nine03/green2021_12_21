package ex1;
// 6번 문제
class ColorPoint extends Point{
	   private String color;
	   public ColorPoint() {
	      super(0, 0);
	      this.color = "BLACK";
	   }
	   public ColorPoint(int x, int y) {
	      super(x, y);
	      this.color = "BLACK";
	   }
	   public void setXY(int x, int y) {
	      move(x, y);
	   }
	   public void setColor(String color) {
	      this.color = color;
	   }
	   public String toString() {
	      String tmp = color+"색의 ("+getX()+","+getY()+") 점";
	      return tmp;
	   }
	   public static void main(String[] args) {
		   ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK 색 점
		   System.out.println(zeroPoint.toString() + "입니다.");
		   ColorPoint cp = new ColorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
		   cp.setXY(5,5);
		   cp.setColor("RED");
		   System.out.println(cp.toString()+"입니다.");
		}
	  }