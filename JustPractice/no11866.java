import java.util.*;


public class no11866 {

	public static void main(String[] args) {

		
		LinkedList<Integer> que = new LinkedList<>();
		
		Scanner S = new Scanner(System.in);
		
		int N = S.nextInt();
		int K = S.nextInt();
		
		for(int i = 1; i<=N; i++) {			
			que.offer(i);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		int cnt =0;
		while(!que.isEmpty()) {
			cnt++;
			int x = 0;
			if(cnt%K!=0) {
			que.offer(que.poll());
			}
			else {x = que.poll();
			answer.add(x);}
		}
		
		Iterator<Integer> it = answer.iterator();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		while(it.hasNext()) {
			
			sb.append(it.next()).append(", ");
			
		}

		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		
		System.out.println(sb);
		
	}

}
