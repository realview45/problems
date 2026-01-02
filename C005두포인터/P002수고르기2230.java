package C005두포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P002수고르기2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int M = Integer.parseInt(strA[1]);//두수를 골랐을 때 차이가 M이상이면서 작은 경우
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start =0;
        int end =0;
        int gap =0;
        int ans = Integer.MAX_VALUE;
        while(true){
            if(gap ==M){
                ans = gap;
                break;
            }else if(gap <M){
                end++;
                if(end==arr.length)break;
            }else if(gap> M){
                ans = Math.min(gap, ans);
                start++;
            }
            gap = arr[end]-arr[start];
        }
        System.out.println(ans);
    }
}
