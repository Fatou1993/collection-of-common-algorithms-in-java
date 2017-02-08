// Algorithme pour détecter l'arbre couvrant de poids minimal
// Complexité en O(Elog(E)) ou O(Elog(V)) avec l'utilisation de la structure Union-Find
import java.util.LinkedList;

public class KruskalMST {
	
	public static void sortEdges(UndirectedGraph graph){
		int edges = graph.E;
		for(int j=1; j<edges; ++j){
			Edge key = graph.edge[j];
			int i=j-1;
			while(i>=0 && graph.edge[i].weight>key.weight){
				graph.edge[i+1]=graph.edge[i];
				i=i-1;
			}
			graph.edge[i+1]=key;
		}
	}
	
	public static void kruskalMST(UndirectedGraph graph){
		int edges = graph.E;
		int vertices = graph.V;
		UndirectedGraph g = new UndirectedGraph(vertices,0); // on initialise un graphe avec aucun arête
		sortEdges(graph); // on trie les arêtes par ordre croissant de poids
		
		int[] parent = new int[vertices];
		int[] size = new int[vertices];
		for(int i=0; i<vertices; ++i){
			parent[i]=i;
			size[i]=1;
		}
		
		LinkedList<Edge> e = new LinkedList<>();
		for(int i=0; i<edges && g.E<vertices; ++i){
			Edge temp = graph.edge[i];
			int x= temp.src;
			int y= temp.dest;
			if(g.find(parent, x)!=g.find(parent, y)){ // si un cycle n'est pas formé on ajoute l'arête
				e.add(temp);
				g.union(parent, size, x, y);
			}
		}
		
		int n = e.size();
		for(int j=0; j<n; ++j){
			System.out.println("weight: "+e.get(j).weight+" src: "+e.get(j).src+" dest: "+e.get(j).dest);
		}
	}
	
	public static void main(String[] args) {
		
	    UndirectedGraph graph = new UndirectedGraph(4,5);	 
	   
	    graph.edge[0].src = 0;
	    graph.edge[0].dest = 1;
	    graph.edge[0].weight = 10;	 
	  
	    graph.edge[1].src = 0;
	    graph.edge[1].dest = 2;
	    graph.edge[1].weight = 6; 
	 
	    graph.edge[2].src = 0;
	    graph.edge[2].dest = 3;
	    graph.edge[2].weight = 5; 

	    graph.edge[3].src = 1;
	    graph.edge[3].dest = 3;
	    graph.edge[3].weight = 15;
	 
	    graph.edge[4].src = 2;
	    graph.edge[4].dest = 3;
	    graph.edge[4].weight = 4;
	 
	    kruskalMST(graph);
	    

	}

}
