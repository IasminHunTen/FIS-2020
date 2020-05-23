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

	@Override
	public String toString() {
		return "ClientList [clients=" + clients + "]";
	}

}