import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int gap = Integer.MIN_VALUE;
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                max = Math.max(num,max);
                min = Math.min(num,min);
                sum += num;
             }
            Arrays.sort(arr);

            for(int j =1;j<n;j++){
                gap = Math.max(gap,arr[j]-arr[j-1]);
            }
            sb.append("Class "+(i+1)+"\n"+"Max "+max+", Min "+min+", Largest gap "+gap+"\n");
        }
        System.out.print(sb);
    }
}
