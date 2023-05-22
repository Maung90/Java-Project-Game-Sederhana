import java.util.Random;
class Player{
	private String name;
	private String weapon;
	private int hp;
	private int defend;
	private int baseDamage = 150;

	public Player(){
		this.hp = 1500;
		this.defend = 350;
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

	public int terimaDamageMonster(int maxDamageEnemy){
	Random dice = new Random();
		int damageEnemy = dice.nextInt(50,maxDamageEnemy);
		return damageEnemy;
	}
	public String getName(){
		return this.name;
	}
	public String getWeapon(){
		return this.weapon;
	}
	public int getHp(){
		return this.hp;
	}
	public int getDefend(){
		return this.defend;
	}
	public int getBaseDamage(){
		return this.baseDamage;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setWeapon(String weapon){
		this.weapon = weapon;
	}
	public void setHp(int hp){
		this.hp = hp;
	}

}