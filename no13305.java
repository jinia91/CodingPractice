import java.io.*;
import java.util.*;


public class no13305 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		ArrayList<Integer> dist = new ArrayList<>();
		
		for(int i =0; i< N-1; i ++) {
			dist.add(Integer.valueOf(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> price = new ArrayList<>();
		
		for(int i =0; i< N; i ++) {
			price.add(Integer.valueOf(st.nextToken()));
		}
		
		
		
		long sum = 0;
		long minprice = price.get(0);

		for(int i=0; i<price.size()-1;i++) {
			if(price.get(i)<minprice) minprice = price.get(i);
			
			sum += (minprice*dist.get(i));
		}
		
		System.out.println(sum);
		
	}

}
