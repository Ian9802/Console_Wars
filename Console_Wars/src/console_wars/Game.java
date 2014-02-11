package console_wars;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Console Wars Game
 *
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class Game {
	
	private JFrame frame;
	private Level level;
//	private KeyBoardListener movementListener;
	private Player[] players;
	
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
		SQLBackend.connectToDB(); // must do or none of the qureies will work
		factionSelectMenu();
		this.level = new Level(0, this.frame, this);
		
		
		
		this.frame.setVisible(true);
		this.frame.add(this.level);
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void factionSelectMenu() {
		
		String[] choices = SQLBackend.getCompaniesNamesList();
		
		Company[] companies = SQLBackend.getCompanies();
		
		Boolean nonProperSelection;
		
		int[] chosen = new int[companies.length];
		
		for (int i = 0; i < chosen.length; i++) {
			chosen[i] = 0;
		}
		
		for (int i = 1; i < Main.NUM_PLAYERS + 1; i++) {
			nonProperSelection = true;
			while(nonProperSelection) {
			
				int selection = JOptionPane.showOptionDialog(null,
					"Player " + i + " Select Faction", "Console Wars",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					choices, "0");
				
				if (chosen[selection] == 1){
					//
				} else {
					chosen[selection] = 1;
					nonProperSelection = false;
				}
				
			}
			
		}
		
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public AbstractTile[][] getTileList() {
		// TODO Auto-generated method stub.
		return this.level.getTileList();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param tileXIndex
	 * @param tileYIndex
	 */
	public void highlightTile(int tileXIndex, int tileYIndex) {
		this.level.getTileList()[tileXIndex][tileYIndex].highlight();
		this.frame.repaint();
		
	}
	
}
