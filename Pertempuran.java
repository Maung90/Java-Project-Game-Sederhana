import java.util.ArrayList;
import java.util.Random;
public class Pertempuran extends Player implements Monster{
	public ArrayList <Monster> monster = new ArrayList <Monster>();

	public void initMonsterData(){

		//set jenis monster
		jenisMonster.add("Slime");
		jenisMonster.add("Goblin");
		jenisMonster.add("Demon");

		jenisMonster.add("Slime King");
		jenisMonster.add("Shaman");
		jenisMonster.add("Demon King");

		//set hp monster
		hpMonster.add(100);
		hpMonster.add(150);
		hpMonster.add(200);

		hpMonster.add(400);
		hpMonster.add(600);
		hpMonster.add(800);

		//set damage monster
		baseDamageMonster.add(75);
		baseDamageMonster.add(100);
		baseDamageMonster.add(150);

		baseDamageMonster.add(350);
		baseDamageMonster.add(550);
		baseDamageMonster.add(750);

		//set defend monster
		defendMonster.add(50);
		defendMonster.add(100);
		defendMonster.add(150);

		defendMonster.add(350);
		defendMonster.add(550);
		defendMonster.add(750);

	}

	public boolean battle(int senjata, int level, int armor){
		initMonsterData();
		boolean tf = true;	
		int hpPlayer = getHp()+armor;
		int i=1,wave = level+2;
		while(tf = true) {
			int hpEnemy = hpMonster.get(i-1);
			String namaMonster = jenisMonster.get(i-1);
			int damageMonster = baseDamageMonster.get(i-1);
			while(tf == true){
				sleep(1);
				cls();
				System.out.println("INI WAVE KE : " + i);
				System.out.println("==============================================");
				System.out.println("Hp "+getName()+"  \t\t\t Hp "+namaMonster);
				System.out.println("   "+hpPlayer+" \t\t\t    "+hpEnemy);
				if (hpPlayer <= 0) {
					hpPlayer = 0;
					cls();
					System.out.println("==============================================");
					System.out.println("Hp "+getName()+"  \t\t\t Hp "+namaMonster);
					System.out.println("   "+hpPlayer+" \t\t\t    "+hpEnemy);
					System.out.println(getName() + " telah wafat ");
					tf = false;
					break;
				}else{
					int damageEnemy = terimaDamageMonster(damageMonster);
					hpPlayer -= damageEnemy;
					System.out.println(namaMonster + " memberikan damage sebesar : " +damageEnemy);
				} 

				if (hpEnemy <= 0) {
					hpEnemy = 0;
					cls();
					System.out.println("==============================================");
					System.out.println("Hp "+getName()+"  \t\t\t Hp "+namaMonster);
					System.out.println("   "+hpPlayer+" \t\t\t    "+hpEnemy);
					System.out.println(namaMonster + " telah Wafat");
					break;
				}else{
					int damagePlayer = terimaDamagePlayer(getBaseDamage(),senjata);
					hpEnemy -= damagePlayer;
					System.out.println(getName() + " memberikan damage sebesar : " +damagePlayer);
				}
				System.out.println("\n==============================================");
				sleep(2);
			}
			i++;
			if (i > level+2 || tf == false) {
				break;
			}
		}
		return tf;
	}
	public void showPlayer(int senjata, int armor, int level){
		cls();
		System.out.println("|===============================================|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|\t     -> GAME GJLS <-	\t\t|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|\t Nama Player   : "+getName()+"\t\t\t|");
		System.out.println("|\t Level         : "+level+"\t\t\t|");
		System.out.println("|\t Senjata       : "+getWeapon()+"\t\t\t|");
		System.out.println("|\t Hp Player     : "+getHp()+"+("+armor+")\t\t|");
		System.out.println("|\t Damage Attack : "+getBaseDamage()+"+("+senjata+")"+"\t\t|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|===============================================|");
	}

	public int terimaDamagePlayer(int maxDamagePlayer,int senjata){
		Random dice = new Random();
		int damagePlayer = dice.nextInt(50,maxDamagePlayer);
		return damagePlayer;
	}

	public void welcomeKalimat(){
		cls();
		System.out.println("|=======================================|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t         WELCOME     \t\t|");
		System.out.println("|\t     -> GAME GJLS <-	\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|=======================================|");
		sleep(1);
		System.out.print(".");
		sleep(1);
		System.out.print(" . ");
		sleep(1);
		System.out.print(". ");
	}
	public void cls(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception E){
			System.out.println("Tidak Bisa Clear Screen");
		}
	}
	public void sleep(long n){
		long second = n * 1000;
		try{
			Thread.sleep(second);
		}catch(Exception e){
			System.err.println(e);
		}
	}
}