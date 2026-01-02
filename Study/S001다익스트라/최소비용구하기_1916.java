package Study.S001다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최소비용구하기_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//도시의개수
        int M = Integer.parseInt(br.readLine());//버스의개수
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            var strA = br.readLine().split(" ");
            int start = Integer.parseInt(strA[0]);
            int end = Integer.parseInt(strA[1]);
            int cost = Integer.parseInt(strA[2]);
            list.get(start).add(new int[]{end, cost});
        }
        var strA2 = br.readLine().split(" ");
        int final_start = Integer.parseInt(strA2[0]);
        int final_end = Integer.parseInt(strA2[1]);

        int[] dist = new int [N+1];
        Arrays.fill(dist, 987654321);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[]{final_start,0});
        dist[final_start]=0;
        while(!pq.isEmpty()){
            int[] here = pq.poll();
            int h = here[0];//위치
            int d = here[1];//비용
            if(dist[h]<d)continue;
            for(int[] next : list.get(h)){
                if(dist[h]+next[1] < dist[next[0]]){
                    dist[next[0]] = dist[h] + next[1];
                    pq.add(new int[]{next[0], dist[h]+next[1]});
                }
            }
        }
        System.out.println(dist[final_end]);
    }
}
