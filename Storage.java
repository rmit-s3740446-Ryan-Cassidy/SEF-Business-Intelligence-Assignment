package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//This class handles input and output for DB management
public class Storage {
	
	//private Connection con;
	
	private final String DB_NAME = "BISDB";			//Database
	private final String S_TABLE = "SUPPLIERS";		//Suppliers Array
	private final String P_TABLE = "PRODUCTS";		//Products Array
	private final String E_TABLE = "EMPLOYEES";		//Employee Array
	private final String C_TABLE = "CUSTOMERS";		//Customer Array
	private final String SW_TABLE = "SWIPECARD";	//SwipeCard Array
	private final String T_TABLE = "TRANSACTIONS"; 	//Transaction Array
	private final String I_TABLE = "ITEMS";			//ItemLine Array
	private final String O_TABLE = "ORDERS";		//Order Array
	
	//Prepared Statements
	private final String supStmt = "INSERT INTO " + S_TABLE 
					+ "(supplier_id, name, address, phone_no)"
					+ "VALUES(?, ?, ? , ?)";
	private final String ordStmt = "INSERT INTO " + O_TABLE
					+ "(order_id, item, quantity, cost, date, fk_supplier_id)"
					+ "VALUES(?, ? ,? ,? ,? ,?)";
	private final String proStmt = "INSERT INTO " + P_TABLE
					+ "(product_id, product_name, category, price, bulk_sales_amt, discount_percent, "
					+ "stock_level, replenish_level, reorder_quantity, wholesale_cost, fk_supplier_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String empStmt = "INSERT INTO " + E_TABLE
					+ "(employee_id, name, password, staff_type)"
					+ "VALUES(?, ?, ?, ?)";
	private final String cusStmt = "INSERT INTO " + C_TABLE
					+ "(customer_id, name, post_code)"
					+ "VALUES(?, ?, ?)";
	private final String swiStmt = "INSERT INTO " + SW_TABLE
					+ "(swipe_card_id, loyalty_points, credit, fk_customer_id)"
					+ "VALUES(?, ?, ?, ?)";
	private final String traStmt = "INSERT INTO " + T_TABLE
					+ "(transaction_id, transaction_date, total_price, discount_price,"
					+ " purchase_points, fk_customer_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?)";
	private final String iteStmt = "INSERT INTO " + I_TABLE
					+ "(line_id, item, quantity, cost, fk_transaction_id)"
					+ "VALUES(?, ?, ?, ?, ?)";

	//Method for getting connection to database
	public Connection getConnection(String dbName) 
			throws SQLException, ClassNotFoundException {
		//Registering the HSQLDB JDBC driver
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
	
		/* Database files will be created in the "database" 
		 * folder in the project. If no username or password is 
		 * specified, the default SA user and an empty password are used */
		Connection con = DriverManager.getConnection
		("jdbc:hsqldb:file:database/" + dbName, "SA", "");
		return con;
	}
	
	//Method for checking if DB exists
	public void dbExists() {
		File f = new File("database\\BISDB.log");
		if (f.exists() == false) {
			createDB();
		}
	}
	
