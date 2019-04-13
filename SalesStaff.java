import java.util.Scanner;

public class SalesStaff extends Employee
{
	Scanner console = new Scanner(System.in);
	
	public SalesStaff(String id, String pass, String type)
	{
		super(id, pass, type);
	}
	
	public void overrideTransaction()
	{
		String opening = ("Enter '1' to remove latest item.\n"
					    + "What would you like to do: ");
		String input;
		int userInput;
		boolean userInputOK = false;
		
		while(!userInputOK)
		{
			try
			{
				System.out.print(opening);
				input = console.nextLine();
				
				userInput = Integer.parseInt(input);
				if(userInput < 0)
				{
					System.out.println("ERROR: Invalid number entered. Please try again.\n");
				}
				else
				{
					userInputOK = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("ERROR: Not a number entered. Please try again.\n");
				overrideTransaction();
			}
		}
	}
	
	public void removeItem(Customer c)
	{
		
	}
}
