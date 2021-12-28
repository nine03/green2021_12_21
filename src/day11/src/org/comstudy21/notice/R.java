package org.comstudy21.notice;

import org.comstudy21.notice.controller.NoticeController;
import org.comstudy21.notice.model.NoticeVo;
import org.comstudy21.notice.view.InsertView;
import org.comstudy21.notice.view.ListOneView;
import org.comstudy21.notice.view.ListSelectView;
import org.comstudy21.notice.view.ListWordView;
import org.comstudy21.notice.view.MenuView;
import org.comstudy21.notice.view.NoticeDelete;
import org.comstudy21.notice.view.NoticeDetail;
import org.comstudy21.notice.view.NoticeEdit;
import org.comstudy21.notice.view.NoticeListView;
import org.comstudy21.notice.view.NoticeView;
import org.comstudy21.notice.view.SearchByUser;
import org.comstudy21.notice.view.SearchWordView;

public class R {
	public static int no;
	public static String word;
	public static int ListNum;
	public static NoticeVo noticeVo;
	public static NoticeVo[] noticeArr;
	
	public static final NoticeView searchByUser = new SearchByUser();
	
	public static final NoticeView menuView = new MenuView();
	
	public static final NoticeView insertView = new InsertView();
	public static final NoticeView noticeDetail = new NoticeDetail();
	public static final NoticeView noticeEdit = new NoticeEdit();
	public static final NoticeView noticeDelete = new NoticeDelete();
	public static final NoticeView noticeListView = new NoticeListView();
	
	public static final NoticeView searchWordView = new SearchWordView();
	public static final NoticeView listSelectView = new ListSelectView();
	public static final NoticeView listOneView = new ListOneView();
	public static final NoticeView listWordView = new ListWordView();
	
	public static final NoticeController noticeController = new NoticeController();
}
