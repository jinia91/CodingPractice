import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.io.*;


public class no1181 {

	public static void main (String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i=0; i< N; i++) {
			
			arr[i] = br.readLine();
			
		}
		
		
		Arrays.sort(arr, 
				new Comparator<String>() {
			
			public int compare(String X, String Y) {
				
			
				if(X.length()==Y.length())
					return X.compareTo(Y);
			
				else
					return X.length()-Y.length();
			}
			
		  }
		);
		
//		for(int i = 0; i<N; i++) {
			
//			for(int j =i; j<N;j++) {
//				if(arr[i].length()>arr[j].length()) {
//					
//					swap(arr, i, j);
//				}
//				if(arr[i].length()==arr[j].length()) {
//					
//					if(arr[i].compareTo(arr[j])>0) {
//						swap(arr, i, j);
//					}
//				}
//
//			} 선택정렬은 시간복잡도때문에 실패함. 내장소트 + comparator 숙련도를 올리자.
//		}
		
		StringBuilder st = new StringBuilder();
		
		for(int i = 0; i< N-1; i++) {
			
			if(!arr[i].equals(arr[i+1]))
			st.append(arr[i]+"\n");
			
		}
		
		st.append(arr[N-1]);
		
		System.out.print(st);
	}
		
	
	private static void swap(String[] a, int i, int j) {
		
		String temp = a[i];
		
		a[i] = a[j];
		
		a[j] = temp;
		
		
	}
	
}
