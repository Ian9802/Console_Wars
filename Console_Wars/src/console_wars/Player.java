package console_wars;
/**
 * A Player
 * 
 * @author samnpd
 *
 */
public class Player {

	private Company faction;
	private boolean lost;
	
	Player(Company faction) {
		this.faction = faction;
	}
	
	public Company getFaction() {
		return this.faction;
	}
	
	public boolean lost() {
		return this.lost;
	}
	
	public void setLost(boolean lost) {
		this.lost = lost;
	}
	
}

