package register;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public abstract class User {

	protected String Name;
	protected String Password;
	protected byte[] Salt;
	protected String SaltS; // nu cea mai eleganta metoda, dar pentru a salva Salt in json merge
	
	public User() {
		
	}
	
	public User(String Name, String Password) {
		this.Name=Name;
		
		try {
			this.Salt= getSalt() ;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SaltS=Salt.toString();
		this.Password=SHA_256(Password,Salt);
	}
	
	protected User(String Name, String Password,byte[] Salt) {
		this.Name=Name;
		
		this.Salt= Salt ;
		this.Password=Password;
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
		return "User [Name=" + Name + ", Password=" + Password + ", Salt=" + Arrays.toString(Salt) + "]";
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
	
	protected void setPassword(String password) {
		Password = password;
	}

	protected void setSalt(byte[] salt) {
		Salt = salt;
	}

	public String getSaltS() {
		return SaltS;
	}

	public void setSaltS(String saltS) {
		Salt=saltS.getBytes();
		SaltS = saltS;
	}

	public boolean checkPassword(String passwordTest) { // verifica daca stringul introdus incriptat devine aceeas parola cu cea a utilizatorului
		String hashedPassword=SHA_256(passwordTest,Salt);
		if (hashedPassword.equals(Password))
			return true;
		else
			return false;
	}


	private String SHA_256(String plainPassword,byte[] sal) {
		  {
		        String generatedPassword = null;
		        try {
		            MessageDigest md = MessageDigest.getInstance("SHA-1");
		            md.update(sal);
		            byte[] bytes = md.digest(plainPassword.getBytes());
		            StringBuilder sb = new StringBuilder();
		            for(int i=0; i< bytes.length ;i++)
		            {
		                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		            }
		            generatedPassword = sb.toString();
		        } 
		        catch (NoSuchAlgorithmException e) 
		        {
		            e.printStackTrace();
		        }
		        return generatedPassword;
		    }
	}
	
	private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
	
	
	
}
