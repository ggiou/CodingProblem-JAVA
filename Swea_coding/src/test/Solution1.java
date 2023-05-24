package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution1 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		int result = 0;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine()); // 발사기 개수
			ArrayList<Integer> lazer = new ArrayList<Integer>();
			Map<Integer, Integer> org = new HashMap<>();

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int l = Integer.parseInt(st.nextToken()); // 좌표
				int v = Integer.parseInt(st.nextToken()); // 강도
				lazer.add(l);

				org.put(l, v);
			} // 레이저 넣기
			Collections.sort(lazer); // 오름차순 정렬


			for (int k = 0; k < lazer.size(); k++) {
				int num = lazer.get(k);
				if (org.get(num) != 0) { //0이라면 이미 삭제된 레이저
					int val = org.get(num) + num; // 총 제거되는 발사기 좌표
					
					for (int d = k; d < lazer.size(); d++) { //현 레이저 범위에서 제거되는 발사기 찾기 & 카운트하기
						if (lazer.get(d) <= val) { //만약 val보다 작다면 즉 범위 내부이니 제거됨
							org.replace(lazer.get(d), 0); //제거됬음을 0으로 표시
						} else {
							result += 1; //제거되지 않으면 거기까지가 그 발사기가 없앨수 있는 범위니 +1, 다음 발사기로 넘어가기
							break;
						}

						if (org.get(lazer.get(d)) == 0 && d == lazer.size() - 1) {
							result += 1; //만약 마지막이면서 이미 삭제됬을 경우도 횟수 +1 해줘야 함
						}
					}
				}
			}
			// if(lazer.size()==1) result = 1;
			System.out.println("#" + (i + 1) + " " + (result)); 
			result = 0;
		}
		br.close();
	}
}