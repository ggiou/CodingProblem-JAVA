package level.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B_2667 {
	static int N;				//가로,세로 길이 = 정사각형 모향의 단지
	static char[][] map; 		//집 위치를 표시할 정사각형 모양의 지도
	static boolean[][] visit;	//dfs 탐색을 위한 방문여부 체크 이차원 배열 
	static int cnt;				//각 단지별 집의 개수
	static int[] xDfs = {0, 1, 0, -1};		//북동남서 방향의 x좌표
	static int[] yDfs = {-1, 0, 1, 0};		//북동남서 방향의 x좌표
	
	public static void dfs(int i, int j) {	//깊이 우선 탐색으로 4방향의 인접한 모든 집의 개수 파악
		visit[i][j] = true; //현재 위치 탐색했으니, 방문처리
		
		for(int k=0; k<4; k++) {
			int x = i+xDfs[k];
			int y = j+yDfs[k];
			
			if(x>=0&&y>=0&&x<N&&y<N) {	//동서남북으로 이동했을때 범위를 벗어나지 않는다면
				if(visit[x][y]==false&&map[x][y]=='1') { //탐색한적이 없고, 집이 존재한다면
					cnt++; //집이 있는 것이니 집의 개수 ++
					dfs(x, y); //존재하니 그 깊이로 이동후 인접한 부분 탐색 필요
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> answer = new ArrayList<Integer>();	//집의 개수를 오름차순으로 반환해야하니, list의 sort 사용을 위해 선언
		
		N = Integer.parseInt(br.readLine()); //입력받아야하는 줄 수
		
		map = new char[N][N]; //지도
		visit = new boolean[N][N]; //탐색을 위한 방문여부
		for(int i=0; i<N; i++) { //지도에 집위치 표시하는 과정
			char[] sh = (br.readLine()).toCharArray(); //한줄로 공백없이 입력되니, 분리 필요(StringTokenizer은 구분자가 있을때 사용하는 것이 편함)
			for(int j=0; j<sh.length; j++) {
				char house = sh[j];	//해당 위치의 집의 존재 여부 (0 = 없음, 1=있음)
				map[i][j] = house;
			}
		}
		
		for(int i=0; i<N; i++) { //각 단지별 집이 몇개 있는지 판별하는 과정
			for(int j=0; j<N; j++) {
				if(map[i][j]=='1'&&visit[i][j]==false) { //처음 탐색하며, 집이 있는 경우 = 1
					cnt = 1; //탐색을 시작하자마자 방문처리를 하니, 1개로 집 개수 세기 시작
					dfs(i, j); //dfs 탐색 시작
					answer.add(cnt); //dfs 탐색을 하며, 각 단지별 집의 개수가 반환되니 이를 answer list에 저장
				}
			}
		}
		
		Collections.sort(answer); //문제에서 집의 수를 오름차순으로 출력해달라했으니, list의 sort 함수를 통해 정렬
		sb.append(answer.size()).append("\n"); //첫번째 줄은 단지의 개수이니 = list 크기 ->속력 향상을 위해 stringBuilder에 저장
		
		for(int i=0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append("\n"); //오름차순으로 정렬된 집의 개수를 stringBuilder에 저장
		}
		
		System.out.println(sb.toString()); //정답 출력
		//1. dfs + Buffer + StringBuilder = 120ms
	}

}
//[단지번호 붙이기] - 정사각형의 칸안에 집이있는(1) 곳이 4방향으로 연결된 전체가 단지라치면, 단지의 총 개수와, 각 단지의 집의 개수를 반환하는 문제
/*	이 문제는 1012번 유기농 배추와 비슷한 문제로, n*n 정사각형의 칸안에 집의 여부 1, 0이 있고 여기서 각 집이 
	4방향으로 연결되어있는 전체를 한단지라고 칭한다, 여기서 총 정사각형 내부의 단지의 개수와, 한 단지당 몇개의 집이 있는지
	계산하여 오름차순으로 반환하는 것이 목표인 문제이다.
	
	이 문제가 1012번 유기농 배추와 유사하다는 것을 인식하자마자 dfs를 통해 깊이 우선탐색으로 먼저 만나는 집이 존재하는 부분의
	인근된 4 방향(북동서남)을 탐색하며, 집이 있을때마다 집의 개수 = cnt++을 해줘 위의 목적을 구해야겠다고 생각했다.
	dfs를 사용하면 한번에 인접한 모든 집을 탐색하게 되니, 각 단지의 인접한 집의 개수도 dfs를 한번 통과하고 나온 횟수를 반환하면 된다.
	
	이를 생각하면 크게 4가지 단계로 나눠 문제가 해결된다.
	1. 주어진 입력을 받는 단계
		-> 효율성을 위한 bufferReader로 정사각형의 길이 N을 받아 N만큼 for로 반복해
		   집의 배치를 map 이차원 배열에 저장한다. => 여기서 string으로 들어오니 그냥 char배열로 변환해 이차원배열로 간단히 만들어줬다.
		   
	2. 기본 세팅이 끝났으니, 전체 map에서 집이 몇개 존재하고 단지가 몇개 존재하는지 파악하는 것이 목적이니,
	   2중 for문을 통해 map의 처음 0, 0부터 탐색을 시작한다. 여기서 집이 존재하고, 그 주변에 집이 존재하는지 두가지 
 	   조건을 모두 충족한다면 = 아직 집의 개수를 세지 못한 단지이니, 집의 개수 = cnt를 1로 고정하고, dfs를 돌려
 	   전체 집의 개수를 구해 list에 담아준다.
 	   -> 여기 dfs에서는 들어온 집의 위치를 기준으로 북동서남을 모두 탐색하며 존재할경우, 갯수를 + 해주고 방문처리를 하며 깊이 우선 탐색이 진행된다.
 	   
 	3. 위의 과정을 통해 단지의 개수와, 각 단지에 포함된 집의 개수가 계산되었다면, 문제에서 요구하는 것은 오름차순으로 반환하는 것이니,
 	   해당 단지별 집의 개수를 저장해둔 리스트 answer을 sort 함수를 사용해 오름차순으로 정렬한다.
 	   
 	4. 정렬 후 출력의 경우, 효율성을 위해 string builder을 사용했다.
 	   1번째 줄에는 단지의 개수를 출력을 요구하니 = answer의 개수 (단지별, 집의 개수니 리스트의 크기가 단지 개수)를 넣고
 	   그 다음줄부터는 오름차순으로 개수를 반환하길 원하니 answer의 각 index의 값을 순서대로 string builder에 담아
 	   마지막으로 출력해주면 문제를 해결할 수 있게 된다.
 */
 