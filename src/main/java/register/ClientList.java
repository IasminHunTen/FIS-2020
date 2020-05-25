package register;

import java.util.ArrayList;

public class ClientList {

	private ArrayList<Client> clients=new ArrayList<Client>(); 
	public ClientList() {
		super();
	}
	
	public ClientList(ArrayList<Client> clientsList) {
		super();
		clients=clientsList;
	}
	
	public ArrayList<Client> getClients(){
		return clients;
	}
	
	public void addClient(Client c) throws Exception {
		if(!clients.contains(c))
			clients.add(c);
		else throw new Exception("Client already in the database");
	}


	public boolean containsName(String name) {
		for(int i=0;i<clients.size();i++) {
			if(clients.get(i).checkUsername(name))
				return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "ClientList [clients=" + clients + "]";
	}

}