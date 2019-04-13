import java.util.ArrayList;

public class Manager extends Employee
{

	public Manager(String id, String pass, String type)
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
	
	public void promoPriceOverride(ArrayList<Product> pList, String pID, double promoPrice)
	{
		int i = 0;
		do
		{
			if(pList.get(i).getProductId().equals(pID))
			{
				pList.get(i).setPrice(promoPrice);
			}
			else
			{
				i++;
			}
		}
		while(pList.get(i).getProductId() != pID);
	}
	
	public void setBulkDiscounts(ArrayList<Product> pList, String pID, int bulkAmt, int discount)
	{
		int i = 0;
		do
		{
			if(pList.get(i).getProductId().equals(pID))
			{
				pList.get(i).setBulkSalesAmt(bulkAmt);
				pList.get(i).setDiscountPercent(discount);
			}
			else
			{
				i++;
			}
		}
		while(pList.get(i).getProductId() != pID);
	}
	
	public void autoPurchaseBelowReplenishmentLvl(ArrayList<Product> pList)
	{
		for(int i = 0; i < pList.size(); i++)
		{
			if(pList.get(i).getStockLevel() <= pList.get(i).getReplenishLevel())
			{
				replenishStock(pList, pList.get(i).getProductId(), pList.get(i).getReorderQuantity());
			}
		}
	}
}
