import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Pertempuran extends Player implements Monster{

	public ArrayList <Items> items = new ArrayList <Items>();
	public ArrayList <Items> itemPlayer = new ArrayList <Items>();
	public ArrayList<String> quest = new ArrayList<String>();
	public Scanner input = new Scanner(System.in);

	public void initItems(){
		Items item = new Items("Bambu",150,"senjata");
		Items item2 = new Items("zirah-kayu",130,"armor");
		Items item3 = new Items("Pedang",200,"senjata");
		Items item4 = new Items("zirah-besi",200,"armor");
		Items item5 = new Items("Katana",250,"senjata");
		Items item6 = new Items("zirah-Baja",250,"armor");

		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);

	}
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

	}

	public void initQuest(){

		quest.add("Membunuh pasukan slime");
		quest.add("Membunuh pasukan goblin");
		quest.add("Membunuh pasukan Demon");
		quest.add("Membunuh Slime King");
		quest.add("Membunuh Raja Shaman");
		quest.add("Membunuh Demon King");
	}
	public void showQuest(){
		cls();
		System.out.println("|=======================================|");
		System.out.println("|                                       |");

		for (int i = 1; i <= quest.size(); i++ ) {
			System.out.println("  \t" + i + " " + quest.get(i-1) );
		}
		System.out.println("|                                       |");
		System.out.println("|=======================================|");
		
	}
	public boolean prosesQuest(int a){
		initItems();
		
		boolean status = false;
		int armor = getDefend();
		int senjata = getDamageWeapon();

		System.out.println("|=======================================|");
		System.out.println("|                                       |");
		System.out.println(" \t "+quest.get(a-1));
		System.out.println("|                                       |");
		System.out.println("|=======================================|");

		status = battle(senjata,armor,a);
		if (status) {

			System.out.println("|=======================================|");
			System.out.println("|                                       |");
			System.out.println("      -- Selamat Anda Mendapat -- ");
			System.out.println("           " +gachaItem().getNameItem());
			System.out.println("|                                       |");
			System.out.println("|=======================================|");

			quest.remove(a-1);
			jenisMonster.remove(a-1);
			hpMonster.remove(a-1);
			baseDamageMonster.remove(a-1);

		}else{
			System.out.println("Anda Kalah!");
		}
		return status;

	}

	public boolean battle(int senjata, int armor,int a){
		initMonsterData();
		boolean tf = true;	
		int hpPlayer = getHp()+armor;
		int i=1,wave = 3;
		while(tf = true) {
			int hpEnemy = hpMonster.get(a-1);
			String namaMonster = jenisMonster.get(a-1);
			int damageMonster = baseDamageMonster.get(a-1);
			while(tf == true){
				sleep(1);
				cls();
				System.out.println("INI WAVE KE : " + i);
				System.out.println("==============================================");
				System.out.println("\t Hp "+getName()+"  \t\t Hp "+namaMonster);
				System.out.println("\t    "+hpPlayer+" \t\t    "+hpEnemy);
				System.out.println("==============================================");
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
			if (i > 3 || tf == false) {
				break;
			}
		}
		return tf;
	}
	public void showPlayer(){
		cls();
		System.out.println("|===============================================|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|\t     -> GAME GJLS <-	\t\t|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|\t Nama Player   : "+getName()+"\t\t\t|");
		System.out.println("|\t Level         : "+getLevel()+"\t\t\t|");
		System.out.println("|\t Senjata       : "+getWeapon()+"\t\t\t|");
		System.out.println("|\t Armor         : "+getNameArmor()+"\t\t\t|");
		System.out.println("|\t Hp Player     : "+getHp()+"+("+getDefend()+")\t\t|");
		System.out.println("|\t Damage Attack : "+getBaseDamage()+"+("+getDamageWeapon()+")"+"\t\t|");
		System.out.println("|\t\t\t\t\t\t|");
		System.out.println("|===============================================|");
	}

	public Items gachaItem() {
		Random dice = new Random();
		int index = dice.nextInt(0,items.size());
		// System.out.println(items.get(index).getNameItem());
		itemPlayer.add(items.get(index));
		sleep(1);
		return items.get(index);
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