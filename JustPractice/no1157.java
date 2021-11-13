package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class no1157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Map<String, Integer> counter = new HashMap<>();
		
		for(int i = 0 ; i< input.length(); i++) {
			
			String ch = input.charAt(i)+"";
			ch = ch.toUpperCase();
			
			if(counter.containsKey(ch)) {
				counter.replace(ch, counter.get(ch)+1);
			}
			else {
				counter.put(ch, 1);
			}
			
		}

		List<Map.Entry<String, Integer>> list = new LinkedList<>(counter.entrySet());
		
		Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());
		
		if(list.size()==1) {
			System.out.println(list.get(0).getKey());
		}
//		else if(list.get(0).getValue() == list.get(1).getValue()) {
		else if(list.get(0).getValue().equals(list.get(1).getValue())) {
			System.out.println("?");
		}
		else {
			System.out.println(list.get(0).getKey());
		}
		
	}

}
