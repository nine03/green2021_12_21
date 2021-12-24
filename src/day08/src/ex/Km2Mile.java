package ex;

// 4번 문제
class Km2Mile extends Converter {
	   public Km2Mile(double ratio) { 
		   this.ratio = ratio; 
		   }
	   protected double convert(double src) { 
		   return src/ratio; 
		   }
	   protected String getSrcString() { 
		   return "Km"; 
		   }
	   protected String getDestString() { 
		   return "mile"; 
		   }
	   
public static void main(String args[]) {
	   Km2Mile toMile = new Km2Mile(1.6); // 1마일은 1.6km
	   toMile.run();
	}
}