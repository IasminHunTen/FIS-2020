package register;

public abstract class User {

	private String Name;
	private String Password;
	private String Role;
	
	public User(String Name, String Password) {
		this.Name=Name;
		this.Password=Password;  //remember to hash the Password !!!!!!
	}
	
	@Override
	public boolean equals(Object obj) {// presupunem ca nu acceptam 2 useri cu acelasi nume
		if (obj instanceof User)
		{
			User u=(User)obj;
			if(this.getName().equals(u.getName()))
				return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	
	
}
