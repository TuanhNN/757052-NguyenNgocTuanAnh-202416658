import java.util.Scanner;
public class Sum2Matrices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//size
		System.out.println("Enter size: ");
		int n = sc.nextInt();
		
		//Matrices
		
		int[][] m1 = new int[n][n];
		int[][] m2 = new int[n][n];
		
		//Enter m1
		System.out.println("Enter 1st matrice: ");
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				m1[i][j] = sc.nextInt();
			}
		}
		//Enter m2
		System.out.println("Enter 2nd matrice: ");
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				m2[i][j] = sc.nextInt();
			}
		}
		//sum
		int[][] sum = new int[n][n];
		System.out.println("Sum of 2 matrices: ");
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
	}
}
