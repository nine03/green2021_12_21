package ch1;

public class Player {
	  String name; // 참가자의 이름
	    String word; // 단어
	 
	    public Player() {}
	    public Player(String name) {
	        this.name = name;
	    }
	    
	    public void sayWord(String word) { // 사용자로부터 단어를 입력받는 클래스
	        this.word = word;
	    }
	    public Boolean succeed(String lastWord) { // 입력받은 문자가 참이면 계속 거짓이면 사용자가 게임에서 지게된다. 게임종료
	        int lastIndex = lastWord.length() - 1;
	        char lastChar = lastWord.charAt(lastIndex);
	        char firstChar = word.charAt(0);
	        if(firstChar == lastChar) // 이전 단어의 마지막과 사용자가 입력한 단어의 첫번째가 맞으면 true 틀리면 false 반환한다.
	            return true;
	        else
	            return false;
	    }
}
