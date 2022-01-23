package project.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main {

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
	        
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("bgnde", "UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("endde", "UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=TSCYgkMUJNavMzzHkbBTAvLHLaj1RrxOpBZ6BGHm49jIZIs%2FWtYi41K96uUEnIDmbtL7F7x900D14CVoDKpsNA%3D%3D\n"); /*Service Key*/
	        // URL 객체 생성.
	        URL url = new URL(urlBuilder.toString());
	        // 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        // 통신을 위한 메소드 SET.
	        con.setRequestMethod("GET");
	        con.setRequestProperty("Content-type", "application/json");
	        // 현재 URL에 대한 HTTP 응답 상태 코드 저장
	        int status = con.getResponseCode();
	        // 전달받은 데이터를 BufferedReader 객체로 저장.
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        StringBuilder inputBuilder = new StringBuilder();
	        String inputLine = null;
	        
	        // BufferedReader로 전달받은 데이터를 JSONObject로 저장하기 위해 StringBuilder로 받아옴
	        while ((inputLine = in.readLine()) != null) {
	            inputBuilder.append(inputLine);
	        }
	        
	        in.close();
	        con.disconnect();
	        // HTTP 응답 상태 확인
	        System.out.println("Response status: " + status);
	        
	        // XML로 받아온 api를 String형태로 만들어 JSONObject화 시킴
	        JSONObject xmlJSONObj = XML.toJSONObject(inputBuilder.toString());
	        
	        // 키와 값으로 이루어진 API이기에 키값으로 item을 쓰기 위해선 경로를 찾아줘야함
	        // 따라서 아래와 같이 response의 값을 responseVal에 담고 그 안에있는 body의 값을
	        // 다시 bodyVal로 받음 이렇게 경로를 찾아준 뒤
	        JSONObject responseVal = xmlJSONObj.getJSONObject("response");
	        JSONObject bodyVal = responseVal.getJSONObject("body");
	        JSONObject items = bodyVal.getJSONObject("items");
	        
	        // JSONArray를 활용하여 배열로 만듦
	        JSONArray itemArr = (JSONArray) items.get("item");
	        
	        System.out.println("도 입력");
	        doS = sc.next();
	        System.out.println("시 입력");
	        siS = sc.next();
	        System.out.println("품종 입력");
	        kindS = sc.next();
	        
	        for (int i = 0; i < itemArr.length(); i++) {
	            animal = (JSONObject) itemArr.get(i);
	            inputView(animal);
	            
	            StringTokenizer st1 = new StringTokenizer(orgNm, " ");
	                doN = st1.nextToken();
	                
	           StringTokenizer st2 = new StringTokenizer(orgNm, " ");
	              siN = st2.nextToken();

	                
	           // System.out.println("siN = " + siN);
	           // System.out.println("doN = " + doN);
	            if (doS.equals(doN) && siS.equals(siN)){
	            	
	                sidoSearch();
	            } else if (doS == null && siS.equals(siN)) {
	            	
	                siSearch();
	            }else if (doS.equals(doN) && siS == null){
	                doSearch();
	            }
	            kind();
	        }
	            
		}
	public static void siSearch() {
        System.out.println(happenDt);
        System.out.println(happenPlace);
        System.out.println(kindCd);
        System.out.println(popfile);
        System.out.println(sexCd);
        System.out.println(processState);
        System.out.println(specialMark);
        System.out.println(orgNm);
    }
    
    public static void doSearch() {
        System.out.println(happenDt);
        System.out.println(happenPlace);
        System.out.println(kindCd);
        System.out.println(popfile);
        System.out.println(sexCd);
        System.out.println(processState);
        System.out.println(specialMark);
        System.out.println(orgNm);
    }
    
    public static void sidoSearch() {
        System.out.println(happenDt);
        System.out.println(happenPlace);
        System.out.println(kindCd);
        System.out.println(popfile);
        System.out.println(sexCd);
        System.out.println(processState);
        System.out.println(specialMark);
        System.out.println(orgNm);
    }
    
    public static void inputView(JSONObject animal) {
        happenDt = (int) animal.get("happenDt");   // 접수일
        happenPlace = (String) animal.get("happenPlace");    // 발견장소
        kindCd = (String) animal.get("kindCd");  // 품종 & 종류
        popfile = (String) animal.get("popfile");    // 이미지
        sexCd = (String) animal.get("sexCd");    // 성별
        processState = (String) animal.get("processState");  // 상태
        specialMark = (String) animal.get("specialMark");    // 특징
        orgNm = (String) animal.get("orgNm");    // 시, 군 주소
        
    }
    
    public static void kind(){
        if (kindCd.indexOf(kindS) != -1){
            System.out.println(happenDt);
            System.out.println(happenPlace);
            System.out.println(kindCd);
            System.out.println(popfile);
            System.out.println(sexCd);
            System.out.println(processState);
            System.out.println(specialMark);
            System.out.println(orgNm);
        }
    }
}
