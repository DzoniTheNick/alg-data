import java.util.Calendar;

public class InsertionSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	static void sort(int array[]) {
		int n = array.length;
		for(int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}
	
	public String InsertionSortArray(int array[]) {
		startTime = System.nanoTime();
		sort(array);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
