package lv1.page1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_MemoryScore {

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length]; //이차원 배열의 행만큼 사이즈 필요
		//-> photo배열에 담긴 i행의 모든 열의 각 사람들의 그리움점수를 더해 추억점수를 반환해주는 문제니..
		
		Map<String, Integer> score = new HashMap<>(); //그리움 점수를 담을 맵
		for(int i=0; i<name.length; i++) {
			score.put(name[i], yearning[i]); //이름 : 그리움 점수
		}
		
		for(int i=0; i<photo.length; i++) {
			int memory = 0; //추억 점수
			for(int j=0; j<photo[i].length; j++) {
				memory += score.getOrDefault(photo[i][j], 0);//사람별 그리움 점수 더하기(없을 경우 0)
			}
			answer[i] = memory; //구한 i번째 행의 추억점수 배열에 담기
		}
		

		return answer;
	}

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},
				{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		int[] result = solution(name, yearning, photo);
		System.out.println(Arrays.toString(result));
	}

}
//[추억점수] : 입력된 값과 대응되는 값에 맞게 각 행의 총 점수를 구해 반환하는 문제
/* 
  이 문제는 사람들의 이름 name[] 배열과 그 사람에 대응되는 그리움 점수 yearning[]에 맞게 
  주어진 사진별 사람들의 이름이 포함된 photo[][]의 각 i번째 행의 사진에 포함된 모든 사람들의 그리움 점수를 더한
  추억점수를 구해 1차원 배열로 반환하는 문제이다. 

  이 문제를 보자마자 효율성을(배열은 시간복잡도 O(n) -> 최대 O(n^2) / 해시맵은 O(1) -> 최대도 상수시간으로 계산되 
  반복이 많을 수록 배열보다 해시맵이 유리) 위해서 일일히 photo의 i번째 행의 모든 열의 이름을 name 배열의 이름과 비교해
  각 사람별 점수를 더하는 것이 아닌 이름별 점수로 key, value를 넣은 map을 만들어 
  photo의 각 이름에 대입되는 map의 key값의 value를 더해주면 쉽게 풀 수 있을 거라 생각이 들었다.

  여기서 만약 map에서 key값이 없을 경우 null이 반환되므로 이를 위해 예외처리를 따로 해도 되지만(if문..)
  나는 map의 .getOrDefault를 이용해 null일 경우 지정한 숫자인 0이 반환되 더해지도록 간단하게 풀었다.
  */ 
