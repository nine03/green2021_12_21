package day20.Ex06_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import day19.guiex.myframe.MyJFrame;

import static day20.Ex06_1.R.*;


public class TestJTable extends MyJFrame {
	
	public TestJTable() { 
		super("",640,480);
	}
	
	private void mkTableData() { 
		columnNames = new Vector();  
		columnNames.add("IDX");
		columnNames.add("NAME");
		columnNames.add("EMAIL");
		columnNames.add("PHONE");
		
		 
		data = dao.selectAll();
	}
	
	
	protected void displayLayer() {
		mkTableData();
		contentPan = getContentPane();
		
		contentPan.add(BorderLayout.WEST,new LeftPane()); 
		contentPan.add(BorderLayout.SOUTH,new BottomPane()); 
		
		
		tbModel = new DefaultTableModel(data,columnNames);
		table = new JTable(tbModel);
		scrollPane = new JScrollPane(table);  
		contentPan.add(scrollPane);
	}

	private void addRowDataTest() {
		tbModel.setDataVector(null, columnNames); 
		tbModel.addRow(new Object[] {4,"aaa","aaa@naver.com","010-4444-4444"} ); 
		tbModel.addRow(new Object[] {5,"bbb","bbb@naver.com","010-5555-5555"});
	}
	
	protected void actionEvent() {  
		
	      table.addMouseListener(new MouseListener() { 
	         public void mouseReleased(MouseEvent e) {}
	         public void mousePressed(MouseEvent e) {
	          
	            JTable tbl = (JTable)e.getSource();
	           
	            int totalCol = tbl.getColumnCount();
	            int totalRow = tbl.getRowCount();
	         
	           int row = table.getSelectedRow();
	           int col = table.getSelectedColumn();
	           int idx = (int)tbModel.getValueAt(row, 0);
	           
	           String name = (String)tbModel.getValueAt(row, 1);
	           String email = (String)tbModel.getValueAt(row, 2);
	           String phone = (String)tbModel.getValueAt(row, 3);
	           
	           txtFld1.setText("" + idx);
	           txtFld2.setText(name);
	           txtFld3.setText(email);
	           txtFld4.setText(phone);
	           
	         }
	         public void mouseExited(MouseEvent e) {}
	         public void mouseEntered(MouseEvent e) {}
	         public void mouseClicked(MouseEvent e) {}
	      });
	      
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> allBtn 클릭!");
				displayList();
			}
			private void displayList() {  
				tbModel.setDataVector(null, columnNames); 
				Vector<Vector> saramList = dao.selectAll();
				for(Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});
	
		inputBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(">>> inputBtn 클릭");
					String name = txtFld2.getText();
					txtFld2.setText("");
					String email = txtFld3.getText();
					txtFld3.setText("");
					String phone = txtFld4.getText();
					txtFld4.setText("");

				
					dao.insert(new SaramDto(0,name,email,phone));
					
					displayList(); 
				}

				private void displayList() {  
					tbModel.setDataVector(null, columnNames); 
					Vector<Vector> saramList = dao.selectAll();
					for(Vector vector : saramList) {
						tbModel.addRow(vector);
					}
				}
			});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(">>> searchBtn 클릭!");
				displayListOne();
			}
			protected void displayListOne() {
				tbModel.setDataVector(null, columnNames);
				Vector<Vector> saramList = dao.selectOne();
				for (Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});
		
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> modifyBtn 클릭!");
				
				int num = Integer.parseInt(txtFld1.getText());
				txtFld1.setText("");
				String name = txtFld2.getText();
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				dao.update(new SaramDto(num, name, email, phone));
				displayList();
			}
			private void displayList() {  
				tbModel.setDataVector(null, columnNames); 
				Vector<Vector> saramList = dao.selectAll();
				for(Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});
	
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> deleteBtn 클릭!");
				
				int num = Integer.parseInt(txtFld1.getText());
				txtFld1.setText("");
				txtFld2.setText("");
				txtFld3.setText("");
				txtFld4.setText("");
				
				dao.delete(new SaramDto(num, null, null, null));
				displayList();
			}
			private void displayList() {  
				tbModel.setDataVector(null, columnNames); 
				Vector<Vector> saramList = dao.selectAll();
				for(Vector vector : saramList) {
					tbModel.addRow(vector);
				}
			}
		});
		
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable.this,"굿바이~");
			
				dispose();
				System.exit(0);
			}
		});
	}
		
	public static void main(String[] args) {
		new TestJTable().setVisible(true);
	}

}
