	package JustPractice;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class no2243{
	
		static int N;
		static long[] tree;
	
	
		static long sum(long r, long l) {
			return r+l;
		}
	
		static long sumQ(int arrS, int arrE, int node, int qS, int qE) {
	
			if (arrE < qS || arrS > qE) {
				return 0;
			}
	
			if (arrS <= qS && qE <= arrE) {
				return tree[node];
			}
	
			int middle = (qS + qE) / 2;
			long left = sumQ(arrS, arrE, node * 2, qS, middle);
			long right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, qE);
	
			return sum(left, right);
		}
	
		static long updateQ(int target, long newValue, int node, int qS, int qE) {
	
			if (target < qS || target > qE) {
				return tree[node];
			}
	
			if (qS == qE)
				return tree[node] += newValue;
	
			int middle = (qS + qE) / 2;
			long left = updateQ(target, newValue, node * 2, qS, middle);
			long right = updateQ(target, newValue, node * 2 + 1, middle + 1, qE);
			return tree[node] = sum(left, right);
		}
		
		static int biSearch(int s, int e, long target) {
			
			while(s <= e) {
				int m = (s+e)/2;
				long sum = sumQ(0, m,1,0,1000000);
				
				if (sum < target) s = m+1;
				else e = m-1;
			}
			
			return s;
			
		}
	
		public static void main(String[] args) throws IOException {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
			N = Integer.parseInt(st.nextToken());
			
			tree = new long[4*1000000];
					
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i< N; i++) {
	
				st = new StringTokenizer(br.readLine()," ");
				
				int q = Integer.parseInt(st.nextToken());
				
				
				if(q == 1) {
				
					long a = Long.parseLong(st.nextToken());
					
					int target = biSearch(0,1000000,a);
					sb.append(target+1+"\n");
					updateQ(target, -1, 1, 0, 1000000);

				}
				
				
				else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
						
					updateQ(a-1, b, 1, 0, 1000000);	
				}
			}
	
			System.out.println(sb);
			
		}
	
	}
