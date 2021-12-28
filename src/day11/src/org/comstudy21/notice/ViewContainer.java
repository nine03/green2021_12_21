package org.comstudy21.notice;

import org.comstudy21.notice.view.NoticeView;

public class ViewContainer {
	public void run(NoticeView view) {
		System.out.println("------------------------------------------------------");
		view.display();
		System.out.println("------------------------------------------------------");
	}
}
