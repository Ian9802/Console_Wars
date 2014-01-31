package console_wars;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * A level
 * 
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class Level extends JComponent {
	
	// render here or in separate level renderer?
	
	private Game game;
	private int numRows;
	private int numCols;
	private ArrayList<String> levelData = new ArrayList<String>();
	private AbstractTile[][] tileList;
	private AbstractUnit[][] heroList;
	private int levelID;
	private JFrame frame;
	
	/**
	 * Constructs level with given levelID
	 *
	 * @param levelID
	 * @param frame
	 * @param game
	 */
	public Level(int levelID, JFrame frame, Game game) {
		this.game = game;
		this.levelID = levelID;
		this.frame = frame;
		loadLevel();
	}
	
	/**
	 * Loads the current level
	 *
	 */
	void loadLevel() {
		// local for now, eventually will use backend
		
		// Name the input file
		String fileName = "src//Console_Wars//Level_" + this.levelID + ".txt";
		File inputFile = new File(fileName);
		if (!inputFile.exists()) {
			System.out.println("Level " + this.levelID + " does not exist");
		}
		
		// Create a scanner
		Scanner inputScanner = null;
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
		// Get all the rows as strings
		while (inputScanner.hasNext()) {
			String nextChar = inputScanner.next();
			this.levelData.add(nextChar);
		}
		
		
	}
	
}
