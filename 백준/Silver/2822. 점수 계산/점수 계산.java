import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];
        for(int i =0;i < 8;i++){
            arr[i][0] = i+1;
            arr[i][1] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr,(o1,o2)-> Integer.compare(o2[1],o1[1]));
        int sum = 0;
        int[] rank = new int[5];
        for(int i = 0 ; i < 5; i++){
            sum += arr[i][1];
            rank[i] = arr[i][0];
        }
        Arrays.sort(rank);
        StringBuilder sb = new StringBuilder();
        for(int  i =0;i<5;i++){
            sb.append(rank[i]+" ");
        }
        System.out.println(sum);
        System.out.println(sb);
    }
}