	//Method for creation of tables in DB
	//If you need to add or remove variables (or change their type)
	//Modify the appropriate table query
	//Modify the toString of whatever class you edited
	//Check the fillArray method and modify appropriately there too.
	public void createDB() {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			//Suppliers table
			stmt.executeUpdate("CREATE TABLE "+S_TABLE + "("
					+ "supplier_id VARCHAR(20) NOT NULL, "
					+ "name VARCHAR(40) NOT NULL, " 
					+ "address VARCHAR(40) NOT NULL, "
					+ "phone_no VARCHAR(10) NOT NULL, "
					+ "PRIMARY KEY (supplier_id))");
			//Order table
			stmt.executeUpdate("CREATE TABLE " +O_TABLE + "("
					+ "order_id VARCHAR(20) NOT NULL,"
					+ "item VARCHAR(20) NOT NULL, "
					+ "quantity INT NOT NULL, "
					+ "cost DOUBLE NOT NULL, "
					+ "date VARCHAR(10) NOT NULL, "
					+ "fk_supplier_id VARCHAR(15) NOT NULL, "
					+ "FOREIGN KEY (fk_supplier_id) REFERENCES suppliers(supplier_id),"
					+ "PRIMARY KEY (order_id))");
			//Product table
			stmt.executeUpdate("CREATE TABLE "+P_TABLE + "("
					+ "product_id VARCHAR(20) NOT NULL, "
					+ "product_name VARCHAR(10) NOT NULL, "
					+ "category VARCHAR(15) NOT NULL,"
					+ "price DOUBLE NOT NULL, "
					+ "bulk_sales_amt INT NOT NULL, "
					+ "discount_percent INT NOT NULL, "
					+ "stock_level INT NOT NULL, "
					+ "replenish_level INT NOT NULL, "
					+ "reorder_quantity INT NOT NULL, "
					+ "wholesale_cost DOUBLE NOT NULL,"
					+ "fk_supplier_id VARCHAR(15) NOT NULL, "
					+ "FOREIGN KEY (fk_supplier_id) REFERENCES suppliers(supplier_id), "
					+ "PRIMARY KEY (product_id))");
			//Employee table
			stmt.executeUpdate("CREATE TABLE "+E_TABLE + "("
					+ "employee_id VARCHAR(20) NOT NULL, "
					+ "name VARCHAR(20) NOT NULL, " 
					+ "password VARCHAR(20) NOT NULL, "
					+ "staff_type VARCHAR(20) NOT NULL, "
					+ "PRIMARY KEY (employee_id))");
			//Customer table
			stmt.executeUpdate("CREATE TABLE "+C_TABLE + "("
					+ "customer_id VARCHAR(20) NOT NULL, "
					+ "name VARCHAR(20) NOT NULL, " 
					+ "post_code VARCHAR(4) NOT NULL, "
					+ "PRIMARY KEY (customer_id))");
			//SwipeCard table
			stmt.executeUpdate("CREATE TABLE "+SW_TABLE + "("
					+ "swipe_card_id VARCHAR(20) NOT NULL, "
					+ "loyalty_points INT NOT NULL, "
					+ "credit INT NOT NULL, " 
					+ "fk_customer_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_customer_id) REFERENCES customers(customer_id), "
					+ "PRIMARY KEY (swipe_card_id))"); //CHECK
			//Transactions table
			stmt.executeUpdate("CREATE TABLE "+T_TABLE + "("
					+ "transaction_id VARCHAR(20) NOT NULL, "
					+ "transaction_date VARCHAR(20) NOT NULL, " 
					+ "total_price DOUBLE NOT NULL, "
					+ "discount_price DOUBLE NOT NULL, "
					+ "purchase_points INT NOT NULL, "
					+ "fk_customer_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_customer_id) REFERENCES customers(customer_id), "
					+ "PRIMARY KEY (transaction_id))");
			//LineItem table
			stmt.executeUpdate("CREATE TABLE "+I_TABLE + "("
					+ "line_id VARCHAR(20) NOT NULL, "
					+ "item VARCHAR(10) NOT NULL, " 
					+ "quantity INT NOT NULL, "
					+ "cost DOUBLE NOT NULL, "
					+ "fk_transaction_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_transaction_id) REFERENCES transactions(transaction_id), "
					+ "PRIMARY KEY (line_id))");
			//administrator manager account
			stmt.executeUpdate("INSERT INTO "+ E_TABLE
								+" VALUES('1', 'admin', 'pass', 'Manager')");
			System.out.println("Database Initialized");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Method for clearing all rows from all tables
	public void clearDB() {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
		stmt.executeUpdate("DELETE FROM " +P_TABLE);
		stmt.executeUpdate("DELETE FROM " +I_TABLE);
		stmt.executeUpdate("DELETE FROM " +T_TABLE);
		stmt.executeUpdate("DELETE FROM " +SW_TABLE);
		stmt.executeUpdate("DELETE FROM " +C_TABLE);
		stmt.executeUpdate("DELETE FROM " +E_TABLE);
		stmt.executeUpdate("DELETE FROM " +O_TABLE);
		stmt.executeUpdate("DELETE FROM " +S_TABLE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method for updating DB with all Arrays
	//DB empties all rows in all tables with clearDB()
	//Then calls for updates in the order below.
	//Order is important, don't change it unless you know what you are doing.
	public void updateDBAll(ArrayList <Customer> cArray, ArrayList <Employee> eArray, 
							ArrayList <Supplier> sArray, ArrayList <Product> pArray) {
		clearDB();
		updateDBSupplier(sArray);
		updateDBProduct(pArray);
		updateDBCustomer(cArray);
		updateDBEmployee(eArray);
	}
	//The following four methods are for inserting objects into tables.
	//Method for updating DB with customer objects
	public void updateDBCustomer(ArrayList <Customer> cArray) {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			//Customer
			for (Customer customer:cArray) {
				String customerSplit[] = customer.toString().split(":");
				PreparedStatement cStmt = con.prepareStatement(cusStmt);
				for(int i = 0; i < customerSplit.length; i++) {
					cStmt.setString(i+1, customerSplit[i]);
				}
				cStmt.executeUpdate();
				//SwipeCard
				String swipecardSplit[] = customer.getSwipeCard().toString().split(":");
				PreparedStatement swStmt = con.prepareStatement(swiStmt);
				for(int i = 0; i < swipecardSplit.length; i++) {
					swStmt.setString(i+1, swipecardSplit[i]);
				}
				//Customer Foreign Key
				swStmt.setString(4, customer.getCustomerID());
				swStmt.executeUpdate();
				//Transactions
				for (Transaction transaction:customer.getTransactions()) {
					String transactionSplit[] = transaction.toString().split(":");
					PreparedStatement tStmt = con.prepareStatement(traStmt);
					for(int i = 0; i < transactionSplit.length; i++) {
						tStmt.setString(i+1, transactionSplit[i]);
					}
					//Customer Foreign Key
					tStmt.setString(6, customer.getCustomerID());
					tStmt.executeUpdate();
					
					//Items
					for (LineItem item:transaction.getItemsBought()) {
						String itemSplit[] = item.toString().split(":");
						PreparedStatement iStmt = con.prepareStatement(iteStmt);
						for(int i = 0; i < itemSplit.length; i++) {
							iStmt.setString(i+1, itemSplit[i]);
						}
						//Transaction Foreign key
						iStmt.setString(5, transaction.getTransactionID());
						iStmt.executeUpdate();
								
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Method for updating DB with employee objects
	public void updateDBEmployee(ArrayList <Employee> eArray) {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			for (Employee employee:eArray) {
				String stringSplit[] = employee.toString().split(":");
				PreparedStatement eStmt = con.prepareStatement(empStmt);
				for(int i = 0; i < stringSplit.length; i++) {
					eStmt.setString(i+1, stringSplit[i]);
				}
				eStmt.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method for updating DB with supplier objects
	public void updateDBSupplier(ArrayList <Supplier> sArray) {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			for (Supplier supplier: sArray) {
				String stringSplit[] = supplier.toString().split(":");
				PreparedStatement sStmt = con.prepareStatement(supStmt);
				for(int i = 0; i < stringSplit.length; i++) {
					sStmt.setString(i+1, stringSplit[i]);
				}
				sStmt.executeUpdate();
				//Orders
				for(Order order: supplier.getoArray()) {
					String orderSplit[] = order.toString().split(":");
					PreparedStatement oStmt = con.prepareStatement(ordStmt);
					for(int i = 0; i < orderSplit.length; i++) {
						oStmt.setString(i+1, orderSplit[i]);
					}
					oStmt.setString(6, supplier.getSupplierID());
					oStmt.executeUpdate();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method for updating DB with product objects
	public void updateDBProduct(ArrayList <Product> pArray) {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			for (Product product: pArray) {
			String stringSplit[] = product.toString().split(":");
			PreparedStatement pStmt = con.prepareStatement(proStmt);
			for (int i = 0; i < stringSplit.length; i++) {
				pStmt.setString(i+1, stringSplit[i]);
			}
			pStmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//The following method is what draws information from the Database
	//It inserts objects into the appropriate arrays
	//Need to edit this if you change variables in the system
	
	//Method for filling arrays with DB content
	public void fillArray(ArrayList <Customer> cArray, ArrayList <Employee> eArray, 
							ArrayList <Supplier> sArray, ArrayList <Product> pArray) {
		try (Connection con = getConnection(DB_NAME);
				Statement stmt = con.createStatement()) {
			String sQuery, pQuery, swQuery, iQuery, eQuery, cQuery, tQuery, oQuery;
			//Supplier Array
			sQuery = "SELECT * FROM " +S_TABLE;
			try (ResultSet resultSet = stmt.executeQuery(sQuery)) {
				while(resultSet.next()) {
					Supplier s = new Supplier(resultSet.getString("supplier_id"), resultSet.getString("name"),
											  resultSet.getString("address"), resultSet.getString("phone_no"));
					oQuery = "SELECT * FROM " +O_TABLE +" WHERE fk_supplier_id LIKE '" +resultSet.getString("supplier_id")+"'";
					try(ResultSet oSet = stmt.executeQuery(oQuery)){
						while (oSet.next()) {
						Order o = new Order(oSet.getString("order_id"), oSet.getString("item"), 
											oSet.getInt("quantity"), oSet.getDouble("cost"), oSet.getString("date"));
						s.getoArray().add(o);
						}
					sArray.add(s);
				}
			}
			}
			//Product Array
			pQuery = "SELECT * FROM " +P_TABLE;
			try (ResultSet resultSet = stmt.executeQuery(pQuery)){
				while (resultSet.next()) {
					Product p = new Product(resultSet.getString("product_id"), resultSet.getString("product_name"),
							resultSet.getString("category"),resultSet.getDouble("price"), resultSet.getInt("bulk_sales_amt"),
							resultSet.getInt("discount_percent"), resultSet.getInt("stock_level"),
							resultSet.getInt("replenish_level"), resultSet.getInt("reorder_quantity"),
							resultSet.getDouble("wholesale_cost"),
							returnSupplier(sArray, resultSet.getString("fk_supplier_id")));
					pArray.add(p);
				}
			}
			//Customer Array
			cQuery = "SELECT * FROM " +C_TABLE;
			try(ResultSet resultSet = stmt.executeQuery(cQuery)) {
				Customer c;
				SwipeCard sw = null;
				while(resultSet.next()) {
					String customerID = resultSet.getString("customer_id");
					String customerName = resultSet.getString("name");
					String customerPostCode = resultSet.getString("post_code");
					swQuery = "SELECT * FROM " +SW_TABLE +" WHERE fk_customer_id LIKE '" +resultSet.getString("customer_id")+"'";
					try(ResultSet swSet = stmt.executeQuery(swQuery)){
						while (swSet.next()) {
						sw = new SwipeCard(swSet.getString("swipe_card_id"), swSet.getInt("loyalty_points"), 
													swSet.getInt("credit"));
						}
					}
					c = new Customer (customerID, customerName, customerPostCode, sw);
					tQuery = "SELECT * FROM " +T_TABLE +" WHERE fk_customer_ID LIKE '" +resultSet.getString("customer_id")+"'";
					try(ResultSet tSet = stmt.executeQuery(tQuery)){
						while(tSet.next()) {
							Transaction t = new Transaction(tSet.getString("transaction_id"), tSet.getString("transaction_date"),
									tSet.getDouble("total_price"), tSet.getDouble("discount_price"),
									tSet.getInt("purchase_points"));
							iQuery = "SELECT * FROM " +I_TABLE +" WHERE fk_transaction_ID LIKE '" +tSet.getString("transaction_id")+"'";
							try (ResultSet iSet = stmt.executeQuery(iQuery)){
								while(iSet.next()) {
									t.getItemsBought().add(new LineItem(iSet.getString("line_id"), iSet.getString("item"),
															iSet.getInt("quantity"), iSet.getDouble("cost")));
								}
							}
							c.getTransactions().add(t);
						}
					}
					cArray.add(c);
				}
			}
			//Employee Array
			eQuery = "SELECT * FROM " +E_TABLE;
			try(ResultSet resultSet = stmt.executeQuery(eQuery)){
				while (resultSet.next()) {
					if(resultSet.getString("staff_type").equals("Manager")) {
						Manager m = new Manager(resultSet.getString("employee_id"), resultSet.getString("name"), resultSet.getString("password"));
						eArray.add(m);
					}
					else if(resultSet.getString("staff_type").equals("Sales Staff")) {
						SalesStaff s = new SalesStaff(resultSet.getString("employee_id"), resultSet.getString("name"), resultSet.getString("password"));
						eArray.add(s);
					}
					else if (resultSet.getString("staff_type").equals("Warehouse Staff")) {
						WarehouseStaff w = new WarehouseStaff(resultSet.getString("employee_id"), resultSet.getString("name"), resultSet.getString("password"));
						eArray.add(w);
					}
				}
			}
			
		}	catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private Supplier returnSupplier(ArrayList <Supplier> sArray, String name) {
		for (Supplier supplier:sArray) {
			if (supplier.getSupplierID().equals(name)) {
				return supplier;
			}
		}
		return null;
	}
			
}
