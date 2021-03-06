package console_wars;

import java.awt.Dimension;
import java.io.IOException;


/**
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class Main {

	/**
	 * Constants
	 */
	public static final Dimension WINDOW_SIZE = new Dimension(720, 720);
	@SuppressWarnings("javadoc")
	public static final Dimension FRAME_SIZE = new Dimension(Main.WINDOW_SIZE.width + 17, Main.WINDOW_SIZE.height + 39);
	@SuppressWarnings("javadoc")
	public static final int TILE_SIZE = WINDOW_SIZE.height / 10;
	@SuppressWarnings("javadoc")
	public static final int NUM_PLAYERS = 3;
	@SuppressWarnings("javadoc")
	public static final Dimension BOARD_DIMENSION_BY_TILE = new Dimension(10, 10);
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.createPlayer();
		game.start();
		
	}
}
