package lv1.page1;

public class P_Babbling2 {
	
	public static int solution(String[] babbling) {
		int answer = 0;

		for(int i=0; i<babbling.length; i++) {
			String babble = babbling[i];
			if(babble.contains("ayaaya")||babble.contains("yeye")||babble.contains("woowoo")||babble.contains("mama")) {
				continue;
			}//중복 발음이 있다면
			
			
			String repBabbleAll = babble.replaceAll("aya|ye|woo|ma", "");
			if(repBabbleAll.length()==0) answer++;	//모두 발음할 수 있을때
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] babbling = {"ayaye", "woomawoo", "yeye", "yemawoo", "ayaayaa"};
		int result = solution(babbling);
		System.out.println(result);
	}
}
//[옹알이 2] 주어진 문자  "aya", "ye", "woo", "ma"를 조합해 주어진 babbling배열의 문자를 만들 수 있는 횟수를 반환하는 문제
/*
이 문제는 문자열을 비교하는 함수들을 활용하면 매우 쉽게 풀 수 있는 문제이다. 문제에서 주어진 조건은 2가지이다.
주어진 옹알이 발음  "aya", "ye", "woo", "ma"가 연속되서는 안되고, 이를 통해서만 만들 수 있다는 조건에 집중하면 쉽게 해결하능하다.

1. 단순히 우선 babbling의 문자 배열중에서 주어진 조건을 통해 만들 수 있는 문자의 개수를 반환하는 것이 목적이니 babbling의
길이만큼 for문으로 반복하며, 우선적으로 내부의 문자를 하나씩 가져온다.
2. 그리고 연속된 문자가 불가능하니 그냥 쉽게 연속된 문자를 임의로 만들어줘 "ayaaya", "yeye", "woowoo", "mama" 라고 지정하고
   만약 이 문자를 contains 함수를 통해 하나라도 포함되어있으면 조건에 어긋나 만들지 못하는 문제이지 넘어가면되고
3. 중복된 문자가 없을 경우 2번째 조건, 해당 4가지 문자만으로만 이루어져야한다는 부분을
   replaceAll을 통해 각 문자를 정규식으로 줘 있을경우 모두 "" 빈칸으로 변경하면,
   만약 해당 문자만으로만 이루어졌다면 변환한 문자의 길이가 0일테니 이 조건이 맞을 경우, 만들수 있는 옹알이라 판단해 반환해야할 횟수를 ++ 해주는 과정을 반복하면 쉽게 풀수 있다.
*/
 