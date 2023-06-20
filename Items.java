class Items{
	private String nameItem;
	private int itemEffect;
	private String jenis;

	public Items(String nameItem, int itemEffect,String jenis){
		this.nameItem = nameItem;
		this.itemEffect = itemEffect;
		this.jenis = jenis;
	}

	public String getNameItem(){
		return this.nameItem;
	} 
	public void setNameItem(String nameItem){
		this.nameItem = nameItem;
	}



	public int getItemEffect(){
		return this.itemEffect;
	}
	public void setItemEffect(int itemEffect){
		this.itemEffect = itemEffect;
	}

	
	public String getJenis(){
		return this.jenis;
	}
	public void setJenis(String jenis){
		this.jenis = jenis;
	}
}