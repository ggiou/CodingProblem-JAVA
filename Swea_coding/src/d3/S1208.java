package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10; i++) { // 총 10개의 테스트케이스
			int n = Integer.parseInt(br.readLine()); // 덤프가능 횟수
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "으로 구분되 한줄로 입력됨
			int heights[] = new int[100]; // 상자의 높이를 담을 배열
			int length = heights.length;
			for (int j = 0; j < length; j++) {
				heights[j] = Integer.parseInt(st.nextToken());
			} // 배열 담기
			Arrays.sort(heights); // 정렬

			for (int k = 0; k < n; k++) {
				
				if (heights[0] == heights[length - 1] || heights[length-1] - heights[0] == 1) {
					//break;
				} else {
					heights[0]++;
					heights[length - 1]--;
					Arrays.sort(heights); //정렬 (++, --하니 가장 높은 높이와, 낮은 높이가 바껴야함, 즉 정렬 다시..)
				}
			}
			
			sb.append("#"+i+" "+(heights[length-1]-heights[0])+"\n");
			
		}
		br.close();
		System.out.println(sb);
	}
}
//덤프횟수만큼 반복해서 가장 높은 위치--, 가장 낮은 위치++ 해서 서로의 높낮이 차를 구하는 문제다 (평탄화)
//문제를 보면 쉽게 알 수 있듯이, 입력받은 높이들을 배열에 담아 정렬 하면, [0] = 가장 낮은 높이, [length-1] 가장 높은 높이가
//되는 것을 알 수 있다. 이 낮고 높은 높이에 ++, --를 통해 평탄화한 후 다시 정렬하는 과정을 반복하며
//만약 두 높이의 차가 1이되거나, 덤프횟수를 다쓴다면 두 높이의 차를 구해 출력하면 쉽게 풀 수 있다.