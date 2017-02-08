// Algorithme pour déterminer les distances minimales entre deux sommets quelconques du graphe
// Complexité en temps de O(n^3)
// Complexité en espace de O(n^2)

public class Floyd {
	static final int INFINITY = Integer.MAX_VALUE/2;
	
	public static void printDist(int[][] dist){ 
		int n = dist.length;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(dist[i][j]==INFINITY){
					System.out.print("∞ ");
				}else{
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println("");
		}
	}
	
	public static void floydWarshall(int[][] graph){
		int n = graph.length;
		int[][] dist = new int[n][n];
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				dist[i][j]=graph[i][j];
			}
		}
		for(int k = 1; k<n; ++k){
			for(int i=0; i<n; ++i){
				for(int j=0; j<n; ++j){
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		printDist(dist);
	}
	
	public static void main(String[] args) {
		
		int[][] graph = {{0, 2, INFINITY, 6, INFINITY},
	            {2, 0, 3, 8, 5},
	            {INFINITY, 3, 0, INFINITY, 7},
	            {6, 8, INFINITY, 0, 9},
	            {INFINITY, 5, 7, 9, 0},
	           };
		
		int[][] graph1 = { {0,   5,  INFINITY, 10},
                {INFINITY, 0,   3, INFINITY},
                {INFINITY, INFINITY, 0,   1},
                {INFINITY, INFINITY, INFINITY, 0}
              };
		
		floydWarshall(graph);
	}

}
