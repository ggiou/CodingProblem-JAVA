package lv1.page1;

public class P_TemplarsWeapon {
	
	public static int solution(int number, int limit, int power) {
		int answer = 1; 
		for(int i=2; i<=number; i++) {
			int cnt = 2; //제곱근이 2일 경우 무저건 2 이니 고정
			for(int j=2; j<=Math.sqrt(i); j++) { //약수 구하기
				if(i%j==0) { //나머지가 없다면 약수
					if(j==Math.sqrt(i)) cnt++; //제곱근과 같다면, +1
					else cnt += 2; //그 외라면, 약수는 쌍을 이루니 +2
				}
			}
			if(cnt>limit) answer += power; //약수가 제한수치 초과일 경우 지정한 power로 제작
			else answer += cnt; 
		}
		return answer;
	}

	public static void main(String[] args) {
		int number = 10;
		int limit = 3;
		int power = 2;
		int result = solution(number, limit, power);
		System.out.println(result);
	}
}
//[기사단원의 무기] : 0 ~ 주어진 수 까지의 각 수의 약수를 모두 더하는 문제 (주어진 제한 사항을 제외하고)
/* 
이 문제는 주어진 수 1부터 number까지 반복하면서 각 수의 약수의 개수를 구해 
만약 개수가 제한 수치 limit을 넘는다면, power을 더하고, 그 외에는 약수의 개수는 모두 더하는 문제이다.

이 문제에서 for문으로 주어진 number를 다 확인하며 약수를 구하게 되면, 시간이 너무 많이 걸려 효율성이 떨어지고, 시간초과가 뜬다.
이를 막기 위해 특정 수의 약수를 구하는 과정을 생각해보면, 약수의 가운데 수, 제곱근을 기준으로
해당 수를 만들기 위한 2개의 약수를 이루고 있다. 이점을 생각하면, number의 제곱근을 구한뒤,
해당 제곱근까지 수 중 약수(나눴을때, 나머지가 0인 수)에 해당된다면 짝을 이루니 +2를 해주면된다.

또한 주의할 점은, 제곱근 그 자체도 해당 약수에 포함되니 제곱근과 같을 때도 +1 해줘야한다.

이 점을 참고하며, 제곱근이 1인 경우는, 무저건 약수의 개수가 2가 되며 1은 약수가 1개인 점을 
미리 answer에 더한 상태로 위와 같은 알고리즘을 통해 각 수의 약수의 개수를 구하고, 
그 개수가 limit을 넘는다면 answer에 주어진 power를 더하고, 넘지 않으면 해당 약수의 개수를 더해 값을 구해주면 되는 문제이다.
*/
//[문법] Math.sqrt(숫자) -> 숫자의 제곱근을 반환해주는 함수