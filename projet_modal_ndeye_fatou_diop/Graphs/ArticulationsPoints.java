// Algorithme qui détermine les points d'articulation dans un graphe
// Complexité en O(V+E) où E est le nombre d'arêtes, V le nombre de sommets grâce à l'utilisation d'une DFS
import java.util.LinkedList;
public class ArticulationPoints {
	
	public class Graph{
		public int V;  
	    public LinkedList<Integer>[] adj;
	    
	    Graph(int v)
	    {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i=0; i<v; ++i)
	            adj[i] = new LinkedList();
	    }

	    
	    void addEdge(int v, int w)
	    {
	        adj[v].add(w); 
	        adj[w].add(v);  
	    }
	}
	public static int time = 0;

	public static void articulationPointsRec(Graph graph, int u, boolean[] visited, int[] d, int[] low, int[] parent, boolean[] isArticulationPoint){
		int children = 0;		
		visited[u]=true;
		d[u]=low[u]=++time;		
		for(int v :graph.adj[u]){
			if(!visited[v]){
				children++;
				parent[v]=u;
				articulationPointsRec(graph, v, visited, d, low, parent, isArticulationPoint);
				low[u]=Math.min(low[u],low[v]);
				if((parent[u]==u && children > 1) || (parent[u]!=u && low[v]>=d[u]))
					isArticulationPoint[u]=true;				
			}else if(v!=parent[u])
				low[u] = Math.min(low[u], d[v]);
		}
	}
	
	public static void articulationPoints(Graph graph){
		int V = graph.V;
		boolean visited[] = new boolean[V];
		int d[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		boolean isArticulationPoint[] = new boolean[V]; 

		for (int i = 0; i < V; i++){
			parent[i] = i;	
		}

		for (int u = 0; u < V; u++)
			if (!visited[u])
				articulationPointsRec(graph, u, visited, d, low, parent, isArticulationPoint);

		for (int i = 0; i < V; i++)
			if (isArticulationPoint[i])
				System.out.print(i+" ");
	}
		
	
	public static void main(String[] args) {
		
   		  ArticulationPoints g = new ArticulationPoints();
		
		System.out.println("Points d'articulation dans le premier graphe ");
        Graph g1 = g.new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        articulationPoints(g1);
        System.out.println();
 
        System.out.println("Points d'articulation dans le second graphe ");
        Graph g2 = g.new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        articulationPoints(g2);
        System.out.println();
 
        System.out.println("Points d'articulation dans le troisième graphe ");
        Graph g3 = g.new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        articulationPoints(g3);
    }

}
