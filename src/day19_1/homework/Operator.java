package homework;

public enum Operator {
	mC,mR,mS,mAdd,mSubtract,//mc,mr,ms,m+,m-
	clBack,clError,clClear,operNegation,operSqrt,//<-,ce,c,-/+,开平方
	n7,n8,n9,operDivide,operPer,// /,%,
	n4,n5,n6,operMultiply,operReciproc,//*,倒数
	n1,n2,n3,operSubtract,operEqu,//-,=
	n0,operDot,operAdd;//+
	
	public static final String [] labs = new String[]{
	"MC","MR","MS","M+","M-",
	"←","CE","C","±","√",
	"7","8","9","/","%",
	"4","5","6","*","1/x",
	"1","2","3","-","=",
	"0",".","+"
	};
}
