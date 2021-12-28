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
import org.comstudy21.saram.view.SearchByName;

public class R {
	public static int no;
	public static SaramVo saramVo;
	public static SaramVo[] saramArr;
	
	public static final SaramView searchByName = new SearchByName();
	
	public static final SaramView menuView = new MenuView();
	
	public static final SaramView insertView = new InsertView();
	public static final SaramView saramDelete = new SaramDelete();
	public static final SaramView saramDetail = new SaramDetail();
	public static final SaramView saramEdit = new SaramEdit();
	public static final SaramView saramListView = new SaramListView();
	
	public static final SaramController saramController = new SaramController();
}