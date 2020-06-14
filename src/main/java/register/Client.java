package register;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import MainMenu.Item;
import MainMenu.ItemList;
import MainMenu.Movie;

public class Client extends User {
	
	private ObjectMapper omap;
	private String PlayList;
	
	public Client() {
		super();
		PlayList = getName() + " - queue";
		try {
			new File("Queue Database/"+PlayList+".json").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.omap=new ObjectMapper();
	}
	
	public Client (String Name, String Password) {
		super(Name,Password);
		PlayList = getName() + " - queue";
		try {
			new File("Queue Database/"+PlayList+".json").createNewFile();// se creaza automat fisier null - queue
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPlayList() {
		return PlayList;
	}

	public void setPlayList(String playList) {
		PlayList = playList;
	}

	@Override
	public String toString() {
		return "Client [PlayList=" + PlayList + ", Name=" + Name + ", Password=" + Password + ", Salt="
				+ Arrays.toString(Salt) + "]";
	}
	
	public void addItem(Item it) {
		ItemList iList = null;
		File f=new File("Queue Database/"+PlayList+".json");
		if(!f.exists() || f.length()==0)
			 iList= new ItemList();
		try {
			if(f.length()!=0)
				iList=omap.readerFor(ItemList.class).readValue(f);//nu gaseste directorul cred
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		iList.addItem(it);

		try {
			omap.writerWithDefaultPrettyPrinter().writeValue(f, iList);//nu gaseste directorul cred
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeItem(Item it) {
		ItemList iList = null;
		File f=new File("Queue Database/"+PlayList+".json");
		
		//reads playlist
		if(!f.exists() || f.length()==0)
			 iList= new ItemList();
		try {
			if(f.length()!=0)
				iList=omap.readerFor(ItemList.class).readValue(f);//nu gaseste directorul cred
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		iList.removeItem(it);
		
		//writes playlist
		try {
			omap.writerWithDefaultPrettyPrinter().writeValue(f, iList);//nu gaseste directorul cred
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	

}
