import java.util.*;
public class no2 {
  public static void main(String[] args){
	  Scanner S1 = new Scanner(System.in);
	  int T = S1.nextInt();
	  int[] N = new int[T];		
	 for (int i=0; i<T;i++) {
		 N[i] = S1.nextInt();		 
	 }
	  for (int i=0; i<T;i++) {
		  String Bi = Integer.toBinaryString(N[i]);
		  for (int j = Bi.length()-1;j>=0;j--) {
			  if (Bi.charAt(j)=='1') {
				  System.out.print((Bi.length()-j-1) + " ");
			  }
		  }
		  System.out.println();
	  }
	}
}
