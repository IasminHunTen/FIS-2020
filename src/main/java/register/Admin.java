package register;

public class Admin extends User {//cred ca nu ar trebui ca orcine sa poata crea cont de admin

	public Admin(String Name, String Password) {
		super(Name,Password);
		super.setRole("Admin");
	}

}
