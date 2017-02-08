// Algorithme qui détermine s'il existe un sous-ensemble dont la somme vaut k (avec k donné)
// Complexité en O(nk)

public class SubsetSum {

	public static boolean isSubsetSum(int[] arr, int sum){
		boolean[] b = new boolean[sum+1]; // b[i]=true si et seulement s'il existe un sous-ensemble d'entiers dont la somme vaut i
		b[0]=true;
		int n = arr.length;
		for(int i=0; i<n; ++i){
			for(int s=sum; s>=arr[i]; --s){
				b[s]|=b[s-arr[i]];
			}
		}
		return b[sum];
	}
	
	
	public static void main(String[] args) {
		
		int[] set = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		if (isSubsetSum(set, sum) == true)
			System.out.println("Il existe un sous-ensemble dont la somme vaut "+sum);
		else
			System.out.println("Il n'existe pas de sous-ensemble dont la somme vaut "+sum);
	}

}
