import java.util.Calendar;

public class MergeSort {
	
	static long startTime;	//Used to mark start time of an function execution 
	static long endTime;	//Used to mark end time of an function execution
	
	static void merge(int array[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		for(int i = 0; i < n1; ++i) {
			L[i] = array[l + i];
		}
		for(int j = 0; j < n2; ++j) {
			R[j] = array[m + 1 + j];
		}
		
		int i = 0, j = 0;
		
		int k = l;
		
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			}
			else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}
	
	static void sort(int array[], int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			
			sort(array, l, m);
			sort(array, m + 1, r);
			
			merge(array, l, m, r);
		}
	}
	
	public String MergeSortArray(int [] array) {
		startTime = System.nanoTime();
		sort(array, 0, array.length - 1);
		endTime = System.nanoTime();
		return endTime - startTime + " ns";
	}
}
