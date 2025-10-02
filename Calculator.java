import java.util.Scanner;
public class Calculator {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);

System.out.println("Enter a: ");
double a = sc.nextInt();
System.out.println("Enter b: ");
double b = sc.nextInt();

System.out.println("Sum: " + (a + b));
System.out.println("Difference: " + Math.abs(a - b));
System.out.println("Product: " + (a * b));
if (b == 0) {
System.out.println("Quotient: null");
}
else {
System.out.println("Quotient: " + (a / b));
}
}
}
