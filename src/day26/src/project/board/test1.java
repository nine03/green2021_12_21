package project.board;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

public class test1 {
	static int happenDt = 0;
    static String happenPlace = null;
    static String kindCd = null;
    static String popfile = null;
    static String sexCd = null;
    static String processState = null;
    static String specialMark = null;
    static String orgNm = null;
    static String siS = null;
    static String doS = null;
    static String siN = null;
    static String doN = null;
    static Scanner sc = new Scanner(System.in);
    static JSONObject animal = null;
    static String kindS = null;
    static JSONArray sArr = null;
    
    public static void main(String[] args) throws IOException {
    	String startDt = sc.next();
		String endDt = sc.next();
		
		 System.out.println("한 페이지의 결과 수 입력");
        String numOfRows = sc.next();
        System.out.println("페이지 입력");
        String pageNo = sc.next();
        
    	// 1. URL을 만들기 위한 StringBuilder.
    	  StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("bgnde", "UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=TSCYgkMUJNavMzzHkbBTAvLHLaj1RrxOpBZ6BGHm49jIZIs%2FWtYi41K96uUEnIDmbtL7F7x900D14CVoDKpsNA%3D%3D\n"); /*Service Key*/
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET.
        conn.setRequestMethod("GET");
        // 6. 통신을 위한 Content-type SET. 
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
        // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 10. 객체 해제.
        rd.close();
        conn.disconnect();
        // 11. 전달받은 데이터 확인.
        System.out.println(sb.toString());
    }
}