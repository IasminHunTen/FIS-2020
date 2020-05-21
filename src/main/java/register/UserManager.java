package register;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserManager {
	private ObjectMapper omap; 
	
	public UserManager() {
		super();
		this.omap=new ObjectMapper();
	}

	public void writeClients(ClientList cList) {
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
	
	public void writeAdmins(AdminList aList) {
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
	
	public ClientList readClients() { // Dosen't work. I don't know why
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
	
	public AdminList readAdmins() {
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
}
