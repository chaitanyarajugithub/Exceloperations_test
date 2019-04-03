package Resource;

public class Usefulmethods {
	
	public String Role(String name) {
	    switch (name) {
	        case "Super User":
	            return "Account owner";
	        case "Super Admin":
	            return "Account owner";
	        case "Admin":
	            return "Admin";
	        case "Manager":
	            return "Employee";
	        case "Employee":
	            return "Employee";
	        default:
	            return "Account owner";
	    }
	}  
	
	/*public static void main(String args[]) {
		String data = Role("Employee");
		System.out.println(data);
	}
*/
}
