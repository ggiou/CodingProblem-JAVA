package lv1.page1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_HallOfFame1 {
	public static int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		
		for(int i=0; i<score.length; i++) {
			pQueue.add(score[i]);
			if(i >= k) {
				pQueue.poll();
			}
			answer[i] = pQueue.peek();
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int k = 3;
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		int[] result = solution(k, score);
		System.out.println(Arrays.toString(result));
	}

}
//[명예의 전당 1] : 주어진 개수까지만 순위를 비교할 수 있을때, 각 순위가 갱신되는 매일매일 가장 낮은 점수를 반환하는 문제
/*
이 문제는 주어진 score가 매일매일의 점수, k가 명예의 전당에 들 수 있는 순위, 명예의 전당이 가득 찬다면 가장 낮은 점수가 전당에서 내려가고
더 높은 점수대로 명예의 전당의 순위가 갱신된다는 점을 주의하며, 결론적을 구하고자 하는 순위가 각 매일매일의 가장 전당에 올라가있는
꼴지의 점수를 반환하는 것인 부분에 집중해 비교적 쉽게 풀 수 있었다.

 여기서 중요한 것은, 명예의 전당은 점수에 따라 순위가 바뀌며 k등까지만 존재하고, 반환값들이 그 날의 가장 낮은 등수의 점수를 반환한다는 점이다.
 이를 생각해보면 다양한 방법으로 해당 문제를 풀 수 있겠지만, 내부 로직을 통해 자동으로 우선 순위에 맞게 (낮은 수, 높은 수) 순서대로
 저장되는 우선순의 큐 PriorityQueue를 사용하면 매우 쉽게 문제를 풀 수 있다.
 PriorityQueue의 경우 default 값이 수가 작을 수록 가장 위에 쌓여 있다는 것을 생각하면 문제는 더 쉬워진다.
 
 우선순위 큐의 성질을 이용해 
 1. 매일매일의 최저 등수의 점수를 반환해야하니, score의 크기만큼 for문으로 반복하며
 2. 각 점수를 k등까지 명예의 전당에 오르니, 우선순위 큐의 사이즈가 (여기서는 i의 값 = 어처피 k전까진 모두 담기니..)
    가능한 등수인 k보다 이상이면, 우선 해당 점수를 넣으면 가장 작은 점수가 맨위에 배치되니, 
    -> poll(가장 상단=작은 값이 제거됨)을 통해 가장 작은 점수를 빼주고, (등수에 벗어난 점수)
    -> peek(가장 상단=작은 값이 반환됨)를 통해 빠져나온 수가 그날의, 가장 낮은 순위의 점수이니 answer에 넣어주는
    과정을 반복하면 쉽게 문제를 해결할 수 있다.
*/

//우선순위 큐 사용