package console_wars;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
	
	private MouseListener mouseListener;
	
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
		
		this.mouseListener = new MouseListener(this.frame, this.game);
		addMouseMotionListener(this.mouseListener);
		addMouseListener(this.mouseListener);
		
		// local for now, eventually will use backend
		
		// Name the input file
		String fileName = "src//Console_Wars//Level_" + this.levelID + ".txt";
		File inputFile = new File(fileName);
		if (!inputFile.exists()) {
			System.out.println("Level " + this.levelID + " does not exist");
		}
		
		// Create a scanner
//		Scanner inputScanner = null;
//		try {
//			inputScanner = new Scanner(inputFile);
//		} catch (FileNotFoundException exception) {
//			exception.printStackTrace();
//		}
		
		// Get all the rows as strings
//		while (inputScanner.hasNext()) {
//			String nextChar = inputScanner.next();
//			this.levelData.add(nextChar);
//		}
		
		this.tileList = new AbstractTile[10][10];
				
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.tileList[i][j] = new AbstractTile(i * Main.TILE_SIZE, j * Main.TILE_SIZE);
				
				
				System.out.printf("%d, %d \n", this.tileList[i][j].getX(), this.tileList[i][j].getY());
			}
		}
		
		
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		Rectangle2D.Double background = new Rectangle2D.Double(0, 0, Main.WINDOW_SIZE.width, Main.WINDOW_SIZE.height);
		g2.fill(background);
		g2.draw(background);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.tileList[i][j].draw(g2);
			}
		}
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public AbstractTile[][] getTileList() {
		return this.tileList;
	}
	
	public void setTile(int index1, int index2, AbstractTile tile) {
		this.tileList[index1][index2] = tile;
	}
	
	public int getLevelID() {
		return this.levelID;
	}
	
	public AbstractTile[] getTilesToHighlight(int xInd, int yInd, int radius) {
		
		HashSet<AbstractTile> tileSet = new HashSet<AbstractTile>();
		
		tileSet = getTilesToHighlightHelper(this.tileList[xInd][yInd], tileSet, radius);
		
		AbstractTile[] tileList = tileSet.toArray(new AbstractTile[tileSet.size()]);
		
		return tileList;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param abstractTile
	 */
	private HashSet<AbstractTile> getTilesToHighlightHelper(AbstractTile tile, HashSet<AbstractTile> tileSet, int radius) {
		
		if(radius == 0) {
			return tileSet;
		}
		
		if(!(tile.getX()/Main.TILE_SIZE < Main.BOARD_DIMENSION_BY_TILE.width) || !(tile.getY()/Main.TILE_SIZE < Main.BOARD_DIMENSION_BY_TILE.height)) {
			return tileSet;
		}
		
		tileSet.add(tile);
		
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE-1][tile.getY()/Main.TILE_SIZE], tileSet, radius-1); //do in all directions
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE][tile.getY()/Main.TILE_SIZE-1], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE-1][tile.getY()/Main.TILE_SIZE-1], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE+1][tile.getY()/Main.TILE_SIZE], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE][tile.getY()/Main.TILE_SIZE+1], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE+1][tile.getY()/Main.TILE_SIZE+1], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE+1][tile.getY()/Main.TILE_SIZE-1], tileSet, radius-1);
		tileSet = getTilesToHighlightHelper(this.tileList[tile.getX()/Main.TILE_SIZE-1][tile.getY()/Main.TILE_SIZE+1], tileSet, radius-1);
		return tileSet;
	}
	
}
