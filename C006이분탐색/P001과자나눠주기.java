package C006이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P001과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int M = Integer.parseInt(strA[0]);//조카의 수
        int N = Integer.parseInt(strA[1]);//과자의 수
        int []arr = new int[N];
        var strA2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(strA2[i]);
        }
        Arrays.sort(arr);
        int start =1;
        int end =arr[arr.length-1];
        int answer =0;
        while(start<=end){
            int mid = (start+end)/2;
            int cnt = 0;
            for(int i=0;i<N;i++){
                cnt+=arr[i]/mid;
            }
            if(cnt>=M){
                start = mid+1;
                answer =mid;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
