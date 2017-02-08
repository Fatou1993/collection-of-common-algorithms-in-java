// Algorithme qui détermine un 4-uplet dont la somme vaut k (avec k donné)
// Complexité en temps de O(n^3)
// Complexité en esapce de O(n)
import java.util.Arrays;

public class FourUpletSum {

	public static void findFourUplet(int[] arr, int sum){
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0; i<n-3; ++i){
			for(int j=i+1; j<n-2; ++j){
				int k = j+1;
				int l = n-1;
				while(k<l){
					if(arr[i]+arr[j]+arr[k]+arr[l]==sum){
						System.out.println("Un 4-uplet dont la somme vaut "+sum+" est ("+arr[i]+", "+arr[j]+", "+arr[k]+", "+arr[l]+")");
						return;
					}else if(arr[i]+arr[j]+arr[k]+arr[l]<sum){
						k++;
					}else {
						l--;
					}
				}
				
			}
		}
		System.out.println("Pas de 4-uplet trouvé");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 45, 6, 10, 12};
		int R = 65;
		findFourUplet(arr,R);
	}

}
