package C002BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 숨바꼭질2_12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);//시작위치
        int m = Integer.parseInt(strA[1]);//끝위치
        int[] dist = new int[200001];
        int[] cnt = new int[200001];
        Queue<int[]> q = new LinkedList<>();//현재위치, 걸린시간
        Arrays.fill(dist,-1);
        dist[n] = 0;
        cnt[n] = 1;
        q.add(new int[]{n,0});
        while (!q.isEmpty()) {
            int[] h = q.poll();
            int here = h[0];
            int[] next = {here + 1, here - 1, here * 2};
            for (int i : next) {
                if (i >= 0 && i <= 200000){
                   if(dist[i]==-1) {
                       dist[i]=h[1]+1;
                       cnt[i]+=cnt[here];
                       q.add(new int[]{i, h[1] + 1});
                   }
                   else if(here +1 != here*2 && dist[i]==h[1]+1){
                       cnt[i]+=cnt[here];
                   }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[m]+"\n");
        sb.append(cnt[m]);
        System.out.println(sb);
    }
}
