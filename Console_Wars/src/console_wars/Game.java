package console_wars;

import java.io.IOException;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Console Wars Game
 * 
 * @author samynpd. Created Jan 30, 2014.
 */
public class Game {
	private AbstractTile[] previouslyHighlightedTiles;
	private JFrame frame;
	private Level level;
	private Player[] players;
	private Player currentPlayer;
	private Level[] levels;
	private int turnCount;
	boolean wait;

	/**
	 * 
	 * Construct a new game.
	 * 
	 */
	public Game() {
		this.frame = new JFrame();
		this.frame.setSize(Main.FRAME_SIZE);
		this.frame.setTitle("Console Wars");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTurnCount(0);
	}

	/**
	 * Starts the game
	 * 
	 * @throws IOException
	 * 
	 */
	public void start() throws IOException {
		SQLBackend.connectToDB(); // must do or none of the queries will work
		this.players = factionSelectMenu();
		this.level = levelSelectMenu();
		
		
		this.frame.setVisible(true);
		this.frame.add(this.level);
		this.currentPlayer = this.players[0];
	}

	public void createPlayer() {
		
		wait = true;
		
		final JFrame aFrame = new JFrame();
		aFrame.setSize(new Dimension(300,300));
		aFrame.setTitle("Console Wars");
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setVisible(true);
		
		final JTextField text1 = new JTextField("Username");
		text1.setBounds(1, 1, 300, 30);
		aFrame.add(text1);
		final JTextField text2 = new JTextField("Password");
		text2.setBounds(1, 30, 300, 30);
		aFrame.add(text2);
		final JTextField text3 = new JTextField("email");
		text3.setBounds(1, 60, 300, 30);
		aFrame.add(text3);
		
		ActionListener l = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 
			String getText1 = text1.getText();
			String getText2 = text2.getText();
			String getText3 = text3.getText();
			SQLBackend.makeUser(getText1, getText2, getText3);
			aFrame.dispose();
			wait = false;
		}}; 
		ActionListener no = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 
			aFrame.dispose();
			wait = false;
		}}; 
		
		JButton button = new JButton("Create User");
		button.setBounds(40, 100, 200, 30);
		button.addActionListener(l);
		aFrame.add(button);
		
		JButton button2 = new JButton("No");
		button2.setBounds(40, 150, 200, 30);
		button2.addActionListener(l);
		aFrame.add(button2);
		
		aFrame.repaint();

	}

	public Level levelSelectMenu() {
		Integer[] levelChoices = SQLBackend.getLevelIDsList(this.frame, this);
		String[] choices = new String[levelChoices.length];
		for (int i = 0; i < choices.length; i++) {
			choices[i] = levelChoices[i].toString();
		}

		int selection = JOptionPane.showOptionDialog(null, "Select Level",
				"Console Wars", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, choices, "0");

		this.levels = SQLBackend.getLevels(this.frame, this);
		return this.levels[selection];

	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @throws IOException
	 * 
	 */
	public Player[] factionSelectMenu() throws IOException {

		String[] choices = SQLBackend.getCompaniesNamesList();

		Company[] companies = SQLBackend.getCompanies();

		Player[] players = new Player[companies.length];

		Boolean nonProperSelection;

		int[] chosen = new int[companies.length];

		for (int i = 0; i < chosen.length; i++) {
			chosen[i] = 0;
		}

		for (int i = 1; i < Main.NUM_PLAYERS + 1; i++) {
			nonProperSelection = true;
			while (nonProperSelection) {

				int selection = JOptionPane.showOptionDialog(null, "Player "
						+ i + " Select Faction", "Console Wars",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
						null, choices, "0");

				if (chosen[selection] == 1) {
					//
				} else {
					chosen[selection] = 1;
					nonProperSelection = false;
				}

				players[i - 1] = new Player(companies[selection]);

				// new CharacterMenu(selection);

			}

		}
		return players;

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

	public void highlightSurroundingTiles(int tileXIndex, int tileYIndex,
			int radius) {
		AbstractTile[] tileListToHighlight = this.level.getTilesToHighlight(
				tileXIndex, tileYIndex, radius); // set to 2 for testing
													// purposes
		for (int i = 0; i < tileListToHighlight.length; i++) {
			tileListToHighlight[i].highlight();
		}
		this.setPreviouslyHighlightedTiles(tileListToHighlight);
		this.frame.repaint();
	}

	public Level getLevel() {
		return this.level;
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param tileXIndex
	 * @param tileYIndex
	 */
	public void unHighlightSurroundingTiles(int tileXIndex, int tileYIndex,
			int radius) {
		AbstractTile[] tileListToHighlight = this.level.getTilesToHighlight(
				tileXIndex, tileYIndex, radius); // set to 2 for testing
													// purposes
		for (int i = 0; i < tileListToHighlight.length; i++) {
			tileListToHighlight[i].unHighlight();
		}
		this.setPreviouslyHighlightedTiles(null);
		this.frame.repaint();

	}

	/**
	 * Returns the value of the field called 'previouslyHighlightedTiles'.
	 * 
	 * @return Returns the previouslyHighlightedTiles.
	 */
	public AbstractTile[] getPreviouslyHighlightedTiles() {
		return this.previouslyHighlightedTiles;
	}

	/**
	 * Sets the field called 'previouslyHighlightedTiles' to the given value.
	 * 
	 * @param previouslyHighlightedTiles
	 *            The previouslyHighlightedTiles to set.
	 */
	public void setPreviouslyHighlightedTiles(
			AbstractTile[] previouslyHighlightedTiles) {
		this.previouslyHighlightedTiles = previouslyHighlightedTiles;
	}

	/**
	 * Returns the value of the field called 'currentPlayer'.
	 * 
	 * @return Returns the currentPlayer.
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Sets the field called 'currentPlayer' to the given value.
	 * 
	 * @param currentPlayer
	 *            The currentPlayer to set.
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Returns the value of the field called 'turnCount'.
	 * 
	 * @return Returns the turnCount.
	 */
	public int getTurnCount() {
		return this.turnCount;
	}

	/**
	 * Sets the field called 'turnCount' to the given value.
	 * 
	 * @param turnCount
	 *            The turnCount to set.
	 */
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public JFrame getFrame() {
		return this.frame;
	}
	
	public void winner(String playerWin) throws InterruptedException{
		Thread.sleep(500);
		this.frame = new JFrame();
		this.frame.setTitle("Winner is " + playerWin);
		this.frame.setSize(400,400);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(0);
		this.frame.setVisible(true);
		this.frame.setLayout(new BorderLayout());
		JLabel winnerBackground = new JLabel(new ImageIcon("src/Winner.jpg"));
		this.frame.add(winnerBackground);
		winnerBackground.setLayout(new FlowLayout());
		winnerBackground.add(new JLabel("Winner is " + playerWin));
		Thread.sleep(5000);
		this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
	}
}
