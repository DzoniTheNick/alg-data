import java.util.Calendar;

public class BubbleSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution	
	
	static void sort(int array[]) {
		int n = array.length;
		int temp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-i); j++) {
				if(array[j - 1] > array[j]) {
					//Swap elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public String BubbleSortArray(int array[]) {
		startTime = System.nanoTime();
		sort(array);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
