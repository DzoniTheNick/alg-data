import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {

	static String input = "";
	static String[] inputs;
	static LinkedList list = null;
	static Queue queue = null;
	static Graph graph = null;
	
	static int[] array_5 = new int[5];
	static int[] array_10 = new int[10];
	static int[] array_50 = new int[50];
	static int[] array_100 = new int[100];
	static int[] array_200 = new int[200];
	static int[] array_400 = new int[400];
	static int[] array_800 = new int[800];
	static int[] array_1600 = new int[1600];
	static int[] array_2400 = new int[2400];
	static int[] array_3200 = new int[3200];
	static int[] array_6400 = new int[6400];
	static int[] array_12800 = new int[12800];
	
	static Random randomNumber = new Random();
	
	static BubbleSort bubbleSort = new BubbleSort();
	static SelectionSort selectionSort = new SelectionSort();
	static InsertionSort insertionSort = new InsertionSort();
	static MergeSort mergerSort = new MergeSort();
	static QuickSort quicksort = new QuickSort();
	static HeapSort heapSort = new HeapSort();
	static CountingSort countingSort = new CountingSort();
	
	static ArrayList<int[]> arrayList = new ArrayList<>();
	
	static String sortingReport[][] = new String[10][8];
	
	public static void main(String[] args) {
		
		System.out.println("Hello and welcome to the Program for the first Assigment!");
		
		printMenuMessage();
		
		inputProcessor();
		
		while(true) {
			switch (inputs[0]) {
			case "0":
				printDevider();
				goodbyeMessage();
				return;
			case "1":
				printDevider();
				if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					list = new LinkedList();
					System.out.println("PROGRAM: A new linked list has been initilizad");
				}
				printDevider();
				printMenuMessage();
				break;
			case "1.1":
				printDevider();
				if(list == null) {
					linkedListChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					list.insert(inputs[1]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "1.2":
				printDevider();
				if(list == null) {
					linkedListChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					list.exists(inputs[1]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "1.3":
				printDevider();
				if(list == null) {
					linkedListChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					list.print_list();
				}
				printDevider();
				printMenuMessage();
				break;
			case "1.4":
				printDevider();
				if(list == null) {
					linkedListChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					list.remove(inputs[1]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "2":
				printDevider();
				if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue = new Queue();
					System.out.println("PROGRAM: A new queue has been initilizad");
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.1":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					queue.enqueue(inputs[1]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.2":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue.dequeue();
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.3":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue.peek();
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.4":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue.size();
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.5":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue.isEmpty();
				}
				printDevider();
				printMenuMessage();
				break;
			case "2.6":
				printDevider();
				if(queue == null) {
					queueChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					queue.print();
				}
				printDevider();
				printMenuMessage();
				break;
			case "3":
				printDevider();
				if(inputs.length != 3) {
					invalidInputMessage();
				}else {
					graph = new Graph();
					graph.init(inputs[1], inputs[2]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "3.1":
				printDevider();
				if(graph == null) {
					graphChecker();
				}else if(inputs.length != 3) {
					invalidInputMessage();
				}else {
					graph.get_edge_adj_matrix(inputs[1], inputs[2]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "3.2":
				printDevider();
				if(graph == null) {
					graphChecker();
				}else if(inputs.length != 3) {
					invalidInputMessage();
				}else {
					graph.get_edge_adj_list(inputs[1], inputs[2]);
				}
				printDevider();
				printMenuMessage();
				break;
			case "3.3":
				printDevider();
				if(graph == null) {
					graphChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					if(graph.vertecies.contains(inputs[1])) {
						graph.DFSAll(inputs[1]);
						System.out.println(graph.dfsOrder.toString());
						graph.dfsOrder.clear();
					}else {
						invalidGraphSearchInputMessage();
					}
				}
				printDevider();
				printMenuMessage();
				break;
			case "3.4":
				printDevider();
				if(graph == null) {
					graphChecker();
				}else if(inputs.length != 2) {
					invalidInputMessage();
				}else {
					if(graph.vertecies.contains(inputs[1])) {
						graph.BFSAll(inputs[1]);
						System.out.println(graph.bfsOrder.toString());
						graph.bfsOrder.clear();
					}else {
						invalidGraphSearchInputMessage();
					}
				}
				printDevider();
				printMenuMessage();
				break;
			case "3.5":
				printDevider();
				if(graph == null) {
					graphChecker();
				}else if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					graph.TopologicalSort();
				}
				printDevider();
				printMenuMessage();
				break;
			case "4":
				if(inputs.length != 1) {
					invalidInputMessage();
				}else {
					printDevider();
					initilizeArrays();
					initilizeArrayList();
					initilizeSortingAlgorithms();
					sortingAlgorithmsReport();
				}
				printDevider();
				printMenuMessage();
			default:
				printDevider();
				invalidInputMessage();
				printDevider();
				printMenuMessage();
				break;
			}
			
			inputProcessor();
		}
		
	}
	
	public static void inputProcessor() {
		input = null;
		input = new Scanner(System.in).nextLine();
		inputs = input.split(" ");
	}
	
	public static void printDevider() {
		String devider = "";
		for(int i = 0; i < 100 ; i++) {
			devider += "=";
		}
		System.out.println("\n" + devider + "\n");
	}
	
	public static void printMenuMessage() {
		System.out.println("Please choose one of the following options!");
		System.out.println("\t 0) Exit program (Syntax: 0)");
		System.out.println("\t 1) Create new Linked List (Syntax: 1)");
		System.out.println("\t\t 1.1) Insert new element (Syntax: 1.1 <value>)");
		System.out.println("\t\t 1.2) Determin if an element exists in the list (Syntax: 1.2 <value>)");
		System.out.println("\t\t 1.3) Print the list (Syntax: 1.3)");
		System.out.println("\t\t 1.4) Delete an element from the list (Syntax: 1.4 <value>)");
		System.out.println("\t 2) Create new Queue (Syntax: 2)");
		System.out.println("\t\t 2.1) Enqueue a charater to the queue (Syntax: 2.1 <value>)");
		System.out.println("\t\t 2.2) Perform dequeue on the queue (Syntax: 2.2)");
		System.out.println("\t\t 2.3) Perform peek on the queue (Syntax: 2.3)");
		System.out.println("\t\t 2.4) Find the size of the queue (Syntax: 2.4)");
		System.out.println("\t\t 2.5) Find out if the queue is empty (Syntax: 2.5)");
		System.out.println("\t\t 2.6) Print out the queue (Syntax: 2.6)");
		System.out.println("\t 3) Create new Graph (Syntax: 3 <node file location> <edge file location>)");
		System.out.println("\t\t 3.1) Determin if an edge between A and B exists through a adjecency matrix (Syntax: 3.1 <A value> <B value>)");
		System.out.println("\t\t 3.2) Determin if an edge between A and B exists through a adjecency list (Syntax: 3.2 <A value> <B value>)");
		System.out.println("\t\t 3.3) Perform a deapth first search on the graph from a starting vertex (Syntax: 3.3 <starting vertex value>)");
		System.out.println("\t\t 3.4) Perform a breath first search on the graph from a starting vertex (Syntax: 3.4 <starting vertex value>)");
		System.out.println("\t\t 3.5) Perform a breath first search on the graph from a starting vertex (Syntax: 3.5 <starting vertex value>)");
		System.out.println("\t 4) Generate report for sorting algorithms (Syntax: 4)");
		System.out.print("\nUser input: ");
	}
	
	public static void goodbyeMessage() {
		System.out.println("PROGRAM: Goodbye!");
	}
	
	public static void invalidInputMessage() {
		System.out.println("PROGRAM: The given input is invalid!");
		System.out.println("PROGRAM: Please enter a valid command!");
	}

	public static void printEndMessage() {
		printDevider();
		printMenuMessage();
	}

	public static void linkedListChecker() {
		printDevider();
		System.out.println("PROGRAM: The list isn't initialized! You must initilize (create) it fist!");
	}
	
	public static void queueChecker() {
		printDevider();
		System.out.println("PROGRAM: The queue isn't initialized! You must initilize (create) it fist!");
	
	}
	
	public static void graphChecker() {
		printDevider();
		System.out.println("PROGRAM: The graph isn't initialized! You must initilize (create) it fist!");
	
	}
	
	public static void invalidGraphSearchInputMessage() {
		System.out.println("PROGRAM: The given element does not exist in the graph!");
		System.out.println("PROGRAM: Please enter a valid element!");
	}
	
	public static void initilizeArrays() {
		for(int i = 0; i < 5; i++) {
			array_5[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 10; i++) {
			array_10[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 50; i++) {
			array_50[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 100; i++) {
			array_100[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 200; i++) {
			array_200[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 400; i++) {
			array_400[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 800; i++) {
			array_800[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 1600; i++) {
			array_1600[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 2400; i++) {
			array_2400[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 3200; i++) {
			array_3200[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 6400; i++) {
			array_6400[i] = randomNumber.nextInt();
		}
		for(int i = 0; i < 12800; i++) {
			array_12800[i] = randomNumber.nextInt();
		}
	}
	
	public static void initilizeArrayList() {
		arrayList.add(array_5);
		arrayList.add(array_10);
		arrayList.add(array_50);
		arrayList.add(array_100);
		arrayList.add(array_200);
		arrayList.add(array_400);
		arrayList.add(array_800);
		arrayList.add(array_1600);
		arrayList.add(array_2400);
		arrayList.add(array_3200);
		arrayList.add(array_6400);
		arrayList.add(array_12800);
	}

	public static void initilizeSortingAlgorithms() {
		bubbleSort = new BubbleSort();
		selectionSort = new SelectionSort();
		insertionSort = new InsertionSort();
		mergerSort = new MergeSort();
		quicksort = new QuickSort();
		heapSort = new HeapSort();
		countingSort = new CountingSort();
	}
	
	public static void sortingAlgorithmsReport() {
		
		System.out.println("Algorithms report:\n");
		System.out.println("Number of elements in arrays:\n5, 10, 50, 100, 200, 400, 800, 1600, 2400, 3200, 6400, 12800");
		System.out.println("Sorting algorithms:\nBubble Sort, Selection Sort, Insertion Sort, Merge Sort, Quick Sort, Heap Sort, Counting Sort");
		System.out.println("\n[Rows - arrays; Columns - algorithms]\n");
		
		for (int[] array : arrayList) {
			String result = "";
			result += bubbleSort.BubbleSortArray(array) + " / ";
			result += selectionSort.SelectionSortArray(array) + " / ";
			result += insertionSort.InsertionSortArray(array) + " / ";
			result += mergerSort.MergeSortArray(array) + " / ";
			result += quicksort.QuickSortArray(array) + " / ";
			result += heapSort.HeapSortArray(array) + " / ";
			result += countingSort.CountingSortArray(array);
			System.out.println(result);
			initilizeSortingAlgorithms();
		}
		
	}
}
