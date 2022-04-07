import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

	ArrayList<String> vertecies = new ArrayList<String>();
	ArrayList<String> edges = new ArrayList<String>();
	ArrayList<LinkedList> adjecencyLists = new ArrayList<LinkedList>();
	ArrayList<String> dfsOrder = new ArrayList<String>();
	ArrayList<String> bfsOrder = new ArrayList<String>();
	Queue pseudStack = new Queue();
	ArrayList<String> degOrder = new ArrayList<String>();
	ArrayList<String> topOrder = new ArrayList<String>();
	
	String[][] adjecencyMatrix;
	String[][] supportAdjMatrix;
	LinkedList adjecencyList = new LinkedList();
	
	public void init(String nodes_file, String edges_file) {
		
		try {
			BufferedReader verticiesBR = new BufferedReader(new FileReader(new File(nodes_file)));
			BufferedReader edgesBR = new BufferedReader(new FileReader(new File(edges_file)));
			String line;
			try {
				while((line = verticiesBR.readLine()) != null) {
					vertecies.add(line);
				}
				while((line = edgesBR.readLine()) != null) {
					edges.add(line);
				}
				fillAdjecenyList(vertecies, edges);
				fillAdjecencyMatrix(vertecies, edges);
			} catch (IOException e) {
				System.err.println("PROGRAM: Error while reading node file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("PROGRAM: The given path for one of the files in invalid. Please try again");
		}
	}
	
	public void get_edge_adj_matrix(String source, String dest) {
		int distance;
		int x = -1;
		int y = -1;
		for(int i = 0; i < vertecies.size(); i++) {
			if(source.equals(vertecies.get(i))) {
				x = i;
			}
			if(dest.equals(vertecies.get(i))) {
				y = i;
			}
		}
		
		try {
			distance = Integer.parseInt(adjecencyMatrix[x + 1][y + 1]);
			System.out.println("PROGRAM: A edge between " + source + " and " + dest + " exists (distance: " + distance +  ")");
		}catch (Exception e){
			System.out.println("PROGRAM: A edge between " + source + " and " + dest + " does not exist");
		}
	}
	
	public void get_edge_adj_list(String source, String dest){
		LinkedList tempList = null;
		for (LinkedList linkedList : adjecencyLists) {
			if(linkedList.existsShorter(source)) {
				tempList = linkedList;
				break;
			}
		}
		if(tempList != null) {
			Node tempNode = tempList.headRetrive();
			String[] nodeInfo;
			String distance;
			while(tempNode != null) {
				nodeInfo = tempNode.get_value().split(", ");
				if(nodeInfo[0].equals("[(" + dest)) {
					distance = nodeInfo[1].substring(0, nodeInfo[1].length() - 1);
					System.out.println("PROGRAM: A edge between " + source + " and " + dest + " exists (distance: " + distance +  ")");
					return;
				}
				tempNode = tempNode.get_next();
			}
		}
		
		System.out.println("PROGRAM: A edge between " + source + " and " + dest + " does not exist");
	}
	
	public void fillAdjecencyMatrix(ArrayList<String> vertecies, ArrayList<String> edges) {
		adjecencyMatrix = new String[vertecies.size() + 1][vertecies.size() + 1];
		String edge = "";
		String[] edgeInfo;
		String vertex = "";
		int x;
		int y;
		
		// Used to initialize matrix edges
		for(int i = 0; i < vertecies.size(); i++) {
			adjecencyMatrix[0][i + 1] = vertecies.get(i);
			adjecencyMatrix[i + 1][0] = vertecies.get(i);
		}
		adjecencyMatrix[0][0] = "-";
		
		for(int i = 0; i < vertecies.size(); i++) {
			vertex = vertecies.get(i);
			x = i;
			for(int j = 0; j < edges.size(); j++) {
				edge = edges.get(j);
				edgeInfo = edge.split(" ");
				if(vertex.equals(edgeInfo[0])) {
					for(int k = 0; k < vertecies.size(); k++) {
						if(edgeInfo[1].equals(vertecies.get(k))) {
							y = k;
							adjecencyMatrix[x + 1][y + 1] = edgeInfo[2];
						}
					}
				}
			}
		}
		
		System.out.println("\n\tAdjecency matrix:\n");
		// Used for testing
		for(int i = 0; i < vertecies.size() + 1; i++) {
			for(int j = 0; j < vertecies.size() + 1; j++) {
				if(adjecencyMatrix[i][j] == null) {
					System.out.print(0 + " ");
				}else {
					System.out.print(adjecencyMatrix[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	

	public void fillAdjecenyList(ArrayList<String> vertecies, ArrayList<String> edges) {		
		String vertex = "";
		String edge = "";
		String[] edgeInfo;
		String result;
		
		for(int i = 0; i < vertecies.size(); i++) {
			vertex = vertecies.get(i);
			adjecencyList.insertShorter(vertex);
			for(int j = 0; j < edges.size(); j++) {
				edge = edges.get(j);
				edgeInfo = edge.split(" ");
				
				if(vertex.equals(edgeInfo[0])) {
					result = "[(" + edgeInfo[1] + ", " + edgeInfo[2] + ")]";
					adjecencyList.insertShorter(result);
				}
			}
			adjecencyLists.add(adjecencyList);
			adjecencyList = new LinkedList();
		}
		
		System.out.println("PROGRAM: New graph initilized");
		System.out.println("\n\tAdjecency lists:\n");
		
		// Used for testing
		for(int i = 0; i < adjecencyLists.size(); i++) {
			adjecencyLists.get(i).print_list();
		}
		
		
	}
	
	public int findPositionOfElement(String element, ArrayList<String> vertecies) {
		for(int i = 0; i < vertecies.size(); i++) {
			if(element.equals(vertecies.get(i))) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public void DFSAll(String vertex) {
		DFS(vertex);
		for (String node : vertecies) {
			if(!dfsOrder.contains(node)) {
				DFS(node);
			}
		}
	}
	
	public void DFS(String vertex){
		
		if(!dfsOrder.contains(vertex)) {
			
			dfsOrder.add(vertex);
			
			int position = vertecies.indexOf(vertex);
			
			for(int i = 0; i < vertecies.size(); i++) {
				
				if(adjecencyMatrix[position + 1][i + 1] != null) {
					if(!dfsOrder.contains(vertecies.get(i))) {
						DFS(vertecies.get(i));
					}
				}
			}
		}
	}
	
	public void BFSAll(String vertex) {
		BFS(vertex);
		for (String node : vertecies) {
			if(!bfsOrder.contains(node)) {
				BFS(node);
			}
		}
		pseudStack = new Queue();
	}
	
	public void BFS(String vertex) {
		
		bfsOrder.add(vertex);
		pseudStack.enqueueNoMessage(vertex);
		
		while(true) {
			if(pseudStack.isEmptyNoMessage()) {
				break;
			}
			String current = pseudStack.dequeueNoMessage();
			
			for(LinkedList row : adjecencyLists) {
				Node head = row.headRetrive();
				if(head.get_value().equals(current)) {
					Node temp = head.get_next();
					while(temp != null) {
						String[] parsed = temp.get_value().split(",");
						String adjecentNode = parsed[0].substring(2);
						if(!bfsOrder.contains(adjecentNode)) {
							bfsOrder.add(adjecentNode);
							pseudStack.enqueueNoMessage(adjecentNode);
						}
						temp = temp.get_next();
					} 
				}	
			}
		}
	}
	
	public boolean DAGChecker() {
		for (String node : vertecies) {
			if(!SimpleDAG(node)) {
				if(!ComplexDAG(node)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean SimpleDAG(String vertex) {
		int row = vertecies.indexOf(vertex);
		
		for(int i = 0; i < vertecies.size(); i++) {
			if(adjecencyMatrix[row + 1][i + 1] != null && adjecencyMatrix[i + 1][row + 1] != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean ComplexDAG(String vertex) {
		
		dfsOrder.add(vertex);
		pseudStack.enqueueNoMessage(vertex);
		
		while(true) {
			
			if(pseudStack.isEmptyNoMessage()) {
				break;
			}
			
			String current = pseudStack.dequeueNoMessage();
			
			for(LinkedList row : adjecencyLists) {
				Node head = row.headRetrive();
				if(head.get_value().equals(current)) {
					Node temp = head.get_next();
					while(temp != null) {
						String[] parsed = temp.get_value().split(",");
						String adjecentNode = parsed[0].substring(2);
						if(!dfsOrder.contains(adjecentNode)) {
							dfsOrder.add(adjecentNode);
							pseudStack.enqueueNoMessage(adjecentNode);
						}else {
							return true;
						}
						temp = temp.get_next();
					} 
				}	
			}
		}
		pseudStack = new Queue();
		dfsOrder.clear();
		return false;
	}
	
	public void TopologicalSort() {
		
		supportAdjMatrix = adjecencyMatrix.clone();
		
		if(DAGChecker()) {
			System.out.println("PROGRAM: The given graph is a DAG");
			System.out.println("PROGRAM: NONE");
		}else {
			
			int verteciesLeft = vertecies.size();
			
			while(verteciesLeft != 0) {
				
				for (int element = 0 ; element < vertecies.size(); element++) {
					
					String vertex = vertecies.get(element);
					
					if(!EdgeChecker(vertex) && !topOrder.contains(vertex)) {
						
						int position = vertecies.indexOf(vertex);
						
						for(int i = 0; i < vertecies.size(); i++) {
							supportAdjMatrix[position + 1][i + 1] = null;
						}
						
						element = 0;
						topOrder.add(vertex);
						verteciesLeft--;
					}
				}
			}
			System.out.println(topOrder.toString());
			topOrder.clear();
		}
	}
	
	public boolean EdgeChecker(String vertex) {
		int position = vertecies.indexOf(vertex);
		for(int i = 0; i < vertecies.size(); i++) {
			if(i != position && supportAdjMatrix[i + 1][position + 1] != null) {
				return true;
			}
		}
		return false;
	}
}
