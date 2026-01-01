//A2dfs
package C001재귀.숫자판점프2210;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        intArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strA = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                intArr[i][j] = Integer.parseInt(strA[j]);
            }
        }
        dfsAll(n);
        System.out.println(mySet.size());
    }
    static void dfsAll(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, "", n);
            }
        }
    }
    static Set<String> mySet = new HashSet<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] intArr;
    static void dfs(int x, int y, String str, int n) {
        str += String.valueOf(intArr[x][y]);
        if (str.length() == 6) {
            mySet.add(str);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                dfs(nx, ny, str, n);
            }
        }
    }
}
