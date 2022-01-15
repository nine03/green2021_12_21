package org.comstudy21.myapp.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.comstudy21.myapp.controller.AppendController;
import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.DeleteController;
import org.comstudy21.myapp.controller.ResetController;
import org.comstudy21.myapp.controller.SearchController;
import org.comstudy21.myapp.controller.SelectController;
import org.comstudy21.myapp.resource.R;
import org.comstudy21.myapp.view.BtnView;

public class BtnEvtHandler implements ActionListener, R {
	BtnView target;
	public BtnEvtHandler(BtnView target) {
		ctrlMap.put(btnAll, new SelectController());
		ctrlMap.put(btnAppend, new AppendController());
		ctrlMap.put(btnDelete, new DeleteController());
		ctrlMap.put(btnSearch, new SearchController());
		ctrlMap.put(btnReset, new ResetController());
		
		// 트리거와 비슷한 기능
		ctrlMap.get(btnAll).service();
		
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		// Map을 이용해서 Controller를 관한다.
		// 버튼 별로 Controller(기능)를 따로 만든다.
		
		// 이벤트가 발생한 버튼의 콘트롤러를 가져온다.
		Controller ctrl = ctrlMap.get(src);
		ctrl.service();
		// 추가 후 리스트를 갱신해준다.
		// 모든 처리 후 목록 보여지는것이기 때문에 지워야한다.
		//ctrlMap.get(btnAll).service();
	}

}
