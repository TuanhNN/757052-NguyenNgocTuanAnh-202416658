import java.net.Authenticator;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 18.0f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", 15.75f);
		
		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		
		cart.printCart();
		
		cart.search(1);
		cart.search(99);
		
		cart.search("The Lion King");
		cart.search("King");
		cart.search("Hehe");
	}

}
