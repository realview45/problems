package C002BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);//시작위치
        int m = Integer.parseInt(strA[1]);//끝위치
        boolean[] visited = new boolean[200001];
        Queue<int[]> q = new LinkedList<>();//현재위치, 걸린시간
        q.add(new int[]{n, 0});
        visited[n] = true;
        int here = n;
        int answer = 0;
        loop:
        while (here != m) {
            int[] h = q.poll();
            here = h[0];
            int[] next = {here + 1, here - 1, here * 2};
            for (int i : next) {
                if(i==m){
                    answer=h[1]+1;
                    break loop;
                }
                if (i >= 0 && i <= 200000 && !visited[i]){
                    visited[i]= true;
                    q.add(new int[]{i, h[1] + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
