import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class Main extends Pertempuran{
	static Scanner input = new Scanner(System.in);
	static Pertempuran duel = new Pertempuran();

	public static void main(String[] args) {
		// duel.setHp();
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
			case 3:
				if (duel.itemPlayer.size()> 0) {
					System.out.println("|=======================================|");
					System.out.println("|                                       |");
					for (int i=1;i<=duel.itemPlayer.size();i++ ) {
						System.out.println("\t " + i + " " +duel.itemPlayer.get(i-1).getNameItem());
					}
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
					duel.sleep(2);
				}else{
					System.out.println(" belum punya item ");
					duel.sleep(2);
				}
				break;
				
			case 4: 
				System.out.println("|=======================================|");
				System.out.println("|                                       |");
				System.out.println(" \t --- Pilih Senjata --- ");
				int nomor2 = 1;
				for (int i=1; i<=duel.itemPlayer.size(); i++) {
					if (duel.itemPlayer.get(i-1).getJenis().equals("senjata")) {
						System.out.println("\t"+nomor2+". " + duel.itemPlayer.get(i-1).getNameItem());
					nomor2++;
					}
				}
				String selectWeapon;
				if (duel.itemPlayer.size() > 0) {
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
					System.out.print("\n \t masukan nama senjata : ");
					selectWeapon = input.next();

					for (int i=1; i<=duel.itemPlayer.size(); i++) {
						if (duel.itemPlayer.get(i-1).getJenis().equals("senjata")) {
							if (duel.itemPlayer.get(i-1).getNameItem().equalsIgnoreCase(selectWeapon)) {
								duel.setWeapon(selectWeapon);
								duel.setDamageWeapon(duel.itemPlayer.get(i-1).getItemEffect());
							// System.out.println("Anda memilih senjata : "+selectWeapon);
							}else{
								System.out.println(" \t Senjata tidak tersedia");
							}
						}
					}
				}else{
					System.out.println("      Belum Memiliki Senjata  ");
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
				}
				duel.sleep(2);
				break;
			case 5: 
				System.out.println("|=======================================|");
				System.out.println("|                                       |");
				System.out.println("\t --- Pilih Armor --- ");
				int nomor = 1;
				for (int i=1; i<=duel.itemPlayer.size(); i++) {
					if (duel.itemPlayer.get(i-1).getJenis().equals("armor")) {
						System.out.println("\t"+nomor+". " +duel.itemPlayer.get(i-1).getNameItem());
						nomor++;
					}
				}
				if (duel.itemPlayer.size() > 0) {
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
					String selectArmor;
					System.out.print("\n \t masukan nama armor : ");
					selectArmor = input.next();
					for (int i=1; i<=duel.itemPlayer.size(); i++) {
						if (duel.itemPlayer.get(i-1).getJenis().equals("armor")) {
							if (duel.itemPlayer.get(i-1).getNameItem().equalsIgnoreCase(selectArmor)) {
								duel.setNameArmor(selectArmor);
								duel.setDefend(duel.itemPlayer.get(i-1).getItemEffect());
							// System.out.println("Anda memilih senjata : "+selectArmor);
							}else{
								System.out.println(" \t Senjata tidak tersedia");
							}
						}
					}
				}else{
					System.out.println("      Belum Memiliki Senjata  ");
					System.out.println("|                                       |");
					System.out.println("|=======================================|");
				}
				duel.sleep(2);
				break;
			default : 
				return;
			}	
		}while(true);





	}

	public static String insertPlayer(){
		duel.welcomeKalimat();
		duel.cls();
		String nama;
		System.out.println("|=======================================|");
		System.out.println("|                                       |");
		System.out.print(  "     Insert Char Name   : ");
		nama = input.next();
		System.out.println("|                                       |");
		System.out.println("|=======================================|");
		duel.sleep(1);
		return nama;
	}
	public static void menu(){
		duel.cls();
		System.out.println("|=======================================|");
		System.out.println("|              Menu                     |");
		System.out.println("|                                       |");
		System.out.println("|          1. Info Player               |");
		System.out.println("|          2. Quest                     |");
		System.out.println("|          3. Item's                    |");
		System.out.println("|          4. Pilih Senjata             |");
		System.out.println("|          5. Pilih Armor               |");
		System.out.println("|                                       |");
		System.out.println("|=======================================|");

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

		boolean status;
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
	}
	
}