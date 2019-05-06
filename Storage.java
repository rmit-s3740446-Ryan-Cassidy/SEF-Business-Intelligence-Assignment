package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//This class handles input and output for DB management
public class Storage {

	private final String DB_NAME = "BISDB"; // Database
	private final String S_TABLE = "SUPPLIERS"; // Suppliers Array
	private final String P_TABLE = "PRODUCTS"; // Products Array
	private final String E_TABLE = "EMPLOYEES"; // Employee Array
	private final String C_TABLE = "CUSTOMERS"; // Customer Array
	private final String SW_TABLE = "SWIPECARD"; // SwipeCard Array
	private final String T_TABLE = "TRANSACTIONS"; // Transaction Array
	private final String I_TABLE = "ITEMS"; // ItemLine Array

	// Method for getting connection to database
	public Connection getConnection(String dbName) throws SQLException, ClassNotFoundException {
		// Registering the HSQLDB JDBC driver
		Class.forName("org.hsqldb.jdbc.JDBCDriver");

		/*
		 * Database files will be created in the "database" folder in the project. If no
		 * username or password is specified, the default SA user and an empty password
		 * are used
		 */
		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:database/" + dbName, "SA", "");
		return con;
	}

	// Method for checking if DB exists
	public void dbExists() {
		File f = new File("database\\BISDB.log");
		if (f.exists() == false) {
			// createDB();
		}
	}

