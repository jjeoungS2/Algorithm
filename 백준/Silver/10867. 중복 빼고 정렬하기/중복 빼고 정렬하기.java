import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> arr = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;i++){
            arr.put(Integer.parseInt(st.nextToken()),0);
        }

        StringBuilder sb = new StringBuilder();
        for(Integer key: arr.keySet()){
            System.out.print(key+" ");
        }
    }
}
