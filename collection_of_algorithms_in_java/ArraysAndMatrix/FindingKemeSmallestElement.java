// Algorithme pour trouver le k-ième plus petit élèment dans un tableau
// Utilise la mediane des médianes en tant que pivot
// Complexité en O(n) + 22n attendu (le pivot p vérifie 3*n/10-1.2<=p<=7*n/10-0.3)
// Problème non résolu malgré toutes mes tentatives de débuggage

import java.util.Arrays;

public class FindingKemeSmallestElement {

	//cette fonction trouve la médiane d'un tableau à 5 élèments
	public static int median5(int[] arr){
		Arrays.sort(arr);
		if(arr.length==2){
			
			return arr[1];
		}
			
		return arr[2];
	}

	public static int mediansOfMedians(int[] arr){
		int n = arr.length;
		int length = n/5;
		if(n%5!=0)
			length+=1;
		int[] M = new int[length];
		for(int i=0; i<length; ++i){
			int[] temp = new int[Math.min(5*i+5,n)-5*i+1];
			temp = Arrays.copyOfRange(arr, 5*i, Math.min(5*i+5,n));
			M[i]=median5(temp); 
		int k = (int)Math.ceil((double)(M.length/2));
		
		return Select(M,k); // on prend la médiane du tableau avec les médianes
		
	}
	public static int Select(int[] arr, int k){
		int n = arr.length;
		
		if(n<5){
			Arrays.sort(arr);
			return arr[k-1];
		}else{
			int pivot = mediansOfMedians(arr);
			
			Arrays.sort(arr);			
			int i=0;
			while(arr[i]<pivot && i<=n-1){
				i++;
			}
			int len1 = i;
			
			int[] b = new int[len1]; // tableaux d'éléments strictement inférieurs à arr[pivot]
			int len2 = n-len1;
			while(arr[i]==pivot && i<n-1){
				len2--;
				i++;
			}

			int[] c = new int[len2]; // tableaux d'éléments strictement supérieurs à arr[pivot]
			for(int j=0; j<len1; ++j){
				b[j]=arr[j];
			}
			for(int j=0; j<len2; ++j){
				c[j]=arr[i+j];
			}
			if(len1>k){	
				System.out.println("b :"+Arrays.toString(b));
				return Select(b,k);
			}else{
				if((k-(n-len2))>0){
					System.out.println("c :"+Arrays.toString(c));
					return Select(c,k-(n-len2));
				}	
				else
					return pivot;
			}
		}
			
			
	}
	public static void main(String[] args) {
		int[] arr1 = {21,27,47,48,92};
		//System.out.println(Select(arr1,4));
		
		int[] arr2 = new int[100];
		for(int i=0; i<100; ++i){
			arr2[i]=i;
		}
		
		System.out.println(Select(arr2,50));
	}

}
