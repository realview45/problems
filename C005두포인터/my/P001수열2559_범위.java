package C005두포인터.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P001수열2559_범위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int S = Integer.parseInt(strA[1]);
        int[] arr = new int [N];
        var strA2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(strA2[i]);
        }
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int minLength = Integer.MAX_VALUE;
        while(end < arr.length){
            if(sum < S){
                end++;
                if(end == arr.length){ break; }
                sum+=arr[end];
            }
            else if(sum >= S){
                sum-=arr[start];
                minLength = Math.min(minLength, end-start+1);
                start++;
            }
        }
        if(minLength==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLength);
    }
}
