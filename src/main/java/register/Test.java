package register;

import java.util.ArrayList;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Client c1=new Client("an","cal");
		Client c2=new Client("ab","cal");
		Client c3=new Client("dan","zor");
		//User a1=new Admin("buna","ziua");
		ArrayList<Client> list=new ArrayList<Client>();
		list.add(c1);
		list.add(c2);
		ClientList l=new ClientList(list);
		l.addClient(c3);
	}

}
