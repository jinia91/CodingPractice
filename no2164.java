import java.util.*;



public class no2164 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		LinkedList<Integer> deque = new LinkedList<>();
		

		for(int i =1; i<=N;i++) {
			deque.offer(i);
		}
		
		int cnt = 0;
		
		while(deque.size()>1) {
			
			if(cnt%2==0) {
				deque.poll();
			}
			
			else {
				int x =deque.poll();
				deque.offer(x);
			}
			
			cnt++;
		}
		
		System.out.println(deque.get(0));
		
	}

}
