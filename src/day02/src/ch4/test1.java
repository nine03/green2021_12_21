package ch4;

class Rectangle{
	   private int x;
	   private int y;
	   private int width;
	   private int height;
	   Rectangle(int x,int y,int width,int height){
	      this.x = x;
	      this.y = y;
	      this.width = width;
	      this.height = height;
	   }
	   int square() {
	      return (width *height);
	   }
	   void show() {
	      System.out.println("("+x+","+y+")에서 크기가 "+width+"X"+height+"인 사각형");
	      return;
	   }
	   boolean contains(Rectangle r) {
	      if(x < r.x && y < r.y) {// main 에서 현 사각형이 t, t와 r을 비교한다. 
	         if((width + x) > (r.x + r.width) && (height + y)>(r.y + r.height)) {
	            return true;
	            
	         }
	      }
	      return false;
	   }
	}


public class test1 {

	public static void main(String[] args) {
		 Rectangle r = new Rectangle(2,2,8,7);
	      Rectangle s = new Rectangle(5,5,6,6);
	      Rectangle t = new Rectangle(1,1,10,10);
	      r.show();
	      System.out.println("s의 면적은 "+ s.square());
	      if(t.contains(r))System.out.println("t는 r을 포함합니다.");
	      if(t.contains(s))System.out.println("t는 s을 포함합니다.");

	}

}
