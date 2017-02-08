// Classe pour implémenter un graphe non dirigé
public class UndirectedGraph {
	int E; 
	int V;
	Edge[] edge;
	
	public UndirectedGraph(int v, int e){
		E = e;
		V = v;
		edge = new Edge[e];
		for(int i=0; i<e; ++i){
			edge[i]=new Edge();
		}
	}
	
	// Complexité en O(log(n))
	public int find(int[] parent,int i){
		if(parent[i]==i)
			return i;
		int r = find(parent, parent[i]);
		parent[i]=r;
		return r;
	}
	// Complexité en O(log(n))
	public void union(int[] parent, int[] size, int x, int y){
		int xset = find(parent,x);
		int yset = find(parent,y);
		if(size[xset]<=size[yset]){
			parent[xset]=yset;
			size[yset]+=size[xset];
		}else{
			parent[yset]=xset;
			size[xset]+=size[yset];
		}
		
	}
	
	public int isCycle(UndirectedGraph graph){
		int edges = graph.E;
		int vertices = graph.V;
		int[] parent = new int[vertices];
		int[] size = new int[vertices];
		for(int i=0; i<vertices; ++i){
			parent[i]=i;
			size[i]=1;
		}
		for(int e=0; e<edges; ++e){
			int x =graph.find(parent, graph.edge[e].src);
			int y =graph.find(parent, graph.edge[e].dest);
			if(x==y)
				return 1;
			graph.union(parent, size, x, y);
		}
		return 0;
	}
}
