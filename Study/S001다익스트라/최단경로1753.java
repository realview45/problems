package Study.S001다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        List<List<int[]>> list = new ArrayList<>();
        //최소거리 기준으로 pq에서 팝
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);//다음 정점, 최소거리
        int V = Integer.parseInt(strA[0]);//정점의 개수
        int E = Integer.parseInt(strA[1]);//간선의 개수
        int K = Integer.parseInt(br.readLine());//시작점
        int[] dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {//방향그래프 생성
            var strA2 = br.readLine().split(" ");
            int u = Integer.parseInt(strA2[0]);
            int v = Integer.parseInt(strA2[1]);
            int e = Integer.parseInt(strA2[2]);
            list.get(u).add(new int[]{v, e});
        }
        Arrays.fill(dist, 200001);
        dist[K] = 0;
        pq.add(new int[]{K, 0});
        boolean[] visited = new boolean[V + 1];
        while (!pq.isEmpty()) {
            int[] here = pq.poll();
            int h = here[0];
            int d = here[1];
            if(dist[h] < d) continue;//더 짧은 경로를 이미 알고있다면 넘어간다.
            for (int[] next : list.get(h)) {
                if(dist[next[0]] > d+next[1]){
                    dist[next[0]] = d + next[1];
                    pq.add(new int[]{next[0], d + next[1]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == 200001) sb.append("INF" + "\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }
}
