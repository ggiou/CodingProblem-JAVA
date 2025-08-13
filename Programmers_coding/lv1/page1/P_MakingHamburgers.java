package Programmers_coding.lv1.page1;

import java.util.Stack;

public class P_MakingHamburgers {
	
	public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> hamburgers = new Stack<>();
        
        for(int i : ingredient) {
        	hamburgers.push(i);
        	int size = hamburgers.size();
        	if(size>=4) {
        		if(hamburgers.get(size-1)==1 && hamburgers.get(size-2)==3
        		   && hamburgers.get(size-3)==2 && hamburgers.get(size-4)==1) {
        			answer++;
        			hamburgers.pop();
        			hamburgers.pop();
        			hamburgers.pop();
        			hamburgers.pop();
        		}
        	}
        	
        }
        
        /*StringBuffer hamburgers = new StringBuffer(Arrays.toString(ingredient).replaceAll("(,|\\[|\\])| ", ""));
        
        int idx = hamburgers.indexOf("1231");
        
        while(idx >-1) {
        	answer++;
        	hamburgers.delete(idx, idx+4);
        	idx = hamburgers.indexOf("1231");
        }*/ //시간초과
        
        return answer;
    }

	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int result = solution(ingredient);
		System.out.println(result);
	}

}
//[햄버거 만들기] : 주어진 숫자 배열에서 정채진 규칙과 일치하는 순서대로 "1, 2, 3, 1" 존재하는 횟수 구하기
/* 
이 문제는 주어진 int 배열에 1, 2, 3, 1 이라는 순서대로 존재하는 횟수를 구하는 문제이다.
여기서 만약 해당 규칙에 맞는 수들이 존재한다면, 이걸 제외하고 다시 규칙을 확인할 수 있다. 이 과정을 반복해 
총 규칙을 만족하는 횟수를 구하는 것이 목적이다. ex) [1 2 (1 2 3 1) 3 1] -> [(1 2 3 1)] -> 2번

처음에는 보자마자 문자열로 바꿔서 해당 문자열("1231")의 인덱스가 존재한다면(.indexOf("1231") != -1 ) 
이를 (.replace("1231", ""))제거하고 총 횟수를 +1 해주는 방식으로 풀어야겠다 생각했다. 하지만 시간 초과 에러가나서 string에서
stringBuffer로 바꿔서 .delete(idx, idx+4)로 존재하면 제거해줬으나 이도, 결국 시간초과 에러가 떴다.

생각해보니 stack을 사용하면, 쌓아온 순서대로 유지하면서 지속해 비교할 수 있겠다 생각이 들어 stack을 사용해 
문제를 풀었다. 똑같은 알고리즘으로, 우선 ingredient에서 1개씩 빼와서 stack에 쌓아 올리고,
크기가 4보다 커진다면 그떄부터 위에서부터 하나씩 꺼내 각 1, 3, 2, 1 순서가 맞는지 비교해 (아래부터 쌓이니 1, 2, 3, 1이 아닌 반대로 비교해야함)
맞다면 POP으로 4개를 꺼내주면 계속해서 바로바로 빠지는거니 정상적으로 비교가되며, stack의 경우 속도가 빨라 시간초과 없이 성공적으로 문제를 풀 수 있었다.
 */
//[문법] : .delete(시작 idx, 끝 idx) -> 해당 idx 범위의 문자를 삭제 시킴 (String Buffer에서 사용 가능)