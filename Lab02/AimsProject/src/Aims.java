
public class Aims {
	public static void main(String[] args) {
		// create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 18.0f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", 15.75f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Dune", 20f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 15f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 22.5f);
		
		// Add to cart
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.addDigitalVideoDisc(dvd5);
		anOrder.addDigitalVideoDisc(dvd6);
		
		// remove
		anOrder.removeDigitalVideoDisc(dvd2);
		
		
		// print total cost
		System.out.println("Total cost: ");
		System.out.println(anOrder.totalCost());
	}
}
