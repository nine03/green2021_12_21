package org.comstudy21.game;

public class GameFactory implements AppContext {
	private static GameFactory instance;
	private GameFactory() {}
	
	public static GameFactory getInstance() {
		if(instance == null) {
			instance = new GameFactory();
		}
		return instance;
	}
	
	public static Object getGame(String gameType) {
		if("myGame".equals(gameType)) {
			return myGame;
		}
		
		return null;
	}
}
