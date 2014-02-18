package console_wars;

public class Units {

	private String unitName;
	private int ability;
	private int attack;
	private int defense;
	private int attackRange;
	private int type;
	private String name;
	private String genName;
	private int mobility;
	private int life;
	private int xPos;
	private int yPos;
	private boolean isGeneral;

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param unitName
	 * @param ability
	 * @param attack
	 * @param defense
	 * @param attackRange
	 * @param type
	 * @param name
	 * @param genName
	 * @param mobility
	 * @param life
	 * @param xPos 
	 * @param yPos 
	 * @param isGeneral 
	 */
	Units(String unitName, int ability, int attack, int defense,
			int attackRange, int type, String name, String genName,
			int mobility, int life, int xPos, int yPos, boolean isGeneral) {
		this.unitName = unitName;
		this.ability = ability;
		this.attack = attack;
		this.defense = defense;
		this.attackRange = attackRange;
		this.type = type;
		this.name = name;
		this.genName = genName;
		this.mobility = mobility;
		this.life = life;
		this.xPos = xPos;
		this.yPos = yPos;
		this.isGeneral = isGeneral;
	}
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param unitName
	 * @param ability
	 * @param attack
	 * @param defense
	 * @param attackRange
	 * @param type
	 * @param name
	 * @param genName
	 * @param mobility
	 * @param life
	 * @param xPos 
	 * @param yPos 
	 * @param isGeneral 
	 */
	Units(String unitName, int ability, int attack, int defense,
			int attackRange, int type, String name, String genName,
			int mobility, int life) {
		this(unitName, ability, attack, defense, attackRange, type, name, genName, mobility, life, 0, 0, name == genName);
		
		this.unitName = unitName;
		this.ability = ability;
		this.attack = attack;
		this.defense = defense;
		this.attackRange = attackRange;
		this.type = type;
		this.name = name;
		this.genName = genName;
		this.mobility = mobility;
		this.life = life;
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
	
	/**
	 * Return if a general exists in the unit
	 * @return 
	 * 
	 * 
	 */
	public boolean getIsGeneral(){
		return this.isGeneral;
	}
	
	public int getXIndex(){
		return this.getX()/Main.TILE_SIZE;
	}
	
	public int getYIndex(){
		return this.getY()/Main.TILE_SIZE;
	}
}
