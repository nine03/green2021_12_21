package day23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyContentPanTest01 extends JPanel {
	JLabel label;
	public MyContentPanTest01() { // 생성자
		label = new JLabel("우리는 하나다!");
		Font font = new Font("궁서체",Font.ITALIC,48);
		label.setFont(font);
		this.add(label); 
		// 디폴트 배치관리자 는 레이아웃 
	}
}

class Airplan01 extends JPanel {
	Image img;
	String imagePath = "C:\\Users\\user\\eclipse-workspace\\YEONGJUN_KIM20211213\\java_work\\day23\\src\\airplan01.png";
	BufferedImage bfImg;
	public int x = 300,y = 300;
	 public JLabel imgLbl = null;
	 
	public  Airplan01() { // 내용을 바꾸고 싶으면 이렇게 다시 만들면된다 
		// img = Toolkit.getDefaultToolkit().getImage(imagePath); // 외부에서 뭐를 가져올려면 사용한다
		 // Graphic getGraphics(); // 그래픽 객체
		// 이미지나 그래픽 관련 메소드는 라이프사이클에 자동 실행 된다.
		// paint(), repaint(), paintComponent()
//		   try {
//		        // bfImg = ImageIO.read(this.getClass().getResource("airplan01.png"));
//			    
//		      } catch (IOException e) {
//		         e.printStackTrace();
//		      }// toolkit 안돠면 대체할수있는거 
			// ImageIcon imgIcon = new ImageIcon("src/day23/airplan01.png");
			 ImageIcon imgIcon  = new ImageIcon("Images/airplan01.png");
			// ImageIcon imgIcon = new ImageIcon(getClass().getResource("airplan01.png"));
			// 이미지 아이콘은 이미지가 아니다.
			img = imgIcon.getImage();
			// 이미지 아이콘을 옮길수있는데 라벨안에 있는 크기는 바꿀수없다 
			// 그래서 이미지 크기도 조정
			Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imgIcon = new ImageIcon(newImg);
			
			//setLayout(null); // 레이아웃을 했던것을 사라지게 한다 
			// JLabel()에 ImageIcon 객체 사용 가능.
			imgLbl = new JLabel(imgIcon);
			this.add(imgLbl);
			//imgLbl.setBounds(x,y,100,100);
			
		}
		// 일체 유심조 - 하면된다! 
	
	@Override
	protected void paintComponent(Graphics g) {
		// g.drawImage(bfImg,x,y,100,100,this);
	}
}

class Airplan02 extends JPanel implements Runnable {
	String imagePath = "Images/airplan02.png";
	Image img = null;
	ImageIcon imgIco = null;
	int x = 100, y = -100, w = 100, h = 100;
	MyCenterPan centerPan;
	Random rand = new Random();
	
