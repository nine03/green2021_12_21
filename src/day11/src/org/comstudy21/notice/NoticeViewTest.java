package org.comstudy21.notice;

public class NoticeViewTest {
	public static ViewContainer vc = new ViewContainer();
	
		public static void main(String[] args) {
			vc.run(R.insertView);
			vc.run(R.noticeDelete);
			vc.run(R.noticeDetail);
			vc.run(R.noticeEdit);
			vc.run(R.noticeListView);
		}
}
