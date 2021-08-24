package 그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class JG1457 {
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dy= {-1,1,0,0};
    static int[] dx= {0,0,-1,1};
    static int cnt; // 넓이세기
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;//영역은 1
                }
            }
        }
         
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==0) {
                    cnt=0;
                    DFS(i,j);
                    arr.add(cnt);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int a : arr) {
            System.out.print(a+" ");
        }
         
    }
    static void DFS(int y, int x) {
        map[y][x]=2;//방문은 2
        cnt++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
             
            if(ny>=0 && nx>=0 && ny<M && nx<N) {
                if(map[ny][nx]==0) {
                    DFS(ny, nx);
                }
            }
        }
    }
}