	public Airplan02(MyCenterPan centerPan) {
		this.centerPan = centerPan;
		x = 100 + (int)rand.nextInt(500);
		imgIco = new ImageIcon(imagePath);
		img = imgIco.getImage();
		Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIco = new ImageIcon(newImg);
		add(new JLabel(imgIco));
		
		JLabel label = new JLabel(imgIco);
		this.add(label);
		
		movePlain();
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
				// 좌표를 변경하고 다시 그리기
				y += 10;
				
				if(y>=600) {
					y = -100;
					x = 100 + (int)rand.nextInt(500);
					this.setVisible(true);
				}
				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class AirplanStarterThread extends Thread {
	Airplan02[] airplan02;
	public AirplanStarterThread(Airplan02[] airplan02) {
		this.airplan02 = airplan02;
	}

	@Override
	public void run() {
		for(int i=0; i<airplan02.length; i++) {
			Thread th = new Thread(airplan02[i]);
			th.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Bulet extends JPanel implements Runnable { // 총알
	MyCenterPan centerPan;
	String imagePath = "Images/bulet.png";
	Image img = null;
	ImageIcon imgIco = null;
	int x=350, y = 400, w = 50, h = 70;
	public Bulet(MyCenterPan centerPan) {
		this.centerPan = centerPan;
		x = centerPan.x1 + 20;
		imgIco = new ImageIcon(imagePath);
		img = imgIco.getImage();
		Image newImg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		imgIco = new ImageIcon(newImg);
		add(new JLabel(imgIco));
		
		
	}

	public void movePlain() {
		this.setBounds(x, y, w, h);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(30);
				// 좌표를 변경하고 다시 그리기
				y -= 10;
				if(y < -100) {
					y = 400;
					x = centerPan.x1 + 20;
					this.setVisible(true);
				}
				movePlain();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class BuletStarterThread extends Thread {
	Bulet[] bulet = null;
	public BuletStarterThread(Bulet[] bulet) {
		this.bulet = bulet;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<bulet.length; i++) {
			Thread buletTh = new Thread(bulet[i]);
			buletTh.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//충돌검사 쓰레드
class BuletbaamThread extends Thread{
	MyCenterPan contentpan;
	public BuletbaamThread(MyCenterPan contentpan) {
		this.contentpan = contentpan;
	}
	@Override
	public void run() {
		Airplan02[] a2Arr = contentpan.airplan02;
		Bulet[] bArr = contentpan.bulet;
		
		while(true) {
			for(int i =0; i<a2Arr.length; i++) {
				int x = a2Arr[i].x;
				int xw = a2Arr[i].x+a2Arr[i].w;
				int y = a2Arr[i].y;
				int yh = a2Arr[i].y+a2Arr[i].h;
				
				for(int j = 0; j<bArr.length; j++) {
					int bx = bArr[j].x;
					int bxw = bArr[j].x+bArr[j].w/2;
					int byh = bArr[j].y+bArr[j].h/2;
					int by = bArr[j].y;
					
					if((bxw>=x)&&(bxw<=xw)&&(byh<=yh)&&(byh>=y)) {
						a2Arr[i].setVisible(false);
						a2Arr[i].y = -100;
						bArr[j].setVisible(false);
					}
				}
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class MyCenterPan extends JPanel { // MyCenterPan  게임화면 
int x1 = 350, y1 = 400, w1 = 100, h1 = 100;
	
	public Airplan01 airplan01 = new Airplan01();
	public Airplan02[] airplan02 = new Airplan02[10];
	public Bulet[] bulet = new Bulet[7];

	public MyCenterPan() {
		setLayout(null);
		add(airplan01);
		
		
		airplan01.setBounds(x1, y1, w1, h1);
		
		for(int i=0; i<airplan02.length; i++) {
			airplan02[i] = new Airplan02(this);
			add(airplan02[i]);
			airplan02[i].movePlain();
			Thread airplai02th = new Thread(airplan02[i]);
		}
		
		for(int i=0; i<bulet.length; i++) {
			bulet[i] = new Bulet(this);
			add(bulet[i]);
		}
		
		AirplanStarterThread starter = new AirplanStarterThread(airplan02);
		starter.start();
		
		BuletStarterThread buletStarter = new BuletStarterThread(bulet);
		buletStarter.start();
		
		BuletbaamThread baam = new BuletbaamThread(this);
		baam.start();
	}
	   
	public void airplan01MoveLeft() {
		x1 -= 10;
		airplan01.setBounds(x1, y1, w1, h1);
	}

	public void airplan01MoveRight() {
		x1 += 10;
		airplan01.setBounds(x1, y1, w1, h1);
	}
}



class MyContentPan extends JPanel {
	MyCenterPan centerPan = new MyCenterPan();
	JButton leftBtn = new JButton("Left");
	JButton rightBtn = new JButton("Right");
	
	public MyContentPan() {
		setBackground(Color.PINK);
		layoutComponent();
		actionEvent();
	}

	private void actionEvent() {
		leftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 버튼을 누르면 비행기가 화면의 좌측으로 이동한다.
				centerPan.x1 -= 10;
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w1, centerPan.h1);
		        repaint(); // 해당 콤포넌트의 화면을 다시 그린다.

			}
		});
		
		rightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 // 버튼을 누르면 비행기가 화면의 우측으로 이동한다.
				centerPan.x1 += 10;
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w1, centerPan.h1);
	            repaint(); // 해당 콤포넌트의 화면을 다시 그린다.

			}
		});
		
		// 총알이랑 비행기 움직일수있게 
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				System.out.println(keyCode);
				if(keyCode == KeyEvent.VK_LEFT) {
					// 버튼을 누르면 비행기가 화면의 좌측으로 이동
					centerPan.x1 -= 10;
		               repaint(); // 해당 컴퍼넌트의 화면을 다시 그린다.
				} else if(keyCode == KeyEvent.VK_RIGHT) {
					// 버튼을 누르면 비행기가 화면의 우측으로 이동
					centerPan.x1 += 10;
		               repaint();  // 해당 컴퍼넌트의 화면을 다시 그린다.
				} else if(keyCode == KeyEvent.VK_UP) {
					centerPan.y1 -= 10;
		               repaint(); 
				} else if (keyCode == KeyEvent.VK_DOWN) {
					centerPan.y1 += 10;
		               repaint(); 
				}
				centerPan.airplan01.setBounds(centerPan.x1, centerPan.y1, centerPan.w1, centerPan.h1);
				repaint();
			}
		}); 
		
		// Focus를 읽을수 있도록 설정 한다.
		this.setFocusable(true);
		this.requestFocus();
	}

	private void layoutComponent() {
		setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH,new JLabel("미사일로 비행기 맞추기 게임 - 방향키로 비행기 조정"));
		this.add(centerPan);
		JPanel bottomPan = new JPanel(new FlowLayout());
		bottomPan.add(leftBtn);
		bottomPan.add(rightBtn);
		this.add(BorderLayout.SOUTH,bottomPan);
		
	}
}

public class Day23Ex01ImgIO extends JFrame {
	
	Container contentPan;
	
	public Day23Ex01ImgIO() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("이미지 불러오기 실습");
		setSize(800,600);
		
		// contentPan = getContentPane();
		MyContentPan myContentPan = new MyContentPan();
		setContentPane(myContentPan);
	}
	
	
	public static void main(String[] args) {
		new Day23Ex01ImgIO().setVisible(true);

	}

}
