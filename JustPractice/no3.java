//import java.util.*;
//
//public class no3 {
//
//	public static void main(String[] args) {
//		Scanner S = new Scanner(System.in);
//		int N = S.nextInt();
//		int[] array = new int[N];
//		
//		for(int i= 0; i <N; i++) {
//			int x = S.nextInt();
//			array[i] = x;
//		}
//		
//		Arrays.sort(array);
//		
//		System.out.print(array[0] + " " + array[N-1]);
//	}
//
//}
import java.util.*;

public class no3 {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		int N = S.nextInt();
		int x = 0;
		int max = 0;
		int min = 0;
		
		for(int i= 0; i <N; i++) {
			x = S.nextInt();
			if (i==0) {max = x; min = x;}
			if (x>max) {max = x;}
			if (x<min) {min = x;}
		}
		
		System.out.println(min + " " + max);
		
		
	}

}
