package C004DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P003가장긴증수4_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        String[] strA = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(strA[i]);
        }
        int[] dp =new int[N];//값
        int[] prev =new int[N];//이전 인덱스저장
        dp[0]=1;
        Arrays.fill(prev,-1);
        for(int i=1;i<N;i++){
             int max=1;
             for(int j=0;j<i;j++){
                 if(arr[i]>arr[j]){
                     if(dp[j]+1 > max){
                         prev[i] = j;
                         max = dp[j]+1;
                     }
                 }
             }
             dp[i]=max;
        }
        int max_len=0;//가장 긴길이
        int idx=0;//긴길이의 인덱스값
        for(int i=0;i<N;i++){
            if(dp[i]>max_len){
                idx=i;
                max_len=dp[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        while(prev[idx]!=-1){
            list.add(arr[idx]);
            idx = prev[idx];
        }
        list.add(arr[idx]);
        StringBuilder sb = new StringBuilder();
        sb.append(max_len+"\n");
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i)+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
//역추적 문제들 더 풀어보기
//스프링 들어가긴 전까지 알고리즘
//후에 알고리즘 스터디 끝 혼자 풀어보기 토요일 두문제, 일요일 두문제
//
//package C004DP;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//public class P003가장긴증수4_14002 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr =new int[N];
//        String[] strA = br.readLine().split(" ");
//        for(int i=0;i<N;i++){
//            arr[i]=Integer.parseInt(strA[i]);
//        }
//        int[] dp =new int[N];//값
//        int[] prev =new int[N];//이전 인덱스저장
//        dp[0]=1;
//        Arrays.fill(prev,-1);
//        for(int i=1;i<N;i++){
//            int max=1;
//            for(int j=0;j<i;j++){
//                if(arr[i]>arr[j]){
//                    if(dp[j]+1 > max){
//                        prev[i] = j;
//                        max = dp[j]+1;
//                    }
//                }
//            }
//            dp[i]=max;
//        }
//        int max_len=0;//가장 긴길이
//        int idx=0;//긴길이의 인덱스값
//        for(int i=0;i<N;i++){
//            if(dp[i]>max_len){
//                idx=i;
//                max_len=dp[i];
//            }
//        }
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<max_len;i++){
//            list.add(arr[idx]);
//            idx = prev[idx];
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(max_len+"\n");
//        for(int i=list.size()-1;i>=0;i--){
//            sb.append(list.get(i)+" ");
//        }
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb);
//    }
//}
