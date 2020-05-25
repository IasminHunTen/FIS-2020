package register;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Client extends User {

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

}
