package homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import homework.Operator;
public class View extends JFrame implements ActionListener{
private JMenuBar jmb;
private JMenu jm_view,jm_edit,jm_help;
private JLabel jla_input,jla_show;
private JButton[] jb_oper = new JButton[28];

	public View(){
	
	initMenu();
	initContent();
	this.setTitle("计算器");//设置标题
	this.setResizable(false);//不可改变大小
	this.setLocationRelativeTo(null);//居中显示
	this.setSize(228, 324);//窗体大小，可以使用FastStone Capture的屏幕尺量一下win计算器的大小
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作
	}
	
	private void initMenu(){
	jmb = new JMenuBar();//创建菜单条
	jm_view = new JMenu("查看(V)");//查看菜单
	jm_view.setMnemonic('V');//设置热键
	jm_edit = new JMenu("编辑(E)");//编辑菜单
	jm_edit.setMnemonic('E');
	jm_help = new JMenu("帮助(H)");//帮助菜单
	jm_help.setMnemonic('H');
	jmb.add(jm_view);
	jmb.add(jm_edit);
	jmb.add(jm_help);
	this.setJMenuBar(jmb);//将菜单条加入窗体中
	}
	
	
	private void initContent(){
	
	//整个窗口区域
	
	JPanel jp = new JPanel();
	jp.setLayout(null);
	//显示框区域
	JPanel jptmp = new JPanel(){
	//获取背景图片，使用截图工具从win计算器显示框中截取2像素宽度作为背景
	Image bg = new ImageIcon("imgs/bg.png").getImage();
	
	@Override
	
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	//x轴平铺满面板
	for(int i = 0;i<this.getWidth();i+=bg.getWidth(this)){
	g.drawImage(bg, i, 0, this);//绘制背景图片
			}
		}
	};
	
	//设置显示框上方小字体
	
	Font font_lab = new Font("arial", Font.BOLD, 22);
	jla_input = new JLabel();
	jla_input.setText("0");
	//设置字体右对齐
	
	jla_input.setHorizontalAlignment(JLabel.RIGHT);
	jla_input.setFont(font_lab);
	//设置显示框中计算结果的字体
	
	font_lab = new Font("arial", Font.BOLD, 10);
	jla_show = new JLabel();
	jla_show.setText("sqrt");
	//设置字体右对齐
	jla_show.setHorizontalAlignment(JLabel.RIGHT);
	jla_show.setFont(font_lab);
	
	//设置显示框区域的位置的大小
	
	jptmp.setBounds(14, 15, 190, 50);
	jptmp.setLayout(new BorderLayout());
	jptmp.add(jla_show,BorderLayout.NORTH);
	jptmp.add(jla_input,BorderLayout.CENTER);
	
	//设置边框
	
	jptmp.setBorder(BorderFactory.createLineBorder(new Color(142,156,173)));
	jp.add(jptmp);
	jptmp = new JPanel();
	jptmp.setBounds(14, 72, 196,194);
	jptmp.setLayout(null);
	Font font_but = new Font("arial", Font.BOLD, 10);//创建按钮字体
	for (int i = 0; i < jb_oper.length; i++) {
	
	jb_oper[i] = new JButton(Operator.labs[i]);//设置按钮文字
	jb_oper[i].setForeground(new Color(30,57,91));//设置字体颜色
	jb_oper[i].setActionCommand(Operator.values()[i].toString());//设置按钮标示
	jb_oper[i].setFont(font_but);//设置按钮字体
	jb_oper[i].setBounds(i%5*(33+6), i/5*(24+6), 33, 24);//统一33宽,24高,间距6，每5个换一行
	jb_oper[i].setBorder(new LineBorder(new Color(135,151,170), 1));//设置按钮边框
	jb_oper[i].addActionListener(this);//添加监听器
	jptmp.add(jb_oper[i]);
	
	}
	
	jb_oper[24].setBounds(24%5*(33+6), 24/5*(24+6), 33, 24*2+6);//调整等号按钮位置
	jb_oper[25].setBounds(25%5*(33+6), 25/5*(24+6), 33*2+6, 24);//调整0按钮的位置
	jb_oper[26].setBounds(27%5*(33+6), 26/5*(24+6), 33, 24);//调整.按钮的位置
	jb_oper[27].setBounds(28%5*(33+6), 27/5*(24+6), 33, 24);//调整较好按钮的位置
	
	jp.add(jptmp);
	this.setLayout(new BorderLayout());
	this.add(jp,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
	new View().setVisible(true);
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
	//TODO 实现逻辑操作
	JButton jb = (JButton) e.getSource();
	   String commond = jb.getActionCommand();
		}
}