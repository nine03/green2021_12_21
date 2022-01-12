package org.comstudy21.member.controller;

import org.comstudy21.member.resource.R;
import org.comstudy21.member.view.MemberView;

public abstract class Controller extends R {
	public abstract MemberView hadlerRequest(); // crud에 관련된 컨트럴러를 만들어야한다 . 
												// r에다가 맵핑시켜야한다 
}
