package ch1;

class Song {
	   private String title;
	   private String artist;
	   private int year;
	   private String country;
	   Song() {
	      this("title","artist",0000,"country");
	   }
	   Song(String title, String artist, int year, String country) {
	      this.title = title;
	      this.artist = artist;
	      this.year = year;
	      this.country = country;
	   }
	   public void show() {
	      System.out.println(year+"�� "+country+"������ "+artist+"�� �θ� "+title);
	   }
	}

public class �� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Song song = new Song("Dancing Queen","ABBA",1978,"������");
	     song.show();
	}

}
