package C004DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P002동전02_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);
        int k = Integer.parseInt(strA[1]);
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        for(int i=0;i<n;i++){
            dp[arr[i]]=1;
        }
        for(int i=0;i<=k;i++){
            if(dp[i]==0)dp[i]=987654321;
            for(int j=0;j<n;j++){
                if(i-arr[j]>=0 && dp[i-arr[j]]!=0 && dp[i-arr[j]] + 1 < dp[i]){
                    dp[i]=dp[i-arr[j]]+1;
                }
            }
        }
        if(dp[k]==987654321) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
