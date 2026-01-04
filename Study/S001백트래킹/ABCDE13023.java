package Study.S001백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ABCDE13023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var strA = br.readLine().split(" ");
        int N = Integer.parseInt(strA[0]);
        int M = Integer.parseInt(strA[1]);
        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            var strA2 = br.readLine().split(" ");
            int a = Integer.parseInt(strA2[0]);
            int b = Integer.parseInt(strA2[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N+1];
        dfsAll(N);
        if(isPos) System.out.println(1);
        else System.out.println(0);
    }
    static void dfsAll(int N){
        for(int i=1;i<=N;i++){
            if (!isPos) dfs(i,1);
        }
    }
    static List<List<Integer>> list;
    static boolean[] visited;
    static boolean isPos = false;
    static void dfs(int v, int depth){
        if(depth==5) {
            isPos = true;
            return;
        }
        visited[v]=true;
        for(int next : list.get(v)){
            if(!visited[next]&&!isPos){
                dfs(next, depth+1);
            }
        }
        visited[v]=false;
    }
}
