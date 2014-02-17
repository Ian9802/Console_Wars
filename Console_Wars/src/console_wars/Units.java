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
}
