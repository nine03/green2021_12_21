package day20.Ex06_1;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class R { 
	public static JTable table;
	public static DefaultTableModel tbModel;
	public static JScrollPane scrollPane;
	
	public static Vector<Vector> data;
	public static Vector<String> columnNames;
	
	public static final JTextField txtFld1 = new JTextField(6);
	public static final JTextField txtFld2 = new JTextField(6);
	public static final JTextField txtFld3 = new JTextField(6);
	public static final JTextField txtFld4 = new JTextField(6);
	public static final JTextField txtFld5 = new JTextField(6);
	public static final JTextField txtFld6 = new JTextField(6);
	
	
	
	public static final ButtonGroup bg = new ButtonGroup();
	public static JRadioButton jrb1 = new JRadioButton("회원", true);
	public static JRadioButton jrb2 = new JRadioButton("비회원", false);

		
	public static final JCheckBox man = new JCheckBox("남자");
	public static final JCheckBox female = new JCheckBox("여자");
		
	public static ImageIcon imageIcon = new ImageIcon("images/1.jpg");
	public static Image image = imageIcon.getImage(); 
	public static Image newimg = image.getScaledInstance(60,30, Image.SCALE_SMOOTH);
	public static ImageIcon imageIcon02 = new ImageIcon(newimg); 
	
 // public static final JButton allBtn = new JButton(new ImageIcon(newimg));	
	public static final JButton allBtn = new JButton("전체보기");  
	public static final JButton inputBtn = new JButton("추가");
	public static final JButton searchBtn = new JButton("검색");
	public static final JButton modifyBtn = new JButton("수정");
	public static final JButton deleteBtn = new JButton("삭제");
	public static final JButton finishBtn = new JButton("끝내기");
		
//	String[] location = {"평안도", "함경도", "강원도", "황해도", "경기도", "충청도", "경상도", "전라도", "제주도"};
//	JComboBox<String> comboList = new JComboBox<String>(location);

	public static final SaramDao dao = new SaramDao();
	
}
