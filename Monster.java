import java.util.ArrayList;

interface Monster{

	public ArrayList <String> jenisMonster = new ArrayList <String>();
	public ArrayList <Integer> hpMonster = new ArrayList <Integer>();
	public ArrayList <Integer> defendMonster = new ArrayList <Integer>();
	public ArrayList <Integer> baseDamageMonster = new ArrayList <Integer>();

	public int terimaDamagePlayer(int maxDamagePlayer,int senjata);


}