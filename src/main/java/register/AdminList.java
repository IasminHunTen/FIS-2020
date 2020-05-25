package register;

import java.util.ArrayList;

public class AdminList {

	private ArrayList<Admin> admins=new ArrayList<Admin>(); 
	public AdminList() {
		super();
	}
	
	public AdminList(ArrayList<Admin> adminsList) {
		super();
		admins=adminsList;
	}
	
	public ArrayList<Admin> getAdmins(){
		return admins;
	}
	
	public void addAdmin(Admin a) throws Exception {// poate exista o metoda mai buna, dar am vrut sa verific daca apare acelas nume, cred ca exclude posibilitatea
								  //  ca un cont sa fie gasit accidental; pe de alta parte toate numele utilizatorilor sunt mai expuse
							     //	  Equals din user e suprascris ca 2 useri avand acelas nume;
		if(!admins.contains(a))
			admins.add(a);
		else throw new Exception("Admin already in the database");
	
	}

	public boolean containsName(String name) {
		for(int i=0;i<admins.size();i++) {
			if(admins.get(i).checkUsername(name))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "AdminList [admins=" + admins + "]";
	}
	
	
	

}