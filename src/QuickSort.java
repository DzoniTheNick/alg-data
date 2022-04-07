import java.util.Calendar;

public class QuickSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	static int partition(int array[], int low, int high) {
		int pivot = array[low];
		int i = (low - 1);
		
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		
		return i + 1;
	}
	
	static void sort(int array[], int low, int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			
			sort(array, low, pi - 1);
			sort(array, pi + 1, high);
		}
	}
	
	public String QuickSortArray(int [] array) {
		startTime = System.nanoTime();
		sort(array, 0, array.length - 1);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
