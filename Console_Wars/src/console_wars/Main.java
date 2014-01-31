package console_wars;

import java.awt.Dimension;


/**
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class Main {

	/**
	 * Constants
	 */
	public static final Dimension WINDOW_SIZE = new Dimension(1920, 1080);
	@SuppressWarnings("javadoc")
	public static final int TILE_SIZE = 108;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		
	}
}
