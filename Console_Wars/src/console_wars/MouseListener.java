package console_wars;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import javax.swing.JFrame;

/**
 * Mouse Input Listener
 *
 * @author samynpd.
 *         Created Jan 31, 2014.
 */
public class MouseListener implements MouseInputListener {
	
	private Game game;
	private JFrame frame;
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param frame
	 * @param game
	 */
	public MouseListener(JFrame frame, Game game) {
		this.game = game;
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int tileXIndex = (int) (arg0.getX()/new Float(Main.WINDOW_SIZE.width) * Main.BOARD_DIMENSION_BY_TILE.width);
		int tileYIndex = (int) (arg0.getY()/new Float(Main.WINDOW_SIZE.height) * Main.BOARD_DIMENSION_BY_TILE.height);
		
		System.out.printf("Clicked: %d, %d \n",tileXIndex, tileYIndex);
		
//		this.game.highlightTile(tileXIndex, tileYIndex);
		this.game.highlightSurroundingTiles(tileXIndex, tileYIndex);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub.
		
//		System.out.println(arg0);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub.

//		System.out.println(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub.

//		System.out.println(arg0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

//		System.out.println(arg0);
		
		int tileXIndex = (int) (arg0.getX()/new Float(Main.WINDOW_SIZE.width) * Main.BOARD_DIMENSION_BY_TILE.width);
		int tileYIndex = (int) (arg0.getY()/new Float(Main.WINDOW_SIZE.height) * Main.BOARD_DIMENSION_BY_TILE.height);
		
		System.out.printf("Tile: %d, %d \n",tileXIndex, tileYIndex);
		
//		this.game.highlightTile(tileXIndex, tileYIndex);
		
//		AbstractTile[][] tileList = this.game.getTileList();
//		tileList[tileXIndex][tileYIndex].highlight();
//		
//		this.frame.repaint();
		
	}

}
