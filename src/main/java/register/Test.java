package register;

import java.util.ArrayList;

import MainMenu.Item;
import MainMenu.Movie;
//add TestCase junit
public class Test{

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Client c1=new Client("an","cal");
		Client c2=new Client("ab","cal");
		Client c3=new Client("zor","daf");
		
		Admin a1=new Admin("buna","ziua");
		Admin a2=new Admin("fe","rit");
		ArrayList<Client> list=new ArrayList<Client>();
		list.add(c1);
		list.add(c2);
		//list.add(c3);
		ClientList l=new ClientList(list);
		UserManager u=new UserManager();
		u.writeClients(l);
		c3.addItem(new Movie("title","gen", 1999, "plot",new ArrayList<String>() ));
		u.addClient(c3);
		/*System.out.println(u.readClients());
/*
		ArrayList<Admin> list=new ArrayList<Admin>();
		list.add(a1);
		list.add(a2);
		AdminList l=new AdminList(list);
		UserManager u=new UserManager();
		u.writeAdmins(l);
		//u.addClient(c3);
		System.out.println(u.readAdmins());
		ArrayList<Admin> x=u.readAdmins().getAdmins();
		System.out.println("Salt a1: " +a1.Salt);
		*/
	}

}
