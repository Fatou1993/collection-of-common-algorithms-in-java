// Algorithme pour déterminer si un graphe est bipartite 
// Cherche si on peut utiliser deux couleurs seulement pour colorier le graphe tel que deux voisins n'ont pas la même couleur
// Utilisation d'une BFS
// Complexité en O(V^2) où V est le nombre de sommets

import java.util.Arrays;
import java.util.LinkedList;

public class isBipartite {	
	
	public static boolean isBipart(int[][] graph, int src){
		int n = graph.length;
		
		int[] color = new int[n];
		Arrays.fill(color, -1);
		color[src]=1;		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);	
		while(!q.isEmpty()){
			int u = q.poll();
			for(int v=0; v<n; ++v){					
				if(graph[u][v]==1 && color[v]==-1){					
					color[v]=1-color[u];
					q.add(v);
				}else if(graph[u][v]==1 && color[v]==color[u]){
					return false;
				}
					
			}
		}		
		return true;
	}
	public static void main(String[] args) {
		
		int[][] graph1 = {{0, 1, 0, 0, 1},
	            {1, 0, 1, 0, 0},
	            {0, 1, 0, 1, 0},
	            {0, 0, 1, 0, 1},
	            {1, 0, 0, 1, 0}
	        };
		
		int[][] graph2 = {{0, 1, 0, 1},
    	        {1, 0, 1, 0},
    	        {0, 1, 0, 1},
    	        {1, 0, 1, 0}
    	    };
       
        if (isBipart(graph1, 0))
           System.out.println("Le graphe est bipartite");
        else
           System.out.println("Le graphe n'est pas bipartite");
        
        if (isBipart(graph2, 0))
            System.out.println("Le graphe est bipartite");
         else
            System.out.println("Le graphe n'est pas bipartite");
	}

}
