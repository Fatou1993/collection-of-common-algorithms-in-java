// Ici on doit déterminer le nombre d'opérations nécessaire pour changer un string en un autre
// Chaque opération (remplacement suppression, insertion ) a un coût de 1
// Complexité en temps: O(n1 x n2)
// Complexité en espace: O(n1 x n2)
import java.util.Locale;
import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
                sc.useLocale(Locale.US);
                int t = sc.nextInt();
                while(t-->0){
                	int n1 = sc.nextInt(); 
                	int n2 = sc.nextInt();	
                	String s1 = sc.next();
                	String s2 = sc.next();	
                	int[][] O= new int[n1+1][n2+1]; // O[i][j] contient le nombre minimum d'opérations nécessaires pour passer d'une sous-séquence
                	//de longueur i de s1 à une sous-séquence de longueur j de s2
                	for(int i=0; i<=n1; ++i){
                		O[i][0]=i;
                	}
                	for(int j=0; j<=n2; ++j){
                		O[0][j]=j;
                	}
                	for(int i=1; i<=n1; ++i){
                		for(int j=1; j<=n2; ++j){
                			O[i][j] = Math.min(O[i][j-1]+1, O[i-1][j]+1);
                			if(s1.charAt(i-1)==s2.charAt(j-1)){
                				O[i][j]=Math.min(O[i][j],O[i-1][j-1]);
                			}else{
                				O[i][j]=Math.min(O[i][j],O[i-1][j-1]+1);
                			}
                		}
                	}
                	System.out.println(O[n1][n2]);
                }
                sc.close();

        	}

}
