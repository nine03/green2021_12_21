package ch1;

public class Player {
	  String name; // �������� �̸�
	    String word; // �ܾ�
	 
	    public Player() {}
	    public Player(String name) {
	        this.name = name;
	    }
	    
	    public void sayWord(String word) { // ����ڷκ��� �ܾ �Է¹޴� Ŭ����
	        this.word = word;
	    }
	    public Boolean succeed(String lastWord) { // �Է¹��� ���ڰ� ���̸� ��� �����̸� ����ڰ� ���ӿ��� ���Եȴ�. ��������
	        int lastIndex = lastWord.length() - 1;
	        char lastChar = lastWord.charAt(lastIndex);
	        char firstChar = word.charAt(0);
	        if(firstChar == lastChar) // ���� �ܾ��� �������� ����ڰ� �Է��� �ܾ��� ù��°�� ������ true Ʋ���� false ��ȯ�Ѵ�.
	            return true;
	        else
	            return false;
	    }
}
