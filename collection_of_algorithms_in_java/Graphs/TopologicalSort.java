// Tri topologique
// DFS avec utilisation d'une pile où les fils sont ajoutés avant les pères dans le parcours DFS
// Complexité en O(V+E)
import java.util.Stack;

public class topologicSort {
	
	public static void topologicalSortRec(DirectedGraph g,int u, Stack<Integer> stack, boolean[] visited){
		visited[u]=true;
		for(int v : g.adj[u]){
			if(!visited[v])
				topologicalSortRec(g,v, stack, visited);
			
		}
		stack.push(u); // on ajoute u à la fin du parcours DFS
	}
	
	public static void topologicalSort(DirectedGraph g){
		int V = g.V;
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for(int u=0; u<V; ++u){
			if(!visited[u]){
				topologicalSortRec(g,u,stack,visited);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static void main(String args[])
	{

		DirectedGraph g = new DirectedGraph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Tri topologique: ");
		topologicalSort(g);
	}
}
