package day20.Ex06;

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

import static day20.Ex06.R.*;

// 잡스가 한말 도그마(dogma)에 빠지지 말라. (도그마)독단적인 신념이나 학설  
public class TestJTable extends MyJFrame {
	
	public TestJTable() { // 생성자 
		super("JTable 연습",640,480);
	}
	
	private void mkTableData() { // 데이터 두개준비  make table data
		columnNames = new Vector();  
		columnNames.add("IDX");
		columnNames.add("NAME");
		columnNames.add("EMAIL");
		columnNames.add("PHONE");
		
		// Object[][] 배열을 대체하는 코드 
		data = dao.selectAll();
	}
	// 호출이 안돼는 이유 데이터를 먼저 만들어줘야됌
	
	protected void displayLayer() {
		mkTableData();
		contentPan = getContentPane();
		
		contentPan.add(BorderLayout.WEST,new LeftPane()); // 패널 상속 받으면 된다 
		contentPan.add(BorderLayout.SOUTH,new BottomPane()); // BottomPane 
		
		// 모델 먼저 만들어라 
		tbModel = new DefaultTableModel(data,columnNames);
		table = new JTable(tbModel);// 데이블
		scrollPane = new JScrollPane(table); // 스크롤팬으로 따로 만들어줌 
		contentPan.add(scrollPane);
	}

	private void addRowDataTest() {
		tbModel.setDataVector(null, columnNames); // 데이터 지우기
		tbModel.addRow(new Object[] {4,"aaa","aaa@naver.com","010-4444-4444"} ); // 새로운 데이터 추가 
		tbModel.addRow(new Object[] {5,"bbb","bbb@naver.com","010-5555-5555"});
	}
	
	protected void actionEvent() {  
		// 테이블 이벤트 핸들러 추가
	      table.addMouseListener(new MouseListener() { // 마우스 리스너 사용
	         public void mouseReleased(MouseEvent e) {}
	         public void mousePressed(MouseEvent e) {
	           // System.out.println(">>> 마우스를 눌렀다");
	            JTable tbl = (JTable)e.getSource();
	            // 테이블의 전체 행과 열 알아내기
	            int totalCol = tbl.getColumnCount();
	            int totalRow = tbl.getRowCount();
	           // System.out.println(row + "," + col); // test용
	            // 선택한 컬럼의 행과 열 알아내기
	           int row = table.getSelectedRow();
	           int col = table.getSelectedColumn();
	           int idx = (int)tbModel.getValueAt(row, 0);
	           // 데이터 찾아오기
	           String name = (String)tbModel.getValueAt(row, 1);
	           String email = (String)tbModel.getValueAt(row, 2);
	           String phone = (String)tbModel.getValueAt(row, 3);
	           // System.out.println(row + "," + col); // test용
	           // System.out.println(data); // test용 
	           // System.out.println(idx + ", " + name + ", " + email +", "+ phone); // test용
	           
	           //찾아 온 데이터 적용하기 
	           txtFld1.setText("" + idx); // 문자열로 가져와야한다 형변환 
	           txtFld2.setText(name);
	           txtFld3.setText(email);
	           txtFld4.setText(phone);
	           
	         }
	         public void mouseExited(MouseEvent e) {}
	         public void mouseEntered(MouseEvent e) {}
	         public void mouseClicked(MouseEvent e) {}
	      });
	      
		
		// 버튼 이벤트 핸들러 추가
		// 버튼이 10개 이하면 이너클래스 만들어주는게 편하다
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> allBtn 클릭!");
			}
		});
	
		inputBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println(">>> inputBtn 클릭!");
					// textField의 데이터를 읽어온다.
					String name = txtFld2.getText();
					txtFld2.setText("");
					String email = txtFld3.getText();
					txtFld3.setText("");
					String phone = txtFld4.getText();
					txtFld4.setText("");

					// System.out.println("name => " + name); // test용
					// System.out.println("email => " + name); // test용
					// System.out.println("phone => " + name); // test용
					
					// DataTableModel에 반영 해 주기.
					// 이론 보다는 실기 -- 연습 
					// sequence 는 idx를 자동으로 올라가게해준다
					// 표에서 마우스를 누르면 데이터를 갖고오게하기  tableModel에서 data를 갖고오기 setText
					//tbModel.addRow(new Object[] {sequence++,name,email,phone}); // input 기능 구현  
					// tbModel.addRow();
					
					// dao에 저장후 
					dao.insert(new SaramDto(0,name,email,phone));
					// list를 다시 그려준다. 함수로 만들기 
					displayList(); 
				}

				private void displayList() { // list를 다시 그려준다. 함수로 만들기  
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
			}
		});
		
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> modifyBtn 클릭!");
			}
		});
	
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>> deleteBtn 클릭!");
			}
		});
		
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable.this,"굿바이~");
				//System.out.println(">>> finishBtn 클릭!");
				dispose();
				System.exit(0);
			}
		});
	}
		
	public static void main(String[] args) {
		new TestJTable().setVisible(true);
	}

}

// 자바는 나의 진리로 생명이고 나의 밥줄이다 
