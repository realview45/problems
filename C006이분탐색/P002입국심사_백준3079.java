package C006이분탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class P002입국심사_백준3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int M = Integer.parseInt(strA[1]);
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long start =1;
        long end = (long)M*arr[arr.length-1];
        long answer = -1;
        while(start<=end){
            long mid = (start+end)/2;
            long sum=0;
            for(int i=0;i<N;i++){
                sum +=mid/arr[i];
                if(sum>=M)break;
            }
            if(sum>=M){
                end = mid-1;
                answer = mid;
            }
            else if(sum<M){
                start = mid+1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
