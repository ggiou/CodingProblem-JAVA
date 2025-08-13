package Programmers_coding.lv1.page2;

import java.util.Arrays;

public class P_AddABunchOfNumbers {
	public static int solution(int[] numbers) {
        int answer = 0;
        boolean[] numPresent = new boolean[10]; 
        
        Arrays.sort(numbers); //오름차 순 정렬 
        
        for(int i=0; i<10; i++) { //0-9까지 숫자를 비교해야하니 반복
        	if(i>numbers.length-1) { //만약 i가 numbers 길이보다 크다면, 배열 범위 오류가 생기니 이를 방지하기 위해..
        		if(numPresent[i]!=true) { //그전에 해당 숫자가 없었다면
        			answer+=i; //없는 숫자를 더해야하니 answer+i
        		}
        		continue;
        	}
        	
        	numPresent[numbers[i]] = true; //numbers[i]의 값이 존재하는 값이니 true
        	if(numPresent[i]==false) { //존재 하지 않는 값 = false
        		answer+=i; //없는 숫자를 더해야하니 answer+i
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
		System.out.println(solution(numbers));
	}
}
//[없는 숫자 더하기] : 주어진 0-9까지로 이루어진 숫자배열에서 0~9사이에 존재하지 않은 숫자들을 모두 더해 반환하기
/*
  이 문제는 0~9까지로 이루어진 숫자배열이 주어지고, 여기서 0~9까지의 숫자중 없는 숫자들을 모두 더해 반환하는 문제이다.
  이 문제를 보고 가장 쉬운 방법은 그냥 case, if 문으로 0~9까지 일일히 비교해 없다면 더하도록 해도되지만
  그럼 코드가 너무 길고 가독성이 좋지 않을꺼 같아 다른 방식을 생각해봤다.
  
  어처피 숫자는 0~9까지로 한정되어있고, 그 중 없는 숫자를 구하는 것이니 주어진 배열을 오름차순으로 정렬한다면,
  해당 numbers 배열에 배치가 무저건 내 index보다 해당 index의 값이 더 크다는걸 생각해봤다. [0, 2, 3, 6] -> 0(0), 1(2), 2(3), 4(6)
  그러면 for문을 10까지 돌리며, numbers[i]의 값을 가져온 후, 해당 값을 numPresent[값] 번째 boolean 배열을 true로 설정해주며
  만약 numPresent[i]의 값이 false 라면 존재하지 않으니 더해주면 되겠다고 생각해 문제를 해결했다.
  
  + 여기서 주의할점은 0~9까지 for문이 반복되다보니, numbers의 길이보다 큰 값일 경우 구할 수 없는데
    이미 오름차순으로 배치해 값이 존재하는 곳은 numPresent에 체크를 다해뒀으니, 단순히 길이를 넘어선 숫자는
    false일 경우에 더해주기만 하면 문제가 해결된다.  
*/
 