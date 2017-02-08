// Algorithme pour déteminer le couplage maximal entre deux graphes
// Complexité en 0(nm) où n = min(|U|,|V|) où U et V sont les deux graphes et m = |E|

import java.util.Arrays;

public class MaxBipartiteMatching {
	
	boolean[][] M;
	int n0, n1;
	int[] m0, m1;
	static final int LIBRE=-1;
	boolean[] visited;
	
	public MaxBipartiteMatching(int n, int m){
		n0=n; n1=m;
		M = new boolean[n0][n1];
		m0 = new int[n0]; m1 = new int[n1];
		visited = new boolean[n0];
		Arrays.fill(m0, LIBRE); Arrays.fill(m1, LIBRE);
	}
	
	public boolean dfs(int i){
		assert(!dfs(i));
		visited[i]=true;
		for(int j=0; j<n1; ++j){
			if(M[i][j] && (m1[j]==LIBRE || (!visited[m1[j]] && dfs(m1[j])))){
				m0[i]=j;
				m1[j]=i;
				return true;
			}
		}
		return false;
	}
	
	public boolean cheminAugmentant(){
		Arrays.fill(visited, false);
		for(int i=0; i<n0; ++i){
			if(m0[i]==LIBRE)
				if(dfs(i))
					return true;
		}
		return false;
	}
	
	int maxBipartiteMatching(){
		int val = 0;
		Arrays.fill(m0, LIBRE);Arrays.fill(m1, LIBRE);
		while(cheminAugmentant())
			val++;
		return val;
	}
	public static void main(String[] args) {
		
	}

}
