package C004DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P004평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int K = Integer.parseInt(strA[1]);
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            String[] strA2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strA2[0]);
            arr[i][1] = Integer.parseInt(strA2[1]);
        }
        int[] dp = new int[K+1];
        for(int i=0;i<N;i++){
            for(int j=K;j>=arr[i][0];j--){
                dp[j]=Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
            }
        }
        System.out.println(Arrays.toString(dp));
//        System.out.println(dp[K]);

    }
}
