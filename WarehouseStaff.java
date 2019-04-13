import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseStaff extends Employee
{
	Scanner console = new Scanner (System.in);

	public WarehouseStaff(String id, String pass, String type)
	{
		super(id, pass, type);
	}

	public void replenishStock(ArrayList<Product> pList, String pID, int upAmt)
	{
		int i = 0;
		do
		{
			if(pList.get(i).getProductId().equals(pID))
			{
				pList.get(i).setStockLevel(upAmt);
			}
			else
			{
				i++;
			}
		}
		while(pList.get(i).getProductId() != pID);
	}
}
