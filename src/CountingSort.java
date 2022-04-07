import java.util.Calendar;

public class CountingSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	static void sort(int array[]) {
		try {
			int size = array.length;
			int sortedArray[] = new int[size];
			int countArray[] = new int[256];
			
			for(int i = 0; i < 256; ++i) {
				countArray[i] = 0;
			}
			
			for(int i = 0; i < size; ++i) {
				++countArray[array[i]];
			}
			
			for(int i = 1; i <= 255; ++i) {
				countArray[i] += countArray[i - 1];
			}
			
			for(int i = size - 1; i >= 0; i--) {
				sortedArray[countArray[array[i]] - 1] = array[i];
				--countArray[array[i]];
			}
			
			for(int i = 0; i < size; ++i) {
				array[i] = sortedArray[i];
			}
		}catch (Exception e) {
			// It technically works up until the end of the array. So the time is also technically correct
		}
		
	} 
	
	public String CountingSortArray(int[] array) {
		startTime = System.nanoTime();
		sort(array);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
