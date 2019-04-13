
public abstract class Employee
{
	private String employeeID;
	private String employeePass;
	private String employeeType;
	
	
	public Employee(String id, String pass, String type)
	{
		this.employeeID = id;
		this.employeePass = pass;
		this.employeeType = type;
	}
	
	public void setEmployeeID(String id)
	{
		this.employeeID = id;
	}
	
	public void setEmployeePass(String pass)
	{
		this.employeePass = pass;
	}
	
	public void setEmployeeType(String type)
	{
		this.employeeType = type;
	}
	
	public String getEmployeeID()
	{
		return employeeID;
	}
	
	public String getEmployeePass()
	{
		return employeePass;
	}
	
	public String getEmployeeType()
	{
		return employeeType;
	}
}
