package console_wars;

/**
 * A Unit
 *
 * @author samynpd.
 *         Created Jan 30, 2014.
 */
public class AbstractUnit {
	private int xPos;
	private int yPos;
	
	/**
	 * AbstractUnit Constructor
	 *
	 * @param xPos
	 * @param yPos
	 */
	public AbstractUnit(int xPos, int yPos) {
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
