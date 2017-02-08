// Algorithme qui implémente la décomposition de Gauss Jordan
// L'algorihme marche bien mais il y a un problème d'arrondi qui fausse un peu le calcul
// La complexité est en O(max(m*m, m*n))

import java.util.Arrays;

public class Matrix {
	
	double[][] matrix;
	int n, m; // n: nombre de lignes, m: nombre de colonnes
	
	public Matrix(int n, int m){
		this.n=n;
		this.m=m;
		this.matrix = new double[n][m];
	}

	public Matrix(double[][] matrix){
		n = matrix.length;
		m = matrix[0].length;
		this.matrix = new double[n][m];
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				this.matrix[i][j]=matrix[i][j];
			}
		}
	}
	
	public void divideBy(int line, double coeff){
		for(int col = 0; col<m; ++col){
			matrix[line][col]/=coeff;
		}
	}
	
	public void soustract(int i, int r, double coeff){
		for(int col = 0; col<m; ++col){
			matrix[i][col]-=(coeff*matrix[r][col]);
		}
	}
	
	public int indexMaxAbsElement(int imin, int col){
		int index = imin;
		double max = 0.0;
		for(int line = imin; line<n; ++line){
			if(Math.abs(matrix[line][col])>max){
				index=line;
				max = Math.abs(matrix[line][col]);
			}
		}
		return index;
	}
	
	public void exchange(int k, int r){
		double[] temp = matrix[k];
		matrix[k]=matrix[r];
		matrix[r]=temp;
	}
	
	public void print(){
		
		for(int i=0; i<n; ++i){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	public static void printSol(double[] sol){
		if(sol==null){
			System.out.println("Pas de solution obtenu");
		}else{
			int n = sol.length;
			System.out.println("Solution obtenu: (j'ai juste un souci lié à la muliplication qui me donne des erreurs por la solution)");
			for(int i=0; i<n; ++i){
				System.out.println(sol[i]);
			}
		}
	}
	public static double[] GaussJordan(Matrix M, Matrix b){
		int K = Math.min(M.n, M.m);
		int r = 0; // Indice du dernier ligne de pivot trouvé
		for(int j = 0; j<M.m; ++j){
			int k = M.indexMaxAbsElement(r, j);
			double pivot = M.matrix[k][j];
			if(pivot!=0){
				// division pour avoir le pivot égal à 1
				M.divideBy(k, pivot);
				b.divideBy(k, pivot);
				// échange de lignes
				M.exchange(k, r);
				b.exchange(k, r);			
				for(int i=0; i<M.n; ++i){
					if(i!=r){
						// on soustrait à la ligne i la ligne du pivot r" multiplié par le bon facteur
						M.soustract(i, r, M.matrix[i][j]); 
						b.soustract(i, r, M.matrix[i][j]);
					}
				}
				r++;
				System.out.println("Matrix obtenu:");
				M.print();
				System.out.println("");
			}else{
				for(int i=r; i<M.n; ++i){
					if(b.matrix[i][0]!=0.0)
						return null;
				}
				K = r;
				break;
			}
		}
		
		double[] sol = new double[b.n];
		for(int i=0; i<K; ++i){
			sol[i]=b.matrix[i][0];
		}
		
		return sol;
	}
	
	public static void main(String[] args) {
		
		double[][] matrix = {{1,-1,2},
				{3,2,1},
				{2,-3,-2}
			};
		double[][] vec = {{5},
				{10},
				{-10}
			};
		double[][] matrix1 = {{1,2,2,-3,2},
				{2,4,1,0,-5},
				{4,8,5,-6,-1},
				{-1,-2,-1,1,1}
			};
		double[][] vec1 = {{3},
				{-6},
				{0},
				{1}
		};
		
		double[][] matrix2 = {{1,2,2,-3,2},
				{2,4,1,0,-5},
				{4,8,5,-6,-1},
				{-1,-2,-1,1,1}
			};
		double[][] vec2 = {{3},
				{-6},
				{0},
				{2}
		};

//		Matrix M = new Matrix(matrix);
//		Matrix b = new Matrix(vec);
//		double[] sol = GaussJordan(M, b);
//		printSol(sol);
//		
//		System.out.println("");
		
		Matrix M1 = new Matrix(matrix1);
		Matrix b1 = new Matrix(vec1);
		double[] sol1 = GaussJordan(M1, b1);
		printSol(sol1);
		
		System.out.println("");
		
		Matrix M2 = new Matrix(matrix2);
		Matrix b2 = new Matrix(vec2);
		double[] sol2 = GaussJordan(M2, b2);
		printSol(sol2);		
		
	}

}
