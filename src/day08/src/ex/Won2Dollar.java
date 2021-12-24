package ex;
// 3번 문제 
class Won2Dollar extends Converter {
	   public Won2Dollar(double ratio) { 
		   this.ratio = ratio; 
		   }
	   protected double convert(double src) { 
		   return src/ratio; 
		   }
	   protected String getSrcString() { 
		   return "원"; 
		   }
	   protected String getDestString() { 
		   return "달러"; 
		   }
public static void main(String args[]) {
	   Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
	   toDollar.run();
	}
}