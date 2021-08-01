import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class no1259 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		
		while(true) {
			
			String x = br.readLine(); 
			
			
			if (x.equals("0")) break;
			
			Stack st = new Stack();
			
			for(int i = 0 ; i < x.length(); i++) {
				st.push(x.charAt(i));
			}
			
			StringBuilder sb = new StringBuilder();
			int size =st.size();
			
			for(int i =0; i<size;i++) {
				sb.append(st.pop());
			}
			
			String y = sb.toString();
			
			if(x.equals(y)) {
				
				System.out.println("yes");
			}
			else System.out.println("no");
			
		}
	
	
	}

}
