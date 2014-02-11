package console_wars;

/**
 * TODO Put here a description of what this class does.
 *
 * @author samynpd.
 *         Created Feb 7, 2014.
 */
public class Company {

	private int perks;
	private String name;
	private String hq;
	
	Company(String name, String hq, int perks) {
		this.perks = perks;
		this.setName(name);
		this.hq = hq;
	}

	/**
	 * Returns the value of the field called 'name'.
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the field called 'name' to the given value.
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
