package Programmers_coding.lv1.page1;

import java.util.Arrays;

public class P_fruiterer {
	
	public static int solution(int k, int m, int[] score) {
		int answer = 0;
		Arrays.sort(score);
		
		for(int i=score.length-m; i>=score.length%m; i -= m) {
			answer += score[i]*m; //최저 사과 점수 x m(한 상자에 담긴 사과의 수)
		}		
		return answer;
	}

	public static void main(String[] args) {
		int k = 4;
		int m = 3;
		int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		int result = solution(k, m, score);
		System.out.println(result);
	}

}
//[과일 장수] : 주어진 조건에 맞는 모든 값을 조건에 맞게 연산해 더하는 문제
/* 
이 문제는 문제 설명을 읽어보고 이해하면 쉽게 풀 수 있는 문제이다.
문제에서 구하고자 하는 것은 최대 이익을 구하는 것으로, 여기서 이익을 구할때는 한 박스에 담긴 최저 점수에 곱하는 것이니, 

즉 한 상자에 높은 값은 높은 값끼리, 낮은 값은 낮은 값끼리 묶어서 담아야 최대 이익을 얻을 수 있다.
(ex. 과일 점수 : {1, 1, 3, 5, 5, 7}인 경우 한 박스에 2개씩 담아야 할때, 
	{1, 7}로 담으면 이 박스의 이익은 1 but {5, 7}로 담으면 이 박스의 이익은 5 처럼 높은 것 끼리 담아야 최대 이익 구할 수 있음)

위 점을 생각하면, 단순히 점수가 담겨 있는 배열을 sort, 오름차순으로 정렬 한 후 (굳이 list로 변환해, 내림차순하는 것보다, 배열에서 맨뒤부터 구해도 됨..)
상자단위로 팔아야하니, 전체 개수 % 상자에 들어가는 수 = (나머지 수)까지만 사과를 담을 수 있게 된다.
마지막으로, 가장 상자에 담긴 최저 점수는, 어처피 sort로 오름차순으로 정렬해줬으니, 해당 박스의 0번째 idx에 오는 것이
작은 점수가 된다. 즉 i -= m, 상자 개수만큼 i를 빼주며 for문으로 반복하면 자동으로 i의 값은 
각 박스의 0번째 idx를 가리키게 되니, 해당 score에서 해당 idx의 값 * 상자에 들어가는 사과의 개수 = 한상자의 최대 이익을
상자에 담을 수 있을 때 까지 (i>=score.length%m) 반복해서 answer에 더해주면 되는 문제이다.
*/