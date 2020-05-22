package register;

import java.util.ArrayList;

public class UserList {

	private ArrayList<User> users=new ArrayList<User>(); 
	public UserList() {
		super();
	}
	
	public UserList(ArrayList<User> usersList) {
		super();
		users=usersList;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void addUser(User u) {
		if(!users.contains(u))
			users.add(u);
		//else throw an exception
	
	}

	@Override
	public String toString() {
		return "UserList [users=" + users + "]";
	}

}