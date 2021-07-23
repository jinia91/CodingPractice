import java.util.Scanner;
import java.util.Stack;

public class no10828 {

	
	
	public static void main(String[] args) {

		Scanner S = new Scanner(System.in);
		int N = S.nextInt();
		Stack st = new Stack();

		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0 ; i < N; i++) {
			String X = S.next();
			
				if(X.equals("size")) sb.append(st.size()).append("\n");
				
				else if(X.equals("empty")) {
					if(!st.isEmpty()) sb.append("0").append("\n");
					else sb.append("1").append("\n");
				}
				
				else if(X.equals("top")) { 
					if(!st.isEmpty())sb.append(st.peek()).append("\n");
					else sb.append("-1").append("\n");
				}	
				
				else if(X.equals("pop")) { 
					if(!st.isEmpty())sb.append(st.pop()).append("\n");
					else sb.append("-1").append("\n");
				}	
				
				else if(X.contains("push")) {
					st.push(S.nextInt());
				}		
		}
		System.out.println(sb);
	}
		
		
		
		
		
}


