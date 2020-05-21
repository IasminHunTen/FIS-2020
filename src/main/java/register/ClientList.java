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
	
	public void addClient(Client c) {// poate exista o metoda mai buna, dar am vrut sa verific daca apare acelas nume, cred ca exclude posibilitatea
								    //  ca un cont sa fie gasit accidental; pe de alta parte toate numele utilizatorilor sunt mai expuse
							       //	Equals din user e suprascris ca 2 useri avand acelas nume;
		if(!clients.contains(c))
			clients.add(c);
		//else throw an exception
	
	}

}