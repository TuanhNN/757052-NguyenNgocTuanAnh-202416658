import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Wie heissen Sie?");
		String name = s.nextLine();
		System.out.println("Quel âge avez-vous?");
		int age = s.nextInt();
		System.out.println("How tall are you? (m)");
		double tall = s.nextDouble();
		
		System.out.println("Mrs/Ms. " + name + ", " + age + " years old. " + "Your heigh is " + tall +".");
		s.close();
	}
}