package org.comstudy21.game;

import java.util.HashMap;

public interface AppContext {
	public static final HashMap<String, Object> request = new HashMap<>();
	
	public static final MyGame myGame = new MyGame();
}
