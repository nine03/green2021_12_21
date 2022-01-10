package homework;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class calc extends JFrame{
	private JTextField display1,display2,display3;
	private JButton num[],operate[];
	private String name[]={"MC","MR","MS","M+","M-","←","CE","C","±","√","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
	private operateNum op1=new operateNum(),op2=new operateNum();// 操作数1,操作数2
	private storageField storage=new storageField();//存储区
	private String action="op1";// 表示要操作的对象  "op1"操作第一个操作数,"op2"操作第二个操作数
	private String sign="";// 运算符,默认为空
	private String screen1,screen2;
	private boolean Disable=false;
	
	private JMenuBar jmb;
	private JMenu jm_view,jm_edit,jm_help;
	private JLabel jla_input,jla_show;
	private JButton[] jb_oper = new JButton[28];
	
	
	
	public calc()
	{
		super("계산기");
		this.setLayout(null);
		this.setSize(240, 350);
		this.setResizable(false);
		JPanel jp=new JPanel(null);
		jp.setBounds(10,15,getWidth()-24,getHeight());
		jp.setBackground(new Color(217,228,241));
		this.getContentPane().setBackground(new Color(217,228,241));
		//显示屏
		
		//private void initMenu(){

			jmb = new JMenuBar();// 创建菜单条
			jm_view = new JMenu("보기(V)");// 查看菜单
			jm_view.setMnemonic('V');// 设置热键
			jm_edit = new JMenu("편집(E)");// 编辑菜单
			jm_edit.setMnemonic('E');
			jm_help = new JMenu("도음말(H)");// 帮助菜单
			jm_help.setMnemonic('H');
			jmb.add(jm_view);
			jmb.add(jm_edit);
			jmb.add(jm_help);
			this.setJMenuBar(jmb);// 将菜单条加入窗体中
		//	}
		
		display1=new JTextField("");
		display2=new JTextField("0");
		display3=new JTextField("");
		display1.setEnabled(false);
		display2.setEnabled(false);
		display3.setEnabled(false);
		display1.setBounds(0, 0, 204, 26);
		display2.setBounds(20, 20, 184, 34);
		display3.setBounds(0, 20, 20, 34);
		display1.setHorizontalAlignment(JLabel.RIGHT);
		display2.setHorizontalAlignment(JLabel.RIGHT);
		display3.setHorizontalAlignment(JLabel.CENTER);
		display1.setFont(new Font("宋体",Font.PLAIN,12));
		display2.setFont(new Font("宋体",Font.BOLD,20));
		display3.setFont(new Font("宋体",Font.PLAIN,20));
		display1.setDisabledTextColor(Color.BLACK);
		display2.setDisabledTextColor(Color.BLACK);
		display3.setDisabledTextColor(Color.BLACK);
		display1.setBorder(new LineBorder(new Color(242,247,252)));
		display2.setBorder(new LineBorder(new Color(242,247,252)));
		display3.setBorder(new LineBorder(new Color(242,247,252)));
		display1.setBackground(new Color(242,247,252));
		display2.setBackground(new Color(242,247,252));
		display3.setBackground(new Color(242,247,252));
		// 35px*29px 28个
		int i;
		operate=new JButton[28];
		// 前24个
		for(i=0;i<24;i++)
		{
			operate[i]=new JButton(name[i]);
			operate[i].setMargin(new java.awt.Insets(0,0,0,0)); 
			operate[i].setBounds(i%5*(35+7), 60+i/5*(29+5)+5, 35, 29);
			jp.add(operate[i]);
		}
		 // =号
		operate[i]=new JButton(name[i]);
		operate[i].setMargin(new java.awt.Insets(0,0,0,0)); 
		operate[i].setBounds(i%5*(35+7), 60+i/5*(29+5)+5, 35, 29*2+5);
		jp.add(operate[i]);
		i++;
		// 0号
		operate[i]=new JButton(name[i]);
		operate[i].setMargin(new java.awt.Insets(0,0,0,0)); 
		operate[i].setBounds(i%5*(35+7), 60+i/5*(29+5)+5, 35*2+7, 29);
		jp.add(operate[i]);
		// 前24个
		for(i=i+1;i<name.length;i++)
		{
			operate[i]=new JButton(name[i]);
			operate[i].setMargin(new java.awt.Insets(0,0,0,0)); 
			operate[i].setBounds((i+1)%5*(35+7), 60+i/5*(29+5)+5, 35, 29);
			jp.add(operate[i]);
		}
		
		
		 // 给按钮注册鼠标监听器,键盘监听器和背景
		 
		mouseAdapter ml=new mouseAdapter();
		keyAdapter kl=new keyAdapter();
		
		for(i=0;i<name.length;i++)
		{
			operate[i].addMouseListener(ml);
			operate[i].addKeyListener(kl);
			operate[i].setBackground(new Color(233,240,247));
			operate[i].setForeground(new Color(30,57,91));
		}
		jp.add(display1);
		jp.add(display2);
		jp.add(display3);
		jp.addKeyListener(kl);
		this.add(jp);
		this.setVisible(true);
	}
	class mouseAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent e)
		{
			
			JButton operate=(JButton)e.getSource();
			if(Disable)// 禁用按钮，点击C 恢复计算器
			{
				if(operate.getText()=="C")
				{	clear();
					Disable=false;
				}
				else
					return;
			}
			switch(operate.getText())
			{
			case "MC":mc();break;
			case "MR":mr();break;
			case "MS":ms();break;
			case "M+":mAdd();break;
			case "M-":mCut();break;
			case "←":cutEnd();break;
			case "CE":cutNum();break;
			case "C":clear();break;
			case "±":revolt();break;
			case "√":sqrt();break;
			case "7":
			case "8":
			case "9":
			case "4":
			case "5":
			case "6":
			case "3":
			case "2":
			case "1":
			case "0":read(Integer.parseInt(operate.getText()));break;// 将按键上的文本转化为Int型
			case "/":divide();break;
			case "%":mo();break;
			case "*":mul();break;
			case "1/x":inverted();break;
			case "-":cut();break;
			case "+":add();break;
			case "=":sum();break;
			case ".":dot();break;	
			}	
		}
		public void mouseEntered(MouseEvent e)
		{
			((JButton)e.getSource()).setBackground(new Color(255,211,113));
		}
		public void mouseExited(MouseEvent e)
		{
			((JButton)e.getSource()).setBackground(new Color(233,240,247));
		}
	}
	
	// MC  取消存储区,清空存储区数据
	
	public void mc()
	{	
		storage.storageNum=0;
		storage.storageMode=false;
		display3.setText(null);
	}
	
	 // MR 读取存储器存储的数据
	
	public void mr()
	{
		op1.value=storage.storageNum;
		screen2=""+op1.value;
		if(op1.value==Math.floor(op1.value))
			screen2=""+(int)op1.value;
		display2.setText(screen2);
		op1.clear=true;
	}
	
	 // MS 保存数据到存储器
	 
	public void ms()
	{
		storage.storageNum=op1.value;
		display3.setText("M");// 屏幕左下角显示M标志
	}
	
	 // M+ 已经储存的数加上当前计算结果并将和存入存储器
	 
	public void mAdd()
	{
		storage.storageNum=storage.storageNum+op1.value;		
	}
	
	 // M- 已经储存的数减去当前计算结果并将差存入存储器
	 
	public void mCut()
	{
		storage.storageNum=storage.storageNum-op1.value;	
	}
	
	 // 输入的数去掉尾数
	public void cutEnd()
	{
		if(action=="op1"&&op1.value!=0)// 表示对op1进行操作
		{
			if(op1.isFloat==false)// 如果op1为整数
			{
				op1.value=(int)op1.value/10;
				screen2=""+(int)op1.value;
			}
			else{// 如果op1为小数
				BigDecimal bd=new BigDecimal(op1.value);   
				op1.value=bd.setScale(--op1.dotWei,BigDecimal.ROUND_DOWN).doubleValue();
				screen2=""+op1.value;
				if(op1.dotWei==0)// 小数点后数位都去除掉后,变位整数,更新isFloat标记
					op1.isFloat=false;
			}
		}
		else if(action=="op2"&&op2.value!=0)// 表示对op2进行操作
		{
			if(op2.isFloat==false)// 如果op2位整数
			{
				op2.value=(int)op2.value/10;
				screen2=""+(int)op2.value;
			}
			else{// 如果op2为小数
				BigDecimal  bd=new BigDecimal(op2.value);   
				op2.value=bd.setScale(--op2.dotWei,BigDecimal.ROUND_DOWN ).doubleValue();
				screen2=""+op2.value;
				if(op2.dotWei==0)// 小数点后数位都去除掉后,变位整数,更新isFloat标记
					op2.isFloat=false;
			}
		}
		display2.setText(screen2);// 输出修改后的操作数
	}
	
	 // CE 清空当前操作数操作数
	public void cutNum()
	{
		if(action=="op1")
			op1.reset();
		else if(action=="op2")
			op2.reset();
		display2.setText("0");// 初始化显示屏2
	}
	
	 // C 归零 重置计算器
	public void clear()
	{
		op1.reset();
		op2.reset();
		// 初始化数据成员
		action="op1";
		sign="";
		// 初始化显示屏
		display1.setText("");
		display2.setText("0");
	}

	 // ± 正负号
	public void revolt()
	{
		if(action=="op1")
		{
			op1.value=-op1.value;
			screen2=""+op1.value;	
		}
		else if(action=="op2")
		{
			op2.value=-op2.value;
			screen2=""+op2.value;
		}
		display2.setText(screen2);
	}
	
	 // √ 根号
	public void sqrt()
	{
		double x;// 临时变量
		if(action=="op1")
		{
			op1.sqrtedString="sqrt("+op1.value+")";
			op1.value=Math.sqrt(op1.value);
			op1.isSqrted=true;
			x=op1.value;	
		}
		else
		{
			op2.sqrtedString="sqrt("+op2.value+")";
			op2.value=Math.sqrt(op2.value);
			op2.isSqrted=true;
			x=op2.value;
		}
		screen2=x+"";
		if(x==Math.floor(x))// 如果x为整数
		{
			screen2=(int)x+"";// 则将浮点数x先转化为int再转化成字符串
		}
		display2.setText(screen2);
		
	}
	
	 //按下数字键
	public void read(int value)
	{
		display2.setFont(new Font("宋体",Font.BOLD,20));// 默认字体大小
		display2.setText(null);// 清屏
		if(op1.clear==true)
			op1.reset();
		if(op2.clear==true)
			op2.reset();
		if(action=="op1")// 表示输数据给op1
		{	
			
			if(op1.isFloat==true)// 若op1为浮点数
			{
				int i=1;
				double num=value;
				++op1.dotWei;
				while(i<=op1.dotWei)
				{
					num*=0.1;
					i++;
				}
				op1.value=op1.value+num;// 将新的小数点位添加到操作数op1中
				// 因为双精度浮点数 其精度比较高,而我们只需取它的op1.dotWei保存
				op1.value=Double.parseDouble(String.format("%."+op1.dotWei+"f",op1.value));
				// 因为双精度浮点数 其精度比较高,而我们只需取它的op1.dotWei显示在屏幕上
				display2.setText(String.format("%."+op1.dotWei+"f", op1.value));
			}
			else// op1为整数
			{	
				op1.value=op1.value*10+value;// 将新的整数位加倒op1中
				display2.setText((int)op1.value+"");// 屏幕输出op1的值
			}
		}
		else if(action=="op2")// 表示输数据给op2
		{
			if(op2.isFloat==true)// 若op2为浮点数
			{
				int i=1;
				double num=value;
				++op2.dotWei;
				while(i<=op2.dotWei)
				{
					num*=0.1;
					i++;
				}
				op2.value=op2.value+num;// 将新的小数点位添加到操作数op2中
				// 因为双精度浮点数 其精度比较高,而我们只需取它的op2.dotWei保存
				op2.value=Double.parseDouble(String.format("%."+op2.dotWei+"f",op2.value));
				// 因为双精度浮点数 其精度比较高,而我们只需取它的op2.dotWei显示在屏幕上
				display2.setText(String.format("%."+op2.dotWei+"f", op2.value));
			}
			else// op2为整数
			{
				op2.value=op2.value*10+value;
				display2.setText((int)op2.value+"");
			}
			
		}
	}
	public void divide()
	{
		run("/");
	}
	public void mo()
	{
		run("%");
	}
	public void mul()
	{
		run("*");
	}
	// 1/x
	public void inverted()
	{
		double num;
		String str;
		if(action=="op1")
		{
			op1.invertedString="1/"+op1.value;// 1/x形式字符串
			op1.value=1/op1.value;
			op1.isInverted=true;
			num=op1.value;
		}
		else{
			op2.invertedString="1/"+op2.value;// 1/x形式字符串
			op2.value=1/op2.value;
			op1.isInverted=true;
			num=op2.value;
		}
		str=num+"";
		if(str.length()>=16)// 计算器屏幕所能显示数据的最大长度
		{
			display2.setFont(new Font("宋体",Font.BOLD,14));// 缩小字体输出
			display2.setText(str.substring(0, 16));	
		}
		else
			display2.setText(str);
	}
	public void cut()
	{
		run("-");
	}
	public void add()
	{
		run("+");
	}
	public void sum()
	{
		display2.setFont(new Font("宋体",Font.BOLD,20));
		int d1=op1.dotWei,d2=op2.dotWei,i;
		switch(sign)// 运算后 结果保存到op1中
		{ 	
			case "+":op1.value=op1.value+op2.value;break;
			case "-":op1.value=op1.value-op2.value;break;
			case "*":op1.value=op1.value*op2.value;break;
			case "/":op1.value=op1.value/op2.value;break;
			case "%":op1.value=op1.value%op2.value;break;
		}
		if(op2.value==0&&sign=="/")// 除数为0
		{
			Disable=true;
			display2.setText(op1.value+"");
			display1.setText(null);
			action="op1";
			return ;
		}
		if(op1.value==Math.floor(op1.value))// 结果为整数
		{
			display2.setText((int)op1.value+"");
			op1.dotWei=0;
			op1.isFloat=false;
		}
		else{// 结果为小数
			String str=op1.value+"";
			// 准确控制算术运算结果的精度，加，减，取模运算，小数点后的有效数字最多为max(d1,d2)位
			if(sign.equals("+")||sign.equals("-")||sign.equals("%"))
			{
				i=d1>d2?d1:d2;
				str=op1.value+"";
				str=str.substring(0, str.indexOf(".")+i+1);// 取i位输出
			}
			// 准确控制算术运算结果的精度，乘法运算，小数点后的有效数字最多为d1+d2位
			else if(sign.equals("*"))
			{
				i=d1+d2;
				BigDecimal bd=new BigDecimal(op1.value); 
				op1.value=bd.setScale(i,BigDecimal.ROUND_DOWN ).doubleValue();
				str=op1.value+"";// 更新修改后的str
			}
			// 结果超过显示数据的最大长度
			if(str.length()>=16)
			{
				display2.setFont(new Font("宋体",Font.BOLD,14));
				str=str.substring(0, 16);
			}
				display2.setText(str);
				op1.dotWei=str.length()-str.indexOf(".")-1;// 更新op1w值
		}		

		display1.setText(null);
		action="op1";
		op1.clear=true;// 开始新的表达式运算时，op1要先重置
		op2.clear=true;// 开始新的表达式运算时，op2要先重置
		sign="";
	}
	public void dot()
	{
		if(action=="op1")
			op1.isFloat=true;
		else
			op2.isFloat=true;
		display2.setText(display2.getText()+".");
	}
	public void run(String SIGN)
	{
		display2.setFont(new Font("宋体",Font.BOLD,20));
		action="op2";
		int d1=op1.dotWei,d2=op2.dotWei,i;
		if(!sign.equals(""))// 检测是否为以为表达式的第一运算
		{
			switch(sign) // 运算后 结果保存到op1中
			{
			case "+":op1.value=op1.value+op2.value;break;
			case "-":op1.value=op1.value-op2.value;break;
			case "*":op1.value=op1.value*op2.value;break;
			case "/":op1.value=op1.value/op2.value;break;
			case "%":op1.value=op1.value%op2.value;break;
			}
		}
		String temp=isSpecileHandle();
		if(temp==null)
			temp=display2.getText();// 先保存display2文本框里的数据
		if(op2.value==0&&sign=="/")// 除数为0
		{
			Disable=true;
			display2.setText(op1.value+"");
			display1.setText(display1.getText()+op1.value);
		}
		if(op1.value==Math.floor(op1.value))// 结果为整数
		{
			display2.setText((int)op1.value+"");
			op1.dotWei=0;
			op1.isFloat=false;
		}
		else{
			String str=op1.value+"";
			// 准确控制算术运算结果的精度，加，减，取模运算，小数点后的有效数字最多为max(d1,d2)位
			if(sign.equals("+")||sign.equals("-")||sign.equals("%"))
			{
				i=d1>d2?d1:d2;
				BigDecimal bd=new BigDecimal(op1.value); 
				op1.value=bd.setScale(i,BigDecimal.ROUND_DOWN ).doubleValue();
				str=op1.value+"";// 更新修改后的str
			}
			// 准确控制算术运算结果的精度，乘法运算，小数点后的有效数字最多为d1+d2位
			else if(sign.equals("*"))
			{
				i=d1+d2;
				BigDecimal bd=new BigDecimal(op1.value); 
				op1.value=bd.setScale(i,BigDecimal.ROUND_DOWN ).doubleValue();
				str=op1.value+"";// 更新修改后的str
			}
			// 结果超过显示数据的最大长度
			if(str.length()>=16)
			{
				display2.setFont(new Font("宋体",Font.BOLD,14));
				str=str.substring(0, 16);
			}
			display2.setText(str);
			op1.dotWei=str.length()-str.indexOf(".")-1;// 每次加完后,如果结果op1的值为小数则更新op1w的值	
		}		
		sign=SIGN;
		display1.setText(display1.getText()+temp+sign);
		op2.value=op1.value;// 运算后，操作数op2默认的值为op1的值	
		op2.clear=true;// 下一次键入数据，op2要重置
		op1.clear=false;// 下一次键入数据，op1不要重置
	}
	
	 // isSpecileHandle() 
	 // 操作数是否sqrt()或1/x过，
	 // 如果有，则返回"sqrt(x)"或"1/x"字符串
	
	public String isSpecileHandle()
	{
		String temp=null;
		if(op1.isSqrted)
		{
			temp=op1.sqrtedString;
			op1.isSqrted=false;
		}
		else if(op2.isSqrted)
		{
			temp=op2.sqrtedString;
			op2.isSqrted=false;
		}
		if(op1.isInverted)
		{
			temp=op1.invertedString;
			op1.isInverted=false;
		}
		else if(op2.isInverted)
		{
			temp=op2.invertedString;
			op2.isInverted=false;
		}
		return temp;
	}
	class keyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e)
		{
		
			int keycode=e.getKeyCode();
			if((keycode>=96&&keycode<=105)||(keycode>=48&&keycode<=57))//数字键
			{
				if(keycode>=96)
					keycode-=48;
				switch(keycode)
				{
				case 48:read(0);break;
				case 49:read(1);break;
				case 50:read(2);break;
				case 51:read(3);break;
				case 52:read(4);break;
				case 53:read(5);break;
				case 54:read(6);break;
				case 55:read(7);break;
				case 56:read(8);break;
				case 57:read(9);break;
				}
			}
			// 运算符键+ - * / =和. 以及退格键(* =号)
			else if((keycode==110||keycode==46)||(keycode==111||keycode==47)||(keycode==45||keycode==109)||keycode==107||keycode==106||keycode==61||keycode==10||keycode==8)
			{
				if((keycode==110||keycode==46))
					dot();
				else if(keycode==111||keycode==47)
					run("/");
				else if(keycode==45||keycode==109)
					run("-");
				else if(keycode==107)
					run("+");
				else if(keycode==106)
					run("*");
				else if(keycode==61||keycode==10)//=号
					sum();
				else if(keycode==8)
					cutEnd();
			}
		}
	}
	public static void main(String[] args) {
	
		calc app = new calc();
		
		
	}
}