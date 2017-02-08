// pour détecter l'arbre couvrant de poids minimal
// complexité en O(n^2)
public class PrimsMST {

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
			if(graph[i][j]!=0 && distances[j]>graph[i][j] ){
				distances[j]=graph[i][j];
				parent[j]=i;
			}
		}
	}
	public static Boolean isAllVisited(boolean[] visited){
		int n = visited.length;
		for(int i=0; i<n; ++i){
			if(visited[i]==false)
				return false;
		}
		return true;
	}
	public static void primMST(int[][] graph){
		int n = graph[0].length;
		int[] distances = new int[n];
		int[] parent = new int[n];
		for(int i=1; i<n; ++i){
			distances[i]=Integer.MAX_VALUE;
			parent[i]=i;
		}
		distances[0]=0;
		boolean[] visited = new boolean[n];
		while(!isAllVisited(visited)){	
			int index_min = findMin(visited, distances);
			if(visited[index_min]==false){
				visited[index_min]=true;
				updateDistances(graph,index_min, distances, parent);
			}
		}
		
		for(int i=1; i<n; ++i){
			System.out.println(parent[i]+"--"+i+"  "+distances[i]);
		}
		System.out.println("");
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
           };

           // Print the solution
           primMST(graph);
	}

}
