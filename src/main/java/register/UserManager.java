package register;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import MainMenu.Item;

public class UserManager {
	private ObjectMapper omap; 
	
	public UserManager() {
		super();
		this.omap=new ObjectMapper();
	}
	
	protected void writeClients(ClientList cList) {
		try {
			omap.writerWithDefaultPrettyPrinter().writeValue(new File("client_database.json"), cList);
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
	
	protected void writeAdmins(AdminList aList) {
		try {
			omap.writerWithDefaultPrettyPrinter().writeValue(new File("admin_database.json"), aList);
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
	
	protected ClientList readClients() {
		 ClientList cl = new ClientList();
		 File f=new File("client_database.json");
		 if(!f.exists() || f.length()==0)
			 cl=new ClientList();
		 try {
			cl=omap.readerFor(ClientList.class).readValue(new File("client_database.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return cl;
	}
	
	protected AdminList readAdmins() {
		 AdminList ad = null;
		 File f=new File("admin_database.json");
		 if(!f.exists() || f.length()==0)
			 ad=new AdminList();
		 else {
			 try {
				 ad= omap.readerFor(AdminList.class).readValue(new File("admin_database.json"));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	    }
		 return ad;
	}


	public void addClient(Client c) throws Exception {
			ClientList cl= readClients();
			cl.addClient(c);
			writeClients(cl);
	}
	
	public void addAdmin(Admin a) throws Exception {
		AdminList al= readAdmins();
		al.addAdmin(a);
		writeAdmins(al);
}
	// o functie de stergere ar putea fi utila, dar pentru proiect nu pare necesara
	
	public Client getClient(String client) throws Exception {
		ArrayList<Client> cl = this.readClients().getClients();
		for(int i=0;i<cl.size();i++)
			if(cl.get(i).getName().equals(client))
				return cl.get(i);
		throw new Exception("User does not exist");
	}
	
	public Admin getAdmin(String admin) throws Exception {
		ArrayList<Admin> al = this.readAdmins().getAdmins();
		for(int i=0;i<al.size();i++)
			if(al.get(i).getName().equals(admin))
				return al.get(i);
		throw new Exception("User does not exist");
	}
	
	public boolean checkPassword(String username, String password) {
		try {
			Client c=this.getClient(username);
			if(c.checkPassword(password))
				return true;
			Admin a=this.getAdmin(username);
			if(a.checkPassword(password))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;// nu sunt sigur de asta, "Username or password is incorect"
		}
		
		return false;
	}
	
	public ArrayList<Item> getPlayList(String username) throws Exception{
		Client u=this.getClient(username);
		return u.getPlayList();
	}
}
