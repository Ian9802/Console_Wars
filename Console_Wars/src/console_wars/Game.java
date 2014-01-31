package console_wars;
import javax.swing.JFrame;

/**
 * Console Wars Game
 *
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class Game {
	
	private JFrame frame;
	private Level level;
	private KeyBoardListener movementListener;
	private MouseListener mouseListener;
	private int levelID;
	
	/**
	 * 
	 * Construct a new game.
	 *
	 */
	public Game() {
		this.frame = new JFrame();
		this.frame.setSize(Main.WINDOW_SIZE);
		this.frame.setTitle("Console Wars");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Starts the game
	 *
	 */
	public void start() {
//		this.level = new Level(this.levelID, this.frame, this);
		
		this.frame.setVisible(true);
	}
	
}
