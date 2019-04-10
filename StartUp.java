package mypackage;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BISystem system = new BISystem();

		Product p1 = new Product(1, "Apples", 10, 10, 1000, 500, 500);

		system.setProduct(p1);

		while (true) {
			try {
				system.bootSystem();
			} catch (Exception e) {
				System.out.println("Invalid input");
			}

		}
	}

}
