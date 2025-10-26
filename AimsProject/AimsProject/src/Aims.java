package AimsProject.AimsProject.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// create a new cart
		Cart anOrder = new Cart();
		
		// Create store
		ArrayList<DigitalVideoDisc> store = new ArrayList<>();
		
		// Create new DVD
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 18.0f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", 15.75f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Dune", 20f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 15f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 22.5f);
		
		// Store DVD
		store.add(dvd1);
		store.add(dvd2);
		store.add(dvd3);
		store.add(dvd4);
		store.add(dvd5);
		store.add(dvd6);
		
		// Add to cart
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		
		// Show DVD list 
		// print total cost
		//System.out.println("Total cost: ");
		//System.out.println(anOrder.totalCost());
	}
}
