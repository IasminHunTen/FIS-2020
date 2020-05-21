package register;

import java.util.Arrays;

public class Admin extends User {//cred ca nu ar trebui ca orcine sa poata crea cont de admin

public Admin() {
		super();
	}
	
	public Admin(String Name, String Password) {
		super(Name,Password);
	}

	@Override
	public String toString() {
		return "Admin [Name=" + Name + ", Password=" + Password + ", Salt=" + Arrays.toString(Salt) + "]";
	}
	
	

}
