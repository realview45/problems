package C002BFS.역추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질4_13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int K = Integer.parseInt(strA[1]);
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[200001];
        int[] prev = new int[200001];
        Arrays.fill(prev, -1);
        q.add(new int[]{N,0});
        visited[N]=true;
        StringBuilder sb = new StringBuilder();
        if(N==K){
            sb.append(0+"\n");
            sb.append(N);
            System.out.println(sb);
            return;
        }
        while(!q.isEmpty()){
            int[] here = q.poll();
            int h = here[0];
            int d = here[1];
            int[] next = {h+1,h-1,h*2};
            for(int i:next){
                if(i>=0&&i<200001&&!visited[i]){
                    visited[i]=true;
                    prev[i]=h;
                    if(i==K){
                        sb.append(d+1+"\n");
                        List<Integer> list = new ArrayList<>();
                        while(prev[i]!=-1){
                            list.add(i);
                            i=prev[i];
                        }
                        list.add(i);
                        for(int j=list.size()-1;j>=0;j--){
                            sb.append(list.get(j)+" ");
                        }
                        System.out.println(sb);
                        return;
                    }
                    q.add(new int[]{i,d+1});
                }
            }
        }

    }
}
