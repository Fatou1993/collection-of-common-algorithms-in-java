// Algorithme de Dijsktra pour déterminer les plus petites distances entre une source donnée et les autres sommets ( ici tous les poids sont positifs)
// L'algorithme met à jour les distances au fûr et à mesure qu'il parcourt les sommets
// Complexité en O(n*n) où n est le nombre de sommets
public class Dijsktra {

	public static Boolean isAllVisited(boolean[] visited){
		int n = visited.length;
		for(int i=0; i<n; ++i){
			if(visited[i]==false)
				return false;
		}
		return true;
	}
	
	public static int findMin(boolean[] visited, int[] distances){
		int n = visited.length;
		int min = Integer.MAX_VALUE, index=-1;
		for(int i=0; i<n; ++i){
			if(distances[i]<min && visited[i]==false){
				min = distances[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void updateDistances(int[][] graph, int i, int[] distances, int[] parent){
		int n = distances.length;	
		for(int j=0; j<n; ++j){
			if(graph[i][j]!=0 && distances[j]>distances[i]+graph[i][j] ){
				distances[j]=distances[i]+graph[i][j];
				parent[j]=i;
			}
		}
	}
	
	public static void dijkstra(int[][] graph, int src){
		int n = graph[0].length;
		int[] distances = new int[n];
		int[] parent = new int[n];
		for(int i=0; i<n; ++i){
			parent[i]=i;
			if(i!=src)
				distances[i]=Integer.MAX_VALUE;
		}
		distances[src]=0;
		boolean[] visited = new boolean[n];
		while(!isAllVisited(visited)){ // tant que tous les sommets n'ont pas été visités
			int index_min = findMin(visited, distances); // chercher le sommet le plus proche
			if(visited[index_min]==false){
				visited[index_min]=true;
				updateDistances(graph,index_min, distances, parent); // mettre à jour les distances
			}
		}
		for(int i=1; i<n; ++i){
			System.out.println("N°: "+i+" distance de la source: "+distances[i]);
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };

		dijkstra(graph, 0);
	}

}
