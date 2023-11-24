import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        List<Integer> listA = new ArrayList<>();     // 초기 용량은 10
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int num = arr[0];
        StringBuilder sb = new StringBuilder();
        sb.append(num+" ");
        for(int i =1;i<N;i++){
            if(arr[i]==num) continue;
            else{
                num = arr[i];
                sb.append(num+" ");
            }
        }
        System.out.println(sb);
    }
}
