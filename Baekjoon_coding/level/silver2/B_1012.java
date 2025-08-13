package Baekjoon_coding.level.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012 {
	static int cnt;
	static int[] xCoor = { 0, 1, 0, -1 }; // 북, 동, 남, 서 순서대로 가는 x좌표
	static int[] yCoor = { -1, 0, 1, 0 }; // 북, 동, 남, 서 순서대로 가는 y좌표
	static int M; // 배추밭의 가로 길이
	static int N; // 배추밭의 세로 길이
	static boolean[][] cabbageField;
	static boolean[][] visit;

	static void visitNearCabbage(int x, int y) { //dfs를 통해 인접한 모든 배추가 존재하는 곳을 탐색 (방문하지 않은 곳 중에서 -> visit[x][y] = false)
		visit[x][y] = true;	//현재 위치는 이미 방문한 곳이니, 방문처리
		
		for(int i=0; i<4; i++) {	//문제에서 동, 서, 남, 북 4방향에 배추가 있으면 벌레 1개만 필요하다했으니, for문으로 현재 위치의 4방향 탐색
			int nowX = x+xCoor[i];
			int nowY = y+yCoor[i];
			
			if( nowX>=0&&nowX<M&&nowY>=0&&nowY<N ) { //밭의 범위를 넘어가지 않고
				if(!visit[nowX][nowY]&&cabbageField[nowX][nowY]) {	//방문(배추 존재 유무 확인)한 적이 없으며, 배추가 존재할때 
					visitNearCabbage(nowX, nowY);	//위의 조건이 만족한다면 인접한, 배추가 존재하는 곳이니 방문
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine()); // test case

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 개수
			cnt = 0; // 필요한 배추흰지렁이의 마리수

			cabbageField = new boolean[M][N];
			visit = new boolean[M][N];
			
			for (int j = 0; j < K; j++) { // 배추 위치 받기
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()); // 배추가 심어진 x 좌표
				int y = Integer.parseInt(st.nextToken()); // 배추가 심어진 y 좌표
				cabbageField[x][y] = true;
			}

			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (!visit[x][y] && cabbageField[x][y]) {	//탐색한 적이 없고, 배추가 존재한다면 -> dfs 탐색 시도
						visitNearCabbage(x, y);	//한번의 탐색으로 인접한 4방향의 모든 배추 탐색
						cnt++;	//인접한 배추가 없으니, 1개의 벌레가 필요해 +1
					} 
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		//1. DFS + Buffer - 172ms
	}
}
// [유기농 배추] - 주어진 조건에 맞게 4방향으로 연결되어 있는 칸의 개수(연결되어있으면 횟수로 안침)를 구하는 문제
/* 이 문제는 인접한 배추들은 1개의 벌레가 필요하다 할때, 총 벌레가 몇개 필요한지 구하는 문제이다.
   처음에는 재귀 함수만을 통해 탐색해 만약 4방향중 존재한다면, 다음 칸 탐색의 방식으로 진행했으나, 이 방식의 경우
   만약 현 위치 기준으로 한 방향으로 이동하면 나머지 세 방향 중 배추가 존재할 때 파악하지 못한다는 부분에서 해결하지 못했다.
   
   이를 방지하기 위해 DFS 알고리즘을 통해 현 위치 기준으로 인접한 4방향을 모두 파악하며, 존재한다면
   방문 처리를 하고, 방문되지 않은 곳에 한해서만 4방향 모두를 탐색하는 알고리즘을 통해 문제를 해결했다.
   
   처음 배추를 만나는 곳에 인접해 있는 배추가 존재한다면, 어처피 for문을 통해 새로운 방문 배열 visit로 
   방문 여부를 체크함과 동시에, 배추의 유무도 확인 하며 배추가 존재할때 모든 방향을 한번에 탐색할 수 있으니
   기존의 문제 풀이 방식에서 나온 한 곳에 인접한 배추가 존재하면 나머지 부분을 확인하지 못한다는 문제에서 걸리지 않았다.
   그 결과 시간적으로도, 효율적으로 문제를 해결할 수 있었다.
   -> DFS 알고리즘을 사용할 경우 인접한 4방향을 탐색할 수 있으니, 한번에 모든 부분이 탐색됨
      여기서 포인트는 방문여부를 확인해야, 배추가 있을 때 이미 탐색한 곳을 재탐색 하지 않으니,
      배추의 유무를 확인할 cabbageField 배열과	-> boolean으로 설정했으나, int형식 배열이 더 탐색이 빠른듯(다른 사람 풀이에서 더 빠름)
      탐색한 적이 있는지 판단한 visit 배열을 설정해 동시에 확인하는 것이 중요하다.
	 
*/
