package C004DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P005벼락치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int T = Integer.parseInt(strA[1]);
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            String[] strA2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strA2[0]);
            arr[i][1] = Integer.parseInt(strA2[1]);
        }
        int[] dp = new int[T+1];//공부시간별 최대점수
        for(int i=0;i<N;i++){
            for(int j=T;j>=arr[i][0];j--){
                dp[j]=Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);
            }
        }
        System.out.println(dp[T]);
    }
}
