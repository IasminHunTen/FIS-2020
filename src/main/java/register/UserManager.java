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
// user to replace cl and ad, make sure playlist and items can be added to client-user trough UserManager
	protected void writeUsers(UserList uList) {
		try {
			omap.writerWithDefaultPrettyPrinter().writeValue(new File("user_database.json"), uList);
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
	
	protected UserList readUsers() {
		 UserList ul = new UserList();
		 File f=new File("user_database.json");
		 if(!f.exists() || f.length()==0)
			 ul=new UserList();
		 try {
			ul=omap.readerFor(UserList.class).readValue(new File("user_database.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return ul;
	}
	
	public void addUser(User u) {
		UserList ul= readUsers();
		ul.addUser(u);
		writeUsers(ul);
}
//replace client and admin with users?
	
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
	
	public void addClient(Client c) {
			ClientList cl= readClients();
			cl.addClient(c);
			writeClients(cl);
	}
	
	public void addAdmin(Admin a) {
		AdminList al= readAdmins();
		al.addAdmin(a);
		writeAdmins(al);
}
	//merge client and admin functions into user functions
	public Client getClient(String client) throws Exception {
		ArrayList<Client> cl = this.readClients().getClients();
		for(int i=0;i<cl.size();i++)
			if(cl.get(i).getName().equals(client))
				return cl.get(i);
		throw new Exception("User does not exist");
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

	public boolean checkPassword(String username, String password) {
		try {
			Client u=this.getClient(username);
			if(u.checkPassword(password))
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
