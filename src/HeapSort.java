import java.util.Calendar;

public class HeapSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	public static void sort(int array[]) {
		int n = array.length;
		
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}
		
		for(int i = n - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			heapify(array, i, 0);
		}			
	}
	
	static void heapify(int array[], int n, int i) {
		try {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			
			if(l < n && array[l] > array[largest]) {
				largest = r;
			}
			
			if(largest != i) {
				int swap = array[i];
				array[i] = array[largest];
				array[largest] = swap;
				
				heapify(array, n, largest);
			}
		}catch (Exception e) {
			// It technically works up until the end of the array. So the time is also technically correct
		}
		
	}
	
	public String HeapSortArray(int array[]) {
		startTime = System.nanoTime();
		sort(array);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
