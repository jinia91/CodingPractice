import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.*;
//public class no05 {
//
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int n1 = 0;
//		int n2 = 1;
//		int N = s.nextInt();
//		
//		if (N==0) {
//			n2 = 0;
//		}
//		for(int i = 0; i <N-1 ; i++)	{
//			int tmp = n2;
//			n2 = n1+n2;
//			n1 = tmp;
//			
//		}	
//		
//		System.out.println(n2);
//		 
//			
//		
//		
//	}
// 
//}



public class no05 {

	static int Fibonachi(int N) {
		if (N==0) {return 0;}
		if (N==1) {return 1;}
		
		return Fibonachi(N-1)+ Fibonachi(N-2);
		
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer N = Integer.valueOf(br.readLine());
		
		System.out.println(Fibonachi(N));
		
		
	}
 
}
