package register;

import java.util.ArrayList;
import java.util.Arrays;

import MainMenu.Item;

public class Client extends User {

	private ArrayList<Item> PlayList= new ArrayList<Item>();
	
	public Client() {
		super();
	}
	
	public Client (String Name, String Password) {
		super(Name,Password);
	}
	
	public ArrayList<Item> getPlayList() {
		return PlayList;
	}

	public void setPlayList(ArrayList<Item> playList) {
		PlayList = playList;
	}

	public void addItem(Item it)
	{
		PlayList.add(it);
	}

	@Override
	public String toString() {
		return "Client [PlayList=" + PlayList + ", Name=" + Name + ", Password=" + Password + ", Salt="
				+ Arrays.toString(Salt) + "]";
	}

}
