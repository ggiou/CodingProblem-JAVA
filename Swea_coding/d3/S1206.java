package Swea_coding.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0.13132s
public class S1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {// 10번 반복 = test case
			int result = 0;
			int n = Integer.parseInt(br.readLine()); // 건물의 개수
			int[] building = new int[n]; // 건물의 높이가 담긴 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int h = Integer.parseInt(st.nextToken());
				building[j] = h; // 건물의 높이
			}

			for (int k = 2; k < n - 2; k++) { // 조망권이 확보될려면 왼쪽, 오른쪽 모두 거리 2이상인 공간이 비워있어야함.
				int max = Math.max(building[k - 2],
						Math.max(building[k - 1], Math.max(building[k + 1], building[k + 2])));
				// i번째 건물 기준 왼쪽, 오른쪽 2칸이내에 가장 큰 건물 찾기
				if (building[k] > max) {// 현재 건물이 왼, 오 2칸이내 가장 큰 건물보다 높다면, 즉 max 건물보다 높은 층은 조망권 확보 됨
					result += building[k] - max;
				}
			}
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
			//System.out.println("#"+(i+1)+" " +result);
			//sb대신 그냥 출력해도 실행시간 큰 차이 없는 듯.. 어처피 10개라..
		}
		System.out.print(sb);
	}
}
