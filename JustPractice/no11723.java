import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class no11723 {

	
	static HashSet<Integer> arr = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	
	static void add(int x) {
		
		arr.add(x);
		
	}
	
	static void remove(int x) {
		
		arr.remove(x);
		
	}
	
	static void check(int x) {
		
		int a = arr.contains(x)? 1:0;

		sb.append(a).append("\n");
	}
	
	static void toggle(int x) {
		
		if(arr.contains(x)) arr.remove(x);
		else arr.add(x);
		
	}
	
	static void all() {
		

		arr.clear();
		
		for(int i =1; i<21; i++) {
			
			arr.add(i);
		}
		
	}
	
	static void empty() {
		
		arr.clear();
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.valueOf(br.readLine());
		
		for(int i = 0 ; i<N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			switch (st.nextToken()) {
			
			case "add" :
				add(Integer.valueOf(st.nextToken()));
				break;
			case "remove" :
				remove(Integer.valueOf(st.nextToken()));
				
				break;
			case "check" :
				check(Integer.valueOf(st.nextToken()));

				break;
			case "toggle" :
				toggle(Integer.valueOf(st.nextToken()));

				break;
			case "all" :
				all();
				break;
			case "empty" :
				empty();
				break;
				
			
			
			
			
			}
			
			
			
		}
		
		
	}

}
