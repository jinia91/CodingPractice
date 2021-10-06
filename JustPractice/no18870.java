package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class no18870 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TreeSet set = new TreeSet();
		
		for(int i = 0; i<N; i++) {
			
			int x = Integer.parseInt(st.nextToken());
			
			arr[i] = x;
			
			set.add(x);
		
		}
		
		int[] setArr = new int[set.size()];
		
		Iterator it = set.iterator();
		
		int idx = 0; 
		while(it.hasNext()) {
			
			setArr[idx++] = (int) it.next();
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i< N; i++) {
			
			sb.append(Arrays.binarySearch(setArr, arr[i])+" ") ;
			
			
		}
		
		System.out.println(sb);
		
	}

}
