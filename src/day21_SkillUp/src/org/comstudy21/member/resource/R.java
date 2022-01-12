package org.comstudy21.member.resource;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import org.comstudy21.member.controller.Controller;
import org.comstudy21.member.controller.DeleteController;
import org.comstudy21.member.controller.EndController;
import org.comstudy21.member.controller.InputController;
import org.comstudy21.member.controller.ListController;
import org.comstudy21.member.controller.MenuController;
import org.comstudy21.member.controller.ModifyController;
import org.comstudy21.member.controller.SearchController;
import org.comstudy21.member.model.MemberDAO;
import org.comstudy21.member.view.Delete;
import org.comstudy21.member.view.End;
import org.comstudy21.member.view.Input;
import org.comstudy21.member.view.List;
import org.comstudy21.member.view.MainActivity;
import org.comstudy21.member.view.MemberView;
import org.comstudy21.member.view.Menu;
import org.comstudy21.member.view.Modify;
import org.comstudy21.member.view.Search;

public class R {
	// title of view pages 뷰페이지의 제목 
	// 문자열 열고 매번 고칠필요가 없다 R에서만 관리하면된다.
	public static final String titleInput = "::: 입력 기능 :::"; // 외부에서 R로 접근할수 있도록
	public static final String titleList = "::: 회원 목록 :::"; 
	public static final String titleSearch = "::: 검색 기능 :::"; 
	public static final String titleModify = "::: 수정 기능 :::"; 
	public static final String titleDelete = "::: 삭제 기능 :::"; 
	public static final String titleEnd = "::: 프로그램 종료 :::"; 
	public static final String titleApp = "::: 회원관리 프로그램 :::"; 
	public static final String titleMenu = "::: 회원관리 프로그램 :::";
	
	
	public static final Scanner scan = new Scanner(System.in);  // 전체적으로 사용할 스캔
	
	public static final MemberView input = new Input();
	public static final MemberView list = new List();
	public static final MemberView search = new Search();
	public static final MemberView modify = new Modify();
	public static final MemberView delete = new Delete();
	public static final MemberView end = new End();
	public static final MemberView menu = new Menu();
	
	// 메인 엑티비티 
	public static final MainActivity mainActivity = new MainActivity(); // 실행은 메인 엑티비에서 
	
	public static final MemberDAO memDao = new MemberDAO();
	
	public static final Hashtable<Integer, Controller> ctrlMapper = 
			new Hashtable<Integer, Controller>();
	
	public static final int MENU = 0, INPUT = 1, LIST = 2, SEARCH =3, MODIFY= 4, DELETE=5, END=6;
	
	static { // 초기화블럭
		ctrlMapper.put(MENU, new MenuController()); // 앞에 input 으로 적으면 관리하기 불편한다 상수로 저장해줘야한다
		ctrlMapper.put(INPUT, new InputController());
		ctrlMapper.put(LIST, new ListController());
		ctrlMapper.put(SEARCH, new SearchController());
		ctrlMapper.put(MODIFY, new ModifyController());
		ctrlMapper.put(DELETE, new DeleteController());
		ctrlMapper.put(END, new EndController());
	}
	
	public static int no = 0;
	
	// 다목적으로 데이터들이 바인딩 되도록 준비.
	public static final HashMap<String, Object> request = 
			new HashMap<String, Object>(); 
}
