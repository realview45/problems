package C002BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 숨바꼭질3_13549다익 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int n = Integer.parseInt(strA[0]);//시작위치
        int m = Integer.parseInt(strA[1]);//끝위치
        int[] dist = new int[200001];
        Arrays.fill(dist, 987654321);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);//현재위치, 걸린시간
        q.add(new int[]{n, 0});
        dist[n] = 0;
        while (!q.isEmpty()) {
            int[] here = q.poll();
            int h = here[0];
            int d = here[1];
            if (dist[h] < d) continue;
            int[][] next = {{h + 1, 1}, {h - 1, 1}, {h * 2, 0}};
            for (int[] i : next) {
                if (i[0] >= 0 && i[0] <= 200000 && dist[i[0]] > d + i[1]) {
                    dist[i[0]] = d + i[1];
                    q.add(new int[]{i[0], d + i[1]});
                }
            }
        }
        System.out.println(dist[m]);
    }

}
