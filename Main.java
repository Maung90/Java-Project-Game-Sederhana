import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class Main extends Pertempuran{
	static Scanner input = new Scanner(System.in);
	static Pertempuran duel = new Pertempuran();

	public static void main(String[] args) {

		String namaPlayer = insertPlayer();
		duel.setName(namaPlayer);
		duel.initQuest();
		do{
			menu();
			int pil1 = choose();
			switch(pil1){
			case 1 : 
				duel.showPlayer(); duel.sleep(4);
				break;
			case 2 : 
				quest(); 
				break;
			case 3 : 
				if (duel.itemPlayer.size()> 0) {
					System.out.println("|=======================================|");
					System.out.println("|                                       |");
					System.out.println("|             LIST ITEM                 |");
					for (int i=1;i<=duel.itemPlayer.size();i++ ) {
						System.out.println("\t " + i + ". " +duel.itemPlayer.get(i-1).getNameItem());
					}
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
					duel.sleep(2);
				}else{
					System.out.println("|=======================================|");
					System.out.println("|                                       |");
					System.out.println("          belum punya item ");
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
					duel.sleep(2);
				}
				break;
			case 4 : 
				chooseWeapon();
				duel.sleep(2);
				break;
			case 5 : 
				chooseArmor();
				duel.sleep(2);
				break;
			default : 
				return;
			}	
		}while(true);
	} 
	public static String insertPlayer(){
		duel.welcomeKalimat();
		// duel.cls();
		String nama;
		System.out.println("\n\n");
		System.out.println("\t\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		System.out.println("\t\t█                                     █");
		System.out.print(  "\t\t     INSERT CHAR NAME   : ");
		nama = input.next(); 
		System.out.println("\t\t█                                     █");
		System.out.println("\t\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		duel.sleep(1);
		return nama;
	}
	public static void menu(){
		duel.cls();
		System.out.println("\n\n");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		System.out.println("\t█                                     █");
		System.out.println("\t█              Menu                   █");
		System.out.println("\t█                                     █");
		System.out.println("\t█          1. Info Player             █");
		System.out.println("\t█          2. Quest                   █");
		System.out.println("\t█          3. Item's                  █");
		System.out.println("\t█          4. Pilih Senjata           █");
		System.out.println("\t█          5. Pilih Armor             █");
		System.out.println("\t█          ... Exit                   █");
		System.out.println("\t█                                     █");
		System.out.println("\t▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

	}
	public static int choose(){
		boolean status = true;
		int a;
		do{
			try{
				System.out.print("     pilih menu  : ");
				a = input.nextInt();
				status = false;
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println(" pilihan tidak ada ");
				status = true;
				a=0;

			}
		}while(status == true);

		return a;
	}
	public static void quest(){

		boolean status,status2=true;
		if (duel.quest.size() <=0) {

			System.out.println("\t|============================================|");
			System.out.println("\t|                                            |");
			System.out.println("\t               QUEST TELAH HABIS     ");
			System.out.println("\t        HARAP TUNGGU DEVELOPER UNTUK ");
			System.out.println("\t           MENAMBAHKAN QUEST BARU ");
			System.out.println("\t|                                            |");
			System.out.println("\t|============================================|");
			duel.sleep(3);
		}else{
			do{

				try{
					duel.showQuest();
					int a = choose();
					status = duel.prosesQuest(a);
					if (status) {
						System.out.println("|=======================================|");
						System.out.println("|                                       |");
						System.out.println("|                Level Up               |");
						System.out.println("|                                       |");
						System.out.println("|=======================================|");
						duel.setLevel(1);
						duel.setHp(duel.getHp(),duel.getLevel(),100);
					}
					duel.sleep(2);
					status2 = false;
				}catch(Exception e){
					System.out.println("\t  --> input yang anda masukan salah  <--");
					System.out.println("\t|                                       |");
					System.out.println("\t|=======================================|");
					status2 = true;
					duel.sleep(1);
				}
			}while(status2);
		}

	}
	public static void	chooseWeapon(){
		int z = 0, exist = 0;
		for (int i=1; i<=duel.itemPlayer.size(); i++) {
			if (duel.itemPlayer.get(i-1).getJenis().equals("senjata")) {
				z++;
			}
		}
		if (z <= 0 ) {
			System.out.println("\t|=======================================|");
			System.out.println("\t|                                       |");
			System.out.println("\t      Belum Memiliki Senjata  ");
			System.out.println("\t|                                       |");
			System.out.println("\t|=======================================|");
		}else{
			System.out.println("\t|=======================================|");
			System.out.println("\t|                                       |");
			System.out.println(" \t\t --- Pilih Senjata --- ");
			int nomor2 = 1;
			for (int i=1; i<=duel.itemPlayer.size(); i++) {
				if (duel.itemPlayer.get(i-1).getJenis().equals("senjata")) {
					System.out.println("\t"+nomor2+". " + duel.itemPlayer.get(i-1).getNameItem());
					nomor2++;
				}
			}

			String selectWeapon;
			if (duel.itemPlayer.size() > 0) {
				System.out.println("\t|                                       |");
				System.out.println("\t|=======================================|");
				System.out.print("\n \t\t masukan nama senjata : ");
				selectWeapon = input.next();

				for (int i=1; i<=duel.itemPlayer.size(); i++) {
					if (duel.itemPlayer.get(i-1).getJenis().equals("senjata")) {
						if (!duel.itemPlayer.get(i-1).getNameItem().equalsIgnoreCase(selectWeapon)) {
							exist = 0;
						}
						else{
							exist = i;
							break;
						}
					}
				}
				if (exist == 0) {
					System.out.println(" \t Senjata tidak tersedia");
				}else{
					duel.setWeapon(selectWeapon);
					duel.setDamageWeapon(duel.itemPlayer.get(exist-1).getItemEffect());
					duel.itemPlayer.remove(exist-1);
				}
			}else{
				System.out.println("\t|=======================================|");
				System.out.println("\t|                                       |");
				System.out.println("\t      Belum Memiliki Senjata  ");
				System.out.println("\t|                                       |");
				System.out.println("\t|=======================================|");
			}
		}
	}
	public static void	chooseArmor(){
		int z = 0, exist = 0;
		for (int i=1; i<=duel.itemPlayer.size(); i++) {
			if (duel.itemPlayer.get(i-1).getJenis().equals("armor")) {
				z++;
			}
		}
		if (z <= 0) {
			System.out.println("\t|=======================================|");
			System.out.println("\t|                                       |");
			System.out.println("\t      Belum Memiliki Armor  ");
			System.out.println("\t|                                       |");
			System.out.println("\t|=======================================|");
		}else{
			System.out.println("\t|=======================================|");
			System.out.println("\t|                                       |");
			System.out.println("\t\t --- Pilih Armor --- ");
			int nomor = 1;
			for (int i=1; i<=duel.itemPlayer.size(); i++) {
				if (duel.itemPlayer.get(i-1).getJenis().equals("armor")) {
					System.out.println("\t"+nomor+". " +duel.itemPlayer.get(i-1).getNameItem());
					nomor++;
				}
			}
			if (duel.itemPlayer.size() > 0) {
				System.out.println("\t|                                       |");
				System.out.println("\t|=======================================|");
				String selectArmor;
				System.out.print("\n \t\t masukan nama armor : ");
				selectArmor = input.next();
				for (int i=1; i<=duel.itemPlayer.size(); i++) {
					if (duel.itemPlayer.get(i-1).getJenis().equals("armor")) {
						if (!duel.itemPlayer.get(i-1).getNameItem().equalsIgnoreCase(selectArmor)) {
							exist = 0;
						}else{
							exist = i;
						}
					}
				}
				if (exist==0) {
					System.out.println(" \t\t Armor tidak tersedia");
				}else{
					duel.setNameArmor(selectArmor);
					duel.setDefend(duel.itemPlayer.get(exist-1).getItemEffect());
					duel.itemPlayer.remove(exist-1);
				}
			}else{
				System.out.println("\t      Belum Memiliki Armor  ");
				System.out.println("\t|                                       |");
				System.out.println("\t|=======================================|");
			}
		}
	}

}