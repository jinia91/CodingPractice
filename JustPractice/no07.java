//import java.util.*;
//public class no07 {
//
//	public static void main(String[] args) {
//		Scanner S = new Scanner(System.in);
//		
//		int X = S.nextInt();
//		ArrayList<Integer> Xlist = new ArrayList<>();
//		
//		
//		int Y = S.nextInt();
//		ArrayList<Integer> Ylist = new ArrayList<>();
//		
//		Xlist.add(Integer.valueOf(X));
//		Ylist.add(Integer.valueOf(Y));
//		
//		
//		
//		for (int i = 1; i <= X/2; i++) {
//			if(X%i==0) {
//				Xlist.add(Integer.valueOf(i));
//				}
//		}
//		
//		for (int i = 1; i <= Y/2; i++) {
//			if(Y%i==0) {
//				Ylist.add(Integer.valueOf(i));
//				}
//		}
//		
//		
//		Xlist.retainAll(Ylist);
//
//		int min = Xlist.get(Xlist.size()-1);
//		int max = X*Y/min;
//		
//		System.out.println(min);
//		System.out.println(max);
//		
//		
//		
//	}
//
//}



import java.util.*;


public class no07 {

	public static int gcd(int x, int y) {
		if ( y == 0 ) {return x;}
		return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in);
		
		int x = S.nextInt();
		int y = S.nextInt();
		int answer = 0;
		if (x>=y) {
		  answer = gcd(x,y);
		}
		if (x<y) {
		 answer = gcd(y,x);
		}
		
		
		System.out.println(answer);
		System.out.println(x*y/answer);
		
	}
}