package Study.S001다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로1753class {
    static List<Edge>[] graph;
    static int[] dist;
    static int V, E;
    static int INF = 987654321;
    static void dijk(int start){
        //시작점으로부터 가장 가까운 거리를 기준으로 pq를 생성해줍니다.
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        Arrays.fill(dist, INF);//시작점으로부터의 정점에 대한 거리배열을 최대값으로 초기화해줍니다.
        dist[start] = 0;//시작점에서 시작점까지의 거리는 0입니다.
        pq.add(new Edge(start,0));//시작점과 시작점까지의 거리를 pq에 넣어줍니다.

        while(!pq.isEmpty()){//pq에 정점이 없어질 때까지
            Edge  cur = pq.poll();//가장 가까운 정점을 방문합니다.
            //시작점으로부터 현재 정점까지의 이미 더 가까운 경로가 존재한다면 방문하지 않습니다.
            if(cur.cost > dist[cur.to])continue;
            for(Edge next : graph[cur.to]){//인접한 정점을 탐색합니다.
                int newCost = cur.cost + next.cost;//시작점으로부터 next까지의 거리를 계산
                if(newCost < dist[next.to]){//그 거리가 더 가까운 경로라면
                    dist[next.to] = newCost;//update해준후
                    pq.add(new Edge(next.to, newCost));//pq에 넣어줍니다. 정점이 중복될 수 있습니다.
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());//정점의 개수
        E = Integer.parseInt(st.nextToken());//간선의 개수
        int K = Integer.parseInt(br.readLine());//시작정점

        dist = new int[V+1];//정점의 개수만큼 시작정점으로부터의 최단거리 배열 초기화
        graph = new ArrayList[V+1];//정점의 개수만큼
        for(int i=1;i<=V;i++) graph[i] = new ArrayList<>();//리스트 생성

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,e));//그래프에 간선들을 넣어줍니다.
        }

        dijk(K);

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=V;i++) sb.append((dist[i]==INF?"INF":dist[i])+"\n");
        System.out.println(sb);
    }
    static class Edge{
        int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
