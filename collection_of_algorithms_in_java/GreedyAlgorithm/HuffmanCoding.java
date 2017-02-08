//Il y a deux étapes dans l'algorithme :  la construction de l'arbre de Huffman et l'affichage du code pour chaque élèment
// On a un algorithme en O(nlog(n)) où n désigne le nombre de caractères
import java.util.PriorityQueue;

public class HuffmanTree implements Comparable<HuffmanTree>{
	
	int freq;
	char root;
	HuffmanTree left, right;
	
	public HuffmanTree(char c, int f){
		left=right=null;
		root=c;
		freq=f;
	}
	public HuffmanTree(char c, HuffmanTree l, HuffmanTree r){
		root=c;
		left=l;
		right=r;
		freq=l.freq+r.freq;
	}
	public int compareTo(HuffmanTree tree){
		return this.freq-tree.freq;
	}
	
	public String toString(){ // pour afficher l'arbre de Huffman de la gauche vers la droite
		if(left==null && right==null)
			return "("+root+","+freq+")";
		String s = "("+root+","+freq+")";
		if(left!=null)
			s=left.toString()+" "+s;
		if(right!=null)
			s=s+" "+right.toString();
		return s;
	}
	
	public static void printCodes(HuffmanTree tree, String s){ // pour afficher le code affecté à chaque caractère
		if(tree==null)
			return;
		if(tree.root!='$')
			System.out.println(tree.root+":"+s);
		printCodes(tree.left,s+"0");
		printCodes(tree.right,s+"1");
	}
	
	public static void HuffmanCodes(char[] arr, int[] freq, int size){
		int n = arr.length;
		PriorityQueue<HuffmanTree> nodes = new PriorityQueue<>();
		for(int i=0; i<n; ++i){
			HuffmanTree temp = new HuffmanTree(arr[i], freq[i]);
			nodes.add(temp);
		}
		
		
		while(nodes.size()>=2){
			HuffmanTree left = nodes.poll();
			HuffmanTree right = nodes.poll();
			HuffmanTree temp = new HuffmanTree('$',left,right);
			nodes.add(temp);	
		}
		
		HuffmanTree temp = nodes.poll();
		//System.out.println(temp.toString()); pour afficher le tableau
		printCodes(temp, "");
		
		
	}
	
	
	public static void main(String[] args) {

		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
	    int[] freq = {5, 9, 12, 13, 16, 45};
	    int size = arr.length;
	    HuffmanCodes(arr, freq, size);
	}

}
