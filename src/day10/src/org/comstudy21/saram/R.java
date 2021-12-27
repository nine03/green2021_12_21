package org.comstudy21.saram;

import org.comstudy21.saram.controller.SaramController;
import org.comstudy21.saram.model.SaramVo;
import org.comstudy21.saram.view.InsertView;
import org.comstudy21.saram.view.MenuView;
import org.comstudy21.saram.view.SaramDelete;
import org.comstudy21.saram.view.SaramDetail;
import org.comstudy21.saram.view.SaramEdit;
import org.comstudy21.saram.view.SaramListView;
import org.comstudy21.saram.view.SaramView;

public class R {  // 데이터 바인딩 위한 클래스 R
	public static int no; // menu 선택값 no 
	public static SaramVo saramVo;
	public static SaramVo[] saramArr;
	
	
	public static final int SEARCH = 0; // 검색
	public static final int DEDAIL = 1; // 상세 정보 
	public static int type = 0;
	
	public static final SaramView menuView = new MenuView();
	
	public static final SaramView insertView = new InsertView();
	public static final SaramView saramDelete = new SaramDelete();
	public static final SaramView saramDetail = new SaramDetail();
	public static final SaramView saramEdit = new SaramEdit();
	public static final SaramView saramListView = new SaramListView();
	
	public static final SaramController saramController = new SaramController();
}