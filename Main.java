import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main extends Pertempuran{
	static Scanner input = new Scanner(System.in);
	static Pertempuran duel = new Pertempuran();

	public static void main(String[] args) {

		int a,b,senjata = 0,armor = 0,level=1;;
		String namaPlayer,jawaban ="",weapon="";
		namaPlayer = insertPlayer();
		a = chooseWeapon();
		switch(a){
		case 1 : weapon ="Panah"; senjata = 150; break;
		case 2 : weapon ="Batu"; senjata = 100;break;
		case 3 : weapon = "Katana"; senjata = 250;break;
		default : weapon ="Bambu"; senjata = 200;break;
		}
		b = chooseArmor();
		switch(b){
		case 1 -> armor = 150;
		case 2 -> armor = 100;
		case 3 -> armor = 250;
		default -> armor = 200;
		}
		duel.setName(namaPlayer);
		duel.setWeapon(weapon);	

		do{
			duel.showPlayer(senjata,armor,level);

			System.out.print("1 ");
			duel.sleep(1);
			System.out.print("2 ");
			duel.sleep(1);
			System.out.print("3...");
			duel.sleep(1);

			boolean status = duel.battle(senjata,level,armor);
			
			if (status == true) {
				level+=1;
				input.nextLine();
				System.out.print("lanjut duel ? ");
				jawaban = input.nextLine();
			}else{
				jawaban = "n";
			}

		}while(jawaban.equals("y"));
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
	public static int chooseWeapon(){
		duel.cls();
		System.out.println("|=======================================|");
		System.out.println("| 1. Panah               damage : 150   |");
		System.out.println("| 2. Batu                damage : 100   |");
		System.out.println("| 3. Katana              damage : 250   |");
		System.out.println("| ... Bambu              damage : 200   |");
		System.out.println("|=======================================|");
		try{
			System.out.print(" masukan pilihan      : ");
			int a = input.nextInt();
			duel.sleep(1);
			return a;
		}catch(InputMismatchException e){
			input.nextLine();
			System.out.println("Input Yang Anda Masukan Salah !");
			duel.sleep(2);
			return 0;
		}
	}


	public static int chooseArmor(){
		duel.cls();
		System.out.println("|=======================================|");
		System.out.println("| 1. Blade Armor         defend : 150   |");
		System.out.println("| 2. Vest lvl 3          defend : 100   |");
		System.out.println("| 3. Helm lvl 3          defend : 250   |");
		System.out.println("| ... Imorrtal           defend : 200   |");
		System.out.println("|=======================================|");
		try{
			System.out.print(" masukan pilihan      : ");
			int a = input.nextInt();
			duel.sleep(1);
			return a;
		}catch(InputMismatchException e){
			input.nextLine();
			System.out.println("Input Yang Anda Masukan Salah !");
			duel.sleep(2);
			return 0;
		}
	}
}