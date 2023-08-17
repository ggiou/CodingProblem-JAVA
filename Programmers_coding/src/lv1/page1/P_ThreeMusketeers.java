package lv1.page1;

public class P_ThreeMusketeers {
	public static int solution(int[] number) {
        int answer = 0;       
        for(int i=0; i<number.length; i++) {
        	for(int j=i+1; j<number.length; j++) {
        		for(int k = j+1; k<number.length; k++){
        			if(number[i]+number[j]+number[k]==0) answer++;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] number = {-2, 3, 0, 2, -5};
		int result = solution(number);
		System.out.println(result);
	}

}
//[삼총사] : 주어진 숫자 배열의 수를 3개를 통해 조합해 0을 만드는 조합 문제
/* 
처음에 이 문제를 보고 중첩 for문을 쓰면 충분히 풀 수 있겠다라는 생각이 들었다. 또한 그게 아니라면 재귀 함수를
통해 푸는 방법도 생각해봤으나, for문을 사용하는 것이 더 깔끔할거 같아 천천히 다시 문제를 살펴봤다.
이 문제를 보면 총 3명의 점수를 더해 0이 되는 문제, 마치 3장의 카트를 뽑아 특정 수를 구하는 것과 유사한 조합문제임을 알 수 있었다.
이를 통해 만약 for문으로 조합으로써 한명씩 모든 사람의 숫자를 3명 단위로 더해 확인해보더라도 
3 ≤number의 길이 ≤ 13 을 보면 최대 시행 횟수는 13C3 = 286번으로 충분히 중첩 for문을 쓰더라도 에러없이 문제를 풀 수 있겠다는 것을 파악했다.
3중 중첩 for문을 써도 과부하가 나지 않을 것을 인지한 후, 조합으로써 3명의 수를 더해 0을 만들어야하니
i번째 학생의 정수, j(i+1) 번째 학생의 정수, k(j+1) 번쨰 학생의 정수를 더해 0이 되면 위의 조건인 삼총사가 되는 것이니, 
3중 for문으로 i, j, k를 중첩해 비교하며 []number에서 3개의 idx의 정수를 가져와 더했을때 0이 되면 answer을 ++해 횟수를 세 문제를 풀었다.
*/