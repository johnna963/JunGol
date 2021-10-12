import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JunGol_2577_회전초밥_나지엽 {
	/**투포인터
	 * 부분배열길이의 변화 여부*/
	static int N;
	static int d;
	static int k;
	static int c;
	static int[] arr;
	static int[] eat;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());//접시수
		d = Integer.parseInt(st.nextToken());//가지 수
		k = Integer.parseInt(st.nextToken());//연속해서 먹는 접시수
		c = Integer.parseInt(st.nextToken());//쿠폰 번호
		arr = new int[N];
		eat = new int[d+1];
		for (int i = 0; i < N; i++) {
			int menu = Integer.parseInt(br.readLine());
			arr[i] = menu;
		}
		int max = TwoPointer();
		System.out.println(max);
	}
	static int TwoPointer() {
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if(eat[arr[i]] == 0) {
				cnt++;
			}
			eat[arr[i]]++;
		}
		max = cnt;
		//System.out.println(max);
		for (int i = 1; i < N; i++) {
			if(max<=cnt) {
				if(eat[c] == 0) {
					max = cnt+1;
				}
				else max = cnt;
			}
			eat[arr[i-1]]--;
			if(eat[arr[i-1]]==0) {
				cnt--;
			}
			if(eat[arr[(i+k-1) % N]]==0) {
				cnt++;;
			}
			eat[arr[(i+k-1) % N]]++;
		}
		return max;
	}
}
