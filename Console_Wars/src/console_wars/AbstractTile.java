package console_wars;
/**
 * An abstract class for tiles
 * 
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public abstract class AbstractTile {
	
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
	
}
