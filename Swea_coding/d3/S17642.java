package Swea_coding.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//!!!!!!!!!!!!!!! 다시 풀기..
public class S17642 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long num1 = 0;
		long num2 = 0;
		long cnt = 0;
		long value = 0;

		long tc = Long.valueOf(br.readLine()); // 테스트 케이스

		for (long i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			num1 = Long.valueOf(st.nextToken()); // 변수 A
			num2 = Long.valueOf(st.nextToken()); // 변수 B

			cnt = 0;

			value = num2 - num1;
			if (value == 0) {
				cnt = 0;
			} else if (value <= 1) {
				cnt = -1;
			} else {
				if (value % 2 == 0) { // 짝수 라면
					cnt = value / 2; // 최대 횟수이니, 짝수면 가장 작은 소수를 계속 더하는게 최대 횟수
				} else { // 홀수 라면
					value -= 3; // 최대 횟수이니, 작은 홀수 소수 3을 뺴줘 짝수로 변환후
					cnt = 1; // 1번 더한거니 횟수 1로 시작
					cnt += value / 2;
				}
			}

			sb.append("#").append(i + 1).append(" ").append(cnt).append("\n");
		}
		br.close();
		System.out.println(sb.toString());

	}

}
//수의 경우 3개, 짝수 홀수 짝홀수도 아닐 떄 