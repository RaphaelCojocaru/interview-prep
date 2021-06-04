import java.security.Permission;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-factory/problem

interface Food {
    public String getType();
}

class Pizza implements Food {
	public String getType() {
		return "Someone ordered a Fast Food!";
	}
}

class Cake implements Food {
	public String getType() {
		return "Someone ordered a Dessert!";
	}
}

class FoodFactory {
	public Food getFood(String order) {
        switch (order) {
            case "cake" :
                return new Cake();
            case "pizza":
                return new Pizza();
            default:
                return null;
        }
    }
}

class Do_Not_Terminate {
	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
    	final SecurityManager securityManager = new SecurityManager() {
    		@Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };

        System.setSecurityManager(securityManager);
    }
}

public class JavaFactory {
	public static void main(String args[]){
		Do_Not_Terminate.forbidExit();

		try{
			Scanner scan = new Scanner(System.in);

			FoodFactory foodFactory = new FoodFactory();

			Food food = foodFactory.getFood(scan.nextLine());


			System.out.println("The factory returned " + food.getClass());
			System.out.println(food.getType());

			scan.close();
		} catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	 }
}
