package console_wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	public void paintComponent(Graphics g){
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0){
		int tileXIndex = (int) (arg0.getX()/new Float(Main.WINDOW_SIZE.width) * Main.BOARD_DIMENSION_BY_TILE.width);
		int tileYIndex = (int) (arg0.getY()/new Float(Main.WINDOW_SIZE.height) * Main.BOARD_DIMENSION_BY_TILE.height);
		
//		System.out.printf("Clicked: %d, %d \n", tileXIndex, tileYIndex);
		
		// check win
		
		ArrayList<Player> activePlayers = new ArrayList<Player>();
		
		for (int j = 0; j < this.game.getPlayers().length; j++) {
			if(!this.game.getPlayers()[j].lost()) {
				activePlayers.add(this.game.getPlayers()[j]);
			}
		}
		
		if (activePlayers.size() < 2) {
			
			
				try {

					System.out.println("Winner: " + activePlayers.get(0).getFaction().getName());
					SQLBackend.updateRegion(activePlayers.get(0).getFaction().getName(), this.game.getLevel().getLevelID());
					this.game.getFrame().getContentPane().add(new WinnerBackground());					
					Thread.sleep(5000);
					this.game.getFrame().dispatchEvent(new WindowEvent(this.game.getFrame(), WindowEvent.WINDOW_CLOSING));
					

				} catch (IOException e) {
					System.out.println("Winner: " + activePlayers.get(0).getFaction().getName());
					SQLBackend.updateRegion(activePlayers.get(0).getFaction().getName(), this.game.getLevel().getLevelID());
					this.game.getFrame().dispatchEvent(new WindowEvent(this.game.getFrame(), WindowEvent.WINDOW_CLOSING));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		}
		
		// check if current player has units
		
		if (!this.game.getLevel().hasUnitLeft(this.game.getCurrentPlayer())) {
			this.game.getCurrentPlayer().setLost(true);
			this.game.setTurnCount(this.game.getTurnCount() + 1);
			Player[] players = this.game.getPlayers();
			this.game.setCurrentPlayer(players[this.game.getTurnCount() % players.length]);
			return;
		}
		
		// Movement & Attack
		if (this.game.getPreviouslyHighlightedTiles() != null) {
			for (int i = 0; i < this.game.getPreviouslyHighlightedTiles().length; i++) {
				if (this.game.getLevel().getTileList()[tileXIndex][tileYIndex].equals(this.game.getPreviouslyHighlightedTiles()[i])) {
					
					AbstractTile tileToMoveTo = this.game.getLevel().getTileList()[tileXIndex][tileYIndex];
					Units unitToMove = this.game.getLevel().getSelectedUnit();
					
					// check if can attack
					Units unitToAttack = this.game.getLevel().getUnitList()[tileXIndex][tileYIndex];
					if (unitToAttack != null && unitToAttack != unitToMove && !unitToAttack.getName().equals(unitToMove.getName())) {
						unitToAttack.takeDamage(unitToMove.getAttack());
						System.out.println("ATTACKED  Attacker attack: " + unitToMove.getAttack() + " Defender defense: " + unitToAttack.getDefense() + " Life remaining: " + unitToAttack.getLife());
						if (unitToAttack.isDead()) {
							unitToAttack = null;
							this.game.getLevel().getUnitList()[tileXIndex][tileYIndex] = null;
							System.out.println("DEAD!");
							
						}
						
						// deselect
						
						if (unitToMove != null) {
							unitToMove.setSelected(false);
							this.game.unHighlightSurroundingTiles(unitToMove.getXIndex(), unitToMove.getYIndex(), unitToMove.getMobility());
						}
						this.game.getLevel().setSelectedUnit(null);
						
						// change player turn
						
						this.game.setTurnCount(this.game.getTurnCount() + 1);
						Player[] players = this.game.getPlayers();
						this.game.setCurrentPlayer(players[this.game.getTurnCount() % players.length]);
						System.out.println(this.game.getTurnCount());
						System.out.println("Current Player: " + this.game.getCurrentPlayer().getFaction().getName());
						
						this.frame.repaint();
						return;
					}
					
					// if cannot move to tile then return
					if (!tileToMoveTo.getMoveThrough()) {
						if (unitToMove != null) {
							unitToMove.setSelected(false);
							this.game.unHighlightSurroundingTiles(unitToMove.getXIndex(), unitToMove.getYIndex(), unitToMove.getMobility());
						}
						this.game.getLevel().setSelectedUnit(null);
						return;
					}
					
					if (unitToAttack != null) {
						if (unitToMove != null) {
							unitToMove.setSelected(false);
							this.game.unHighlightSurroundingTiles(unitToMove.getXIndex(), unitToMove.getYIndex(), unitToMove.getMobility());
						}
						this.game.getLevel().setSelectedUnit(null);
						return;
					}
					
					// deselect
					
					if (unitToMove != null) {
						unitToMove.setSelected(false);
						this.game.unHighlightSurroundingTiles(unitToMove.getXIndex(), unitToMove.getYIndex(), unitToMove.getMobility());
					}
					this.game.getLevel().setSelectedUnit(null);
					
					// move
					int x = unitToMove.getXIndex();
					int y = unitToMove.getYIndex();
					
					unitToMove.setX(tileToMoveTo.getX());
					unitToMove.setY(tileToMoveTo.getY());
					
					this.game.getLevel().getUnitList()[x][y] = null;
					this.game.getLevel().getUnitList()[tileXIndex][tileYIndex] = unitToMove;
					
					this.frame.repaint();
					
					// change player turn
					
					this.game.setTurnCount(this.game.getTurnCount() + 1);
					Player[] players = this.game.getPlayers();
//					this.game.setCurrentPlayer(players[this.game.getTurnCount() % players.length]);
					this.game.setCurrentPlayer(this.game.getLevel().nextAvailablePlayer());
					
					System.out.println(this.game.getTurnCount());
					System.out.println("Current Player: " + this.game.getCurrentPlayer().getFaction().getName());
					
					return;
				}
			}
		}
		
		// new unit is different from previously selected unit
		if (this.game.getLevel().getUnitList()[tileXIndex][tileYIndex] != null) {
			if (this.game.getLevel().getUnitList()[tileXIndex][tileYIndex].getName().equals(this.game.getCurrentPlayer().getFaction().getName())) {
				if (this.game.getLevel().getSelectedUnit() != this.game.getLevel().getUnitList()[tileXIndex][tileYIndex]) {
					
					// deselect previous
					
					Units tempUnit = this.game.getLevel().getSelectedUnit();
					if (tempUnit != null) {
						tempUnit.setSelected(false);
						this.game.unHighlightSurroundingTiles(tempUnit.getXIndex(), tempUnit.getYIndex(), tempUnit.getMobility());
					}
					this.game.getLevel().setSelectedUnit(null);
					
					// select new unit
					if (this.game.getLevel().getUnitList()[tileXIndex][tileYIndex] != null) {
						this.game.getLevel().getUnitList()[tileXIndex][tileYIndex].setSelected(true);
						this.game.getLevel().setSelectedUnit(this.game.getLevel().getUnitList()[tileXIndex][tileYIndex]);
						this.game.highlightSurroundingTiles(tileXIndex, tileYIndex, this.game.getLevel().getUnitList()[tileXIndex][tileYIndex].getMobility());
					}
					
				} else {
					// deselect previous unit
					
					Units tempUnit = this.game.getLevel().getSelectedUnit();
					if (tempUnit != null) {
						tempUnit.setSelected(false);
						this.game.unHighlightSurroundingTiles(tempUnit.getXIndex(), tempUnit.getYIndex(), tempUnit.getMobility());
					}
					this.game.getLevel().setSelectedUnit(null);
				}
			}
		}
		
//		if (this.game.getLevel().getSelectedUnit() != null) {
//			Units tempUnit = this.game.getLevel().getSelectedUnit();
//			tempUnit.setSelected(false);
//			this.game.unHighlightSurroundingTiles(tempUnit.getXIndex(), tempUnit.getYIndex());
//			this.game.getLevel().setSelectedUnit(null);
//		}
//		
//		if (this.game.getLevel().getUnitList()[tileXIndex][tileYIndex] != null) {
//			if (this.game.getLevel().getUnitList()[tileXIndex][tileYIndex].isSelected()) {
//				Units tempUnit = this.game.getLevel().getSelectedUnit();
//				tempUnit.setSelected(false);
//				this.game.unHighlightSurroundingTiles(tempUnit.getXIndex(), tempUnit.getYIndex());
//				this.game.getLevel().setSelectedUnit(null);
//			} else {
//			
//				this.game.getLevel().getUnitList()[tileXIndex][tileYIndex].setSelected(true);
//				this.game.getLevel().setSelectedUnit(this.game.getLevel().getUnitList()[tileXIndex][tileYIndex]);
//				this.game.highlightSurroundingTiles(tileXIndex, tileYIndex);
//			}
//		} else {
//			//
//		}
		
		
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
		
//		int tileXIndex = (int) (arg0.getX()/new Float(Main.WINDOW_SIZE.width) * Main.BOARD_DIMENSION_BY_TILE.width);
//		int tileYIndex = (int) (arg0.getY()/new Float(Main.WINDOW_SIZE.height) * Main.BOARD_DIMENSION_BY_TILE.height);
//		
//		System.out.printf("Tile: %d, %d \n",tileXIndex, tileYIndex);
		
		
	}

}
