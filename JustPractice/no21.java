import java.io.*;
import java.util.*;

public class no21 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();
		
		HashSet<String> chatmapEnter = new HashSet<>();
		HashSet<String> chatmapExit = new HashSet<>();
		String eof = "";

		while((eof = br.readLine())!= null) {
			
			String[] temp = eof.split(" ");
			String time = temp[0];
			String Id = temp[1];		
		
			if (time.compareTo(S)<=0)
				chatmapEnter.add(Id);
		
			if(time.compareTo(E)>=0&&time.compareTo(Q)<=0)
				chatmapExit.add(Id);
		}

		
		chatmapEnter.retainAll(chatmapExit);
		
		System.out.println(chatmapEnter.size());
	}

}
