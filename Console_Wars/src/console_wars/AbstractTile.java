package console_wars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * An abstract class for tiles
 * 
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class AbstractTile {
	
	private int xPos;
	private int yPos;
	private Boolean canMoveThrough;
	private Color color;
	
	/**
	 * AbstractTile constructor
	 *
	 * @param xPos
	 * @param yPos
	 * @param canMoveThrough
	 */
	public AbstractTile(int xPos, int yPos, Boolean canMoveThrough, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.canMoveThrough = canMoveThrough;
		this.color = color;
	}
	
	/**
	 * AbstractTile constructor.
	 *
	 * @param xPos
	 * @param yPos
	 */
	public AbstractTile(int xPos, int yPos) {
		this(xPos, yPos, true, Color.GREEN);
	}
	
	/**
	 * returns xPos
	 *
	 * @return xPos
	 */
	public int getX() {
		return this.xPos;
	}
	
	/**
	 * Returns yPos.
	 *
	 * @return yPos
	 */
	public int getY() {
		return this.yPos;
	}
	
	public int getXIndex() {
		return this.xPos/Main.TILE_SIZE;
	}
	
	public int getYIndex() {
		return this.yPos/Main.TILE_SIZE;
	}
	
	public void draw(Graphics2D g2) {
		Rectangle2D.Double tile = new Rectangle2D.Double(this.xPos, this.yPos, Main.TILE_SIZE, Main.TILE_SIZE);
		if(this.canMoveThrough) {
			g2.setColor(this.color);
		} else {
			g2.setColor(Color.black);
		}
		
		g2.fill(tile);
		g2.draw(tile);
		g2.setColor(Color.GRAY);
		g2.draw(tile);
	}
	
	public void setColor(Color color){
		this.color = color;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void highlight() {
		setColor(Color.blue);
		
	}
	
	public void unHighlight() {
		setColor(this.color);
	}
	
	public void setMoveThrough(Boolean bool) {
		this.canMoveThrough = bool;
	}
}
