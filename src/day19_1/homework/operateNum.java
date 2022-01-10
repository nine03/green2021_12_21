package homework;

class operateNum {//操作数类
	public double value;//操作数的实际值
	public int dotWei;//操作数如果是小数,记录小数点后的位数
	public String invertedString;//1/x字符串
	public String sqrtedString;//sqrt(x)字符串
	public boolean isSqrted,isInverted;//做标记是否√,1/x过,用于后续判断
	public boolean clear;//clear为真表示是否重置操作数
	public boolean isFloat;//isFloat为真,表示操作数是小数
	public operateNum()
	{
		value=0;
		dotWei=0;
		sqrtedString=null;
		invertedString=null;
		isSqrted=false;
		isInverted=false;
		clear=false;
		isFloat=false;
	}
	public void reset()//重置操作数
	{
		value=0;
		dotWei=0;
		sqrtedString=null;
		invertedString=null;
		isSqrted=false;
		isInverted=false;
		clear=false;
		isFloat=false;
	}
}