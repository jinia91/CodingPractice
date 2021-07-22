//import java.util.*;
//
//public class no11 {
//
//	public static void main(String[] args) {
//
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		for(int i = 2; i<=10000;i++){
//			if(sosu(i)) {
//				list.add(i);
//			}
//		}
//		
//		
//		
//		Scanner S = new Scanner(System.in);
//		
//		int x = S.nextInt();
//		int y = S.nextInt();
//		
//		
//		int sum = 0;
//		int min = 0;
//		for(int i= x; i<= y; i++) {
//			if(list.indexOf(i)!= -1) {
//				min = i; break;
//			}
//			}
//		for(int i= x; i<= y; i++) {
//			if(list.indexOf(i)!= -1) {
//				sum += i;
//			}
//		}
//		
//		if (sum == 0) {
//			System.out.println(-1);
//		}
//		else 
//		{System.out.println(sum);
//		System.out.println(min);}
//
//	
//		
//	}
//
//	static boolean sosu(int x) {
//
//		if(x == 1) return false;
//		for(int i = 2; i<=Math.sqrt(x);i++)
//			if(x%i == 0) return false;
//		return true;
//	}
//	
//	
//} 억지로 소수 판정후 구현. 앞으로는 에라토스테네스의 체와 버퍼리더 사용하기






import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no11 {

	static boolean[] prime_a;
	
	static void prime(int N) {
		
		prime_a = new boolean[N+1];
		
		prime_a[0] = true;
		prime_a[1] = true;
		
	for(int i =2; i <= Math.sqrt(prime_a.length); i++) {
		if(prime_a[i]) continue; 
		
		for(int j = 2; i*j<= N; j++) {
			prime_a[i*j] = true;
		}
	}
		
	
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		prime(N);

		int sum = 0;
		int min = 0;
		for(int i= M; i<= N; i++) {
			if(prime_a[i] == false) {
				min = i; break;
			}
			}
		for(int i= M; i<= N; i++) {
			if(prime_a[i] == false) {
				sum += i;
			}
		}
		
		if (sum == 0) {
			System.out.println(-1);
		}
		else 
		{System.out.println(sum);
		System.out.println(min);}

		
		
		
		
	}
}
