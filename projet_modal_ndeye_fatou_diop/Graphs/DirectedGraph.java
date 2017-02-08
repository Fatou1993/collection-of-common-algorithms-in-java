// Classe qui implémente une graphe dirigé

import java.util.LinkedList;

public class DirectedGraph {
	int V;
	LinkedList<Integer>[] adj;
	
	public DirectedGraph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<V; ++i){
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v){
		adj[u].add(v);
	}
	
	public boolean isCyclicRec(int u, boolean[] visited, boolean[] isInStack){
		if(!visited[u]){
			visited[u]=true;
			isInStack[u]=true;
			for(int v : adj[u]){
				if(!visited[v] && isCyclicRec(v, visited, isInStack))
					return true;
				if(isInStack[v])
					return true;
			}
				
		}
		isInStack[u]=false;
		return false;
	}
	
	// Complexité en O(V+E) où V est le nombre de sommets, E le nombre d'arêtes
	public boolean isCyclic(){
		boolean[] visited = new boolean[V];
		boolean[] isInStack = new boolean[V];
		
		for(int u=0; u<V; ++u){
			if(isCyclicRec(u,visited,isInStack))
				return true;
		}
		return false;
	}
	
}
