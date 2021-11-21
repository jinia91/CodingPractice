package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.ToIntFunction;

public class no1302 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        while(N-->0) {
            inputBook(br.readLine());
        }

        ArrayList<Entry<String, Integer>> arrayList = new ArrayList<>(map.entrySet());
        
        arrayList.sort(Comparator
                        .comparingInt(
                                (ToIntFunction<Entry<String, Integer>>)
                                        Entry::getValue)
                        .reversed()
                        .thenComparing(Entry::getKey));

        System.out.println(arrayList.get(0).getKey());

    }

    private static void inputBook(String input) {

        if(map.containsKey(input)) {
            map.put(input, map.get(input)+1);
        }

        else {
            map.put(input, 1);
        }

    }
}
