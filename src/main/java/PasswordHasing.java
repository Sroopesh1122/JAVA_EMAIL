import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasing {
	
	
	 public static String hashPassword(String plainPassword) {
	        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(10));
	    }
	 
	 public static boolean verifyPassword(String plainPassword, String hashedPassword) {
	        return BCrypt.checkpw(plainPassword, hashedPassword);
	    }

	public static void main(String[] args) {
		
		String hashedPassword = hashPassword("shivu9895");
		System.out.println(hashedPassword);
		
		if(verifyPassword( "Shivu9895",hashedPassword))
		{
			System.out.println("Success");
		}else {
			System.out.println("Failed");
		}
	
		

	}

}
