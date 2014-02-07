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
	public static final Dimension WINDOW_SIZE = new Dimension(720, 720);
	@SuppressWarnings("javadoc")
	public static final int TILE_SIZE = 72;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		SQLBackend.connectToDB();
		SQLBackend.getCompanies();
		SQLBackend.getUnits();
		SQLBackend.getGenerals();
		SQLBackend.getRegions();
		
	}
}
