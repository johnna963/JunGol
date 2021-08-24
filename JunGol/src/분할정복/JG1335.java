package 분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class JG1335 {
    static int N;
    static int[][] map;
    static int blue;
    static int white;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
         
        map= new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        DivideSearch(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    static void DivideSearch(int x, int y, int size) {
        if(check(x, y, size)) {
            if(map[x][y]==1) {
                blue++;
                return;
            }
            else
            {
                white++;
                return;
            }
        }
         
        int nsize = size/2;
        DivideSearch(x, y, nsize);
        DivideSearch(x, y+nsize, nsize);
        DivideSearch(x+nsize, y, nsize);
        DivideSearch(x+nsize, y+nsize, nsize);
         
    }
    static boolean check(int x, int y, int size) {
        int num = map[x][y];
         
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(num!=map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}