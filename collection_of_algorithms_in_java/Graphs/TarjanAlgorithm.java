// Algorithme pour déterminer les composantes connexes d'un graphe
// Complexité en espace de O(V*V)
// Complexité en espace de O(V^2)

public class TarjanAlgorithm {
	
	static boolean visited[];
	static int graph[][]= {{1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0}
           };
	static int time;
	static int V  = graph.length;
	static int sommet[];
	static int sccp[];
	
	public static void dfs(int u){
		visited[u]=true;	
		for(int w=0; w<V; ++w){
			if(graph[u][w]!=0 && !visited[w])		
				dfs(w);
		}
		sommet[time++]=u;
	}
	
	public static void dfsInv(int u, int comp){	
		visited[u]=true;
		sccp[u]=comp;
		System.out.print(u+" ");
		for(int w=0; w<V; ++w){
			if(graph[w][u]!=0 && !visited[w])
				dfsInv(w, comp);
		}
	}
	public static int sccp(){
		time=0;
		visited = new boolean[V];
		sommet = new int[V];
		for(int u=0; u<V; ++u){
			if(!visited[u])		
				dfs(u);
			
		}
		
		int comp = 0;
		visited = new boolean[V];
		sccp = new int[V];
		for(int i=V-1; i>=0; --i){
			int u = sommet[i];
			
			if(!visited[u]){
				if(i!=V-1)
					System.out.println("");
				System.out.println("Eléments du composant n°"+comp+": ");
				dfsInv(u, comp);
				comp++;
			}
				
		}
		System.out.println("");	
		return comp-1;
		
	}
	
	public static void main(String args[])
	{
		
		System.out.println("Nombre de composants connexes: "+sccp());	
		
	}

}
