package Programmers_coding.lv1.page1;

public class P_SplitString {
	public static int solution(String s) {
		int answer = 0;
		int xCnt = 0; //공통 문자가 몇개 있는지 횟수
		int diffCnt = 0; //다른 문자가 몇개 있는지 횟수
		String[] sArray = s.split("");
		String firstS = sArray[0]; //공통 횟수를 세야하는 문자

		
		for(int i=0; i<sArray.length; i++) { //전체문자를 비교해 나눠야하니 for문을 통해..
			if(firstS.equals(sArray[i])) { //공통 문자와 현재 index의 문자가 동일하면
				xCnt++; //공통문자이니 공통 횟수 ++
			}else {
				diffCnt++; //다른 문자이니 다른 문자 횟수 ++
			}
			
			if(i==sArray.length-1) { //만약 공통&다른 문자의 횟수가 다르더라도 마지막 index라면 무저건 분리되니
				answer++; //문자열의 개수 ++
				break;
			}
			if(xCnt==diffCnt) { //공통&다른 문자의 횟수가 같다면 분리되어야하니
				answer++; //분리됬으니 문자열의 개수는 ++
				firstS = sArray[i+1]; //다음 문자가 공통문자를 확인해야하는 문자가 되니 재설정
				xCnt = 0; diffCnt = 0; //각각 횟수는 0으로 초기화
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String s = "aaabbaccccabba";
		int answer = solution(s);
		System.out.println(answer);

	}

}
//[문자열 나누기] : 주어진 문자를 앞에서부터 세면서, 같은 문자가 나오는 횟수를 기억해, 다른 문자가 나온 횟수와 동일해지면 이를 끊고, 이렇게 나눠지는 문자열의 총 횟수를 반환하는 문제
/*
이 문제는 처음에는 문제의 말이 이해하기 어려워 헷갈려했었다. 하지만 예시와 문제를 천천히 다시 읽어보니 이해가되 문제를 해결할 수 있게되었다.
이 문제에서 요구하는 것은 주어진 조건대로 문자열을 분리했을때 총 몇개의 문자로 분리가 되는지 그 횟수를 반환하는 문제이다.
여기서 주어진 조건은 간단하다. 현재 나온 문자와 다음 문자를 계속 비교해가며 동일한 문자가 나오는 경우 그 횟수를 센다. 
동일한 문자가 나오는 경우의 횟수와, 다른문자가 나온 경우의 횟수가 같아진다면 분리가 가능해지고, 다시 분리됬을때의 처음에 나오는 문자를 기준으로 
동일한 문자의 횟수를 세며 이 과정을 반복해 최종적으로 분리된 문자가 몇개인지 세면 되는 문제이다.

말로 하면 헷갈리니 예시를 들어 설명하자면
주어진 문자 : "aaabbaccccabba" 일 경우에는 첫번째로 온 문자 a를 기준으로 판별한다.
		   문자 a는 연속해 3개가 우선적으로 횟수가 세진다. = "(aaa)bbaccccabba"
		   그 후 b라는 다른 문자 2개가와 3 : 2로 동일하지 않으니 다음을 센다. = "(aaa(bb))accccabba"
		   다음으로 a라는 처음과 동일한 문자가 한개가 더와 4개가 된다. = "(aaabba)ccccabba"
		   다음에 c라는 문자가 2개가 더오면  4=4 동일하니 문자열이 분리된다. = "(aaa(bb)a(cc))ccabba"
		   그럼 다음에오는 c 문자열을 기준으로 동일한 형식으로 계산해 분리하면 = "(aaabbacc)(ccab)(ba)"와
		   같이 분리되 정답은 3이된다.
		   
위의 예시를 이해하면 문제는 비교적 쉽게 풀수 있게된다.
그 결과 위와같이 우선 처음에 오는 문자를 기준으로 for문을 통해 전체 s의 문자열을 탐색하며 만약 같은 문자일 경우
xcnt++, 다를 경우는 diffcnt++해주며 공통과 다른 문자열의 횟수를 파악해주며
이 두 횟수가 동일해지면 분리되었다는 뜻이니 여기서 원하는 문자의 횟수가 하나 늘어나 ++ 해주고 공통문자 기준은 그 다음 문자, 나머지는 0으로 초기화해주며
전체를 비교하며 총 분리 횟수를 구해 반환하면 되는 간단한 문제이다.
*/
 