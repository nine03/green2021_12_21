package org.comstudy21.game;

public class GameClient {
	
	public static void gamePlayer(Game game) {
		game.play();
	}

	public static void main(String[] args) {
		
		//GameFactory factory = GameFactory.getInstance();
		Game game = (Game)GameFactory.getGame("myGame");
		
		gamePlayer(game);

	}

}
