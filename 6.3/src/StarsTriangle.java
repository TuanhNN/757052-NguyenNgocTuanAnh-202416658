import java.util.Scanner;
public class StarsTriangle {
	public static void main(String[] args) {
	System.out.println("Enter n: ");
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	for (int i = 0; i < n; i++) {
		System.out.println(" ".repeat((2 * n - 1 - (2 * i + 1)) / 2) + "*".repeat(2 * i + 1) + " ".repeat((2 * n - 1 - (2 * i + 1)) / 2));
	}
	s.close();
	}
}
