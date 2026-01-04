package Study.S001다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 녹색옷젤다44852차원 {
    static int[][] arr;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int[][] dist;
    static int N;
    static int INF = 987654321;
    static void dijk(int r, int c){
        //시작점으로부터 가장 가까운 거리를 기준으로 pq를 생성해줍니다.
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[r][c] = arr[r][c];//시작점에서 시작점까지의 거리는 0입니다.
        pq.add(new Edge(r,c,arr[r][c]));//시작점과 시작점까지의 거리를 pq에 넣어줍니다.

        while(!pq.isEmpty()){//pq에 정점이 없어질 때까지
            Edge cur = pq.poll();//가장 가까운 정점을 방문합니다.
            //시작점으로부터 현재 정점까지의 이미 더 가까운 경로가 존재한다면 방문하지 않습니다.
            if(cur.cost > dist[cur.r][cur.c])continue;
            for(int i=0;i<4;i++){//인접한 정점을 탐색합니다.
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if(nr>=0&&nc>=0&&nr<N&&nc<N){
                    int newCost = cur.cost + arr[nr][nc];
                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.add(new Edge(nr,nc,newCost));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();
        int t=1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {break;}
            dist = new int[N][N];
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], INF);
                st = new StringTokenizer(br.readLine());
                int j = 0;
                while (st.hasMoreTokens()) {
                    arr[i][j++] = Integer.parseInt(st.nextToken());
                }
            }
            dijk(0,0);
            sb.append("Problem ");
            sb.append(t++);
            sb.append(": ");
            sb.append(dist[N-1][N-1]+"\n");
        }
        System.out.println(sb);
    }
    static class Edge{
        int r,c, cost;
        public Edge(int r,int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
