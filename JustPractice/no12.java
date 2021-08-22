import java.util.*;

public class no12 {

	static int function(int x) {	
		
		int N = x;
		int sum = 0;
		sum += x;
		while(N!=0) {
			sum += N%10;
			N= N/10;
		}
	    
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		Set set = new HashSet();
		for(int i = 1 ; i <=10000;i ++) {
			set.add(Integer.valueOf(function(i)));
		}
		Set answer = new HashSet();
		
		for(int i =1; i <= 10000; i++) {
			answer.add(i);
		}
		answer.removeAll(set);
		Iterator it = answer.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
//
//		boolean[] check = new boolean[10001];
//		
//		for(int i=1; i <10001; i++){
//			int n = function(i);
//			if (n<10001) {
//			check[n] = true;}
//			if(!check[i])
//			System.out.println(i);
//		}
	}

}
