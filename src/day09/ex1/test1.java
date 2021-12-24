package ex1;

import java.util.Scanner;

class Music{
	// 가수, 노래
	private String type;
	private String song;
	
	public Music(String type, String song) {
		this.type = type;
		this.song = song;
	}
	
	public void play() {
		System.out.printf("%s type의 %s가 실행됩니다.\n",type,song);
	}
	
	public String getSong() {
		return song;
	}
}

class DanceMusic extends Music{
	private String name;
	
	public DanceMusic(String type, String song, String name) {
		super(type, song);
		this.name = name;
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		super.play();
		System.out.printf("가수는 %s입니다.\n",name);
	}
}

class NCSMusic extends Music{
	
	public NCSMusic(String type, String song) {
		super(type, song);
	}
	
	@Override
	public void play() {
		super.play();
		System.out.println("No Copyright sound!");
	}
	
}
class MusicPlayer{
	private Music[] musicList = new Music[12];
	private int top = 0;
	
	// 음악 추가
	public void appendMusic(Music[] music) {
		System.out.println("어떤 음악을 추시겠습니까 ? 1.DanceMusic 2.NCSMusic");
		System.out.print(" >> ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 : 
			System.out.println("DanceMusic을 선택하셨습니다");
			System.out.println("노래 type과 이름, 가수를 입력해 주세요");
			String type = sc.next();
			String song = sc.next();
			String name = sc.next();
			music[top++] = new DanceMusic(type, song, name);
			System.out.println("음악이 추가 되었습니다.");
			break;
		case 2:
			System.out.println("NCSMusic을 선택하셨습니다");
			System.out.println("노래 type과 이름을 입력해 주세요");
			type = sc.next();
			song = sc.next();
			music[top++] = new NCSMusic(type, song);
			System.out.println("음악이 추가 되었습니다.");
			break;
		default: System.out.println("잘못입력하셨습니다");
		}
		menu();
	}
	
	// 음악 제거
	public void removeMusic() {
		int index = -1;
		System.out.print("삭제할 음악을 입력해 주세요 >> ");
		String song = sc.next();
		index = searchIndex(song);
		System.out.println(index);
		if(index != -1 ) {
			if(index != top-1) {
				for(int j= index; j<top-1; j++) {
					musicList[j] = musicList[j+1];
				}
				musicList[top-1] = null;
				top--;
			System.out.printf("\"%s\"가 리스트에서 삭제되었습니다. \n",song);
			}
			else {
				musicList[index] = null;
				System.out.printf("\"%s\"가 리스트에서 삭제되었습니다. \n",song);
				top--;
			}	
		}else {
			System.out.printf("\"%s\"은 리스트에 없습니다.\n ",song);
		}
		menu();
	}
	
	// 검색된 음악 실행
	public void findMusic() {
		int index = -1;
		System.out.print("재생할 음악의 이름을 입력해 주세요 >> ");
		String songName = sc.next();
		index = searchIndex(songName);
		if(index !=-1) {
			musicList[index].play();			
		}else {
			System.out.printf("\"%s\"는 리스트에 없습니다.\n",songName);
		}
		menu();
	}
	
	// 모든 음악 실행
	public void playAllMusic(Music[] List) {
		for(Music p : List) {
			if(p == null) {
				break;
			}
			p.play();
		}
		menu();
	}
	
	Scanner sc = new Scanner(System.in);
	// 메뉴
	public void menu() {
		int index = -1;
		String song = "";
		System.out.println("1.추가 2.전체곡실행 3.선택곡 실행 4.삭제 5.종료");
		System.out.print("선택 >> ");
		int num = sc.nextInt();
		switch(num) {
		case 1: 
			appendMusic(musicList); 
			break;
		case 2: playAllMusic(musicList); 
			break;
		case 3: 
			
			findMusic(); 
			break;
		case 4: 
			removeMusic();
			break;
		case 5:	System.exit(0);
		
		}
	}
	
	public int searchIndex(String songName) {
		int index = -1;
		for(int i =0; i<top; i++) {
			if(songName.equals(musicList[i].getSong())) {
				index = i;
			}
		}
		return index;
	}
}


public class test1 {

	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer();
		mp.menu();
	}
}