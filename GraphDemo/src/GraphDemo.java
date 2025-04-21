import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import java.util.*;

public class GraphDemo {

	public static void main(String[] args) {
		Graph<Integer, String> g = new SparseGraph<>();
		
		g.addEdge("12", 1, 2);
		g.addEdge("23", 2, 3);
        g.addEdge("24", 2, 4);
        g.addEdge("34", 3, 4);
        g.addEdge("45", 4, 5);
		System.out.println(g);
		
		
		System.out.println("\nBreadth First Search starting from node 1:");
		bfs(g, 1);
		
        System.out.println("\nDepth First Search starting from node 1:");
        dfs(g, 1);
	}

	
	
	//Implement Breadth First Search
	//Follow "outline" from video
    public static void bfs(Graph<Integer, String> g, Integer start) {
    	Set<Integer> visited = new HashSet<>();
    	Queue<Integer> q = new LinkedList<>();
    	
    	visited.add(start);
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int current = q.poll();
            System.out.print(current + " ");
            
            for(int neighbor: g.getNeighbors(current)) {
            	if(!visited.contains(neighbor)) {
            		visited.add(neighbor);
            		q.add(neighbor);
            	}
            }
    	}
    	
    	
    }
	
	
	
	//Implement Depth First Search
	//Follow "outline" from video
    public static void dfs(Graph<Integer, String> g, Integer start) {
    	Set<Integer> visited = new HashSet<>();
    	Stack<Integer> stack = new Stack<>();
    	
    	stack.push(start);
    	
    	while(!stack.isEmpty()) {
    		int current = stack.pop();
    		if(!visited.contains(current)) {
    			visited.add(current);
    			System.out.print(current + " ");
    			
    			for(int neighbor : g.getNeighbors(current)) {
    				if(!visited.contains(neighbor)) {
    					stack.push(neighbor);
    				}
    			}
    		}
    		
    	}
    	
    	
    }

	

	
	
}
