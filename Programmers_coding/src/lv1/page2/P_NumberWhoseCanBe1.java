  package lv1.page2;

public class P_NumberWhoseCanBe1 {
	
	public static int solution(int n) {
        int answer = 0;
        int canBe1 = n-1;	//나눴을때 1을 남기는 수는 현재 n-1이 최대 수
        double sqrt = Math.sqrt(canBe1);	//전체를 구하기엔 오래걸리니, 제곱근까지 구해 중간까지 탐색
       
        for(int i=2; i<=sqrt; i++) {	//1은 나눴을때 나머지를 남길 수 없으니 제외에 2부터 시작
        	if(canBe1%i == 0) {
        		answer = i;
        		break;
        	}
        }
        if(answer == 0) answer = canBe1;	//만약 제곱근전까지 약수가 없다면 canBe1만이 1로 만드는 수
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));

	}

}
//[나머지가 1이 되는 수 찾기] : 주어진 수를 나눴을때 1로 만드는 가장 작은 수를 구하는 문제
/*
이 문제는 주어진 수 n을 나눴을때 1로 만드는 수 중, 가장 작은 수를 구하는 간단한 문제이다. 
정말 단순하게 n을 나눴을때 1로 만드는 수는 = n에 -1을 해주면, 1로 만드는 가장 큰 수가 된다.
그리고 해당 수의 약수들은 어처피 곱해서 해당 수가 되니 즉 같은 결과 그 수로도 나눴을때 나머지를 1로 만들 수 있게 된다.
이점을 생각하면 단순하게, 해당수를 1로 만드는 가장 큰 수의 약수 중 가장 작은 수를 반환하면된다. 이를 통해

1. 1로 만드는 수를 구한다 -> canBe1 = n-1 (1을 뺴준수는 나눴을때 나머지가 1을 남김..)
2. 해당수의 약수 중 가장 작은 수를 구한다
   - 여기서 단순히 for문으로 canBe1까지 모두 % 했을때 나머지가 0인 경우중 첫번째로 오는걸 구해도 되지만
     만약 약수가 자신밖에없는 소수인데 큰 수 일 경우 효율성에서 떨어지니 제곱근까지만 비교해 약수를 구한다.
     -> 여기서 1은 나눴을때 나머지가 남지 않으니 for문을 돌리때 2부터 시작하며
     -> 첫번째로 i번째로 %했을때 0이 되는수가 가장 작은 수니, 해당수를 반환하며 break로 빠르게 탈출시킨다.
     -> 만약 약수가 제곱근까지 없다면 즉, 소수라는 뜻이 되니 (answer = 0일 경우) 
     	처음의 cnaBe1가 가장 작은 나눠서 1을만드는 수이므로 반환하면 쉽게 문제를 해결할 수 있다.
*/
 