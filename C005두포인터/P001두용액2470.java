package C005두포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P001두용액2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        var strA = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(strA[0]);
        }
    }
}
