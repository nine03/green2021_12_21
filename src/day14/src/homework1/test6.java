package homework1;

import java.util.*;

// 6번 문제
class Location{
    String city, g, w;
    Location(String city, String g, String w){
        this.city = city;
        this.g = g;
        this.w = w;
    }
    public String get_city() {
        return city;
    }
    public String get_g() {
        return g;
    }
    public String get_w() {
        return w;
    }
    public void find_city(String city) {
        if(city.equals(this.city))
        System.out.println(get_city() + " " + get_g() + " " + get_w());
    }
}
public class test6 {
 
    public static void main(String[] args) {
        HashMap<String,Location> map= new HashMap<String,Location>();
        Scanner scanner = new Scanner(System.in);
        Location[] loc = new Location[4];
        System.out.println("도시,경도,위도를 입력하세요");
        for(int i = 0; i < 4; i++) {
            System.out.print(">>");
            String text = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(text,",");
            String city = st.nextToken().trim();
            String g = st.nextToken().trim();
            String w = st.nextToken().trim();
            loc[i] = new Location(city, g, w);
            map.put(city,loc[i]);
        }
        System.out.println("------------------------");
        for(int i = 0; i<4; i++)
            System.out.println(loc[i].get_city()+" "+loc[i].get_g()+" "+loc[i].get_w());
        
        System.out.println("------------------------");
        String city = null;
        while(true){
            try {
            System.out.print("도시이름>>");
             city = scanner.next();
            if(city.equals("그만"))
                break;
            Location l = map.get(city);
            l.find_city(city);}
            
        
        catch(java.lang.NullPointerException e) {
            System.out.println(city+"는 없습니다.");
        	}
        }
    }
}
