// Création de la classe FenwickTree pour implémenter un arbre de Fenwick
import java.util.Arrays;

public class FenwickTree {

	int n; 
	int[] tree;
	
	public FenwickTree(int n){
		tree = new int[n];
		this.n = n;
	}
	
	// ajouter une valeur à l'index, complexité en O(n-index)
	public void add(int index, int value){
		assert(0<index);
		while(index<n){
			tree[index]+=value;
			index+=(index&-index);
		}
	}
	
	// calcul d'une somme préfixe, complexité en O(index)
	public int prefixSum(int index){
		int sum = 0;
		while(index>0){
			sum+=tree[index];
			index-=(index&-index);
		}
		return sum;
	}
	
	public int intervalSum(int a, int b){
		return prefixSum(b)-prefixSum(a);
	}
	public static void main(String[] args) {

		FenwickTree fenwick = new FenwickTree(17);
		System.out.println(Arrays.toString(fenwick.tree));
		//on ajoute des valeurs
		fenwick.add(1, 42);
		fenwick.add(5, 1);
		System.out.println(Arrays.toString(fenwick.tree));
		
		// Calcul de la somme des valeurs entre les index 0 et 10 :  on doit trouver 43 normalement
		System.out.println(fenwick.prefixSum(10));
		
		// Calcul de la somme des valeurs entre les index 0 et 2 :  on doit trouver 42 normalement
		System.out.println(fenwick.prefixSum(2));
		
		// Calcul de la somme des valeurs entre les index 2 et 6 :  on doit trouver 1 normalement
		System.out.println(fenwick.intervalSum(2, 6));
		
	}

}
