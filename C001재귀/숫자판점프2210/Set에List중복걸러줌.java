package C001재귀.숫자판점프2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Set에List중복걸러줌 {
    static int[][] arr;
    static boolean[][] visited;
    static int n=5;
    static Set<List<Integer>> answer2 = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr= new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            var strA = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(strA[j]);
            }
        }
        dfsAll();
        System.out.println(answer2.size());
        br.close();
    }
    static void dfsAll(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dfs(i,j, new ArrayList<>());
            }
        }
    }
    static int[] dr = {0,0,1,-1}; static int[] dc = {1,-1,0,0};
    static void dfs(int r, int c, List<Integer> temp2){//매개변수로 리스트를 쓰려면
        temp2.add(arr[r][c]);
        if(temp2.size()==6){
            answer2.add(new ArrayList<>(temp2));//return시
            temp2.remove(temp2.size() - 1);
            return;
        }
        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0&&nc>=0&&nr<n&&nc<n){
                dfs(nr,nc,temp2);
            }
        }
        temp2.remove(temp2.size() - 1);//여기로 못오므로 remove를 둘다 해줘야함!
    }
}