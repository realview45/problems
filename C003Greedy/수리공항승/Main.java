package C003Greedy.수리공항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);
        int l= Integer.parseInt(strA[1]);
        int[] arr =new int[n];
        var strA2 = br.readLine().split(" ");
        int end=-1;
        int cnt=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strA2[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(end<arr[i]){
                end=arr[i]+l-1;
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
