//package C004DP;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class P006호텔 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] strA = br.readLine().split(" ");
//        int C = Integer.parseInt(strA[0]);
//        int N = Integer.parseInt(strA[1]);
//        int[][] arr = new int[N][2];
//        int[] dp = new int[1000001];//비용에대한 고객수
//        for(int i=0;i<N;i++){
//            String[] strA2 = br.readLine().split(" ");
//            arr[i][0] = Integer.parseInt(strA2[0]);//비용
//            arr[i][1] = Integer.parseInt(strA2[1]);//고객의 수
//        }
//        for(int i=0;i<N;i++){
//            for(int j=1;j<1000001;j++){
//                if(j-arr[i][0]>=0) dp[j]=Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);
//            }
//        }
//        for(int i=1;i<1000001;i++){
//            if(dp[i]>=C){
//                System.out.println(i);
//                break;
//            }
//        }
//
//        //System.out.println(dp[C]);
//    }
//}
package C004DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P006호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strA = br.readLine().split(" ");
        int C = Integer.parseInt(strA[0]);
        int N = Integer.parseInt(strA[1]);
        int[][] arr = new int[N][2];
        int[] dp = new int[C+1];
        for(int i=0;i<N;i++){
            String[] strA2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strA2[0]);//비용
            arr[i][1] = Integer.parseInt(strA2[1]);//고객의 수
        }
        Arrays.fill(dp,987654321);
        dp[0]=0;//고객의 수에 대한 최소비용
        for(int i=0;i<N;i++){
            for(int j=0;j<C+1;j++){
                if(j-arr[i][1]<0) dp[j]= arr[i][0];
                else dp[j]=Math.min(dp[j],dp[j-arr[i][1]]+arr[i][0]);
            }
        }
        System.out.println(dp[C]);
    }
}