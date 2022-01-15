package org.comstudy21.myapp.controller;

import org.comstudy21.myapp.resource.R;

// Controller가 모든  콘트롤러의 부모이기 때문에 
public interface Controller extends R {
	void service();
}
