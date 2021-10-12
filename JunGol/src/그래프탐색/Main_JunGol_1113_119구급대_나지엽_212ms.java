package 그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JunGol_1113_119구급대_나지엽_212ms {
	static int M;
	static int N;
	static int endx;
	static int endy;
	static int min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		st = new StringTokenizer(br.readLine()," ");
		endx = Integer.parseInt(st.nextToken());
		endy = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}
	
	static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.cnt - o2.cnt;
			}
		});
		q.add(new Node(0,0,0,-1));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int cnt = node.cnt;
			int dir = node.dir;
			
			if(x == endx && y == endy) {
				min = Math.min(cnt,min);
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<M&&ny<N) {
					if(!visited[nx][ny] && map[nx][ny]==1) {
						visited[nx][ny] = true;
						if(dir==-1 || dir == i) {
							q.add(new Node(nx,ny,cnt,i));
						}
						else {
							q.add(new Node(nx,ny,cnt+1,i));
						}
					}
				}
			}
		}
		
	}
	static class Node{
		int x, y, cnt, dir;

		public Node(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