	// Method for creation of tables in DB
	// If you need to add or remove variables (or change their type)
	// Modify the appropriate table query
	// Modify the toString of whatever class you edited
	// Check the fillArray method and modify appropriately there too.
	public void createDB() {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			// Suppliers table
			stmt.executeUpdate("CREATE TABLE " + S_TABLE + "(" + "supplier_id VARCHAR(10) NOT NULL, "
					+ "name VARCHAR(40) NOT NULL, " + "address VARCHAR(40) NOT NULL, "
					+ "phone_no VARCHAR(10) NOT NULL, " + "PRIMARY KEY (supplier_id))");
			// Product table
			stmt.executeUpdate("CREATE TABLE " + P_TABLE + "(" + "product_id VARCHAR(5) NOT NULL, "
					+ "product_name VARCHAR(10) NOT NULL, " + "price DOUBLE NOT NULL, "
					+ "bulk_sales_amt INT NOT NULL, " + "discount_percent INT NOT NULL, " + "stock_level INT NOT NULL, "
					+ "replenish_level INT NOT NULL, " + "reorder_quantity INT NOT NULL, "
					+ "fk_supplier_id VARCHAR(15) NOT NULL, "
					+ "FOREIGN KEY (fk_supplier_id) REFERENCES suppliers(supplier_id), " + "PRIMARY KEY (product_id))");
			// Employee table
			stmt.executeUpdate("CREATE TABLE " + E_TABLE + "(" + "employee_id VARCHAR(5) NOT NULL, "
					+ "name VARCHAR(20) NOT NULL, " + "password VARCHAR(20) NOT NULL, "
					+ "staff_type VARCHAR(20) NOT NULL, " + "PRIMARY KEY (employee_id))");
			// Customer table
			stmt.executeUpdate("CREATE TABLE " + C_TABLE + "(" + "customer_id VARCHAR(5) NOT NULL, "
					+ "name VARCHAR(20) NOT NULL, " + "post_code VARCHAR(4) NOT NULL, " + "PRIMARY KEY (customer_id))");
			// SwipeCard table
			stmt.executeUpdate("CREATE TABLE " + SW_TABLE + "(" + "swipe_card_id VARCHAR(20) NOT NULL, "
					+ "loyalty_points INT NOT NULL, " + "credit INT NOT NULL, " + "fk_customer_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_customer_id) REFERENCES customers(customer_id), "
					+ "PRIMARY KEY (swipe_card_id))"); // CHECK
			// Transactions table
			stmt.executeUpdate("CREATE TABLE " + T_TABLE + "(" + "transaction_id VARCHAR(5) NOT NULL, "
					+ "transaction_date VARCHAR(20) NOT NULL, " + "total_price DOUBLE NOT NULL, "
					+ "discount_price DOUBLE NOT NULL, " + "purchase_points INT NOT NULL, "
					+ "fk_customer_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_customer_id) REFERENCES customers(customer_id), "
					+ "PRIMARY KEY (transaction_id))");
			// LineItem table
			stmt.executeUpdate("CREATE TABLE " + I_TABLE + "(" + "product_id VARCHAR(5) NOT NULL, "
					+ "item VARCHAR(10) NOT NULL, " + "quantity INT NOT NULL, " + "cost DOUBLE NOT NULL, "
					+ "fk_transaction_id VARCHAR(5) NOT NULL, "
					+ "FOREIGN KEY (fk_transaction_id) REFERENCES transactions(transaction_id), "
					+ "PRIMARY KEY (product_id))");
			System.out.println("Database Initialized");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method for clearing all rows from all tables
	public void clearDB() {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			stmt.executeUpdate("DELETE FROM " + P_TABLE);
			stmt.executeUpdate("DELETE FROM " + I_TABLE);
			stmt.executeUpdate("DELETE FROM " + T_TABLE);
			stmt.executeUpdate("DELETE FROM " + SW_TABLE);
			stmt.executeUpdate("DELETE FROM " + C_TABLE);
			stmt.executeUpdate("DELETE FROM " + E_TABLE);
			stmt.executeUpdate("DELETE FROM " + S_TABLE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method for updating DB with all Arrays
	// DB empties all rows in all tables with clearDB(); (Lazy method for updating)
	// Then calls for updates in the order below.
	// Order is important, don't change it unless you know what you are doing.
	public void updateDBAll(ArrayList<Customer> cArray, ArrayList<Employee> eArray, ArrayList<Supplier> sArray,
			ArrayList<Product> pArray) {
		clearDB();
		updateDBSupplier(sArray);
		updateDBProduct(pArray);
		updateDBCustomer(cArray);
		updateDBEmployee(eArray);
	}
	// The following four methods are for inserting objects into tables.
	// Each method opens a connection to the database
	// Builds a string based on contents of the relevant object (Using query
	// builder)
	// Then executes that string as an SQL query like you would in any SQL parser
	// If you are going to edit these keep a close eye on the formatting
	// SQL requires apostrophes surrounding variables
	// Meaning you have to open and close quotes, it's rather annoying in java.
	// Test queries in SQLite or the Manager Swing GUI that comes with HSQLDB if you
	// are unsure.

	// Method for updating DB with customer objects
	// Customer is a bit more complicated since it contains many objects within it
	// This means it needs a bunch of different foreign key entries
	// Mostly hard written for now, consider re-factoring this code.
	// Does not utilize the queryBuilder method unlike the other 3
	public void updateDBCustomer(ArrayList<Customer> cArray) {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			// Customer
			String cQuery, sQuery, tQuery, iQuery;
			for (Customer customer : cArray) {
				String customerSplit[] = stringWrapper(customer.toString().split(":"));
				cQuery = "INSERT INTO ";
				cQuery = cQuery.concat(C_TABLE + " ");
				cQuery = cQuery.concat("VALUES (" + customerSplit[0] + ", ");
				for (int ci = 1; ci < customerSplit.length - 1; ci++) {
					cQuery = cQuery.concat(customerSplit[ci] + ", ");
				}
				// Final value
				cQuery = cQuery.concat(customerSplit[customerSplit.length - 1] + ")");
				stmt.executeUpdate(cQuery);
				// SwipeCard
				String swipecardSplit[] = stringWrapper(customer.getSwipeCard().toString().split(":"));
				sQuery = "INSERT INTO ";
				sQuery = sQuery.concat(SW_TABLE + " ");
				sQuery = sQuery.concat("VALUES (" + swipecardSplit[0] + ", ");
				for (int si = 1; si < swipecardSplit.length; si++) {
					sQuery = sQuery.concat(swipecardSplit[si] + ", ");
				}
				// Customer foreign key
				sQuery = sQuery.concat("'" + customer.getCustomerID() + "')");
				stmt.executeUpdate(sQuery);
				// Transactions
				for (Transaction transaction : customer.getTransactions()) {
					String transactionSplit[] = stringWrapper(transaction.toString().split(":"));
					tQuery = "INSERT INTO ";
					tQuery = tQuery.concat(T_TABLE + " ");
					tQuery = tQuery.concat("VALUES (" + transactionSplit[0] + ", ");
					for (int ti = 1; ti < transactionSplit.length; ti++) {
						tQuery = tQuery.concat(transactionSplit[ti] + ", ");
					}
					// Customer foreign key
					tQuery = tQuery.concat("'" + customer.getCustomerID() + "')");
					stmt.executeUpdate(tQuery);
					// Items
					for (LineItem item : transaction.getItemsBought()) {
						String itemSplit[] = stringWrapper(item.toString().split(":"));
						iQuery = "INSERT INTO ";
						iQuery = iQuery.concat(I_TABLE + " ");
						iQuery = iQuery.concat("VALUES (" + itemSplit[0] + ", ");
						for (int ii = 1; ii < itemSplit.length; ii++) {
							iQuery = iQuery.concat(itemSplit[ii] + ", ");
						}
						// Transaction foreign key
						iQuery = iQuery.concat("'" + transaction.getTransactionID() + "')");
						stmt.executeUpdate(iQuery);

					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method for updating DB with employee objects
	public void updateDBEmployee(ArrayList<Employee> eArray) {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			for (Employee employee : eArray) {
				String query = queryBuilder(E_TABLE, employee.toString());
				stmt.executeUpdate(query);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method for updating DB with supplier objects
	public void updateDBSupplier(ArrayList<Supplier> sArray) {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			for (Supplier supplier : sArray) {
				String query = queryBuilder(S_TABLE, supplier.toString());
				stmt.executeUpdate(query);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method for updating DB with product objects
	public void updateDBProduct(ArrayList<Product> pArray) {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			for (Product product : pArray) {
				String query = queryBuilder(P_TABLE, product.toString());
				stmt.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// The following method is what draws information from the Database
	// It inserts objects into the appropriate arrays
	// It's rather complicated, bit hard to read. Might re-factor.
	// Need to edit this if you change variables in the system

	// Method for filling arrays with DB content
	public void fillArray(ArrayList<Customer> cArray, ArrayList<Employee> eArray, ArrayList<Supplier> sArray,
			ArrayList<Product> pArray) {
		try (Connection con = getConnection(DB_NAME); Statement stmt = con.createStatement()) {
			String sQuery, pQuery, swQuery, iQuery, eQuery, cQuery, tQuery;
			// Supplier Array
			sQuery = "SELECT * FROM " + S_TABLE;
			try (ResultSet resultSet = stmt.executeQuery(sQuery)) {
				while (resultSet.next()) {
					Supplier s = new Supplier(resultSet.getString("supplier_id"), resultSet.getString("name"),
							resultSet.getString("address"), resultSet.getString("phone_no"));
					sArray.add(s);
				}
			}
			// Product Array
			pQuery = "SELECT * FROM " + P_TABLE;
//			try (ResultSet resultSet = stmt.executeQuery(pQuery)) {
//				while (resultSet.next()) {
//					Product p = new Product(resultSet.getString("product_id"), resultSet.getString("product_name"),
//							resultSet.getDouble("price"), resultSet.getInt("bulk_sales_amt"),
//							resultSet.getInt("discount_percent"), resultSet.getInt("stock_level"),
//							resultSet.getInt("replenish_level"), resultSet.getInt("reorder_quantity"),
//							returnSupplier(sArray, resultSet.getString("fk_supplier_id")));
//					pArray.add(p);
//				}
//			}vineet commented
			// Customer Array
			cQuery = "SELECT * FROM " + C_TABLE;
			try (ResultSet resultSet = stmt.executeQuery(cQuery)) {
				Customer c;
				SwipeCard sw = null;
				while (resultSet.next()) {
					String customerID = resultSet.getString("customer_id");
					String customerName = resultSet.getString("name");
					String customerPostCode = resultSet.getString("post_code");
					swQuery = "SELECT * FROM " + SW_TABLE + " WHERE fk_customer_id LIKE '"
							+ resultSet.getString("customer_id") + "'";
					try (ResultSet swSet = stmt.executeQuery(swQuery)) {
						while (swSet.next()) {
							sw = new SwipeCard(swSet.getString("swipe_card_id"), swSet.getInt("loyalty_points"),
									swSet.getInt("credit"));
						}
					}
					c = new Customer(customerID, customerName, customerPostCode, sw);
					tQuery = "SELECT * FROM " + T_TABLE + " WHERE fk_customer_ID LIKE '"
							+ resultSet.getString("customer_id") + "'";
					try (ResultSet tSet = stmt.executeQuery(tQuery)) {
						while (tSet.next()) {
							Transaction t = new Transaction(tSet.getString("transaction_id"),
									tSet.getString("transaction_date"), tSet.getDouble("total_price"),
									tSet.getDouble("discount_price"), tSet.getInt("purchase_points"));
							iQuery = "SELECT * FROM " + I_TABLE + " WHERE fk_transaction_ID LIKE '"
									+ tSet.getString("transaction_id") + "'";
							try (ResultSet iSet = stmt.executeQuery(iQuery)) {
								while (iSet.next()) {
									t.getItemsBought().add(new LineItem(iSet.getString("product_id"),
											iSet.getString("item"), iSet.getInt("quantity"), iSet.getDouble("cost")));
								}
							}
							c.getTransactions().add(t);
						}
					}
					cArray.add(c);
				}
			}
			// Employee Array
			eQuery = "SELECT * FROM " + E_TABLE;
			try (ResultSet resultSet = stmt.executeQuery(eQuery)) {
				while (resultSet.next()) {
					if (resultSet.getString("staff_type").equals("Manager")) {
						Manager m = new Manager(resultSet.getString("employee_id"), resultSet.getString("name"),
								resultSet.getString("password"));
						eArray.add(m);
					} else if (resultSet.getString("staff_type").equals("Sales Staff")) {
						SalesStaff s = new SalesStaff(resultSet.getString("employee_id"), resultSet.getString("name"),
								resultSet.getString("password"));
						eArray.add(s);
					} else if (resultSet.getString("staff_type").equals("Warehouse Staff")) {
						WarehouseStaff w = new WarehouseStaff(resultSet.getString("employee_id"),
								resultSet.getString("name"), resultSet.getString("password"));
						eArray.add(w);
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private Supplier returnSupplier(ArrayList<Supplier> sArray, String name) {
		for (Supplier supplier : sArray) {
			if (supplier.getSupplierID().equals(name)) {
				return supplier;
			}
		}
		return null;
	}

	// Method for wrapping toStrings with '
	private String[] stringWrapper(String array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = "'" + array[i] + "'";
		}
		return array;
	}

	// Method for building INSERT queries
	private String queryBuilder(String table, String values) {
		// Split the toString input
		String stringSplit[] = stringWrapper(values.split(":"));
		// Begin writing INSERT query
		// Start of query
		String query = "INSERT INTO ";
		// Table target
		query = query.concat(table + " ");
		// First value
		query = query.concat("VALUES (" + stringSplit[0] + ", ");
		// In-between values
		for (int i = 1; i < (stringSplit.length - 1); i++) {
			query = query.concat(stringSplit[i] + ", ");
		}
		// Final value
		query = query.concat(stringSplit[stringSplit.length - 1] + ")");
		return query;
	}
}
