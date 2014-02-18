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

	Units(String unitName, int ability, int attack, int defense,
			int attackRange, int type, String name, String genName,
			int mobility, int life) {
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	public int getMobility() {
		return mobility;
	}

	public void setMobility(int mobility) {
		this.mobility = mobility;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}
