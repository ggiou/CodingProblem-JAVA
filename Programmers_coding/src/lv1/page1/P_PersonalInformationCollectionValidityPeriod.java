package lv1.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class P_PersonalInformationCollectionValidityPeriod {
	static Map<String, Integer> term;
	
	public static int getValidityPeriod(String period, String type){//현재 날짜 / 약관 타입
		int addMonth = 0;
		if(!type.equals("!")) {
			addMonth = term.get(type);	//약관에 맞는 유효기간을 가져옴
		}
		
		int[] dates = Stream.of(period.split("\\.")).mapToInt(Integer::parseInt).toArray(); 
		int validDay = 	dates[0]*12*28 				//년 -> 일 변환해서 더하기 
						+((dates[1]+addMonth)*28)	//월 -> 일 변환해서 더하기 (유효기간 +달 포함)
						+dates[2];					
		//해당 날짜를 일단위로 전환해서 모두 더함
		
		return validDay;
	}//유효기간으로 변환해주는 메소드
	
	
	public static int[] solution(String today, String[] terms, String[] privacies){
        List<Integer> answerList = new ArrayList<Integer>(); //answer 길이를 모르니 리스트로 받은 후 arrays로 변환해서 반환
        term = new HashMap<String, Integer>();
        for(int i=0; i<terms.length; i++) {	//각 약관별 유효기관을 분류해 저장하는 과정
        	String[] validT = terms[i].split(" ");
        	term.put(validT[0], Integer.parseInt(validT[1]));
        }
        
        int toDay = getValidityPeriod(today, "!");	//현재 날짜를 구함
        
        for(int i=0; i<privacies.length; i++) {	//유효기간 내에 포함되는지 확인해 답을 구하는 과정
        	String[] prv = privacies[i].split(" ");
        	int validDay = getValidityPeriod(prv[0], prv[1]);	//해당 약관의 현재기준 유효기간을 구함
        	        	
        	if(toDay>=validDay) answerList.add(i+1);	//만약 현재 날자보다 작다면, 유효기간이 지난거니 폐기해야해 정답 리스트에 담음
        }
        
        
        return answerList.stream().filter(i->i != null).mapToInt(i->i).toArray();	//stream을 통해 arrays로 반환
    }
	
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		int[] result = solution(today, terms, privacies);
		System.out.println(Arrays.toString(result));
	}

}
//[개인정보 수집 유효기간] : 주어진 문자배열들을 통해 기준점보(today)다 작을 경우 값을 반환하는 문제
/*
이 문제는 주어진 문자배열의 약관 종류에 맞게, 입력된 privacies를 기준으로 유효기간을 구하고, 이를 현재 날짜와 비교해
만약 작다면 몇번쨰 요소인지 담아(index+1) 반환하는 문제이다.

처음엔 이문제를 그저 간단하게 생각해, 날짜 형식으로 변환해 각 년, 월, 일로 비교할려고 하다가, 이렇게 할경우 에러가 생길수 있다 생각이 들어
근본적으로 가장 쉽게, 날짜로 변환해 푸는 것이 아닌, 어처피 모든달은 28일까지 있다고 정했으니 년, 월, 일을 가장 작은 단위인
일로 변환해 비교하는 것이 좋다고 생각해 해당 방식으로 문제를 풀기로 정했다. 또한 약관의 정보 terms의 제한사항이 짧지만
효율성을 위해 map에 담아 가져다 쓰기로 정했다. 그 결과

1. for문을 통해 문자열로 이루어진 terms를 약관의 종류와 유효기간 일을 split을 통해 분리해 
   map에 담아줘, 사용하기 편한 상태로 변경해준다.
2. 유효기간 내에 해당되는지 확인하기 위해, 판단해야할 개인정보 리스트인  privacies를 하나씩 for문으로 가져와
   getValidityPeriod 함수를 통해 -> map에서 약관별 유효기한을 가져와 주어진 개인정보의 유효기간을 일 기준으로 변경해 반환
   유효기간을 가져오고, 이미 구해돈 현재 날짜를 일수로 변환한것과 비교해, 만약 현재 날짜보다 작다면
   이는 즉 유효기간이 지났다는 뜻이니 list에 담고, 이를 최종적으로 숫자 배열로 stream을 통해 변경해 반환하며 문제를 해결했다. 
*/
 