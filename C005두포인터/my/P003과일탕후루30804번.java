package C005두포인터.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003과일탕후루30804번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] type = new int[10];
        int start=0;
        int end=0;
        type[arr[0]]++;
        int typeCnt=1;
        int cnt=1;
        int answer =0;
        while(end < arr.length){
            if(typeCnt<=2){
                answer = Math.max(cnt,answer);
                end++;
                if(end==arr.length) {break;}
                if(type[arr[end]]==0) typeCnt++;
                type[arr[end]]++;
                cnt++;
            }
            else if(typeCnt>2){
                type[arr[start]]--;
                if (type[arr[start]]==0) typeCnt--;
                start++;
                cnt--;
            }
        }
        System.out.println(answer);
    }
}
