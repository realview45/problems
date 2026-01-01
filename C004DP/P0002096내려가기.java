package C004DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P0002096내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][]arr = new int[n+1][3];
        for(int i=0;i<n;i++){
            String[] strA = br.readLine().split(" ");
            arr[i+1][0] = Integer.parseInt(strA[0]);
            arr[i+1][1] = Integer.parseInt(strA[1]);
            arr[i+1][2] = Integer.parseInt(strA[2]);
        }
        int [][]dp_M = new int[n+1][3];
        int [][]dp_m = new int[n+1][3];
        for(int i=1;i<=n;i++){
            dp_M[i][0] = Math.max(dp_M[i-1][0], dp_M[i-1][1]) + arr[i][0];
            dp_M[i][1] = Math.max(dp_M[i-1][0], Math.max(dp_M[i-1][2],dp_M[i-1][1])) + arr[i][1];
            dp_M[i][2] = Math.max(dp_M[i-1][1], dp_M[i-1][2]) +arr[i][2];
        }
        for(int i=1;i<=n;i++){
            dp_m[i][0] = Math.min(dp_m[i-1][0], dp_m[i-1][1]) + arr[i][0];
            dp_m[i][1] = Math.min(dp_m[i-1][0], Math.min(dp_m[i-1][2],dp_m[i-1][1])) + arr[i][1];
            dp_m[i][2] = Math.min(dp_m[i-1][1], dp_m[i-1][2]) +arr[i][2];
        }
        int max = Math.max(dp_M[n][0],Math.max(dp_M[n][2],dp_M[n][1]));
        int min = Math.min(dp_m[n][0],Math.min(dp_m[n][2],dp_m[n][1]));
        System.out.print(max+" ");
        System.out.println(min);
    }
}
