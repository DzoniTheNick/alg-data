import java.util.Calendar;

public class SelectionSort {

	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	static void sort(int array[]) {
		for(int i = 0; i < array.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[index]) {
					index = j; //Finding lowest index
				}
			}
			int smallerNumber = array[index];
			array[index] = array[i];
			array[i] = smallerNumber;
		}
	}
	
	public String SelectionSortArray(int array[]) {
		startTime = System.nanoTime();
		sort(array);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
