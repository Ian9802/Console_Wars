package console_wars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Units extends JComponent {

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
	private boolean isDead;
	private boolean selected;
	private Color color;
	
//	private UnitMouseListener mouselistener;

	/**
	 * Constructs a Unit.
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
		this.isDead = false;
		this.setSelected(false);
		
		if (name.equals("Nintendo")) {
			this.color = Color.red;
		} else if (name.equals("Microsoft")) {
			this.color = Color.WHITE;
		} else if (name.equals("Sony")) {
			this.color = Color.blue;
		} else {
			this.color = Color.orange;
		}
		
//		this.mouselistener = new UnitMouseListener(this);
//		addMouseMotionListener(this.mouselistener);
//		addMouseListener(this.mouselistener);
	}
	
	/**
	 * Constructs unit, sets xPos = 0, yPos = 0.
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
	 * 
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
		this.isDead = false;
	}
	
	/**
	 * Constructs a Unit, use this constructor directly with backend.
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
	 * 
	 */
	Units(String unitName, int ability, int attack, int defense,
			int attackRange, int type, String name, String genName,
			int mobility, int life, int xPos, int yPos) {
		this(unitName, ability, attack, defense, attackRange, type, name, genName, mobility, life, xPos, yPos, name == genName);
		
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
	
	public void draw(Graphics2D g2, String character) throws IOException {
//		BufferedImage img = new BufferedImage(Main.TILE_SIZE, Main.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
		Image image = (Image) ImageIO.read(new File("src/" + character + ".jpg"));
		g2.setPaint(Color.WHITE);
		g2.fill(new Rectangle2D.Double(this.xPos,this.yPos,Main.TILE_SIZE,Main.TILE_SIZE));
		g2.fillRect(this.xPos, this.yPos, Main.TILE_SIZE, Main.TILE_SIZE);
		g2.drawImage(image, this.xPos, this.yPos, Main.TILE_SIZE, Main.TILE_SIZE, null);
	}
	
	/**
	 * returns xPos
	 *
	 * @return xPos
	 */
	@Override
	public int getX() {
		return this.xPos;
	}
	
	/**
	 * Returns yPos.
	 *
	 * @return yPos
	 */
	@Override
	public int getY() {
		return this.yPos;
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.xPos = x;
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.yPos = y;
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

	public void takeDamage(int attack){
		int damage = attack * ((100 - this.defense)/100);
		this.life -= damage;
		if(this.life <= 0){
			this.isDead = true;
		}
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/**
	 * Returns the value of the field called 'selected'.
	 * @return Returns the selected.
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Sets the field called 'selected' to the given value.
	 * @param selected The selected to set.
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Returns the value of the field called 'color'.
	 * @return Returns the color.
	 */
	public Color getColor() {
		return  this.color;
	}

	/**
	 * Sets the field called 'color' to the given value.
	 * @param color The color to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
