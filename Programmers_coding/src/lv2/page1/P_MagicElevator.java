package lv2.page1;

public class P_MagicElevator {
	public static int solution(int storey) {
		int answer = 0;
		while(storey>0) { //가고 싶은 층에 도착하기 전까지 반복
			int num = storey%10; //남은 층의 가장 첫번째 자리수
			storey /= 10; //첫번째 자리수 만큼 이동했다 가정하기 위해, 남은 층을 10으로 나눠줌

			if (num>5) { //5보다 클경우
				answer += 10-num; //가장 적은 돌을 써야하니, 10단위로 만들기 위해 10-num 만큼 올라가는데 돌을 써 이동
				storey++; //10으로 올라가면 +1을 해줘야함
			}else if(num<5) { //작을 경우
				answer += num; //0단위로 만들기 위해 num만큼 내려가는데 돌을써 이동
			}else if(storey%10>=5) { //5일 경우(5칸 이동은 위든 아래든 같지만, 다음 자리수가 5보다 크면 위로가는게 더 적은 돌 사용)
				answer+=5; 
				storey++; //위칸으로 이동해 10으로 변환되니 +1을 해줌
			}else {
				answer+=5;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int storey = 2554;
		int result = solution(storey);
		System.out.println(result);
	}

}
//[마법의 엘리베이터] : 주어진 숫자를 1, 10의 단위로 빼거나 더해 0을 만들고자 할때, 연산의 최소횟수를 반환하는 문제
/*
 이 문제를 처음에 읽으면 어려울 수 있으나, 이동가능한 케이스를 나눠 케이스별, 횟수를 더해주면 쉽게 풀 수 있는 문제이다.
 여기서 마법의 엘리베이터는 1, 10의 제곱수의 숫자로만 이동이 가능하다(더하기 빼기) -> 1로 이동가능하니, 모든 층 이동가능
 근데 구하고자 하는 답은 최소 횟수이니, 10이나 0으로 변환하기 위해서 최소로 1을 빼고 더한다 생각하면
 숫자의 각 자리수를 하나씩 가져오며 0으로 만든다는 부분에 집중하면 (0 or 10)크게 3가지 케이스로 나눠서 계산이 가능해진다.
 
 1.	현재 자리수의 숫자가 5보다 큰 경우
 	: 5보다 클 경우, 0으로 반드는 것보다 10으로 만드는게 더 작은 이동횟수를 사용하게 되니
 	  총 횟수인 answer에 10-현재 자리의수 만큼 더해주고(총 이동횟수를 구하니..)
 	  10이 될 경우에는 바로 앞자릿수의 수가 +1이 되어야하니 현재 위치의 수를 ++ 해준다.
 2.	현재 자리수의 숫자가 5보다 작은 경우
 	: 5보다 작을 경우 0으로 만드는 것이 더 작은 이동횟수를 사용하니, answer에 현재 자리수만큼 더해주고
 	  0으로 되면 다음 자리수에 변화가 없으니 최종 층수가 0이 될때까지 계산하기 위해 다음 연산으로 넘어가면 된다.
 3. 현재 자리수가 5인 경우
 	: 현재 자리수가 5인 경우 0, 10 둘중 뭐로 변경하든, 이동횟수는 5로 동일하다. 하지만 최종적으로
 	  최소 횟수로 0층으로 이동하고 싶은 것이니, 다음 자리수의 층(현재 층%10)이 5보다 크다면 10으로 만들어주고, 
 	  작거나 같다면, 0으로 만들어주는 것이 가장 최소의 이동 횟수로 0층으로 이동이 가능할 것이다.
 	  -> 다음 자리수 5 이상 -> 1 or 5 이하 -> 2 번 케이스 대로 계산
 	  
위의 3가지 케이스에 집중해 while 문을 통해 현재 층이 0층으로 가는 것이 목표이니, 0보다 클동안 반복하여,
현재 내가 이동하고자하는 가장 작은 자리수의 층 -> int num = storey%10; 을 기준으로 
3가지 기준에 맞게 각각 총 이동횟수를 더해주고, 현재 층을 1층 더 올려주는 과정을 반복하며,10 or 0으로 변환해주면 -> 해당 층은 0으로 변환, 
이미 최소의 횟수를 통해 0으로 이동된 것이니 storey /= 10으로 이동후의 현재 층을 재 세팅하며 반복하면, 
마법 엘리베이터를 타고 현재 층에서 0층으로 이동하기 위한 최소한의 횟수를 구할 수 있다.
 */
