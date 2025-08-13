package Programmers_coding.lv1.page2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_AssessPersonalityType {
	public static String solution(String[] survey, int[] choices) {
        String[] answer = {"RT", "CF", "JM", "AN"};	//성격 검사 결과 지표를 담을 배열
        
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();	//각 지표의 점수를 담을 배열
        
        for(int i=0; i<choices.length; i++) {	//설문조사의 점수를 구하는 과정
        	String[] addWhat = survey[i].split("");	//지표별 선택지 방향 지정(survey[i] = 문자의 위치가 앞이면, 비동의쪽 / 뒤면 동의쪽 일 경우 점수 얻음)
        	//addWhat[0] = 4이하일 경우 -> 4 - 점수 만큼 해당지표 점수 add 
        	//addWhat[1] = 4이상일 경우 -> 점수 - 4 만큼 해당 지표 점수 add 
        	int score = choices[i]; //해당 질문의 점수 (4이하 비동의, 이상 동의)
        	
        	if(score<4) {		//비동의 쪽을 선택했다면
        		scoreMap.put(addWhat[0], scoreMap.getOrDefault(addWhat[0], 0) + (4-score));	
        		//해당 지표의 점수를 map에 더해줌 (처음 저장일 경우 0+(4-점수), 아닐 경우 기존점수 + (4-점수)) -> 4를 기준으로 1 = 비동의로 갈수록 점수가 커지니 4-점수
        	}else if(score>4) {	//동의 쪽을 선택했다면
        		scoreMap.put(addWhat[1], scoreMap.getOrDefault(addWhat[1], 0) + (score-4));	
        	}
        }
        
        for(int i=0; i<answer.length; i++) {	//설문 결과를 구하는 과정
        	String[] indicators = answer[i].split(""); 
        	Integer oneI = scoreMap.getOrDefault(indicators[0], 0);
        	Integer twoI = scoreMap.getOrDefault(indicators[1], 0);
        	
        	if(oneI<twoI) {
        		answer[i] = answer[i].replace(indicators[0], "");	//두번째 지표가 더 크니, 첫번째 지표값 제거
        	}else {
        		answer[i] = answer[i].replace(indicators[1], "");	//첫번째 지표가 더 크니, 두번째 지표값을 지워줌 (같을 경우, 알파벳순으로 빠른 지표니 = 첫번째 지표값이 반환되야함)

        	}
        }
         
        return Arrays.toString(answer).replaceAll("(\\[|\\]|,)| ", ""); //배열형식으로 반환되니, 문자제외 모두 공백으로 변경후 반환
    }
	
	public static void main(String[] args) {
		 String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		 int[] choices = {5, 3, 2, 7, 5};
		 String result = solution(survey, choices);
		 System.out.println(result);

	}

}
//[성격 유형 검사하기] : 주어진 조건에 맞게 각 유형에 점수를 매겨, 점수가 높은 유형별 1가지씩 총 4가지 문자를 정해 반환하는 문제 
/*
 이 문제에서 문자열 배열에 주어진 순서대로(첫번째 주어질 경우, 비동의 항목에서 점수 + / 두번째 주어질 경우, 동의 항목에서 점수 +)
 각 문항마다 얻을 수 있는 점수가 계속 달라진다는 부분에 초점을 맞춰 풀었다. 이에 맞춰 우선 
 1. 설문 배열의 길이 만큼 반복해 점수를 구해줘야하니 for문으로 하나씩 survey의 각 문자를 가져와, split으로 나눠준 후
  	나눠진 배열 addWhat[0] = 앞에 위치하니, 비동의 항목에서 점수가 오르고, 비동의는 4를 기준으로, 3->약간 비동의 = +1, 2-> 비동의 = +2, 1 ->  매우 비동의 = +3이 되는 점을 인식하면된다.
  	+ 마찬가지로 addWhat[1] = 뒤에 위치하니, 동의 항목에서 점수가 오르고, 동의는 4를 기준으로 5->약간 동의 = +1, 6-> 동의 = +2, 7 ->  매우 동의 = +3

 2. 위처럼 점수가 정해지는 기준을 파악하면, 해당 질문의 점수 = choices[i] 가 만약 4 이상이라면, 동의쪽에 있는 유형의 점수를 올려주고 이하라면 비동의쪽에 있는 유형의 점수를 올려주면 된다.
 	이를 알면, 점수를 담은 map에 put(저장된 값이 있으면, 수정 / 없으면, 새로 저장)을 사용해, getOrDefault로 
 	현재 유형의 키값으로 가져온 value (or 0) 에 4보다 크다면, addWhat[1]의 value - 4 만큼 더해주고, 작다면 4 - addWhat[0]의 value 만큼 더해주는 과정을 반복해
 	모든 설문 조사를 통해 얻은 각 유형별 점수를 계산해주면된다.
 	
 3. 마지막으로 주어진 점수를 통해 해당 유형을 구해주면 된다. 이 과정에서 유의할 점은, 만약 두 점수가 일치한다면, 둘중 알파벳 순서가 빠른 것이 반환되야하니,
 	일일히 문자를 case문으로 더하기보다, 미리 각 위치에 해당되도록 유형을 두가지씩 넣은 문자열 배열 answer을 만들고
 	여기서 getOrDefault로 없을 경우 0으로 설정해, 더 높은 값의 문자열을 냅두고, 낮은 값의 문자열을 해당 answer[i]번째에서 replace로 제거해주는
 	방식으로 for문을 통해 case대신 간결하게 문제를 풀었다. 
 	(처음 answer에 배치시, 알파벳이 더 앞에 있는걸 앞에 배치해, if문 하나로 두번째 지표가 더 클때만, 첫번째 지표 문자를 제거하고 그 외에는 두번째 문자 지표를 제거하는 형식으로 문제를 해결 가능) 
*/
