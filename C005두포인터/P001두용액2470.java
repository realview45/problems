package C005두포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P001두용액2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        var strA = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(strA[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int start =0;
        int end =arr.length-1;
        int min = Integer.MAX_VALUE;
        boolean isZero = false;
        int minIdx1 =0; int minIdx2 =0;
        while(start<end){
            if(Math.abs(arr[end]+arr[start])<min){
                min = Math.abs(arr[end]+arr[start]);
                minIdx1 =start;
                minIdx2 =end;
            }
            if(arr[end]+arr[start] > 0){
                end--;
            }
            else if(arr[end]+arr[start] < 0){
                start++;
            }
            else{
                sb.append(arr[start]+" ");
                sb.append(arr[end]);
                isZero = true;
                break;
            }
        }
        if(!isZero){
            sb.append(arr[minIdx1]+" ");
            sb.append(arr[minIdx2]);
        }
        System.out.println(sb);
    }
}
