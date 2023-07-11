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
		Items item = new Items("TONGKAT",150,"senjata");
		Items item2 = new Items("ZIRAH-KAYU",130,"armor");
		Items item3 = new Items("PANAH",200,"senjata");
		Items item4 = new Items("ZIRAH-BESI",200,"armor");
		Items item5 = new Items("BOM",250,"senjata");
		Items item6 = new Items("ZIRAH-BAJA",300,"armor");

		Items item7 = new Items("KAPAK",150,"senjata");
		Items item8 = new Items("HELM-KAYU",230,"armor");
		Items item9 = new Items("PISTOL",200,"senjata");
		Items item10 = new Items("HELM-BESI",200,"armor");
		Items item11 = new Items("MACHINEGUN",300,"senjata"); 
		Items item12 = new Items("HELM-BAJA",250,"armor");

		items.add(item);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		items.add(item11);
		items.add(item12);

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

		baseDamageMonster.add(200);
		baseDamageMonster.add(250);
		baseDamageMonster.add(700);

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
		System.out.println("\n\n");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		System.out.println("\t█                                            █");
		System.out.println("\t█                                            █");
		for (int i = 1; i <= quest.size(); i++ ) {
			System.out.println("  \t\t" + i + " " + quest.get(i-1) );
		}
		System.out.println("\t█                                            █");
		System.out.println("\t█                                            █");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		
		
	} 
	public boolean prosesQuest(int a){
		initItems();
		boolean status = false;
		// int senjata = getDamageWeapon(); 
		int armor = getDefend();
		System.out.println("\t|=======================================|");
		System.out.println("\t|                                       |");
		System.out.println("\t \t "+quest.get(a-1));
		System.out.println("\t|                                       |");
		System.out.println("\t|=======================================|");
		sleep(1);
		status = battle(armor,a);
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
			System.out.println("|=======================================|");
			System.out.println("|                                       |");
			System.out.println("\t --> ANDA KALAH! <--");
			System.out.println("|                                       |");
			System.out.println("|=======================================|");
		}
		
		return status;

	}
	
	//overreading dari class player
	public void showPlayer(){
		cls();
		System.out.println("\n\n");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		System.out.println("\t█                                            █");
		System.out.println("\t█                                            █");
		System.out.println("\t               INFO PLAYER                   ");
		System.out.println("\t        NAMA PLAYER   : "+getName());
		System.out.println("\t        LEVEL         : "+getLevel());
		System.out.println("\t        SENJATA       : "+getWeapon());
		System.out.println("\t        ARMOR         : "+getNameArmor());
		System.out.println("\t        HP PLAYER     : "+getHp()+"+("+getDefend()+")");
		System.out.println("\t        DAMAGE ATTACK : "+getBaseDamage()+"+("+getDamageWeapon()+")");
		System.out.println("\t█                                            █");
		System.out.println("\t█                                            █");
		System.out.println("\t█                                            █");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
	}
	public Items gachaItem() {
		Random dice = new Random();
		int index = dice.nextInt(0,items.size());
		itemPlayer.add(items.get(index));
		sleep(1);
		return items.get(index);
	}
	public int terimaDamagePlayer(int maxDamagePlayer,int senjata){
		Random dice = new Random();
		int damagePlayer = dice.nextInt(50,maxDamagePlayer);
		return damagePlayer;
	}


	public boolean battle( int armor,int a){
		initMonsterData();
		boolean kondisi1 = true,kondisi2 = true;	
		int hpPlayer = getHp()+armor;
		int i=1;
		int senjata = getDamageWeapon();
		String weaponName = getWeapon();
		while(kondisi1 = true) {
			int hpEnemy = hpMonster.get(a-1);
			String namaMonster = jenisMonster.get(a-1);
			int damageMonster = baseDamageMonster.get(a-1);

			cls();
			System.out.println("\n\t\tWAVE " + i);
			sleep(1);
			while(kondisi1 == true){

				if (hpEnemy > 0 || hpPlayer > 0) {
					if (hpPlayer > 0) {
						int damageEnemy = terimaDamageMonster(damageMonster);
						Animation.enemyAttack(getName(),namaMonster,hpPlayer,hpEnemy,damageEnemy);
						hpPlayer -= damageEnemy;
					}

					if (hpEnemy > 0) { 
						int damagePlayer = terimaDamagePlayer(getBaseDamage(),senjata);
						if (weaponName.equalsIgnoreCase("PISTOL")) {
							Animation.playerAttackPistol(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}else if (weaponName.equalsIgnoreCase("PANAH")) {
							Animation.playerAttackPanah(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}else if (weaponName.equalsIgnoreCase("KAPAK")) {
							Animation.playerAttackKapak(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}else if (weaponName.equalsIgnoreCase("MACHINEGUN")) {
							Animation.playerAttackMachineGun(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}else if (weaponName.equalsIgnoreCase("TONGKAT")) {
							Animation.playerAttackTongkat(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}else if (weaponName.equalsIgnoreCase("BOM")) {
							Animation.playerAttackBom(getName(),namaMonster,hpPlayer,hpEnemy,damagePlayer);

						}
						hpEnemy -= damagePlayer;
					}

					if (hpPlayer <= 0) {
						cls();
						System.out.println("                                ");
						System.out.println("                          \\@/   ");
						System.out.println("                            |   ");
						System.out.println("___________________________/ \\___");
						System.out.println("                                  ");
						System.out.println("    "+getName() + " telah Kalah ");
						sleep(1);
						kondisi1 = false;
						break;
					}

					if (hpEnemy <= 0) {
						cls();
						System.out.println("                                ");
						System.out.println("                                ");
						System.out.println("  \\@/                           ");
						System.out.println("   |                          ");
						System.out.println("__/ \\__________________________");
						System.out.println("    "+ namaMonster + i+ " telah Kalah");
						sleep(1);
						break;
					}
					

				}else{
					kondisi2 = false;
					break;
				}
			}
			
			i++;
			if (i > 3 || kondisi1 == false) {
				break;
			}
		}
		return kondisi1;
	}


	public void welcomeKalimat(){
		cls();
		System.out.println("\n\n\n");
		System.out.println("\t          █   █ █▀▀ █   █▀▀ █▀▀█ █▀▄▀█ █▀▀");
		System.out.println("\t          █▄█▄█ █▀▀ █   █   █  █ █ ▀ █ █▀▀"); 
		System.out.println("\t           ▀ ▀  ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀   ▀ ▀▀▀");
		System.out.println("\t ░█▀▀█  █▀▄▀█  █▀▀▄ 　 █▀▀ █ █ █▀▀█ █   █▀▀█ █▀▀█ █▀▀ █▀▀█"); 
		System.out.println("\t ░█     █ █ █  █ 　█   █▀▀ ▄▀▄ █  █ █   █  █ █▄▄▀ █▀▀ █▄▄▀ ");
		System.out.println("\t ░█▄▄█  █   █  █▄▄▀ 　 ▀▀▀ ▀ ▀ █▀▀▀ ▀▀▀ ▀▀▀▀ ▀ ▀▀ ▀▀▀ ▀ ▀▀");

		sleep(3);
	}
	public void cls(){
		try{
			new ProcessBuilder("cmd","/c","clear").inheritIO().start().waitFor();
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