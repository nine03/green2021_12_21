package day20.Ex06;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class R { // 리소스를 보관하는곳 
	public static JTable table;
	public static DefaultTableModel tbModel;
	public static JScrollPane scrollPane;
	
	public static Vector<Vector> data;
	public static Vector<String> columnNames;
	
	public static final JTextField txtFld1 = new JTextField(6);
	public static final JTextField txtFld2 = new JTextField(6);
	public static final JTextField txtFld3 = new JTextField(6);
	public static final JTextField txtFld4 = new JTextField(6);
	
	public static final JButton allBtn = new JButton("All"); // 나중에 리소스 보관하는곳으로 옴겨줘야한다 
	public static final JButton inputBtn = new JButton("Input");
	public static final JButton searchBtn = new JButton("Search");
	public static final JButton modifyBtn = new JButton("Modify");
	public static final JButton deleteBtn = new JButton("Delete");
	public static final JButton finishBtn = new JButton("Finish");
	
	//public static int sequence = 4; // sequence 에 4를 넣음 
	
	public static final SaramDao dao = new SaramDao();
	
}
