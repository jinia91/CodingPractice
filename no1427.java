import java.io.*;
import java.util.*;



public class no1427 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.valueOf(br.readLine());
		
		int X = N;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; ; i++) {
			list.add(X%10);
			X=X/10;
			if(X==0) break;
		}
		
		
		list.sort(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		
		
		System.out.println(sb);
			
		
		
	}

}
