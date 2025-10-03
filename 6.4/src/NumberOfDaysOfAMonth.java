import java.util.Scanner;
public class NumberOfDaysOfAMonth {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter month: ");
		String month = s.nextLine();
		System.out.println("Enter year: ");
		int year = s.nextInt();
		
		String[] m = {
				 "1",  "Jan", "Jan.", "January",
				 "2",  "Feb", "Feb.", "February",
				 "3",  "Mar", "Mar.", "March",
				 "4",  "Apr", "Apr.", "April",
				 "5",  "May", "May.", "May",
				 "6",  "Jun", "Jun.", "June",
				 "7",  "Jul", "Jul.", "July",
				 "8",  "Aug", "Aug.", "August",
				 "9",  "Sep", "Sep.", "Septemper",
				 "10", "Oct", "Oct.", "October",
				 "11", "Nov", "Nov.", "November",
				 "12", "Dec", "Dec.", "December"
				 };
		// check 
		boolean valid = false;
		for (int i = 0; i < m.length; i++) {
		    if (month.equals(m[i])) {
		        valid = true;
		        break;
		    }
		}
		if (!valid) {
		    System.out.println("Please enter the correct format!/Invalid month!");
		    return;
		}
		
		for (int i = 0; i < m.length; i += 4) {
			if (month.equals(m[i]) || month.equals(m[i + 1]) || month.equals(m[i+2]) || month.equals(m[i+3])) {
				month = Integer.toString(i / 4 + 1);	
			}
		}
		
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				// nam thuong 
				if (month.equals("1") || month.equals("3") ||month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
					System.out.println("Days: 31");
				} else if (month.equals("2")) {
					System.out.println("28");
				} else if (month.equals("4") || month.equals("6") ||month.equals("9") || month.equals("11")) {
					System.out.println("30");
				}
			}
			else {
				// nam nhuan
				if (month.equals("1") || month.equals("3") ||month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
					System.out.println("Days: 31");
				} else if (month.equals("2")) {
					System.out.println("29");
				} else if (month.equals("4") || month.equals("6") ||month.equals("9") || month.equals("11")) {
					System.out.println("30");
				}
			}
		}
		else {
			//nam thuong
			if (month.equals("1") || month.equals("3") ||month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")) {
				System.out.println("Days: 31");
			} else if (month.equals("2")) {
				System.out.println("28");
			} else if (month.equals("4") || month.equals("6") ||month.equals("9") || month.equals("11")) {
				System.out.println("30");
			}
		}
	}
}



