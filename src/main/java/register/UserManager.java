package register;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserManager {
	private ObjectMapper oMap; 
	
	public UserManager() {
		super();
		this.oMap=new ObjectMapper();
	}

	public void writeClients(ClientList cList) {
		try {
			oMap.writerWithDefaultPrettyPrinter().writeValue(new File("client_database.json"), cList);
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
			oMap.writerWithDefaultPrettyPrinter().writeValue(new File("admin_database.json"), aList);
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
