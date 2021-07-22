import java.util.*;
import java.io.*;

public class no15{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.valueOf(br.readLine());
        boolean[] check = new boolean[2000001];
        
        
        for(int i = 1; i<=N; i++){
            int x = 1000000 + Integer.valueOf(br.readLine());
            check[x] = true;
        }      
        
        for(int i = 0;i<check.length;i++) {
        if(check[i])
        	sb.append(i-1000000).append('\n');
        }     
        System.out.println(sb);
    }   
    
}