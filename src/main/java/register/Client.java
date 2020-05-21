package register;

import MainMenu.Item;
import MainMenu.ItemList;

public class Client extends User {

	private ItemList PlayList= new ItemList();
	
	public Client (String Name, String Password) {
		super(Name,Password);
		super.setRole("Client");
	}
	
	public void addItem(Item it)
	{
		PlayList.addItem(it);
	}
	public Item getItem() {
		//To do
		return null;
	}

}
