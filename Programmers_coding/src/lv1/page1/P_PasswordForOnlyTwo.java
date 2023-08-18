package lv1.page1;

import java.util.HashSet;

public class P_PasswordForOnlyTwo {
	
	public static String solution(String s, String skip, int index) {
        String answer = "";
        char[] ps = s.toCharArray();
        
        HashSet<Character> passCh = new HashSet<Character>();
        char[] skips = skip.toCharArray();
        for(int i=0; i < skips.length; i++) {
        	passCh.add(skips[i]);	//pass 해야할 문자열을 어처피, 한개씩 존재하니 hashset에 저장
        }
        
        for(int i=0; i<ps.length; i++) {
        	char ch = ps[i];
        	int nowIdx = index;
        	while(nowIdx!=0) {	//pass해야할 문자열은 건너뛰고 주어진 index만큼 뒤의 알파벳으로 바꿔야하니, 현재 index가 0이 될때까지 반복 
        		ch++;	//한칸씩 뒤의 문자로 바꿔줘야함 - char의 경우, ++ 해주면 다음 문자로 받기 가능
        		if(ch > 'z') ch = 'a';  	//소문자 z이상이면 영어 소문자가 아니니 도로 a로 복귀 
        		if(!passCh.contains(ch)) {	//현재 문자가 생략해야할 문자에 포함되어있으면 다음으로 넘어가고 아니라면
        			nowIdx--;	//생략할 문자가 아니라면, 이동된거니 index를 --해준다.
        		}       		      		
        	}
        	answer += ch;	//index만큼 이동되면 변환된 암호이니 정답 문자열에 붙여준다
        }        
        return answer;
    }

	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		String result = solution(s, skip, index);
		System.out.println(result);

	}
}
//[둘만의 암호] : 정해진 규칙에 맞게 주어진 문자열의 문자를 각각 index 만큼 이동시켜 새로운 문자로 변환하는 문제
/*
 이 문제는 크게 2가지 포인트에 집중해서 풀면 쉽다. 
 1. 주어진 알파벳을 index 만큼 뒤의 알파벳으로 바꿔준다 -> 알파벳 변환의 편의를 위해 char 사용, 문자열의 한자씩 가져다 변환해야니, toCharArray()로 char배열로 변환해 사용
 2. skip으로 주어진 알파벳은 제외하고 건너뛴다 -> 문자열 자체로 contains로 비교해도 되지만 속도 개선을 위해 어처피 한자씩 저장되있니, hash set 사용
 (+ 당연히 소문자 알파벳만으로 변경해야하니, z 이상이 될경우 a로 변경해줘야함 -> char은 +1을 통해 다음 문자를 가져올 수 있음 = 숫자로 판단해서 다음지정되어있던 규칙의 문자가 가져와짐..)
 
 이 2가지 포인트에 집중해 풀면 
 1. skip이라는 알파벳은 제외하고 건너 뛰어야한다는 조건을 위해, 제한사항으로 주어진 문자열들은 짧지만 효율성 개선을 위해 우선,
 	skip문자를 char배열로 변경하고(char 형식으로 문자변환을 사용할거니, string이 아닌 char배열로 저장해야함 -> 아니면 형식이 안맞아서 오작동 할수도)
 
 2. 모든 문자열을 index만큼 뒤의 문자로 변경해야하니 for문으로 변환한 s char 배열의 길이만큼 반복하며
 	각 char을 하나씩 가져와, index만큼 이동해야하니 index가 0이될때까지 while을 통해 반복해주면됨 
 		-> 이때 index의 수가 -- 되는 경우는 현재 char을 +1을 했을때 skip 문자들이 아니라면, 한칸 뒤로 이동이 가능하니 --해 index가 0이될때까지 반복
 		-> 또한 여기서 소문자 알파벳만으로 이루어져 있으니, char을 다음 문자로 미뤘을때, z보다 클 경우 a로 변환해 비교해주면 소문자 알파벳만으로 변환이 가능
 	이 과정을 반복하며 index가 0이됬을때로 변환된 문자를 정답 answer string에 붙여 반환해주면 쉽게 문제가 해결할 수 있다.
 */
