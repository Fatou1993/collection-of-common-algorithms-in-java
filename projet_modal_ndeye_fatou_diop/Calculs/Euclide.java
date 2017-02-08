// Classe Euclide qui sert à calculer le PGCD et le PPCM de deux élèments
//Complexité en 0(logFk) où Fk est le k-ième nombre de Fibonnacci donc complexité linéaire en 0,21*k 
public class Euclide {
	public static int PGCD(int a, int b){
		if(a<b){
			int c = a;
			a = b;
			b = c;
		}
		while(b!=0){
			int temp = a%b;
			a = b;
			b = temp;		
		}
		return (a>0)?a:-a;
	}
	
	public static int PPCM(int a, int b){
		return a*b/PGCD(a,b);
	}
	
	public static void main(String[] args) {
		
		System.out.println("PGCD(60,84): "+PGCD(60,84));
		System.out.println("PPCM(60,84): "+PPCM(60,84));
	}

}
