import java.util.Random;
class Player{
	private String name;
	private String weapon = "TONGKAT"; // nama senjata
	private String nameArmor = "-"; // nama defend
	private int hp;
	private int damageWeapon; // damage senjata
	private int defend; //effect armor
	private int baseDamage = 150;
	private int level = 1;

	public Player(){
		this.hp = 1000;
		this.defend = 50;
		this.baseDamage = 150;
	} 
	public Player(String name, String weapon){
		this.name = name;
		this.weapon = weapon;
		this.hp = hp;
		this.defend = defend;
		this.baseDamage = baseDamage;
	} 
	public void showPlayer(){
		System.out.println("Name Char    : " + this.name);
		System.out.println("HP           : " + this.hp);
		System.out.println("Weapon       : " + this.weapon);
		System.out.println("Defend       : " + this.defend);
		System.out.println("Base Damage  : " + this.baseDamage);
	}
	public void sleep(){
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	// terima damage
	public int terimaDamageMonster(int maxDamageEnemy){
		Random dice = new Random();
		int damageEnemy = dice.nextInt(50,maxDamageEnemy);
		return damageEnemy;
	} 
	// Getter & Setter
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	// nama senjata
	public String getWeapon(){
		return this.weapon;
	}
	public void setWeapon(String weapon){
		this.weapon = weapon;
	}

	// damage senjata
	public int getDamageWeapon(){
		return this.damageWeapon;
	}
	public void setDamageWeapon(int damageWeapon){
		this.damageWeapon = damageWeapon;
	}

	//-------------------------------------
	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp,int level,int hpLevel){
		this.hp = hp+(level * hpLevel);
	}

	// get & set level
	public int getLevel(){
		return this.level;
	}
	public void setLevel(int level){
		this.level += level;
	}

	// nama Armor
	public String getNameArmor(){
		return this.nameArmor;
	}
	public void setNameArmor(String nameArmor){
		this.nameArmor = nameArmor;
	}

	// Effect Armor
	public int getDefend(){
		return this.defend;
	}
	public void setDefend(int defend){
		this.defend = defend;
	}


	public int getBaseDamage(){
		return this.baseDamage;
	}




}