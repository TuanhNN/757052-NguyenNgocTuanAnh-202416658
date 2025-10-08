import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class SortNumericArray {
	public static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
	
	public static void merge(int[] array, int left, int mid, int right) {
		
		int lengthL = mid - left + 1;
		int lengthR = right - mid;
		
		int[] L = new int[lengthL];
		int[] R = new int[lengthR];
		
		for (int i = 0; i < lengthL; i++) {
			L[i] = array[left + i];
		}
		for (int i = 0; i < lengthR; i++) {
			R[i] = array[mid + 1 + i];
		}
		
		int i = 0, j = 0;
		int l = left;
		
		while (i < lengthL && j < lengthR) {
			if (L[i] <= R[j]) {
				array[l] = L[i];
				i++;
			} else {
				array[l] = R[j];
				j++;
			}
			l++;
		}
		
		while(i < lengthL) {
			array[l] = L[i];
			i++;
			l++;
		}
		
		while(j < lengthR) {
			array[l] = R[j];
			j++;
			l++;
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//array
		System.out.println("Enter array: ");
		ArrayList<Integer> iArray = new ArrayList<>();
		String num = s.nextLine();
		String[] sArray = num.split(" "); 
		for (String n : sArray) {
			iArray.add(Integer.parseInt(n));
		}
		int[] array = new int[iArray.size()];
        for (int i = 0; i < iArray.size(); i++) {
            array[i] = iArray.get(i);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
        	sum += array[i];
        }
        double avg = sum / array.length;
		//sort
		mergeSort(array, 0,  array.length - 1);
		
		System.out.println("New array: " + Arrays.toString(array));
		System.out.println("Sum: " + Integer.toString(sum));
		System.out.println("Avg:" + Double.toString(avg));
		
		
	}
}
