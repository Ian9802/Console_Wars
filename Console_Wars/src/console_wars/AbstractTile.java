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
	
	/**
	 * AbstarctTile constructor.
	 *
	 * @param xPos
	 * @param yPos
	 */
	public AbstractTile(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
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
	
	public void draw(Graphics2D g2) {
		Rectangle2D.Double tile = new Rectangle2D.Double(this.xPos, this.yPos, Main.TILE_SIZE, Main.TILE_SIZE);
		g2.setColor(Color.black);
		g2.fill(tile);
		g2.draw(tile);
		g2.setColor(Color.GRAY);
		g2.draw(tile);
	}
	
}
